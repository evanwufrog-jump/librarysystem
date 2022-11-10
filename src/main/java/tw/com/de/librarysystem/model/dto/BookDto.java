package tw.com.de.librarysystem.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
public class BookDto implements Serializable {
	private Integer id;
	private String title;
	private Integer bookCategoryId;
	private String bookCategoryCategory;

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
	private String reservationStatus;
	private Set<BookPicDto> bookPics;
	public Set<BookPicDto> getBookPics() {
	      if (bookPics == null) {
	    	  bookPics = new HashSet<BookPicDto>();
	      }
	      return bookPics;
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

	public Integer getBookCategoryId() {
		return bookCategoryId;
	}

	public void setBookCategoryId(Integer bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}

	public String getBookCategoryCategory() {
		return bookCategoryCategory;
	}

	public void setBookCategoryCategory(String bookCategoryCategory) {
		this.bookCategoryCategory = bookCategoryCategory;
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

	public void setBookPics(Set<BookPicDto> bookPics) {
		this.bookPics = bookPics;
	}

	@Override
	public String toString() {
		return "BookDto [id=" + id + ", title=" + title + ", bookCategoryId=" + bookCategoryId
				+ ", bookCategoryCategory=" + bookCategoryCategory + ", author=" + author + ", technology=" + technology
				+ ", publisher=" + publisher + ", publishDate=" + publishDate + ", status=" + status + ", postStart="
				+ postStart + ", isbn=" + isbn + ", description=" + description + ", day=" + day
				+ ", reservationStatus=" + reservationStatus + ", bookPics=" + bookPics + "]";
	}


	}

	





