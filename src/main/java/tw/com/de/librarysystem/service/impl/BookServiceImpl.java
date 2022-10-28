package tw.com.de.librarysystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.de.librarysystem.entity.impl.Book;
import tw.com.de.librarysystem.repository.BookDao;
import tw.com.de.librarysystem.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	public BookServiceImpl() {
	}

	@Override
	public List<Book> findByTitleContainingOrAuthorContainingOrTechnologyContaining(String title, String author,
			String technology) {
		return bookDao.findByTitleContainingOrAuthorContainingOrTechnologyContaining(title, author, technology);
	}

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public Optional<Book> getBook(Integer pk) {
		return bookDao.findById(pk);
	}

	@Override
	public void delete(Integer pk) {
		bookDao.deleteById(pk);
	}

	@Override
	public Book saveOrUpdate(Book book) {
		return bookDao.save(book);
	}

}