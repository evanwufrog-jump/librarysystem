package tw.com.de.librarysystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.entity.impl.BookNo;

@Repository
public interface BookNoRepository extends JpaRepository<BookNo, Integer>{

	@Query(
			nativeQuery = true,
			value ="select * from BOOK_NO where year = :year ")
	 BookNo findBookNoByYear(Integer year);
	
//	@Query(value = "select * from BOOK_No where year like :date", nativeQuery =  true)
//	BookNo findByYearLike(String date);
	
	@Modifying
	@Query(
			nativeQuery = true,
			value = " update BOOK_NO bn set bn.`NUMBER` = :number WHERE bn.ID = :id ")
	void updateNumberById(@Param("number") Integer number, @Param("id") Integer id);
	
	@Query(nativeQuery = true,
			value = " select * from BOOK_NO where ID=:id ")
	BookNo findBById(Integer id);
	
//	List<BookNo> findByYear(Integer year);
	
	

}
