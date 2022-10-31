package tw.com.de.librarysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.service.MemberService;

@RestController
public class LoginController {
	
//	@Autowired
//	MemberService memberService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login() {
		
//		Member member = memberService.findMemByMemNo("0700");
//		System.out.println(member);
		
		return "security/mylogin";
	}
}
