package tw.com.de.librarysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.entity.impl.BookNo;
import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.entity.impl.Record;
import tw.com.de.librarysystem.entity.impl.Reservation;
import tw.com.de.librarysystem.service.BookNoService;
import tw.com.de.librarysystem.service.RecordService;
import tw.com.de.librarysystem.service.ReservationService;

@RestController
@RequestMapping(value = "/record")
public class RecordController {
	
	@Autowired
	RecordService recordService;
	
	@GetMapping(value = "/findAllData")
	public List<Record> findAllDataHandler() {
		List<Record> list =  recordService.findAll();
		if (list != null) {
			return list;
			
		} else {
			return null;
		}
	}
	
	@PostMapping(value = "/update")
	public Integer updateNumberHandler(Record record) {
		return recordService.update(record);
	}
	
	@GetMapping(value = "/findByMember")
	public List<Record> findByMemberhandler(Member member) {
		//沒有判斷是否有
		return recordService.findAllByMember(member);
	}
	
	@GetMapping(value = "/findByBookTitle")
    public List<Record> findByBookTitleHandler(String title) {
		//title = "%" +title + "%";
		//沒有判斷是否有
		return recordService.findByTitleLike(title);
	}
	



}
