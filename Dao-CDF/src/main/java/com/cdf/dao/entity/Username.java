package com.cdf.dao.entity;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Username {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USERNAME_ID")
	private Collection<Favour> favours = new LinkedHashSet<Favour>();

	public Collection<Favour> getFavours() {
		return favours;
	}

	public void setFavours(Collection<Favour> favours) {
		this.favours = favours;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
