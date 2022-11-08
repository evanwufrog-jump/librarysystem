package tw.com.de.librarysystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.model.entity.impl.Member;
import tw.com.de.librarysystem.model.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepository;

	public List<Member> findAll(){
		return memberRepository.findAll();
	}

	public Member findMemberByEmail(String email){return memberRepository.findByEmail(email);};

	public Optional<Member> findByMemNo(String memNo){
		return memberRepository.findById(memNo);
	}
}


