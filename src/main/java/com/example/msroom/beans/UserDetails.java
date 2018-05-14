package com.example.msroom.beans;

import java.sql.Date;

public class UserDetails {
	private final String username;
	private final String password;
	private final String name;
	private final Date dateCreated;
	private final String userGroup;
	
	public UserDetails(String username, String password, String name, Date dateCreated, String userGroup) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.dateCreated = dateCreated;
		this.userGroup = userGroup;
	}
	public String getUsername() {
		return username;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	
}
