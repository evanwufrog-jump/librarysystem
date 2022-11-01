package tw.com.de.librarysystem.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.service.MemberService;

import java.util.Date;

@RestController
public class LoginController {

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login() {
		//輸入模擬
		String email = "evan.wu@frog-jump.com";
		String password = "password";

		Member member = new Member();
		member = memberService.findMemberByEmail("evan.wu@frog-jump.com");
		System.out.println("email："+member.getPermission());
		Date expireDate =
				//設定30min過期時間
				new Date(System.currentTimeMillis() + 30 * 60 * 1000);
		String jwtToken = Jwts.builder()
				.setSubject(email) //我以email當subject
				.setExpiration(expireDate)
				//MySecret是自訂的私鑰，HS512是自選的演算法，可以任意改變
				.signWith(SignatureAlgorithm.HS512, "libsysKey")
				.compact();
		//直接將JWT傳回
		return jwtToken;
	}
}
