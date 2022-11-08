package tw.com.de.librarysystem.utility;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

import tw.com.de.librarysystem.model.dto.LendingListDto;
import tw.com.de.librarysystem.model.entity.impl.Book;
import tw.com.de.librarysystem.model.entity.impl.LendingList;
import tw.com.de.librarysystem.model.entity.impl.Member;

public class DTO {

	public static void main(String[] args) {
		
		// -- entity to dto test
		LendingList res = new LendingList();
		Book book = new Book();
		Member mem = new Member();
		res.setBook(book);
		res.setExpiryDate(LocalDate.now());
		res.setId(123);
		res.setMember(mem);
		
		book.setTitle("java");
		book.setId(107);
//		book.setDay(30);
		System.out.println(res.getBook().getId());
		mem.setMemNO("001");
		mem.setPassword("13245678");
		mem.setName("David");
//		ModelMapper modelMapper = new ModelMapper();
//		LendingListDto lendingListDto = modelMapper.map(res, LendingListDto.class);
		LendingListDto lendingListDto = Convert.toDto(res, new LendingListDto());
		LendingListDto listDto = Transfer.toDto(res, new LendingListDto());
		
		System.err.println(lendingListDto + "  <=========== entity to dto");
		System.err.println(listDto + "  <=========== entity to dto");
		
		// ========================
		
		// -- dto to entity
		LendingListDto req = new LendingListDto();
		req.setBookId(0000);
		req.setBookTitle(".NET");
		req.setMemberName("Johnson");
//		LendingList entity = modelMapper.map(req, LendingList.class);
		LendingList entity = Convert.toEntity(req, new LendingList());
		
		System.out.println("dto to entity, book_id =========== >" + entity.getBook().getId());
		System.out.println("dto to entity, book_title =========== >" + entity.getBook().getTitle());
		System.out.println("dto to entity, member_name =========== >" + entity.getMember().getName());
		

	}
}
