package tw.com.de.librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.repository.MemberDao;
import tw.com.de.librarysystem.entity.impl.Member;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public List<Member> findMemberAll(){
		return memberDao.findAll();
	}
	
//	public Member findByMemNo(String memNo){
//		return memberDao.findByMemNo("memNo");		
//	}


}
