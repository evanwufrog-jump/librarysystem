package tw.com.de.librarysystem.service;

import java.util.List;
import java.util.Optional;


import tw.com.de.librarysystem.entity.impl.Book;

public interface BookService {
	List<Book> findByTitleContainingOrAuthorContainingOrTechnologyContaining(String title, String author,
			String technology);

	List<Book> findAll();

	Optional<Book> getBook(Integer pk);
	
	void delete(Integer pk);
	
	Book saveOrUpdate(Book book);
}
