package tw.com.de.librarysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import tw.com.de.librarysystem.service.MemberService;


public class JwtVerifier {
    @Autowired
    MemberService memberService;
//    MemberService memberService = new MemberService();

    public void JwtVerifierTest(){

        String email = "evan.wu@frog-jump.com";
        memberService.findMemberByEmail(email);

    }


}
