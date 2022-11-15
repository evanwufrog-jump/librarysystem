package tw.com.de.librarysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.exception.TestException;
import tw.com.de.librarysystem.model.dto.ReservationDto;
import tw.com.de.librarysystem.model.dto.ResponseDto;
import tw.com.de.librarysystem.service.ReservationService;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping(value = "/findAllData") // OK
//	public List<ReservationDto> findAllDataHandler(){
		public ResponseDto findAllDataHandler(){
		return ResponseDto.success(reservationService.findAll());
//		try {
//			return reservationService.findAll();
//		} catch (Exception e) {
//			return null;
//		}
		
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
	
	@PostMapping(value = "/update") // OK
	public ResponseDto updateNumberHandler(ReservationDto dto) {
		return ResponseDto.success(reservationService.update(dto));
	}
	
	@GetMapping(value = "/findByMember") // OK
	public ResponseDto findByMemberHandler(ReservationDto dto) {
		//沒有判斷是否有
		return ResponseDto.success(reservationService.findAllByMember(dto));
	}
	
	@GetMapping(value = "/findByBookTitle") // OK
    public ResponseDto findByBookTitleHandler(ReservationDto dto) {		
		return ResponseDto.success(reservationService.findAllByTitle(dto));
	}
	
	@DeleteMapping(value = "/deleteData") // OK
	public ResponseDto deleteByIdHandler(ReservationDto dto) {
		return ResponseDto.success(reservationService.delete(dto));
	}
	
	@GetMapping("/exceptionTest")
	public void findException() throws TestException {
		throw new TestException();		
	}
}
