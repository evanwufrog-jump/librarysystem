package tw.com.de.librarysystem.entity.impl;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Member {
	@Id
	private String memNO;
	private String name;
	private String password;
	private String permission;
	private String email;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "member")
	private Set<Advice> advices;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "member")
	@JsonManagedReference
	private Set<Reservation> reservations;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "member")
	private Set<Record> records;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "member")
	private Set<LendingList> lendingLists;

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

	public Set<LendingList> getLendingLists() {
		return lendingLists;
	}

	public void setLendingLists(Set<LendingList> lendingLists) {
		this.lendingLists = lendingLists;
	}
	
}