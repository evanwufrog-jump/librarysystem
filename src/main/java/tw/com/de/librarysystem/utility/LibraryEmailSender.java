package tw.com.de.librarysystem.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

public class LibraryEmailSender {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    freemarker.template.Configuration freemarkerConfig;

    //email sender which should be in utils package
    public Map<String,String> libraryEmailSender(String mailFrom, Map<String, String> mailContent, String subject, String templateName){
        Map<String, String> methodResponse = new HashMap<String, String>();
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("qoo90069@gmail.com");
            helper.setTo(mailFrom);
            helper.setSubject("主旨："+subject);
            String templateString = FreeMarkerTemplateUtils
                    .processTemplateIntoString(freemarkerConfig.getTemplate(templateName), mailContent);
            helper.setText(templateString, true);
            mailSender.send(mimeMessage);
            methodResponse.put("status","1");
            methodResponse.put("msg","email success");
        }catch(Exception e){
            methodResponse.put("status","2");
            methodResponse.put("msg","email fail");
            System.out.println(e.getMessage());
        }
        return methodResponse;
    }

}
