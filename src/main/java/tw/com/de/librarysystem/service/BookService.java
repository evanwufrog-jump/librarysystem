package tw.com.de.librarysystem.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tw.com.de.librarysystem.model.dto.BookDto;
import tw.com.de.librarysystem.model.entity.impl.Book;

public interface BookService {
	List<BookDto> findByTitle(String title, String author, String technology);

	List<BookDto> findAll();
	
	BookDto getBook(Integer id);

	boolean delete(Integer id);

	BookDto save(BookDto bookDto);

	void updateStatusById(@Param("id") Integer id);

	void updateStatus2ById(@Param("id") Integer id);

	void updateStatus3ById(@Param("id") Integer id);

	List<Book> findByTitleContaining(String title);

}
