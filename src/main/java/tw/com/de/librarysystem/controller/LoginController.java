package tw.com.de.librarysystem.controller;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import tw.com.de.librarysystem.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

	@Autowired
	MemberService memberService;

	//如果登入成功，會取得jwt，前端存入cookie，若登入失敗則收到fail
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
		JwtVerifyUser jwtVerifyUser = new JwtVerifyUser();
		jwtVerifyUser.setMemberService(memberService);

		String loginResponse = jwtVerifyUser.userVerify(email,password);
		return loginResponse;
	}

////測試filter用的method
//	@RequestMapping(value="/test", method = RequestMethod.POST)
//	public String testMethod(){
//		System.out.println("email = "+memberService.findByMemNo("0700").get().getEmail());
//		return "nullllll";
//	}

}
