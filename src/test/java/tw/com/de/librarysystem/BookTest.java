package tw.com.de.librarysystem;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.de.librarysystem.model.dto.BookDto;
import tw.com.de.librarysystem.model.entity.impl.BookPic;
import tw.com.de.librarysystem.service.BookService;

@SpringBootTest
public class BookTest {
	@Autowired
	private BookService bookService;

//	@Test
//	void bookTest() {
//		bookService.findAll();
//	}
	
	@Test
	void test() {
		BookDto dto = new BookDto();
		dto.setId(2);
		dto.setDay(50);
		BookPic picDto = new BookPic();
//		picDto.setId(1);
//		picDto.setBookId(2);
		picDto.setPicture("cccccc");
//		Set<BookPicDto> setDto = new HashSet<BookPicDto>();
//		setDto.add(picDto);
		Set<BookPic> bookPics = new HashSet<>();
		bookPics.add(picDto);
//		picDto.setId(2);
		picDto.setPicture("ddddd");
//		setDto.add(picDto);
		
//		dto.setBookPics(setDto);
//		BookPic pic = new BookPic();
//		pic.setId(1);
//		pic.setPicture("111");
//		Set<BookPic> set = new HashSet<BookPic>();
//		set.add(pic);
		
		
		bookService.save(dto);
	}
}

