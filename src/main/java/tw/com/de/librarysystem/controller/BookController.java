package tw.com.de.librarysystem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.entity.impl.Book;
import tw.com.de.librarysystem.entity.impl.BookNo;
import tw.com.de.librarysystem.repository.BookNoRepository;
import tw.com.de.librarysystem.service.BookService;

@RequestMapping("/book")
@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@Autowired
	private BookNoRepository bookNoRepository;
	
	@Autowired
	BookNo bookNo;

	@GetMapping("/bookSearch")
	public void bookSearch(String title, String author, String technology) {
		System.out.println("條件查詢成功");
		bookService.findByTitleContainingOrAuthorContainingOrTechnologyContaining(title, author, technology);
	}

	@GetMapping("/bookSearch2")
	public void bookSearch2(String title) {
		System.out.println("單條件查詢成功");
		bookService.findByTitleContaining(title);
		System.out.println(bookService.findByTitleContaining(title));
	}

	@GetMapping("/book")
	public List<Book> findAll() {
		System.out.println("搜尋成功");
		return bookService.findAll();
	}
	
	@PostMapping("/book")
	public void save(Book book, Integer year,BookNo bookNo) {
		String date = new SimpleDateFormat("yyyy").format(new Date());
		int bookYear = Integer.valueOf(date);
		System.out.println(bookYear);
		bookNo.setYear(bookYear);
		bookNoRepository.findBookNoByYear(year);
		bookService.save(book);
		System.out.println("新增成功");
	}
	
	
	@PostMapping("/book1")
	public void save1(Book book,Integer year) {
		
		if() {
		Integer number;
		BookNo bookNo = bookNoRepository.findBookNoByYear(year);
		if (bookNo == null) {
			number = 1;
			bookNo = new BookNo();
			bookNo.setNumber(number + 1);
			bookNo.setYear(year);
			bookNoRepository.save(bookNo);
			return year * 1000 + number;
		} else {
			number = bookNo.getNumber();
			bookNo.setNumber(number + 1);
			bookNoDao.save(bookNo);
			return year * 1000 + number;
		}}
		
		
		String date = new SimpleDateFormat("yyyy").format(new Date());
		int bookYear = Integer.valueOf(date);
		System.out.println(bookYear);
		bookNo.setYear(bookYear);
		bookNoRepository.findBookNoByYear(bookYear);
	}
	
	
	
	
	
	
	
	

	@DeleteMapping("/book/{id}")
	public boolean delete(@PathVariable("id") Integer id) {
		System.out.println("刪除成功");
		return bookService.delete(id);
	}

	@GetMapping("/updateStatusById/{id}")
	public void updateStatusById(@PathVariable("id") Integer id) {
		System.out.println("狀態(借出)修改成功");
		bookService.updateStatusById(id);
	}

	@GetMapping("/updateStatus2ById/{id}")
	public void updateStatus2ById(@PathVariable("id") Integer id) {
		System.out.println("狀態(上架)修改成功");
		bookService.updateStatus2ById(id);
	}

}
