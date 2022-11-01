package tw.com.de.librarysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.entity.impl.BookNo;
import tw.com.de.librarysystem.service.BookNoService;

@RestController
@RequestMapping(value = "/bookNo")
public class BookNoController {
	
	@Autowired
	BookNoService bookNoService;
	
	@GetMapping(value = "/findAllData")
	public List<BookNo> findAllDataHandler() {
		List<BookNo> list =  bookNoService.findAll();
		if (list != null) {
			return list;
			
		} else {
			return null;
		}
	}
	
	@PostMapping(value = "/updateNumber")
	public boolean updateNumberhandler(BookNo bookNo) {
		return bookNoService.updateNumber(bookNo);
	}
	
	@GetMapping("/getSerialNumber")
	public Integer getSerialNumberHander(Integer year) {
		
		int number = bookNoService.getByYear(year);
		if (number != 0) {
			return number;
			
		} else {
			return 0;
		}
		
	}

}
