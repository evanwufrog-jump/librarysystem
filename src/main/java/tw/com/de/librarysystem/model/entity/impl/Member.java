package tw.com.de.librarysystem.model.entity.impl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String memNO;

	private String name;

	private String password;

	private String permission;

	private String email;

//	@OneToMany(fetch = FetchType.LAZY,mappedBy = "member")
//	private Set<Advice> advices;
//	@OneToMany(fetch = FetchType.LAZY,mappedBy = "member")
//	@JsonManagedReference
////	@JsonBackReference
//	private Set<Reservation> reservations;
//	@OneToMany(fetch = FetchType.LAZY,mappedBy = "member")
//	private Set<Record> records;
//	@OneToMany(fetch = FetchType.LAZY,mappedBy = "member")
//	private Set<LendingList> lendingLists;

	@Override
	public String toString() {
		return "Member [id=" + id + ", memNO=" + memNO + ", name=" + name + ", password=" + password + ", permission="
				+ permission + ", email=" + email + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMemNO() {
		return memNO;
	}

	public void setMemNO(String memNO) {
		this.memNO = memNO;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}