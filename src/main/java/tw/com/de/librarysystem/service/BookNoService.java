package tw.com.de.librarysystem.service;

import java.util.List;

import tw.com.de.librarysystem.model.entity.impl.BookNo;

public interface BookNoService {

	public Integer getBookNoByYear(Integer year);
	
	public List<BookNo> findAll();
	
	public Integer getByYear(Integer year);
	
	public boolean updateNumber(BookNo bookNo);

}
