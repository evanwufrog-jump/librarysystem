package tw.com.de.librarysystem.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tw.com.de.librarysystem.model.dto.BookDto;
import tw.com.de.librarysystem.model.dto.BookResponseDto;

public interface BookService {
	List<BookResponseDto> findByTitle(String title, String author, String technology);

	List<BookResponseDto> findAll();
	
	BookResponseDto getBook(Integer id);

	boolean delete(Integer id);

	Integer save(BookDto bookDto);

	void updateStatusById(@Param("id") Integer id);

	void updateStatus2ById(@Param("id") Integer id);

	void updateStatus3ById(@Param("id") Integer id);

	List<BookResponseDto> findByTitleContaining(String title);

}
