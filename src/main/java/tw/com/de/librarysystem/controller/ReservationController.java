package tw.com.de.librarysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.model.entity.impl.BookNo;
import tw.com.de.librarysystem.model.entity.impl.Member;
import tw.com.de.librarysystem.model.entity.impl.Reservation;
import tw.com.de.librarysystem.service.BookNoService;
import tw.com.de.librarysystem.service.ReservationService;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping(value = "/findAllData")
	public List<Reservation> findAllDataHandler() {
		
		try {
			return reservationService.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
//		List<Reservation> list =  reservationService.findAll();
//		System.err.println(list.get(0).getBook().getAuthor() + "<=====================");
////		System.err.println(list.get(0).getBook().getReservations() + "<=====================");
//		if (list != null) {
//			return list;
//			
//		} else {
//			return null;
//		}
	}
	
	@PostMapping(value = "/updateNumber")
	public Integer updateNumberHandler(Reservation reservation) {
		return reservationService.update(reservation);
	}
	
	@GetMapping(value = "/findByMember")
	public List<Reservation> findByMemberhandler(Member member) {
		//沒有判斷是否有
		return reservationService.findAllByMember(member);
	}
	
	@GetMapping(value = "/findByBookTitle")
    public List<Reservation> findByBookTitleHandler(String title) {
		title = "%" +title + "%";
		//沒有判斷是否有
		return reservationService.findAllByTitle(title);
	}
	



}
