package tw.com.de.librarysystem.model.dto;

public class BookPicDto {
	private Integer id;
	private String picture;
	private Integer BookId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getBookId() {
		return BookId;
	}
	public void setBookId(Integer bookId) {
		BookId = bookId;
	}
	
	@Override
	public String toString() {
		return "BookPicDto [id=" + id + ", picture=" + picture + ", BookId=" + BookId + "]";
	}
	
}
