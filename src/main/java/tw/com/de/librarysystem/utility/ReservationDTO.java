package tw.com.de.librarysystem.utility;

import java.time.LocalDate;

public class ReservationDTO {

	private Integer id;
	private String title;
	private String status;
	private LocalDate lendingDate;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDate() {
		return lendingDate;
	}
	public void setDate(LocalDate lendingDate) {
		this.lendingDate = lendingDate;
	}
	
	
}
