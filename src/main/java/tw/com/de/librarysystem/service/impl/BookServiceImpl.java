package tw.com.de.librarysystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.de.librarysystem.model.dto.BookDto;
import tw.com.de.librarysystem.model.dto.BookResponseDto;
import tw.com.de.librarysystem.model.entity.impl.Book;
import tw.com.de.librarysystem.model.repository.BookRepository;
import tw.com.de.librarysystem.service.BookService;
import tw.com.de.librarysystem.utility.Convert;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	public BookServiceImpl() {
	}

	@Override
	public List<BookResponseDto> findByTitle(String title, String author, String technology) {
		List<Book> books = bookRepository.findByTitleContainingOrAuthorContainingOrTechnologyContaining(title, author,
				technology);
		return Convert.mapAll(books, BookResponseDto.class);
	}

	@Override
	public List<BookResponseDto> findAll() {
		List<Book> books = bookRepository.findAll();
		return Convert.mapAll(books, BookResponseDto.class);
	}

	@Override
	public BookResponseDto getBook(Integer id) {
		bookRepository.findById(id);
		Optional<Book> op = bookRepository.findById(id);
		return Convert.map(op, BookResponseDto.class);
	}

	@Override
	public boolean delete(Integer id) {
		boolean flag = false;
		try {
			bookRepository.deleteById(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public ResponseEntity<?> save(BookDto bookDto) {
		Book book = Convert.mapEntity(bookDto, new Book());
		bookRepository.save(book);
		return new ResponseEntity<>(book, HttpStatus.OK);

	}

	// 書本狀態改成借出
	@Override
	public void updateStatusById(Integer id) {
		try {
			bookRepository.updateStatusById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 書本狀態改成上架
	@Override
	public void updateStatus2ById(Integer id) {
		try {
			bookRepository.updateStatus2ById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 書本狀態改成預約中
	@Override
	public void updateStatus3ById(Integer id) {
		try {
			bookRepository.updateStatus3ById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BookResponseDto> findByTitleContaining(String title) {
		List<Book> book = bookRepository.findByTitleContaining(title);
		return Convert.mapAll(book, BookResponseDto.class);
	}

}