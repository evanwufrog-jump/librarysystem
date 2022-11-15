package tw.com.de.librarysystem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.model.dto.BookDto;
import tw.com.de.librarysystem.model.dto.BookResponseDto;
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
	public List<BookResponseDto> bookSearch(String title, String author, String technology) {
		List<BookResponseDto> books = bookService.findByTitle(title, author, technology);
		return books;
	}

	@GetMapping("/bookSearch2/{title}")
	public List<BookResponseDto> bookSearch2(@PathVariable String title) {
		List<BookResponseDto> books = bookService.findByTitleContaining(title);
		System.out.println(bookService.findByTitleContaining(title));
		return books;
	}

	@GetMapping("/bookid/{id}")
	public BookResponseDto getBook(@PathVariable Integer id) {
		return bookService.getBook(id);
	}

	@GetMapping("/book")
	public List<BookResponseDto> findAll() {
		return bookService.findAll();
	}

	@PostMapping("/book")
	public ResponseEntity<?> save(BookDto bookdto, Integer year) {
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
			bookdto.setBookNo(i);
		} else {
			number = bookNo.getNumber();
			bookNo.setNumber(number + 1);
			bookNoRepository.save(bookNo);
			int i = (year * 1000) + number;
			bookdto.setBookNo(i);

		}
		return bookService.save(bookdto);
	}

	@DeleteMapping("/book/{id}")
	public boolean delete(@PathVariable("id") Integer id) {
		boolean flag = false;
		try {
			bookService.delete(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 借出
	@GetMapping("/updateStatusById/{id}")
	public boolean updateStatusById(@PathVariable("id") Integer id) {
		boolean flag = false;
		try {
			bookService.updateStatusById(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 上架
	@GetMapping("/updateStatus2ById/{id}")
	public boolean updateStatus2ById(@PathVariable("id") Integer id) {
		boolean flag = false;
		try {
			bookService.updateStatus2ById(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 預約
	@GetMapping("/updateStatus3ById/{id}")
	public boolean updateStatus3ById(@PathVariable("id") Integer id) {
		boolean flag = false;
		try {
			bookService.updateStatus3ById(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
