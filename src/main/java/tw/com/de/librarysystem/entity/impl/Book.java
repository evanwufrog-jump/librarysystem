package tw.com.de.librarysystem.entity.impl;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
public class Book implements Serializable {
	@Id
	private Integer id;
	private String author;
	private Integer day;
	private String description;
	private String isbn;
//	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate postStart;
//	private LocalDate postStart = LocalDate.now();
//	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate publishDate;
	private String publisher;
	@NotNull
	private String status = "上架";
	private String technology;
	private String title;
	private Integer bookCategoryId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public LocalDate getPostStart() {
		return postStart;
	}
	public void setPostStart(LocalDate postStart) {
		this.postStart = postStart;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getBookCategoryId() {
		return bookCategoryId;
	}
	public void setBookCategoryId(Integer bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}




}
/*
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
@DateTimeFormat(pattern = "yyyy-MM-dd")
@NotNull
private Date publishDate;
@NotNull
private String status = "上架";

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date postStart = new Date();

private String isbn;
private String description;
private Integer day;

@OneToMany
@JoinColumn(name = "id")
private Set<BookPic> bookPics;

@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
private Set<Advice> advices;
/*
@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
@JsonManagedReference
private Set<Reservation> reservations;

@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
private Set<Record> records;

@OneToOne(fetch = FetchType.LAZY, mappedBy = "book")
private LendingList lendingList;
*/