package tw.com.de.librarysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.entity.ReservationTest;
import tw.com.de.librarysystem.entity.impl.BookNo;
import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.entity.impl.Reservation;
import tw.com.de.librarysystem.model.dto.ReservationDto;
import tw.com.de.librarysystem.service.BookNoService;
import tw.com.de.librarysystem.service.ReservationService;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping(value = "/findAllData")
	public List<ReservationTest> findAllDataHandler() {
		try {
			System.err.println(1111);
			List<ReservationTest> list =  reservationService.findAll();
			System.err.println(2222);
			System.out.println(list.size());
			System.err.println(333333);
			return list;
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@PostMapping(value = "/postTest")
	public void testHandler(ReservationTest res) {
		try {
			System.err.println(res.getName());
			System.err.println(res.getStatus());
			System.err.println(res.getDate());
			System.err.println(res.getAuthor());
			System.err.println(res.getIsbn());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*
	@GetMapping(value = "/findAllData")
	public List<Reservation> findAllDataHandler() {
		List<Reservation> list =  reservationService.findAll();
		if (list != null) {
			return list;
			
		} else {
			return null;
		}
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
	
*/


}
