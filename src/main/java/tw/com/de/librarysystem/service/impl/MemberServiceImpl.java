package tw.com.de.librarysystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.repository.MemberRepository;
import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.service.MemberService;

import javax.transaction.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Transactional
	@Override
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	@Transactional
	@Override
	public Member findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	@Transactional
	@Override
	public Optional<Member> findById(String memNO) {
		return memberRepository.findById(memNO);
	}

	@Transactional
	@Override
	public void updatePasswordByMemNO(String memNO, String password){
		memberRepository.updatePasswordByMemNO(memNO,password);
	}


}


