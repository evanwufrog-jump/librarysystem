package tw.com.de.librarysystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.entity.impl.Member;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{
    Member findByEmail(String email);
    List<Member> findAll();
    Optional<Member> findById(String memNO);

//    @Modifying
//    @Query("update Member member set member.password = :password where member.memNO = :memNO")
//    void updatePasswordByMemNO(@Param("memNO")String memNO, @Param("password")String password);

    @Modifying
    @Query(
            nativeQuery=true,
            value = "update Member member set member.`password` = :password where member.memNO = :memNO")
    void updatePasswordByMemNO(@Param("memNO")String memNO, @Param("password")String password);

}
