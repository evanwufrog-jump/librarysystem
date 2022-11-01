package tw.com.de.librarysystem.bookno;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.de.librarysystem.entity.impl.BookNo;
import tw.com.de.librarysystem.service.BookNoService;

@SpringBootTest
public class BookNoServiceTest {
	
//	@Autowired
//	BookNoDao bookNoDao;
	
	@Autowired
	BookNoService bookNoServiceimpl;
	
	/*
	@Test
	void findBookNoByYearTest() {
		Integer year = 2024;
		Integer bookNo = bookNoServiceimpl.getBookNoByYear(year);
		System.out.println("BOOK_Number:" +bookNo);
	}
	*/
	
	/*
	@Test
	void findAllTest() {
		List<BookNo> list = bookNoServiceimpl.findAll();
		for(BookNo bookNo : list) {
			System.out.print("id: " + bookNo. getId() + "; ");
			System.out.print("year: " + bookNo. getYear() + "; ");
			System.out.print("number: " + bookNo. getNumber() + "; ");
			System.out.println();
			System.err.println("------------------------------");
			System.out.println();
		}
	}
	*/
	
	
	@Test
	void getByYearTest() {
		Integer year, number;
		year = 1999;
		number = bookNoServiceimpl.getByYear(year);
		if (number != 0) {
			System.out.println("目前編號: " + number);
			
		} else {
			System.out.println("目前沒有編號");
		}
		
	}
	
	
	@Test
	void updateNumberTest() {
		BookNo bookNo = new BookNo();
		bookNo.setNumber(99);
		bookNo.setId(1);
		boolean flag = bookNoServiceimpl.updateNumber(bookNo);
		if(flag) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失敗");
		}
		
	}
	
	/*
	@Test
	void findAllTest() {
		List<BookNo> list = new ArrayList<>();
		list = bookNoServiceimpl.findAll();
		System.out.println("圖書編號有" + list.size() + "筆");
	}
	*/
	/*
	@Test
	void findBookNoByYearTest() {
		BookNo bookNo = new BookNo();
		bookNo = bookNoServiceimpl.findBookNoByYear(2022);
		System.err.println("以下測試");
		System.out.println(bookNo.getYear());
		System.err.println("--------------------");
	}
	*/
/*	
	@Test
	void findById() {
		System.out.println(bookNoServiceimpl.findById(1).getNumber());
		
	}
	*/
	
	
	/*
	@Test
	void updateBookNoTest() {
		
		bookNoServiceimpl.updateNumberById("9527", 1);

		
		System.err.println("以下測試, new BOOK_NO=>");
		String str = bookNoServiceimpl.findByIdA(1).getNumber();
		System.out.println(str);

		System.err.println("--------------------");
	}
	*/
	
	/*
	@Test
	void ttTest() {
		BookNo bookNo = bookNoServiceimpl.findById(1);
		if (bookNo != null)
			System.err.println("-->>" + bookNo.getNumber());
		else {
			System.err.println("Can't find it");
			
		}
		
		
		
		bookNo = bookNoServiceimpl.findById(2);
		if (bookNo != null)
			System.err.println("-->>" + bookNo.getNumber());
		else {
			System.err.println("Can't find it");
			
		}
		 
	}
	*/
	
}
