package tw.com.de.librarysystem.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.entity.impl.Book;
import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.entity.impl.Record;
@Repository
public interface RecordRepository extends JpaRepository<Record, Integer>{

	
	List<Record> findByBook(Book book);
	
	List<Record> findByMember(Member member);
	
//	@Query(nativeQuery = true,
//			value = "select * from RECORD r "
//					+ "left join BOOK b "
//					+ "on b.BOOK_ID = r.BOOK_ID "
//					+ "where TITLE like :title ")
//	List<Record> findByTitleLike(String title);
	
}
