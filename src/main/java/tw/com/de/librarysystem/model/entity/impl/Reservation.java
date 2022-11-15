package tw.com.de.librarysystem.model.entity.impl;

import java.io.Serializable;
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
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
//	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")
//	@JsonBackReference
//	@JsonIgnoreProperties({"RESERVATION"})
//	@JsonManagedReference
	private Book book;
	
	@ManyToOne
	@JoinColumn
//	@JsonIgnoreProperties({"reservation"})
//	@JsonBackReference
//	@JsonManagedReference
	private Member member;
//	private String status;

//	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(columnDefinition = "Date")
	private LocalDate date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}