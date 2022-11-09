package tw.com.de.librarysystem.controller;

import com.google.gson.Gson;
import freemarker.template.TemplateException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.service.MemberService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.*;

@RestController
public class LoginController {

	@Autowired
	MemberService memberService;


	//如果登入成功，會取得jwt，前端存入cookie，若登入失敗則收到fail
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Member member) {

//============PostMan Test===============
//	public String login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
//		Member member = new Member();
//		member.setEmail(email);
//		member.setPassword(password);
//=======================================
		Map<String,String> map = new HashMap();
		Map<String, Object> loginData = userVerify(member.getEmail(),member.getPassword());
		map.put("loginStatus",(String)loginData.get("loginStatus"));

		if(loginData.get("loginStatus").equals("1")){
			String jwt = jwtCreator(((Member)loginData.get("member")).getEmail(),((Member)loginData.get("member")).getPermission());
			map.put("jwt",jwt);
			map.put("email", member.getEmail());
			map.put("permission", ((Member)loginData.get("member")).getPermission());
			map.put("memNo",  ((Member)loginData.get("member")).getMemNO());
			map.put("name",  ((Member)loginData.get("member")).getName());
		}

		String loginResponse = new Gson().toJson(map);
		return loginResponse;
	}

	//點擊忘記密碼後寄信
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	freemarker.template.Configuration freemarkerConfig;

	@RequestMapping(value = "/missingPassoword", method = RequestMethod.POST)
//	public String missingPassword(@RequestParam(name = "email") String,@RequestParam(name = "memberID") String) {
	public String missingPassword(@RequestBody Member member){
		try{
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom("qoo90069@gmail.com");
			helper.setTo(member.getEmail());
			helper.setSubject("主旨：密碼重置");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("userName", "alan.lee");
			String templateString = FreeMarkerTemplateUtils
					.processTemplateIntoString(freemarkerConfig.getTemplate("template.html"), model);
			helper.setText(templateString, true);
			mailSender.send(mimeMessage);
		}catch(MessagingException me){
		}catch(IOException ie){
		}catch (TemplateException te){
		}
		return "";
	}

//	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
//	public String resetPassword() {
//
//
//		return "";
//	}


	private Map<String, Object> userVerify(String email, String password){
		Map<String, Object> loginResponse = new HashMap();
		try{
			Member member = memberService.findByEmail(email);

			if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(member.getPassword())){
				//status1=登入成功
				loginResponse.put("loginStatus","1");
				loginResponse.put("msg","登入成功");
				loginResponse.put("member", member);
			}else{
				//status=密碼不正確
				loginResponse.put("loginStatus","2");
				loginResponse.put("msg","登入失敗，密碼不正確");
				}
		}catch (NullPointerException ne){
			//status3=信箱不正確
			loginResponse.put("loginStatus","3");
			loginResponse.put("msg","登入失敗，信箱不正確");
			}

		return loginResponse;
}

	private String jwtCreator(String email, String permission){
	Date expireDate =
			new Date(System.currentTimeMillis() + 30 * 60 * 1000);
		System.out.println("email"+email);
		System.out.println("permission"+permission);
	String jwt = Jwts.builder()
			.setSubject(email) //以email當subject
			.setExpiration(expireDate)
			.claim("permission",permission)
			//libsysKey是整個登入系統使用的私鑰，不可外流，可變更為任意字串
			//HS512是自選的演算法，可以替換成其他算法，在AuthorizationFilter內的key要相同
			.signWith(SignatureAlgorithm.HS512, "libsysKey")
			.compact();
	//暫時不將權限數值放入token，亦不做主動掌控token入資料庫的設計，只驗證token是否從此本伺服器發出即可
	//之後Token在前端必須存入Cookie，並且對該 Cookie 使用 HttpOnly 和 Secure Flag 讓 Cookie 內容不能被 JavaScript 讀取
	//避免XSS跨站攻擊(XSS)
	return jwt;
}
}
