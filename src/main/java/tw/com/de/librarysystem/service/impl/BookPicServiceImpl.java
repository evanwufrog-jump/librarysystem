package tw.com.de.librarysystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.model.dto.BookPicDto;
import tw.com.de.librarysystem.model.entity.impl.BookPic;
import tw.com.de.librarysystem.model.repository.BookPicRepository;
import tw.com.de.librarysystem.service.BookPicService;
import tw.com.de.librarysystem.utility.Convert;

@Service
public class BookPicServiceImpl implements BookPicService {

	@Autowired
	private BookPicRepository bookPicRepository;

	@Override
	public List<BookPic> findAll() {
		return bookPicRepository.findAll();
	}

	@Override
	public BookPicDto getBookPic(Integer id) {
		Optional<BookPic> bookPic = bookPicRepository.findById(id);
		BookPicDto bookPicDto = Convert.toDto(bookPic.get(),new BookPicDto());
		return bookPicDto;
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
