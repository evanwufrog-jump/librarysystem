package tw.com.de.librarysystem.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.model.entity.impl.LendingList;
import tw.com.de.librarysystem.model.repository.LendingListRepository;
import tw.com.de.librarysystem.service.LendingListService;

@Service
public class LendingListServiceImpl implements LendingListService {

	@Autowired
	LendingListRepository lendingListRepository;
	
	@Transactional
	@Override
	public Integer insert(LendingList lendingList) {
		LendingList lend = lendingListRepository.save(lendingList);
		if (lend == null) {
			return 0;
		} else {
			return 1;
		}
	}

	@Transactional
	@Override
	public Integer updeate(LendingList lendingList) {
		LendingList lend = lendingListRepository.save(lendingList);
		if (lend == null) {
			return 0;
		} else {
			return 1;
		}
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

}
