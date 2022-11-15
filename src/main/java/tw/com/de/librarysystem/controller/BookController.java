package tw.com.de.librarysystem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.model.entity.impl.Book;
import tw.com.de.librarysystem.model.entity.impl.BookNo;
import tw.com.de.librarysystem.model.repository.BookNoRepository;
import tw.com.de.librarysystem.service.BookService;

@RequestMapping("/book")
@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@Autowired
	private BookNoRepository bookNoRepository;

	@GetMapping("/bookSearch")
	public List<Book> bookSearch(String title, String author, String technology) {
		System.out.println("條件查詢成功");
		List<Book> books = bookService.findByTitleContainingOrAuthorContainingOrTechnologyContaining(title, author,
				technology);
		System.out.println(books.toString());
		return books;
	}

	@GetMapping("/bookSearch2/{title}")
	public List<Book> bookSearch2(@PathVariable String title) {
		System.out.println("單條件查詢成功");
		List<Book> books = bookService.findByTitleContaining(title);
		System.out.println(bookService.findByTitleContaining(title));
		return books;
	}
	
	@GetMapping("/bookid/{id}")
	public Optional<Book> getBook(@PathVariable Integer id) {
		Optional<Book> book = bookService.getBook(id);
		return book;
	}
	
	@GetMapping("/book")
	public List<Book> findAll() {
		System.out.println("搜尋成功");
		return bookService.findAll();
	}

	@PostMapping("/book")
	public boolean save(Book book, Integer year) {
		boolean flag = false;
		try {
			String date = new SimpleDateFormat("yyyy").format(new Date());
			year = Integer.valueOf(date);
			Integer number;
			BookNo bookNo = bookNoRepository.findBookNoByYear(year);
			if (bookNo == null) {
				number = 1;
				bookNo = new BookNo();
				bookNo.setNumber(number + 1);
				bookNo.setYear(year);
				bookNoRepository.save(bookNo);
				int i = (year * 1000) + number;
				book.setId(i);
			} else {
				number = bookNo.getNumber();
				bookNo.setNumber(number + 1);
				bookNoRepository.save(bookNo);
				int i = (year * 1000) + number;
				book.setId(i);

			}
			bookService.save(book);
			System.out.println("新增成功");
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@DeleteMapping("/book/{id}")
	public boolean delete(@PathVariable("id") Integer id) {
		boolean flag = false;
		try {
			System.out.println("刪除成功");
			bookService.delete(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@GetMapping("/updateStatusById/{id}")
	public boolean updateStatusById(@PathVariable("id") Integer id) {
		boolean flag = false;
		try {
			System.out.println("狀態(借出)修改成功");
			bookService.updateStatusById(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@GetMapping("/updateStatus2ById/{id}")
	public boolean updateStatus2ById(@PathVariable("id") Integer id) {
		boolean flag = false;
		try {
			System.out.println("狀態(上架)修改成功");
			bookService.updateStatus2ById(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@GetMapping("/updateStatus3ById/{id}")
	public boolean updateStatus3ById(@PathVariable("id") Integer id) {
		boolean flag = false;
		try {
			System.out.println("狀態(預約中)修改成功");
			bookService.updateStatus3ById(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
