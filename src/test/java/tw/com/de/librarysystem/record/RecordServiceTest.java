package tw.com.de.librarysystem.record;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.de.librarysystem.model.entity.impl.Record;
import tw.com.de.librarysystem.model.repository.BookRepository;
import tw.com.de.librarysystem.service.RecordService;

@SpringBootTest
public class RecordServiceTest {

	@Autowired
	RecordService recordService;
	
	@Autowired
	BookRepository bookRepository;
	
	/*
	@Test
	void insertTest() {
		Record record = new Record();
		Book book = new Book(); book.setId(2022001);
		Member member = new Member(); member.setMemNO("0001");
		LocalDate date = LocalDate.of(2020, 1, 5);
		record.setBook(book);
		record.setLendingDate(date);
		record.setMember(member);
		recordService.insert(record);
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
	
	
	

	
}
