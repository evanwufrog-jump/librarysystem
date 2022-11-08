package tw.com.de.librarysystem.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class RecordDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
//	private Book book;
	private Integer bookId;
	private String bookTitle;
//	private Member member;
	private String memberMemNo;
	private String memberName;
	private LocalDate returnDate;
	private LocalDate LendingCheckedDate;
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
	public LocalDate getLendingCheckedDate() {
		return LendingCheckedDate;
	}
	public void setLendingCheckedDate(LocalDate lendingCheckedDate) {
		LendingCheckedDate = lendingCheckedDate;
	}
	public LocalDate getReturnCheckedDate() {
		return returnCheckedDate;
	}
	public void setReturnCheckedDate(LocalDate returnCheckedDate) {
		this.returnCheckedDate = returnCheckedDate;
	}
	@Override
	public String toString() {
		return "RecordDto [id=" + id + ", bookId=" + bookId + ", bookTitle=" + bookTitle + ", memberMemNo="
				+ memberMemNo + ", memberName=" + memberName + ", returnDate=" + returnDate + ", LendingCheckedDate="
				+ LendingCheckedDate + ", returnCheckedDate=" + returnCheckedDate + ", getId()=" + getId()
				+ ", getBookId()=" + getBookId() + ", getBookTitle()=" + getBookTitle() + ", getMemberMemNo()="
				+ getMemberMemNo() + ", getMemberName()=" + getMemberName() + ", getReturnDate()=" + getReturnDate()
				+ ", getLendingCheckedDate()=" + getLendingCheckedDate() + ", getReturnCheckedDate()="
				+ getReturnCheckedDate() + "]";
	}

}
