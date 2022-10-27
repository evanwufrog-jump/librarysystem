package tw.com.de.librarysystem.controller;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/email")
@Controller
public class SendEmailTest {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	freemarker.template.Configuration freemarkerConfig;
	@GetMapping("/test")
	public void SendEmail() throws Exception{
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("qoo90069@gmail.com");
		helper.setTo("alan.lee@frog-jump.com");
		helper.setSubject("主旨：測試寄件");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userName", "alan.lee");
		String templateString = FreeMarkerTemplateUtils
				.processTemplateIntoString(freemarkerConfig.getTemplate("template.html"), model);
		helper.setText(templateString, true);
		mailSender.send(mimeMessage);
	}

}
