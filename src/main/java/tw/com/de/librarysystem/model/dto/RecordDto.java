package tw.com.de.librarysystem.model.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RecordDto {

	private Integer id;
//	private Book book;
	private Integer bookId;
	private String bookTitle;
//	private Member member;
	private String memberMemNo;
	private String memberName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate lendingDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate returnDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate lendingCheckedDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate returnCheckedDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	public LocalDate getReturnCheckedDate() {
		return returnCheckedDate;
	}
	public void setReturnCheckedDate(LocalDate returnCheckedDate) {
		this.returnCheckedDate = returnCheckedDate;
	}
	public LocalDate getLendingCheckedDate() {
		return lendingCheckedDate;
	}
	public void setLendingCheckedDate(LocalDate lendingCheckedDate) {
		this.lendingCheckedDate = lendingCheckedDate;
	}
	
	@Override
	public String toString() {
		return "RecordDto [id=" + id + ", bookId=" + bookId + ", bookTitle=" + bookTitle + ", memberMemNo="
				+ memberMemNo + ", memberName=" + memberName + ", returnDate=" + returnDate + ", lendingCheckedDate="
				+ lendingCheckedDate + ", returnCheckedDate=" + returnCheckedDate + ", getId()=" + getId()
				+ ", getBookId()=" + getBookId() + ", getBookTitle()=" + getBookTitle() + ", getMemberMemNo()="
				+ getMemberMemNo() + ", getMemberName()=" + getMemberName() + ", getReturnDate()=" + getReturnDate()
				+ ", getReturnCheckedDate()=" + getReturnCheckedDate() + ", getLendingCheckedDate()="
				+ getLendingCheckedDate() + "]";
	}
	

}
