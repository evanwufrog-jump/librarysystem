package tw.com.de.librarysystem.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.model.dto.RecordDto;
import tw.com.de.librarysystem.model.entity.impl.Book;
import tw.com.de.librarysystem.model.entity.impl.Member;
import tw.com.de.librarysystem.model.entity.impl.Record;
import tw.com.de.librarysystem.model.repository.BookRepository;
import tw.com.de.librarysystem.model.repository.RecordRepository;
import tw.com.de.librarysystem.service.RecordService;
import tw.com.de.librarysystem.utility.Convert;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	RecordRepository recordRepository;
	
	@Autowired
	BookRepository bookRepository;

	@Transactional //沒加測試成功
	@Override // OK
	public Integer insert(RecordDto dto) {
		recordRepository.saveAndFlush(Convert.toEntity(dto, new Record()));
		return 1;
//		Record nRecord = recordRepository.save(record);
//		if (nRecord == null) {
//			return 0;
//
//		} else {
//			return 1;
//		}

	}

	@Transactional
	@Override // junit 測試成功
	public Integer delete(RecordDto dto) { //只要有id 就可以執行，以下二同義
		recordRepository.delete(Convert.toEntity(dto, new Record()));
//		recordRepository.deleteById(dto.getId());		
		return 1;
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
	@Override // OK
	public Integer update(RecordDto dto) {
		// 先找DB有沒有資料，有->更新；沒有->回傳新增；
		// 如果前台沒有傳舊資料，就必須先找出來再增對要的更新；目前只要更新lendingCheckTime, returnTime, and returnCheckTime
		recordRepository.saveAndFlush(Convert.toEntity(dto, new Record()));
		return 1;
//		Record nRecord = recordRepository.save(record);
//		if (nRecord == null) {
//			return 1;
//		} else {
//			return 0;
//		}

//		Optional<Record> op = recordRepository.findById(record.getId());
//		if (op.isPresent()) {
//			recordRepository.save(record);
//			return "新增成功";
//		} else {
//			recordRepository.save(record);
//			return "沒有此筆資料";
//		}
	}

	// book的id->bookID要調整，先不動。
	/*
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
	*/

	@Override // OK
	public List<RecordDto> findAll() {
		return recordRepository.findAll()
				.stream().map(e -> (RecordDto) Convert.toDto(e, new RecordDto()))
				.collect(Collectors.toList());
//		return Convert.toDto(recordRepository.findAll(), new RecordDto());
//		return recordRepository.findAll();
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


	@Override // OK, 如何用stream處理
	public List<RecordDto> findByTitleLike(RecordDto dto) {
//		StringBuilder builder = new S
		System.err.println(dto.getBookTitle());
		List<Book> bookList = bookRepository.findByTitleContaining(dto.getBookTitle());
		System.err.println(bookList.size() + "<==================");
//		System.err.println(bookList.get() + "<==================");
		List<Record> records = new ArrayList<>();
//		Map<Integer, List<Record>> map = new HashMap<>();
		
		/*
		if (bookList == null || bookList.size() == 0) {
			return null;
		} else {
			bookList.stream()
					.map(b -> recordRepository.findByBook(b))
					.filter(b -> b.size()>0)
					.collect(Collectors.groupingBy(Book::getId));
//					.map(op -> op.get())
//					.collect(Collectors.toList());
			return null;
		}
		*/
		
		if (bookList == null || bookList.size() == 0) {
			return null;
		} else {
			for (Book book : bookList) {
				List<Record> list = recordRepository.findByBook(book);
				if (list != null || list.size()>0) {
					records.addAll(list);				
				} 
			}			
			return records.stream()
					.map(record -> (RecordDto) Convert.toDto(record, new RecordDto()))
					.collect(Collectors.toList());
		}
		
	}

	// book的id->bookID要調整，先不動。
	/*
	@Override
	public List<Record> findByBookNo(Integer bookNo) {
		Optional<Book> op = bookRepository.findById(bookNo);
		if (op.isPresent()) {
			return recordRepository.findByBook(op.get());			
		} else {
			return null;
		}
	}
	*/
}
