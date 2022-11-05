package tw.com.de.librarysystem.entity.impl;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Member implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String memNO;
	private String email;
	private String name;
	private String password;
	private String permission;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}



}

/*
 * @Id
	private String memNO;
	private String name;
	private String password;
	private String permission;
	private String email;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "member")
	private Set<Advice> advices;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "member")
	@JsonManagedReference
//	@JsonBackReference
	private Set<Reservation> reservations;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "member")
	private Set<Record> records;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "member")
	private Set<LendingList> lendingLists;
	*/