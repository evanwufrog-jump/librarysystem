package tw.com.de.librarysystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.entity.impl.BookPic;
import tw.com.de.librarysystem.repository.BookPicRepository;
import tw.com.de.librarysystem.service.BookPicService;

@Service
public class BookPicServiceImpl implements BookPicService {

	@Autowired
	private BookPicRepository bookPicRepository;

	@Override
	public List<BookPic> findAll() {
		return bookPicRepository.findAll();
	}

	@Override
	public Optional<BookPic> getBookPic(Integer id) {
		return bookPicRepository.findById(id);
	}

	@Override
	public boolean delete(Integer id) {
		bookPicRepository.deleteById(id);
		return false;
	}

	@Override
	public BookPic save(BookPic bookPic) {
		return bookPicRepository.save(bookPic);
	}

}
