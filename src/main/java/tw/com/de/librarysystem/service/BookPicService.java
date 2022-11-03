package tw.com.de.librarysystem.service;

import java.util.List;
import java.util.Optional;

import tw.com.de.librarysystem.entity.impl.BookPic;

public interface BookPicService {
	List<BookPic> findAll();
	
	Optional<BookPic> getBookPic(Integer id);
	
	boolean delete(Integer id);
	
	BookPic save(BookPic bookPic);
}
