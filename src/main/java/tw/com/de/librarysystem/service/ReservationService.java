package tw.com.de.librarysystem.service;

import java.util.List;

import tw.com.de.librarysystem.model.dto.ReservationDto;
import tw.com.de.librarysystem.model.entity.impl.Member;
import tw.com.de.librarysystem.model.entity.impl.Reservation;

public interface ReservationService {
	
	public Integer insert(ReservationDto dto);
	
	public Integer update(ReservationDto dto); // OK
	
	public Integer delete(ReservationDto dto);	// OK
	
//	memberNo, id, all, bookNo, title,(年份)
	public List<ReservationDto> findAll(); // OK
//	
	public ReservationDto findById(Integer id); // OK
//	
//	public List<Reservation> getAllByMemNo(String memNo);
//	
//	public List<Reservation> getAllByBookNo(Integer bookNo);
//	
	public List<ReservationDto> findAllByTitle(ReservationDto dto); // OK
	
	public List<Reservation> findAllByMember(Member member);
//	
//	public List<Reservation> getAllByBookYear(Integer year);

}
