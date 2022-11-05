package tw.com.de.librarysystem.entity.impl;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer bookId;
	@Column(name = "member_memno")
	private String memNo;
	private String status;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(columnDefinition = "Date")
	private LocalDate date;

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

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
/*
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
 * 
 * @ManyToOne
 * 
 * @JoinColumn // @JsonBackReference // @JsonIgnoreProperties({"RESERVATION"})
 * 
 * @JsonManagedReference private Book book;
 * 
 * @ManyToOne
 * 
 * @JoinColumn // @JsonIgnoreProperties({"reservation"})
 * 
 * @JsonManagedReference // @JsonBackReference private Member member; private
 * String status;
 * 
 * 
 * // @Temporal(TemporalType.DATE) // @DateTimeFormat(pattern = "yyyy-MM-dd")
 * 
 * @JsonFormat(pattern = "yyyy-MM-dd")
 * 
 * @Column(columnDefinition = "Date") private LocalDate date; public Integer
 * getId() { return id; } public void setId(Integer id) { this.id = id; } public
 * Book getBook() { return book; } public void setBook(Book book) { this.book =
 * book; } public Member getMember() { return member; } public void
 * setMember(Member member) { this.member = member; }
 * 
 * public String getStatus() { return status; } public void setStatus(String
 * status) { this.status = status; } public LocalDate getDate() { return date; }
 * public void setDate(LocalDate date) { this.date = date; }
 */
