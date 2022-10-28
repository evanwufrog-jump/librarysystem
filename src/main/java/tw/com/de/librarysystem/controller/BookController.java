package tw.com.de.librarysystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.entity.impl.Book;
import tw.com.de.librarysystem.service.BookService;
@RequestMapping("/api")
@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	public void bookSearch(String title, String author, String technology) {
		bookService.findByTitleContainingOrAuthorContainingOrTechnologyContaining(title, author, technology);
	}

	@GetMapping("/list")
	public List<Book> findAll() {
		return bookService.findAll();
	}

	@PostMapping("/book")
	public void saveOrUpdate(Book book) {
		bookService.saveOrUpdate(book);
	}

	@DeleteMapping("/book/{id}")
	public String delete(@PathVariable("id") Integer pk) {
		bookService.delete(pk);
		System.out.println("OK");
		return "OK DELETE";
	}

}
