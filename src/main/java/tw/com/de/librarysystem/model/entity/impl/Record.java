package tw.com.de.librarysystem.model.entity.impl;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate lendingDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(columnDefinition = "Date")
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
		return "Record [id=" + id + ", book=" + book + ", member=" + member + ", lendingDate=" + lendingDate
				+ ", returnDate=" + returnDate + ", lendingCheckedDate=" + lendingCheckedDate + ", returnCheckedDate="
				+ returnCheckedDate + ", getId()=" + getId() + ", getLendingDate()=" + getLendingDate()
				+ ", getReturnDate()=" + getReturnDate() + ", getBook()=" + getBook() + ", getMember()=" + getMember()
				+ ", getReturnCheckedDate()=" + getReturnCheckedDate() + ", getLendingCheckedDate()="
				+ getLendingCheckedDate() + "]";
	}
	
	
}
