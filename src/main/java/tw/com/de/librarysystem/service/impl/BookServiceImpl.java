package tw.com.de.librarysystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.de.librarysystem.model.dto.BookDto;
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
	public List<BookDto> findByTitle(String title, String author, String technology) {
		List<Book> books = bookRepository.findByTitleContainingOrAuthorContainingOrTechnologyContaining(title, author,
				technology);
		return books.stream().map(t -> (BookDto) Convert.toDto(t, Convert.toDto(t, new BookDto())))
				.collect(Collectors.toList());
	}

	@Override
	public List<BookDto> findAll() {
		List<Book> books = bookRepository.findAll();
		List<BookDto> bookDtos = books.stream()
				.map(book -> (BookDto) Convert.toDto(book, Convert.toDto(book, new BookDto())))
				.collect(Collectors.toList());
		System.out.println(bookDtos.toString());
		return books.stream().map(book -> (BookDto) Convert.toDto(book, Convert.toDto(book, new BookDto())))
				.collect(Collectors.toList());

	}

	@Override
	public BookDto getBook(Integer id) {
		bookRepository.findById(id);
		Optional<Book> op = bookRepository.findById(id);
		BookDto bookDto = null;
		if (op.isPresent()) {
			bookDto = Convert.toDto(op.get(), new BookDto());
		}
		return bookDto;

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
	public BookDto save(BookDto bookDto) {
		Book book = new Book();
		Book book2 = bookRepository.save(book);
		return Convert.toEntity(bookDto, book2);
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
	public List<Book> findByTitleContaining(String title) {
		return bookRepository.findByTitleContaining(title);
	}

}