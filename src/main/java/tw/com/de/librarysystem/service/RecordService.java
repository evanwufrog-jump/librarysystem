package tw.com.de.librarysystem.service;

import java.util.List;

import tw.com.de.librarysystem.model.entity.impl.Book;
import tw.com.de.librarysystem.model.entity.impl.Member;
import tw.com.de.librarysystem.model.entity.impl.Record;

public interface RecordService {
	
	public Integer insert(Record record);
	
	public void delete(Record record);
	
	public Integer deleteById(Integer id);
	
	public Integer update(Record record);
	
	public Integer updateReturndate(Book book);
	
	public List<Record> findAll();
	
	public Record getById(Integer id);
	
	public List<Record> findAllByMember(Member member);
//	
	public List<Record> findByTitleLike(String title);
//	
//	public Record findByTitle(String title);
//	
	public List<Record> findByBookNo(Integer id);
//	
//	public List<Record> findByBookNoLike(Integer bookNo);
	

}
