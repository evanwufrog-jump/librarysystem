package tw.com.de.librarysystem.service;

import java.util.List;

import tw.com.de.librarysystem.entity.impl.Book;

public interface BookService {
	List<Book> findByTitleContainingOrAuthorContainingOrTechnologyContaining(String title, String author,
			String technology);
	
	List<Book> findAll();
}
