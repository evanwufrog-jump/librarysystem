package tw.com.de.librarysystem.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.entity.impl.Book;
import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.entity.impl.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	
//	// 新增
//	
//	// 修改
//	
//	// 刪除
//	
//	// 修改
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

}
