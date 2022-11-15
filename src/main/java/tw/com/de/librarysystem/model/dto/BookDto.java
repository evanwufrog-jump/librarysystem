package tw.com.de.librarysystem.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import tw.com.de.librarysystem.model.entity.impl.BookCategory;
import tw.com.de.librarysystem.model.entity.impl.BookPic;

@SuppressWarnings("serial")
public class BookDto implements Serializable {
	private Integer id;
	private Integer bookNo;
	private String title;
	private BookCategory bookCategory;
	private String author;
	private String technology;
	private String publisher;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate publishDate;
	private String status = "上架";
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate postStart = LocalDate.now();
	private String isbn;
	private String description;
	private Integer day;
	private String reservationStatus = "可預約";
	private List<BookPic> bookPics;

	public List<BookPic> getBookPics() {
		return bookPics;
	}

	public void setBookPics(List<BookPic> bookPics) {
		this.bookPics = bookPics;
	}

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

	public Integer getBookNo() {
		return bookNo;
	}

	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}

	@Override
	public String toString() {
		return "BookDto [id=" + id + ", bookNo=" + bookNo + ", title=" + title + ", bookCategory=" + bookCategory
				+ ", author=" + author + ", technology=" + technology + ", publisher=" + publisher + ", publishDate="
				+ publishDate + ", status=" + status + ", postStart=" + postStart + ", isbn=" + isbn + ", description="
				+ description + ", day=" + day + ", reservationStatus=" + reservationStatus + ", bookPics=" + bookPics
				+ "]";
	}

}
