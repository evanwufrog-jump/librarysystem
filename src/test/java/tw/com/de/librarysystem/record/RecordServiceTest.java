package tw.com.de.librarysystem.record;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.de.librarysystem.model.dto.RecordDto;
import tw.com.de.librarysystem.model.entity.impl.Book;
import tw.com.de.librarysystem.model.entity.impl.Member;
import tw.com.de.librarysystem.model.entity.impl.Record;
import tw.com.de.librarysystem.model.entity.impl.Reservation;
import tw.com.de.librarysystem.model.repository.BookRepository;
import tw.com.de.librarysystem.model.repository.RecordRepository;
import tw.com.de.librarysystem.model.repository.ReservationRepository;
import tw.com.de.librarysystem.service.BookService;
import tw.com.de.librarysystem.service.RecordService;
import tw.com.de.librarysystem.service.ReservationService;

@SpringBootTest
public class RecordServiceTest {

	@Autowired
	RecordService recordService;
	
	@Autowired
	BookRepository bookRepository;
	
	@Test
	void deleteTest() {
		RecordDto dto = new RecordDto();
		dto.setId(2);
		recordService.delete(dto);
	}
	
	/*
	@Test
	void insertTest() {
		RecordDto dto = new RecordDto();
		dto.setBookId(1);
		dto.setBookTitle(null);
		dto.setMemberMemNo("0001");
		dto.setLendingCheckedDate(LocalDate.of(2021, 1, 5));
		
//		Book book = new Book(); book.setId(2022001);
//		Member member = new Member(); member.setMemNO("0001");
//		LocalDate date = LocalDate.of(2020, 1, 5);
//		record.setBook(book);
//		record.setLendingDate(date);
//		record.setMember(member);
		recordService.insert(dto);
	}
	*/
	/*
	@Test
	void updateTest() {
		Record record = recordService.getById(2);
		if (record != null) {
			System.err.println(record.getLendingDate());
			record.setReturnDate(LocalDate.of(2021, 1, 5));
			recordService.update(record);
			
		} else {
			System.out.println("nothing");
		}
		
		
	}
	*/
	
	/*
	@Test
	void findAllTest() {
		List<Record> list = recordService.findAll();
		System.err.println(list.size());
	}
	
	@Test
	void findAllByMemberTest() {
		Member member = new Member();member.setMemNO("0001");
		List<Record> list = recordService.findAllByMember(member);
		System.err.println("0001================>" + list.size());
		member.setMemNO("0002");
		list = recordService.findAllByMember(member);
		System.err.println("0002================>" + list.size());
	}
	*/
	/*// 資料不對
	@Test
	void findByTitleLike() {
		List<Record> list = recordService.findByTitleLike("v");
		System.err.println(list.size());
	}
	*/
	// null無法列印
	/*
	@Test
	void findByBookNo() {
		List<Record> list = recordService.findByBookNo(2022001);
		System.err.println(list.size() + "<+++++++++");
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<> ();
		List<Integer> list2 = new ArrayList<> ();
		List<Integer> list = new ArrayList<> ();
		list1.add(1);
		list1.add(5);
		list1.add(3);
		list2.add(9);
		list2.add(6);
		list2.add(6);
		list2.add(7);
		list.addAll(list2);
		list.addAll(list1);
		System.out.println(list);
	}
	*/
	
	

	
}
