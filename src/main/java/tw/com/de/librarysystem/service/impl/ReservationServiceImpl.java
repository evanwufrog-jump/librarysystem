package tw.com.de.librarysystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.de.librarysystem.entity.impl.Reservation;
import tw.com.de.librarysystem.repository.ReservationRepository;
import tw.com.de.librarysystem.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}
	
}
