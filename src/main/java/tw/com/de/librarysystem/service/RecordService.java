package tw.com.de.librarysystem.service;

import java.util.List;

import tw.com.de.librarysystem.model.dto.RecordDto;
import tw.com.de.librarysystem.model.entity.impl.Member;
import tw.com.de.librarysystem.model.entity.impl.Record;

public interface RecordService {
	
	public Integer insert(RecordDto dto); // OK
	
	public Integer delete(RecordDto dto);
	
	public Integer deleteById(Integer id);
	
	public Integer update(RecordDto dto); // OK

	// book的id->bookID要調整，先不動。
//	public Integer updateReturndate(Book book);
	
	public List<RecordDto> findAll(); // OK
	
	public Record getById(Integer id);
	
	public List<Record> findAllByMember(Member member);
//	
	public List<RecordDto> findByTitleLike(RecordDto dto);
//	
//	public Record findByTitle(String title);
//	
	// book的id->bookID要調整，先不動。
//	public List<Record> findByBookNo(Integer id);
//	
//	public List<Record> findByBookNoLike(Integer bookNo);
	

}
