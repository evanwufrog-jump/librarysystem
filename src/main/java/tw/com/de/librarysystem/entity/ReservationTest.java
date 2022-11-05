package tw.com.de.librarysystem.entity;

import java.time.LocalDate;

public interface ReservationTest {
	
	public Integer getId();
	public String getStatus();
	public LocalDate getDate();
	public String getAuthor();
	public String getIsbn();
	public String getTechnology();
	public String getTitle();
	public String getCategory();
	public String getMemNO();
	public String getEmail();
	public String getName();
	public String getPermission();
	
	public Integer setId();
	public String setStatus();
	public LocalDate setDate();
	public String setAuthor();
	public String setIsbn();
	public String setTechnology();
	public String setTitle();
	public String setCategory();
	public String setMemNO();
	public String setEmail();
	public String setName();
	public String setPermission();
}
