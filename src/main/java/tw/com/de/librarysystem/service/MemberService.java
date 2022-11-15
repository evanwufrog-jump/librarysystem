package tw.com.de.librarysystem.service;

import tw.com.de.librarysystem.model.entity.impl.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<Member> findAll();

    Member findByEmail(String email);

    Optional<Member> findById(String memNO);

    void updatePasswordByMemNO(String memNO, String password);


}
