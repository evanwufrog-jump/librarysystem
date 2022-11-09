package tw.com.de.librarysystem.service;

import tw.com.de.librarysystem.entity.impl.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<Member> findAll();

//    Optional<Member> findByMemNo(String memNo);

    Member findByEmail(String email);

//    Member findByMemNoAndEmail(String memNo,String email);

    Optional<Member> findById(String memNo);
}
