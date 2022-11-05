package tw.com.de.librarysystem.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.entity.impl.BookNo;
import tw.com.de.librarysystem.repository.BookNoRepository;
import tw.com.de.librarysystem.service.BookNoService;

@Service
public class BookNoServiceImpl implements BookNoService {

	@Autowired
	BookNoRepository bookNoDao;

	public Integer getBookNoByYear(Integer year) {
		Integer number;
		BookNo bookNo = bookNoDao.findBookNoByYear(year);
		if (bookNo == null) {
			number = 1;
			bookNo = new BookNo();
			bookNo.setNumber(number + 1);
			bookNo.setYear(year);
			bookNoDao.save(bookNo);
			return year * 1000 + number;
		} else {
			number = bookNo.getNumber();
			bookNo.setNumber(number + 1);
			bookNoDao.save(bookNo);
			return year * 1000 + number;
		}
	}

	@Override
	public List<BookNo> findAll() {
		List<BookNo> list = bookNoDao.findAll();
		return list;//bookNoDao.findAll();
	}

	@Override
	public Integer getByYear(Integer year) {		
		BookNo bookNo=  bookNoDao.findBookNoByYear(year);		
		if (bookNo != null) {
			return bookNo.getNumber();
		} else {
			return 0;
		}
	}

	@Transactional
	@Override
	public boolean updateNumber(BookNo nBookNo) {
		Optional<BookNo> op = bookNoDao.findById(nBookNo.getId());
		
		if (op.isPresent()) {
			BookNo oBookNo = op.get();
			oBookNo.setNumber(nBookNo.getNumber());
			bookNoDao.save(oBookNo);
			return true;
		} else {
			return false;
		}
		
	}
	
}