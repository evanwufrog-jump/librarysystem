package tw.com.de.librarysystem.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tw.com.de.librarysystem.model.entity.impl.Book;
import tw.com.de.librarysystem.model.entity.impl.Member;
import tw.com.de.librarysystem.model.entity.impl.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{


	public List<Reservation> findByBook(Book book);
//	public List<Reservation> findByBookLikeTitleList(Book book);
	
	@Query(nativeQuery = true,
			value = "select * from de_library_system.reservation r " + 
			"left join de_library_system.book b " +
			"on b.id = r.book_id " +
			" where b.title like :title "  //%title%
			+ "or 1 = 1 ")
	public List<Reservation> findByBookLikeTitle(String title);
	
//	public List<Reservation> findByMemberLikeList(Member member);
	public List<Reservation> findByMember(Member member);
	
	@Query(nativeQuery = true,
			value = "select * "
					+ "from RESERVATION r "
					+ "left join BOOK b "
					+ "on r.BOOK_ID = b.ID "
					+ "left join `MEMBER` m "
					+ "on m.ID = r.MEMBER_ID "
					+ "where MEMBER_ID = :memberId "
					+ "or 1 = 1 ")
	public List<Reservation> findByMemberId(@Param("memberId") Integer memberId);
	
	
//	@Query(nativeQuery = true,
//			value =" " )
//	public List<Reservation> findByMemberLike(String name);
	
//
//	public List<Reservation> findByBookIdList(Integer bookNo);
//	
//	public Optional<Reservation> findById(Integer id);

	@Override
//	@Query(nativeQuery = true,
////	value = "select * "
//	value = "select "
//			+ "r.id , r.`date` , r.status , r.book_id , r.member_memno , b.* "
////			+ "b.id , b.author , b.`day` , b.desecription , b.isbn , b.post_start , "
////			+ "b.publish_date , b.publisher , b.status , b.technology , b.title , b.bookcategory_id , b.description  "
//			+ "from de_library_system.reservation r "
//			+ "left join de_library_system.book b "
//			+ "on r.book_id = b.id; ")
	public List<Reservation> findAll();
	
}
