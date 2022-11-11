package tw.com.de.librarysystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.de.librarysystem.model.dto.BookDto;
import tw.com.de.librarysystem.model.dto.BookPicDto;
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
		dto.setDay(30);
		BookPicDto picDto = new BookPicDto();
		picDto.setId(2);
		
		bookService.save(dto);
	}
}

