package tw.com.de.librarysystem.utility;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import tw.com.de.librarysystem.entity.impl.Book;

public class DTO {

	public static void main(String[] args) {
		Reservation res = new Reservation();
		Book book = new Book();
		book.setTitle("java");
		book.setDay(30);
		res.setDate(LocalDate.now());
		res.setId(123);
		res.setMemNo("0001");
		res.setBook(book);
		res.setStatus("uuuu");
		
		ReservationDTO dto = new ReservationDTO();
		dto.setTitle(book.getTitle());
		
		BeanUtils.copyProperties(res, dto);
		System.out.println(dto);
		System.out.println(dto.getTitle());
		System.out.println(dto.getStatus());
		System.out.println(dto.getId());
		System.out.println(dto.getDate());
		System.err.println(dto.getClass());
	}
}
