package tw.com.de.librarysystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.com.de.librarysystem.service.BookService;

@SpringBootTest
public class BookTest {
	@Autowired
	private BookService bookService;
@Test
void bookTest() {
	bookService.findAll();
}
}
