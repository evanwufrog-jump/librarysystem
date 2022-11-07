package tw.com.de.librarysystem.service;

import java.util.List;

import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.entity.impl.Reservation;

public interface ReservationService {
	
	public Integer insert(Reservation reservation);
	
	public Integer update(Reservation reservation);
	
	public Integer delete(Integer id);
	
	
//	memberNo, id, all, bookNo, title,(年份)
	public List<Reservation> findAll();
//	
	public Reservation findById(Integer id);
//	
//	public List<Reservation> getAllByMemNo(String memNo);
//	
//	public List<Reservation> getAllByBookNo(Integer bookNo);
//	
	public List<Reservation> findAllByTitle(String title);
	
	public List<Reservation> findAllByMember(Member member);
//	
//	public List<Reservation> getAllByBookYear(Integer year);

}
