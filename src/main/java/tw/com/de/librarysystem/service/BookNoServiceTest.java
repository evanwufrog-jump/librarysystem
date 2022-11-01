package tw.com.de.librarysystem.service;

import java.util.List;
import java.util.Optional;

import tw.com.de.librarysystem.entity.impl.BookNo;

public interface BookNoServiceTest {
	
	public String insert(BookNo bookNo);
	
	public String delete(Integer id);
	
	public String update(BookNo bookNo);
	
	public List<BookNo> findAll();
	
	public BookNo findBookNoByYear(Integer year);
	
	public String updateNumberById(Integer number, Integer id);
	
	public BookNo findByIdA(Integer id);
//	public List<BookNo> findById(Integer id);
	
	public BookNo findById(Integer id);
	
	public Integer getBookNoByYear(Integer year);
	
	
//	public BookNo findById(Integer id);
	

}
