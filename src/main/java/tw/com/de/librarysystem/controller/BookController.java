package tw.com.de.librarysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.entity.impl.Book;
import tw.com.de.librarysystem.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/bookSearch")
	public void bookSearch (String title, String author, String technology) {
		bookService.findByTitleContainingOrAuthorContainingOrTechnologyContaining(title, author, technology);
	}
	@GetMapping("/findAll")
	public List<Book> findAll(){
		return bookService.findAll();
	}
}
