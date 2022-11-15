package tw.com.de.librarysystem.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.model.entity.impl.Book;
import tw.com.de.librarysystem.model.entity.impl.Member;
import tw.com.de.librarysystem.model.entity.impl.Record;
@Repository
public interface RecordRepository extends JpaRepository<Record, Integer>{

	
	// book的id->bookID要調整，先不動。
	List<Record> findByBook(Book book);	
	
	// OK
	@Query(nativeQuery = true,
			value = "select * "
					+ "from RECORD r "
					+ "left join BOOK b "
					+ "on r.BOOK_ID = b.ID "
					+ "left join `MEMBER` m "
					+ "on m.ID = r.MEMBER_ID "
					+ "where TITLE like :title "
					+ "or 1 = 1 ")
	List<Record> findByBookTitleContain(@Param(value = "title")String title);
	
//	List<Record> findByBooList(Book book);
	
	List<Record> findByMember(Member member); // 用不到, 下一個用SQL取代
	
	@Query(nativeQuery = true,
	value = "select * "
			+ "from RECORD r "
			+ "left join BOOK b "
			+ "on r.BOOK_ID = b.ID "
			+ "left join `MEMBER` m "
			+ "on m.ID = r.MEMBER_ID "
			+ "where MEMBER_ID = :memberId "
			+ "or 1 = 1 ")
	List<Record> findByMemberId(@Param("memberId") Integer memberId);
	
//	@Query(nativeQuery = true,
//			value = "select * from RECORD r "
//					+ "left join BOOK b "
//					+ "on b.BOOK_ID = r.BOOK_ID "
//					+ "where TITLE like :title ")
//	List<Record> findByTitleLike(String title);
	
}
