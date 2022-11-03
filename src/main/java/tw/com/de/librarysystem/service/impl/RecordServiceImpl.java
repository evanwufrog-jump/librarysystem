package tw.com.de.librarysystem.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.entity.impl.Book;
import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.entity.impl.Record;
import tw.com.de.librarysystem.repository.BookRepository;
import tw.com.de.librarysystem.repository.RecordRepository;
import tw.com.de.librarysystem.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	RecordRepository recordRepository;
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public Integer insert(Record record) {
		Record nRecord = recordRepository.save(record);
		if (nRecord == null) {
			return 0;

		} else {
			return 1;
		}

	}

	@Transactional
	@Override
	public void delete(Record record) {
		recordRepository.delete(record);
	}

	@Transactional
	@Override
	public Integer deleteById(Integer id) {
		Optional<Record> op = recordRepository.findById(id);
		if (op.isPresent()) {
			recordRepository.delete(op.get());
			return 1;
		} else {
			return 0;
		}

	}

	@Transactional
	@Override
	public Integer update(Record record) {
		Record nRecord = recordRepository.save(record);
		if (nRecord == null) {
			return 1;
		} else {
			return 0;
		}

//		Optional<Record> op = recordRepository.findById(record.getId());
//		if (op.isPresent()) {
//			recordRepository.save(record);
//			return "新增成功";
//		} else {
//			recordRepository.save(record);
//			return "沒有此筆資料";
//		}
	}

	@Transactional
	@Override
	public Integer updateReturndate(Book book) {
		List<Record> list = recordRepository.findByBook(book);
		Optional<Record> op = recordRepository.findById((list.get(list.size() - 1)).getId());
		if (op.isPresent()) {
			Record record = op.get();
			record.setLendingDate(LocalDate.now());
			recordRepository.save(record);
//			recordRepository.save(op.get().setLendingDate(LocalDate.now()));
			return 1;
		} else {
			return 0;

		}
	}

	@Override
	public List<Record> findAll() {		
		return recordRepository.findAll();
	}

	@Override
	public Record getById(Integer id) {
		Optional<Record> op = recordRepository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Record> findAllByMember(Member member) {		
		return recordRepository.findByMember(member);
	}


	@Override
	public List<Record> findByTitleLike(String title) {
		List<Book> bookList = bookRepository.findByTitleContaining(title);
		System.err.println(bookList.size() + "<==================");
		List<Record> records = new ArrayList<>();
		if (bookList == null || bookList.size() == 0) {
			return null;
		} else {
//			List<Record> records = new ArrayList<>();
			for (Book book : bookList) {
				Optional<Record> op = recordRepository.findById(book.getId());
				if (op.isPresent()) {
					records.addAll((Collection<? extends Record>) op.get());				
				} 
			}			
			return records;
		}
	}

	@Override
	public List<Record> findByBookNo(Integer bookNo) {
		Optional<Book> op = bookRepository.findById(bookNo);
		if (op.isPresent()) {
			return recordRepository.findByBook(op.get());			
		} else {
			return null;
		}
	}
}
