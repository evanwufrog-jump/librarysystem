package tw.com.de.librarysystem.controller;

import com.google.gson.Gson;
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

import javax.mail.internet.MimeMessage;
import java.util.*;

@RestController
public class LoginController {

	@Autowired
	MemberService memberService;
	//Get Json Web Token(jwt) if login success. Get fail msg if not then.

// =============================controller action part =============================
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Member member) {

//=======PostMan Test By ResquestParam Annotation=======
//	public String login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
//		Member member = new Member();
//		member.setEmail(email);
//		member.setPassword(password);
//=======================================

		Map<String,String> restApiData = new HashMap();
		Map<String, Object> verifyData = loginVerify(member.getEmail(),member.getPassword());
		restApiData.put("status",(String) verifyData.get("status"));
		restApiData.put("msg",(String) verifyData.get("msg"));
		//login status 1:登入成功 2:密碼錯誤 3:信箱錯誤
		if(verifyData.get("status").equals("1")){
			String jwt = jwtCreator(((Member) verifyData.get("member")).getEmail(),((Member) verifyData.get("member")).getPermission());
			restApiData.put("jwt",jwt);
			restApiData.put("email", member.getEmail());
			restApiData.put("permission", ((Member) verifyData.get("member")).getPermission());
			restApiData.put("name",  ((Member) verifyData.get("member")).getName());
		}
		return new Gson().toJson(restApiData);
	}

//	@PostMapping("test")
//	public String test() {
//		sendNewPassword(memberService.findById("0700").get());
//		return "fine";
//	}

	//send email with new password
	//ignorable autowired error, just spring prefer config class more nowaday
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	freemarker.template.Configuration freemarkerConfig;

	//get new password
	@RequestMapping(value = "/getNewPassword", method = RequestMethod.POST)
//	public String forgotVerify(@RequestParam(name = "email") String,@RequestParam(name = "memberID") String) {
	public String getNewPassword(@RequestBody Member member){
		Map<String, String> restApiData = new HashMap<>();

	//let forgotVerify method，verify userData，if pass then send email with new password
		Map<String, Object> verifyData = forgotVerify(member.getEmail(),member.getMemNO(),member.getName());
		//verify status 1:驗證成功 2:驗證失敗 3:信箱錯誤
		String status = (String)verifyData.get("status");
		String msg = (String)verifyData.get("msg");
		restApiData.put("status",status);
		if(status.equals("1")){

			String newPassword = UUID.randomUUID().toString().substring(8);
			memberService.updatePasswordByMemNO(member.getMemNO(), newPassword);
			Map<String, String> model = new HashMap<>();
			model.put("memNO",member.getMemNO());
			model.put("name",member.getName());
			model.put("password",newPassword);
			Map<String, String> senderResponse = libraryEmailSender(member.getEmail(), model, "密碼重置","newPassword.ftl");
			if(senderResponse.get("status").equals(""))
			restApiData.put("msg", msg);

		}else {
			//error msg to frontend
			restApiData.put("msg", msg);
		}
		return  new Gson().toJson(restApiData);
	}

	//change password
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
//=======================postman test===========================
//	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, consumes={"application/x-www-form-urlencoded"})
//		public String resetPassword(@RequestParam(name = "email") String email, @RequestParam(name = "oldPassword") String password, @RequestParam(name = "newPassword") String newPassword){
//==============================================================
	public String resetPassword(@RequestBody ChangePasswordDto changePasswordDto){
		String email=changePasswordDto.getEmail();
		String oldPassword = changePasswordDto.getOldPassword();
		String newPassword = changePasswordDto.getNewPassword();
		Map<String, String> restApiData = new HashMap<>();
		Map<String, String> verifyData = passwordChangeVerify(email, oldPassword);
		Member member = memberService.findByEmail(email);

		restApiData.put("status", verifyData.get("status"));
		restApiData.put("msg", verifyData.get("msg"));

		if(verifyData.get("status").equals("1")){
			System.out.println(newPassword);
			System.out.println(member.getMemNO());
			memberService.updatePasswordByMemNO(member.getMemNO(),DigestUtils.md5DigestAsHex(newPassword.getBytes()));
		}
		return new Gson().toJson(restApiData);
	}
	//verify login userdata for "/login" action




// ============================= private method part =============================
	private Map<String, Object> loginVerify(String email, String password){
		Map<String, Object> loginResponse = new HashMap();
		try{
			Member member = memberService.findByEmail(email);
			if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(member.getPassword())){
				//status1=登入成功
				loginResponse.put("status","1");
				loginResponse.put("msg","登入成功");
				loginResponse.put("member", member);
			}else{
				//status2=密碼不正確
				loginResponse.put("status","2");
				loginResponse.put("msg","登入失敗，密碼不正確");
			}
		}catch (NullPointerException ne){
			//status3=信箱不正確
			loginResponse.put("status","3");
			loginResponse.put("msg","登入失敗，信箱不正確");
		}
		return loginResponse;
	}
		//verify new password for "/resetPassword" action
	private Map<String, String> passwordChangeVerify(String email, String password){
		Map<String, String> verifyResponse = new HashMap();
		try{
			Member member = memberService.findByEmail(email);

			if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(member.getPassword())){
				//status1=登入成功
				verifyResponse.put("status","1");
				verifyResponse.put("msg","密碼修改成功");
				System.out.println("code======1");
			}else{
				//status2=密碼不正確
				verifyResponse.put("status","2");
				verifyResponse.put("msg","密碼不正確");
			}
		}catch (NullPointerException ne){
			//status3=信箱不正確
			verifyResponse.put("status","3");
			verifyResponse.put("msg","登入資料已過時，請重新登入後再嘗試");
		}
		return verifyResponse;
	}

	//create jwt token for "/login" action
	private String jwtCreator(String email, String permission){
		Date expireDate =
				new Date(System.currentTimeMillis() + 30*60*1000);
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

	//verify user info for "/getNewPassword" action
	private Map<String, Object> forgotVerify(String email, String memNO, String name){
		Map<String, Object> loginResponse = new HashMap();
		try{
			Member member = memberService.findByEmail(email);

			if(memNO.equals(member.getMemNO()) && name.equals(member.getName())){
				//status1=驗證成功
				loginResponse.put("status","1");
				loginResponse.put("msg","驗證成功");
				loginResponse.put("member", member);
			}else{
				//status2=資料錯誤
				loginResponse.put("status","2");
				loginResponse.put("msg","驗證失敗，資料錯誤");
				}
		}catch (NullPointerException ne){
			//status2=資料錯誤
			loginResponse.put("status","2");
			loginResponse.put("msg","驗證失敗");
		}

		return loginResponse;
	}

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


//===============dto===================
//整合後該移動至dto路徑
class ChangePasswordDto {
	String email="";
	String oldPassword="";
	String newPassword="";

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
