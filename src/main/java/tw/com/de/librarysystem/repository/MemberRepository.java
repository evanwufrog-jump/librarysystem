package tw.com.de.librarysystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.entity.impl.Member;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{
    Member findByEmail(String email);
//    Member findByMemNoAndEmail(String memNo, String email);
    List<Member> findAll();
//    Optional<Member> findByMemNo(String memNo);
    Optional<Member> findById(String memNo);
}
