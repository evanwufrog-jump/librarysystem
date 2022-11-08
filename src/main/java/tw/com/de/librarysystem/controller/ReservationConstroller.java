package tw.com.de.librarysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.model.entity.impl.Reservation;
import tw.com.de.librarysystem.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationConstroller {
	@Autowired
	private ReservationService reservationService;
	@GetMapping("/reservation")
	public List<Reservation> findAll(){
		return reservationService.findAll();
	}
}
