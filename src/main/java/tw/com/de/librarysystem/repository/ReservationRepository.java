package tw.com.de.librarysystem.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.entity.ReservationTest;
import tw.com.de.librarysystem.entity.impl.Book;
import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.entity.impl.Reservation;
import tw.com.de.librarysystem.model.dto.ReservationDto;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	/*
	public List<Reservation> findByBook(Book book);
//	public List<Reservation> findByBookLikeTitleList(Book book);
	
	@Query(nativeQuery = true,
			value = "select * from de_library_system.reservation r " + 
			"left join de_library_system.book b " +
			"on b.id = r.book_id " +
			" where b.title like :title ;") //%ttle%
	public List<Reservation> findByBookLikeTitle(String title);
	
//	public List<Reservation> findByMemberLikeList(Member member);
	public List<Reservation> findByMember(Member member);
	
//	@Query(nativeQuery = true,
//			value =" " )
//	public List<Reservation> findByMemberLike(String name);
	
//
//	public List<Reservation> findByBookIdList(Integer bookNo);
//	
//	public Optional<Reservation> findById(Integer id);

	*/
	@Query(nativeQuery = true, 
			value = "select "
					+ " r.id , r.`date` , b.author , b.isbn , b.technology , bc.category "
					+ "from reservation r "
					+ "left join book b "
					+ "on r.book_id = b.id "
					+ "left join book_category bc "
					+ "on b.bookcategory_id = bc.id ")
	public List<ReservationTest> findAList();

}
/**
 * value = "select r.id , r.`date` , b.author , b.isbn , b.technology , bc.category "
					+ "from reservation r "
					+ "left join book b "
					+ "on r.book_id = b.id "
					+ "left join book_category bc "
					+ "on b.bookcategory_id = bc.id ")/
 */