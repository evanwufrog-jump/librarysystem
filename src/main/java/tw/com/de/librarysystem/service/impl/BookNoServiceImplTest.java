package tw.com.de.librarysystem.service.impl;

import java.util.List;
import java.util.Optional;

//import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.model.entity.impl.BookNo;
import tw.com.de.librarysystem.model.repository.BookNoRepository;
import tw.com.de.librarysystem.service.BookNoServiceTest;

@Service
public class BookNoServiceImplTest implements BookNoServiceTest {

	@Autowired
	BookNoRepository bookNoDao;
	
	public Integer getBookNoByYear(Integer year) {
		Integer number;
		System.err.println(year);
		try {
			BookNo bookNo =  bookNoDao.findBookNoByYear(year);
			
			
			/*
			number = bookNo.getNumber();
			if (number == null || number == 0) {
				number = 1;
				bookNo = new BookNo();
				bookNo.setNumber(number++);
				bookNo.setYear(year);
				
				return year * 1000 + number + 1;
								
			} else {
				number = bookNo.getNumber();System.err.println(number);
				bookNo.setNumber(number++);
				bookNoDao.save(bookNo);
				
				return year*1000 + number;

			}
			*/
			
			if(bookNo == null) {
				number = 1;
				bookNo = new BookNo();
				bookNo.setNumber(number+1);
				bookNo.setYear(year);
				bookNoDao.save(bookNo);
				return year * 1000 + number;
			} else {
				
				number = bookNo.getNumber();
				bookNo.setNumber(number + 1);
				bookNoDao.save(bookNo);
				
				return year*1000 + number;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
// ----------------------------------------
	//新增資料
	@Transactional
	@Override
	public String insert(BookNo bookNo) {
		try {
			bookNoDao.save(bookNo);
			return "sucess";
			/*
//			BookNo nBookNo =  bookNoDao.save(bookNo);
//			if(nBookNo != null) {
//				return "sucess";
//			} else {
//				return "fail";
//			}
			 */
		} catch (Exception e) {
			return "exception";
		}
	}

	//刪除資料
	@Transactional
	@Override
	public String delete(Integer id) {
		BookNo bookNo = this.findById(id);
		if(bookNo != null) {
			try {
				bookNoDao.deleteById(id);
				return "sucess";
			} catch (Exception e) {
				return "exception";
			}			
		} else {
			return "no data";			
		}

	}

	//更新資料
	@Transactional
	@Override
	public String update(BookNo nBookNo) {
		
		try {
			Optional<BookNo> op = bookNoDao.findById(nBookNo.getId());			
			if (op.isPresent()) {
				bookNoDao.save(nBookNo);
				return "sucess";		
			} else {
				return "no data";
			}	
			
		} catch (Exception e) {
			return "exception";
		}		
	}
	
	//找全部資料
	@Override
	public List<BookNo> findAll() {

		return bookNoDao.findAll();
	}
// ----------------------------------------------------
	@Override
	public BookNo findBookNoByYear(Integer year) {		
		return bookNoDao.findBookNoByYear(year);
	}

	@Transactional
	public String updateNumberById(Integer number, Integer id) {
		bookNoDao.updateNumberById(number, id);
		return "true";
	}

	@Override
	public BookNo findByIdA(Integer id) {
		return bookNoDao.findBById(id);
	}

	@Override
	public BookNo findById(Integer id) {
		
		Optional<BookNo> op = bookNoDao.findById(id);
		if(op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
		
	};

}
