package tw.com.de.librarysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.de.librarysystem.model.dto.RecordDto;
import tw.com.de.librarysystem.model.dto.ResponseDto;
import tw.com.de.librarysystem.service.RecordService;

@RestController
@RequestMapping(value = "/record")
public class RecordController {
	
	@Autowired
	RecordService recordService;
	
	@GetMapping(value = "/findAllData") // OK
	public ResponseDto findAllDataHandler() {
		return ResponseDto.success(recordService.findAll());
//		try {
//			List<Record> list =  recordService.findAll();
//			return list;			
//		} catch (Exception e) {
//			return null;
//		}
////		Map<String, List<Record>> map = new HashMap<>();
//		if (list != null) {
//			list.forEach(record -> System.err.println(record.getMember().getMemNO()));
//			return (Map<String, List<Record>>) map.put("data", list);//再確認是否要map
////			return list;
//			
//		} else {
//			return null;
//		}
	}
	
//	@GetMapping(value = "/findAllData")
//	public Map<String, List<Record>> findAllDataHandler() {
////	public List<Record> findAllDataHandler() {
//		List<Record> list =  recordService.findAll();
//		Map<String, List<Record>> map = new HashMap<>();
//		if (list != null) {
//			list.forEach(record -> System.err.println(record.getMember().getMemNO()));
//			return (Map<String, List<Record>>) map.put("data", list);//再確認是否要map
////			return list;
//			
//		} else {
//			return null;
//		}
//	}
	
	@PutMapping(value = "/update") // OK
	public ResponseDto updateNumberHandler(RecordDto dto) {
		return ResponseDto.success(recordService.update(dto));
//		recordService.update(dto);
//		return recordService.update(record);
	}
	
	@GetMapping(value = "/findByMember") // OK
	public ResponseDto findByMemberHandler(RecordDto dto) {
		//沒有判斷是否有
		return ResponseDto.success(recordService.findAllByMember(dto));
//		return recordService.findAllByMember(dto);
	}
	
	@GetMapping(value = "/findByBookTitle") // OK
    public ResponseDto findByBookTitleHandler(RecordDto dto) {
//		title = "%" +title + "%";
		//沒有判斷是否有
//		List<Record> list = recordService.findByTitleLike(title);
//		System.err.println("==============>" + list.isEmpty() + "==============>");
//		return list;
		return ResponseDto.success(recordService.findByBookTitle(dto));
	}
	



}
