package tw.com.de.librarysystem.model.dto;

import java.time.LocalDate;

import tw.com.de.librarysystem.entity.ReservationTest;

public class ReservationDto implements ReservationTest{
	
	public ReservationDto() {};
	
	public ReservationDto(Integer id, LocalDate date, String author, String isbn, String technology, String category) {
		super();
		this.id = id;
		this.date = date;
		this.author = author;
		this.isbn = isbn;
		this.technology = technology;
		this.category = category;
	}
	public ReservationDto(Integer id, String status, LocalDate date, String author, String isbn, String technology,
			String title, String category, String memNO, String email, String name, String permission) {
		super();
		this.id = id;
		this.status = status;
		this.date = date;
		this.author = author;
		this.isbn = isbn;
		this.technology = technology;
		this.title = title;
		this.category = category;
		this.memNO = memNO;
		this.email = email;
		this.name = name;
		this.permission = permission;
	}
	private Integer id;
//	private Integer bookId;
	private String memNo;// member_memno
	private String status;
	private LocalDate date;
	// bookId = Book.id
//	private Integer id;
	private String author;
//	private Integer day;
//	private String description;
	private String isbn;
//	private LocalDate postStart;
//	private LocalDate publishDate;
//	private String publisher;
//	private String status = "上架";
	private String technology;
	private String title;
//	private Integer bookCategoryId;
	// BookCategory.id
//	private Integer id;
	private String category; // 評估

	
	// Member
	private String memNO;
	private String email; // back
	private String name; // back
//	private String password;
	private String permission; // back
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMemNO() {
		return memNO;
	}
	public void setMemNO(String memNO) {
		this.memNO = memNO;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public Integer setId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDate setDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setIsbn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setTechnology() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setMemNO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setPermission() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
