package tw.com.de.librarysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.model.dto.LendingListDto;
import tw.com.de.librarysystem.model.dto.ResponseDto;
import tw.com.de.librarysystem.service.LendingListService;

@RestController
@RequestMapping(value = "/lendingList")
public class LendingListController {
	
	@Autowired
	LendingListService lendingListService;	
	
	@GetMapping(value = "/findAllData") // OK
	public ResponseDto findAllDataHandler() {
		return ResponseDto.success(lendingListService.findAll());
	}	
	
	@PutMapping(value = "/update") // OK
	public ResponseDto updateNumberHandler(LendingListDto dto) {
		return ResponseDto.success(lendingListService.update(dto));
	}
	
	@GetMapping(value = "/findByMember") // OK
	public ResponseDto findByMemberHandler(LendingListDto dto) {
		//沒有判斷是否有
		return ResponseDto.success(lendingListService.findByMemberId(dto));
	}
	
	@GetMapping(value = "/findByBookTitle") // OK
    public ResponseDto findByBookTitleHandler(LendingListDto dto) {
		return ResponseDto.success(lendingListService.findByBookTitle(dto));
	}
	



}
