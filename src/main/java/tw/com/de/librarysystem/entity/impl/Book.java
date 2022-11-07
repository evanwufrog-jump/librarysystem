package tw.com.de.librarysystem.entity.impl;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
public class Book implements Serializable {
	@Id
	@Column(name = "id")
	private Integer id;
	private String title;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BOOKCATEGORY_ID")
	private BookCategory bookCategory;

	private String author;
	private String technology;
	private String publisher;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate publishDate;
	@NotNull
	private String status = "上架";

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate postStart = LocalDate.now();

	private String isbn;
	private String description;
	private Integer day;
	private String reservationStatus;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "bookId")
//	private Set<BookPic> bookPics;
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
//	private Set<Advice> advices;
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
//	@JsonManagedReference
//	private Set<Reservation> reservations;
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
//	private Set<Record> records;
//
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "book")
//	private LendingList lendingList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getPostStart() {
		return postStart;
	}

	public void setPostStart(LocalDate postStart) {
		this.postStart = postStart;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", bookCategory=" + bookCategory + ", author=" + author
				+ ", technology=" + technology + ", publisher=" + publisher + ", publishDate=" + publishDate
				+ ", status=" + status + ", postStart=" + postStart + ", isbn=" + isbn + ", description=" + description
				+ ", day=" + day + ", reservationStatus=" + reservationStatus + "]";
	}


}
