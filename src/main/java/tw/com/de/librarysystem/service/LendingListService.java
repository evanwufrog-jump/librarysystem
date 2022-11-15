package tw.com.de.librarysystem.service;

import java.util.List;

import tw.com.de.librarysystem.model.dto.LendingListDto;

public interface LendingListService {

	public Integer insert(LendingListDto dto);

	public Integer update(LendingListDto dto);

	public Integer delete(Integer id);

	public List<LendingListDto> findByMemberId(LendingListDto dto);

	public List<LendingListDto> findAll();

//	public LendingList findByBookNo(Integer bookNo);

	public List<LendingListDto> findByBookTitle(LendingListDto dto);

}
