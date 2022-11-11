package tw.com.de.librarysystem.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
//	private Book book;
	private Integer bookId;
	private String bookTitle;
//	private Member member;
	private String memberMemNo;
	private String memberName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
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
	
	@Override
	public String toString() {
		return "ReservationDto [id=" + id + ", bookId=" + bookId + ", bookTitle=" + bookTitle + ", memberMemNo="
				+ memberMemNo + ", memberName=" + memberName + ", date=" + date + ", getId()=" + getId()
				+ ", getDate()=" + getDate() + ", getBookId()=" + getBookId() + ", getBookTitle()=" + getBookTitle()
				+ ", getMemberMemNo()=" + getMemberMemNo() + ", getMemberName()=" + getMemberName() + "]";
	}
}
