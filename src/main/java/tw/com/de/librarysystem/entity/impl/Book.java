package tw.com.de.librarysystem.entity.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Book implements Serializable {
	@Id
	private Integer id;
	private String title;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BOOKCATEGORY_ID")
	private BookCategory bookCategory;

	private String author;
	private String technology;
	private String publisher;

	@Temporal(TemporalType.DATE)
	private Date publishDate;

	private String status = "上架";

	@Temporal(TemporalType.DATE)
	private Date postStart = new Date();

	private String isbn;
	private String description;
	private Integer day;

	@OneToMany
	@JoinColumn(name = "id")
	private Set<BookPic> bookPics;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	private Set<Advice> advices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	private Set<Reservation> reservations;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	private Set<Record> records;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "book")
	private LendingList lendingList;

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

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPostStart() {
		return postStart;
	}

	public void setPostStart(Date postStart) {
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

	public Set<BookPic> getBookPics() {
		return bookPics;
	}

	public void setBookPics(Set<BookPic> bookPics) {
		this.bookPics = bookPics;
	}

	public Set<Advice> getAdvices() {
		return advices;
	}

	public void setAdvices(Set<Advice> advices) {
		this.advices = advices;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Set<Record> getRecords() {
		return records;
	}

	public void setRecords(Set<Record> records) {
		this.records = records;
	}

	public LendingList getLendingList() {
		return lendingList;
	}

	public void setLendingList(LendingList lendingList) {
		this.lendingList = lendingList;
	}

}
