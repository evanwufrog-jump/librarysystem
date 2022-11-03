package tw.com.de.librarysystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.entity.impl.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{
    Member findByEmail(String email);

}
