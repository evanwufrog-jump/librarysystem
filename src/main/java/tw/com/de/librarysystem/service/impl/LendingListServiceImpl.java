package tw.com.de.librarysystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.model.dto.LendingListDto;
import tw.com.de.librarysystem.model.entity.impl.LendingList;
import tw.com.de.librarysystem.model.repository.LendingListRepository;
import tw.com.de.librarysystem.service.LendingListService;
import tw.com.de.librarysystem.utility.Convert;

@Service
public class LendingListServiceImpl implements LendingListService {

	@Autowired
	LendingListRepository lendingListRepository;
	
	@Transactional
	@Override
	public Integer insert(LendingListDto dto) {
		lendingListRepository.saveAndFlush(Convert.toEntity(dto, new LendingList()));
		return 1;	}

	@Transactional
	@Override
	public Integer update(LendingListDto dto) {
		lendingListRepository.saveAndFlush(Convert.toEntity(dto, new LendingList()));
		return 1;
	}

	@Transactional
	@Override
	public Integer delete(Integer id) {
		Optional<LendingList> op = lendingListRepository.findById(id);
		if (op.isPresent()) {
			lendingListRepository.deleteById(id);
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<LendingListDto> findByMemberId(LendingListDto dto) {
		System.err.println(dto.getMemberId() + "<==========================");
		return lendingListRepository.findByMemberId(dto.getMemberId()).stream()
		.map(e -> (LendingListDto) Convert.toDto(e, new LendingListDto()))
		.collect(Collectors.toList());
	}

	@Override
	public List<LendingListDto> findAll() {
		return lendingListRepository.findAll().stream()
		.map(e -> (LendingListDto) Convert.toDto(e, new LendingListDto()))
		.collect(Collectors.toList());
	}

	@Override
	public List<LendingListDto> findByBookTitle(LendingListDto dto) {		
		return lendingListRepository.findByBookTitle("%" + dto.getBookTitle() + "%").stream()
				.map(e -> (LendingListDto) Convert.toDto(e, new LendingListDto()))
				.collect(Collectors.toList());
	}

}
