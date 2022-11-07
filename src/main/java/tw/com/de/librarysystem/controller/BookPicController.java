package tw.com.de.librarysystem.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.com.de.librarysystem.entity.impl.BookPic;
import tw.com.de.librarysystem.service.BookPicService;

@RestController
@RequestMapping("/bookpic")
public class BookPicController {
	@Autowired
	BookPicService bookPicService;

	@GetMapping("/bookpic")
	public List<BookPic> findAll() {
		System.out.println("書本圖片資訊");
		return bookPicService.findAll();
	}

	@PostMapping("/bookpic")
	public boolean save(BookPic bookPic, MultipartFile imageFile) throws IllegalStateException, IOException {
		boolean flag = false;
//		String newFileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
//		String ImgUrl = "/bookPics/" + newFileName;
//		String saveFilePath = new File("target\\classes\\static\\bookPictures\\" + newFileName).getAbsolutePath();
//		if (imageFile.getOriginalFilename().length() != 0) {
//			bookPic.setPicture(ImgUrl);
//			imageFile.transferTo(new File(saveFilePath));
//		}
		try {
			bookPicService.save(bookPic);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@DeleteMapping("/bookpic/{id}")
	public boolean delete(@PathVariable("id") Integer id) {
		boolean flag = false;
		try {
			bookPicService.delete(id);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
