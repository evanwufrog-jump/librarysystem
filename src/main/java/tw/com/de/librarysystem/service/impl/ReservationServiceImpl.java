package tw.com.de.librarysystem.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.entity.impl.Book;
import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.entity.impl.Reservation;
import tw.com.de.librarysystem.repository.BookRepository;
import tw.com.de.librarysystem.repository.ReservationRepository;
import tw.com.de.librarysystem.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired	
	ReservationRepository reservationRepository;
	
	
	
//	@Autowired
//	BookRepository bookRepository;

	@Transactional
	@Override
	public Integer insert(Reservation reservation) {
		Reservation res = reservationRepository.save(reservation);
		if (res == null) {
			return 0;			
		} else {
			return 1;

		}
	}

	@Transactional
	@Override
	public Integer update(Reservation reservation) {
		Reservation res = reservationRepository.save(reservation);
		if (res == null) {
			return 0;			
		} else {
			return 1;

		}
	}

	@SuppressWarnings("null")
	@Transactional
	@Override
	public Integer delete(Integer id) {
		
		Optional<Reservation> op = reservationRepository.findById(id);
		if (op.isPresent()) {
			reservationRepository.deleteById(id);
			return 1;
		} else {
			return 0;
		}
		
		
		/*
		// 以下為按還書後傳入
		Integer bookId = 2022001;
		Optional<Book> op = bookRepository.findById(bookId);
		Book book = op.get();
		// ------------------------
		
		List<Reservation> ResList = reservationRepository.findByBook(book);
		if (ResList == null) {
			reservationRepository.delete(ResList.get(0));
			book.setStatus("在架上！！！");
			bookRepository.save(book);
			
		} else {
			ResList.get(0).setStatus("待取書");
			reservationRepository.save(ResList.get(0));
			//系統發信

		}
		return 1;
		*/
		
	}

	@Override
	public List<Reservation> findAllByTitle(String title) {
		Book book = new Book();
		book.setTitle(title);
		
//		List<Reservation> list = reservationRepository.findByBookLikeTitleList(book);
		List<Reservation> list = reservationRepository.findByBookLikeTitle(title);
		if (list == null || list.size() == 0) {
			return null;
			
		} else {
			return list;

		}
		
	}

	@Override
	public List<Reservation> findAllByMember(Member member) {
		return reservationRepository.findByMember(member);
		
	}

	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation findById(Integer id) {
		
		Optional<Reservation> op = reservationRepository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}

}
