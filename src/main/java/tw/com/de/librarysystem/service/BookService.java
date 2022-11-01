package tw.com.de.librarysystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import tw.com.de.librarysystem.entity.impl.Book;

public interface BookService {
	List<Book> findByTitleContainingOrAuthorContainingOrTechnologyContaining(String title, String author,
			String technology);

	List<Book> findAll();

	Optional<Book> getBook(Integer id);
	
	boolean delete(Integer id);
	
	Book save(Book book);
	
	void updateStatusById(@Param("id")Integer id);
	
	void updateStatus2ById(@Param("id")Integer id);
	
	List<Book> findByTitleContaining(String title);
}
