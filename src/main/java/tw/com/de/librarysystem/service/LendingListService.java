package tw.com.de.librarysystem.service;

import java.util.List;

import tw.com.de.librarysystem.model.entity.impl.LendingList;
import tw.com.de.librarysystem.model.entity.impl.Member;

public interface LendingListService {
	
	public Integer insert(LendingList lendingList);
	
	public Integer updeate(LendingList lendingList);
	
	public Integer delete(Integer id);
	
	// memberNo, id, all, bookNo, tittle
	
//	public List<LendingList> findByMemNo(Member member);
//	
//	public LendingList findById(Integer id);
//	
//	public List<LendingList> findAll();
//	
//	public LendingList findByBookNo(Integer bookNo);
//	
//	public LendingList findByTitle(String title);
	

}
