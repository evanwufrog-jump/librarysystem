package tw.com.de.librarysystem.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class LendingListDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
//	private Book book;
	private Integer bookId;//類別加類別原名
	private String bookTitle;
//	private Member member;
	private String memberMemNo;
	private String memberName;
	private LocalDate lendingDate;
	private LocalDate expiryDate;
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getMemberMemNo() {
		return memberMemNo;
	}
	public void setMemberMemNo(String memberMemNo) {
		this.memberMemNo = memberMemNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public LocalDate getLendingDate() {
		return lendingDate;
	}
	public void setLendingDate(LocalDate lendingDate) {
		this.lendingDate = lendingDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Override
	public String toString() {
		return "LendingListDto [id=" + id + ", bookId=" + bookId + ", bookTitle=" + bookTitle + ", memberMemNo="
				+ memberMemNo + ", memberName=" + memberName + ", lendingDate=" + lendingDate + ", expiryDate="
				+ expiryDate + ", getBookId()=" + getBookId() + ", getId()=" + getId() + ", getBookTitle()="
				+ getBookTitle() + ", getMemberMemNo()=" + getMemberMemNo() + ", getMemberName()=" + getMemberName()
				+ ", getLendingDate()=" + getLendingDate() + ", getExpiryDate()=" + getExpiryDate() + "]";
	}	
}

/*
class Member {
	private String memNo;
	private String name;
	private LocalDate date;
	public String getMemNo() {
		return memNo;
	}
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Member [memNo=" + memNo + ", name=" + name + ", date=" + date + "]";
	}	
}

class Book {
	private Integer book_id;
	private String title;
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + "]";
	}
}
*/
