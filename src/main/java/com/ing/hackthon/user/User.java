package com.ing.hackthon.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for the user domain object
 */
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="number_of_logins")
	private int numberOfLogins;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	public User(int id, String name, String userName, String password) {
		super();
		this.id = id;
		this.userName = name;
		this.userName = userName;
		this.password = password;
	}

	public User(){

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfLogins() {
		return numberOfLogins;
	}

	public void setNumberOfLogins(int numberOfLogins) {
		this.numberOfLogins = numberOfLogins;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
