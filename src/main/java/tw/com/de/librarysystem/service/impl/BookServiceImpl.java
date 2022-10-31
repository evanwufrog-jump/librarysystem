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
	public Optional<Book> getBook(Integer id) {
		return bookDao.findById(id);
	}

	@Override
	public boolean delete(Integer id) {
		boolean flag = false;
		try {
			bookDao.deleteById(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Book save(Book book) {
		return bookDao.save(book);
	}
	
	//書本狀態改成借出
	@Override
	public void updateStatusById(Integer id) {
		try {
			bookDao.updateStatusById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//書本狀態改成上架
	@Override
	public void updateStatus2ById(Integer id) {
		try {
			bookDao.updateStatus2ById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}