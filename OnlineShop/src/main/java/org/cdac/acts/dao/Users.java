package org.cdac.acts.dao;

public class Users {
	
	String userName;
	String password;
	String name;
	String phone;
	
	public Users() {
	}
	
	public Users(String userName, String password, String name, String phone) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.phone = phone;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
