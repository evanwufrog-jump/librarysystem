package tw.com.de.librarysystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.de.librarysystem.entity.impl.Book;
import tw.com.de.librarysystem.repository.BookRepository;
import tw.com.de.librarysystem.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	public BookServiceImpl() {
	}

	@Override
	public List<Book> findByTitleContainingOrAuthorContainingOrTechnologyContaining(String title, String author,
			String technology) {
		return bookRepository.findByTitleContainingOrAuthorContainingOrTechnologyContaining(title, author, technology);
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> getBook(Integer id) {
		return bookRepository.findById(id);
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
	public Book save(Book book) {
		return bookRepository.save(book);
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

	@Override
	public List<Book> findByTitleContaining(String title) {
		return bookRepository.findByTitleContaining(title);
	}

}