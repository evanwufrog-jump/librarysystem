package tw.com.de.librarysystem.reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.de.librarysystem.entity.ReservationTest;
import tw.com.de.librarysystem.entity.impl.Book;
import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.entity.impl.Reservation;
import tw.com.de.librarysystem.model.dto.ReservationDto;
import tw.com.de.librarysystem.repository.BookRepository;
import tw.com.de.librarysystem.repository.ReservationRepository;
import tw.com.de.librarysystem.service.BookService;
import tw.com.de.librarysystem.service.ReservationService;

@SpringBootTest
public class ReservationServiceTest {

//	
	@Autowired
	ReservationService reservationService;

	@Test
	void findAllTest() {
		List<ReservationTest> list = reservationService.findAll();
		System.err.println(list.size());
		for (ReservationTest dto : list) {
			System.err.println(dto.getAuthor());
			System.err.println(dto.getIsbn());
			System.err.println(dto.getTitle());
//			System.err.println(dto.getMemNo());
			System.err.println(dto.getName());
		}
	}

//	
//	@Autowired
//	BookRepository bookRepository;
//	@Autowired
//	BookService bookSVC;
//	
//	@Autowired
//	ReservationRepository reservationRepository;
//	
//	@Test
//	void findAllAndByIdTest () {
//		List<Reservation> listAll = reservationService.findAll();
//		System.err.println("================================");
//		System.out.println(listAll.size());
//		
//		Reservation rese = reservationService.findById(6);
//		System.err.println(rese.getDate());
//	}
//	
//	/*
//	@Test
//	void findByMemberTest() {
//		Member mem = new Member();
//		mem.setMemNO("0001");
//		List<Reservation> resList = reservationService.findAllByMember(mem);
//		if (resList == null || resList.size() == 0) {
//			System.out.println("no reservation: " + resList);
//			
//		} else {
//			System.out.println("共有 " + resList.size() + "筆!");
//
//		}
//	}
//	*/
//	
//	/* // querryByTitleLike
//	@Test
//	void findByBookLikeTitleListTest() {
//		String a = "a";
//		String title = "%" + a + "%";
//		List<Reservation> list = reservationService.findAllByTitle(title);
//		System.out.println(list);
//		System.out.println(list.size());
//	}
//	*/
//	
//	/* //測試成功
//	@Test
//	void updateTest() {
//		Reservation res = reservationRepository.findAll().get(0);
//		res.setStatus("請來取書");
//		reservationService.update(res);
//	}
//	*/
//	
//	
//	// 測試成功，整理後移交
//	@SuppressWarnings("null")
//	@Test
//	void retrunBookTest() {
//		// 以下為按還書後傳入 2022002
//				Integer bookId = 2022001;
//				Optional<Book> op = bookSVC.getBook(bookId);
////				Optional<Book> op = bookRep.findById(bookId);
//				Book book = op.get();
//				System.out.println(book.getTitle());
//				System.out.println(book.getId());
//				// ------------------------
//				
//				//BookDao
//				List<Reservation> resList = reservationRepository.findByBook(book);
//				System.err.println("what !!!" + resList);
//				// 沒預約
//				if (resList == null || resList.size() == 0) {
//					Reservation reservation = resList.get(0);
//					reservationRepository.delete(reservation); //這是dao的方法
////					reservationService.delete(reservation.getId()); // 這是呼叫service
//
//					book.setStatus("重新上架架上！！！");//要改成定義的名稱
////					System.out.println(book.getStatus());
//					bookRepository.save(book);
//					System.err.println("可借閱");
//				// 有預約	
//				} else {
//					Reservation res = resList.get(0);
//					res.setStatus("11111待取書");// 待取書
////					System.out.println( res.getId()+ "       " + resList.get(0).getStatus());
//					
//					reservationRepository.save(resList.get(0));// 這是dao的方法
////					reservationService.update(resList.get(0));// 這是呼叫service
////					System.err.println("請來取書");
//					//系統發信
//
//				}
//		
//	}
//	
//	
//	
//	
//	
//	/*
//	//又不能新增了，再確認
//	@Test
//	void insertTest() {
//		
//		Reservation res = new Reservation();
//		Member member = new Member();
//		member.setMemNO("0001");
//		Book book = new Book();
//		book.setId(2022001);
//		
//		res.setBook(book);
//		res.setDate(LocalDate.now());
//		res.setMember(member);
//		res.setStatus("預約中");
//		
//		//res.set
//		
////		Integer num = resSVC.insert(res);
////		System.out.println("新增" + num + "筆");
//	}
//	*/
//	
//	/*
//	@Test
//	void deleteTest() {
//		Integer id = 5;
//		Integer num = reservationService.delete(id);
//		System.out.println(num);
//	}
//	*/

}
