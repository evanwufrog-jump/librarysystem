package tw.com.de.librarysystem.controller;

import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.service.MemberService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

	@Autowired
	MemberService memberService;

	//如果登入成功，會取得jwt，前端存入cookie，若登入失敗則收到fail
	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@RequestBody Member member) {

//============PostMan Test===============
	public String login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
		Member member = new Member();
		member.setEmail(email);
		member.setPassword(password);
//=======================================

		Map<String,String> map = new HashMap();
		String loginStatus = userVerify(member.getEmail(),member.getPassword());
		map.put("loginStatus",loginStatus);

		if(loginStatus.equals("success")){
			map.put("jwt",jwtCreator(member.getEmail(),member.getPermission()));
			map.put("permission", member.getPermission());
		}

		String loginResponse = new Gson().toJson(map);
		System.out.println(loginResponse);
		return loginResponse;
	}

	@RequestMapping(value = "/missingPassoword", method = RequestMethod.POST)
	public String missingPassword(@RequestParam(name = "email") String email) {

		return "";
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public String resetPassword() {

		return "";
	}


	private String userVerify(String email, String password){
		String loginResponse;
		try{
			Member member = memberService.findMemberByEmail(email);

			if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(  member.getPassword())){
				loginResponse="success";
			}else{
				loginResponse="wrong password";
			}
		}catch (NullPointerException ne){
			loginResponse = "wrong email";
		}
		return loginResponse;

}

	private String jwtCreator(String email, String permission){
	Date expireDate =
			new Date(System.currentTimeMillis() + 30 * 60 * 1000);
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
