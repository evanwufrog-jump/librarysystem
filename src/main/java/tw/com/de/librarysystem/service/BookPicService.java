package tw.com.de.librarysystem.service;

import java.util.List;

import tw.com.de.librarysystem.model.dto.BookPicDto;
import tw.com.de.librarysystem.model.entity.impl.BookPic;

public interface BookPicService {
	List<BookPic> findAll();

	BookPicDto getBookPic(Integer id);

	boolean delete(Integer id);

	BookPic save(BookPic bookPic);
}
