package tw.com.de.librarysystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.model.dto.ReservationDto;
import tw.com.de.librarysystem.model.entity.impl.Reservation;
import tw.com.de.librarysystem.model.repository.ReservationRepository;
import tw.com.de.librarysystem.service.ReservationService;
import tw.com.de.librarysystem.utility.Convert;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

//	@Autowired
//	BookRepository bookRepository;

	@Transactional
	@Override  // 未測，有測過updeate
	public Integer insert(ReservationDto dto) {
		reservationRepository.saveAndFlush(Convert.toEntity(dto, new Reservation()));
//		Reservation res = reservationRepository.saveAndFlush(Convert.toEntity(dto, new Reservation()));
			return 1;
	}

	@Transactional
	@Override
	public Integer update(ReservationDto dto) {
		Reservation res = reservationRepository.saveAndFlush(Convert.toEntity(dto, new Reservation()));
		Integer num = 0;
		if (res != null) {
			num = 1;
		}
		return num;
	}

	@Transactional
	@Override //OK
	public Integer delete(ReservationDto dto) {		
		reservationRepository.deleteById(dto.getId());		
		return 1;
		
		/*
		Integer id = dto.getId();
		reservationRepository.findById(id);
		Optional<Reservation> op = reservationRepository.findById(id);
		Integer num = 0;
		if (op.isPresent()) {
			reservationRepository.deleteById(id);
			num = 1;
		}
		return num;	
		*/
		
//		Integer id = (Convert.toEntity(dto, new Reservation())).getId(); // 不能直接找
//		if (op.isPresent()) {
//			reservationRepository.deleteById(id);
//			return 1;
//		} else {
//			return 0;
//		}

		/*
		 * // 以下為按還書後傳入 Integer bookId = 2022001; Optional<Book> op =
		 * bookRepository.findById(bookId); Book book = op.get(); //
		 * ------------------------
		 * 
		 * List<Reservation> ResList = reservationRepository.findByBook(book); if
		 * (ResList == null) { reservationRepository.delete(ResList.get(0));
		 * book.setStatus("在架上！！！"); bookRepository.save(book);
		 * 
		 * } else { ResList.get(0).setStatus("待取書");
		 * reservationRepository.save(ResList.get(0)); //系統發信
		 * 
		 * } return 1;
		 */
	}

	@Override // OK
	public List<ReservationDto> findAllByTitle(ReservationDto dto) {
		/*
		StringBuffer buffer = new StringBuffer();
		return reservationRepository.findByBookLikeTitle(buffer.append("%")
															.append(dto.getBookTitle())
															.append("%").toString()
															)
				.stream().map(e -> (ReservationDto) Convert.toDto(e, dto))
				.collect(Collectors.toList());
		*/
		return reservationRepository.findByBookLikeTitle("%" + dto.getBookTitle() + "%")
				.stream().map(e -> (ReservationDto) Convert.toDto(e, dto))
				.collect(Collectors.toList());
		
//		return Convert.toDto(
//				reservationRepository.findByBookLikeTitle(buffer.append("%").append(dto.getBookTitle()).append("%").toString()), new ReservationDto());
		
//		StringBuffer buffer = new StringBuffer();
//		String title = buffer.append("%").append(dto.getBookTitle()).append("%").toString();
//		List<Reservation> list = reservationRepository.findByBookLikeTitle(title);
//		List<Reservation> list = reservationRepository.findByBookLikeTitleList(book);
//		List<Reservation> list = reservationRepository.findByBookLikeTitle(title);
//		if (list == null || list.size() == 0) {
//			return null;
//
//		} else {
//			return list;
//		}
	}

	@Override
	public List<ReservationDto> findAllByMember(ReservationDto dto) {
		return reservationRepository.findByMemberId(dto.getMemberId()).stream()
				.map(e -> (ReservationDto) Convert.toDto(e, new ReservationDto()))
				.collect(Collectors.toList());
//		return reservationRepository.findByMemberId(dto.getMemberId()); // 還沒有member的dao 
	}

	@Override //OK
	public List<ReservationDto> findAll() {
		return reservationRepository.findAll().stream()
				.map(eo -> (ReservationDto) Convert.toDto(eo, new ReservationDto()))
				.collect(Collectors.toList());
	}

	@Override //暫時不用
	public ReservationDto findById(Integer id) {
		Optional<Reservation> op = reservationRepository.findById(id);
		if (op.isPresent()) {
			return Convert.toDto(op.get(), new ReservationDto());
		} else {
			return null;
		}
	}

}
