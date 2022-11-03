package tw.com.de.librarysystem.service;

import java.util.List;

import tw.com.de.librarysystem.entity.impl.Reservation;

public interface ReservationService {
	List<Reservation> findAll();
}
