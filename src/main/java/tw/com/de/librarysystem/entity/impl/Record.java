package tw.com.de.librarysystem.entity.impl;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;
	@ManyToOne
	@JoinColumn(name = "MEMBER_MEMNO")
	private Member member;
	@Column(columnDefinition = "Date")
	private LocalDate lendingDate;
	@Column(columnDefinition = "Date")
	private LocalDate returnDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate LendingCheckedDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate returnCheckedDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getLendingDate() {
		return lendingDate;
	}
	public void setLendingDate(LocalDate lendingDate) {
		this.lendingDate = lendingDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
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
		return "Record [id=" + id + ", book=" + book + ", member=" + member + ", lendingDate=" + lendingDate
				+ ", returnDate=" + returnDate + ", LendingCheckedDate=" + LendingCheckedDate + ", returnCheckedDate="
				+ returnCheckedDate + "]";
	}
	
}
