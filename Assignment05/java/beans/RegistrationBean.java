package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class RegistrationBean {
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String dob;
	private int status; 
	private String role;
	private int userStatus;
	
	public RegistrationBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
	public void register()
	{
		Date date = Date.valueOf(dob);
		User user = new User(0,fname,lname,email,password,date,status,role);
		System.out.println(user);
		try(UserDao userDao = new UserDaoImpl()) {
			this.userStatus = userDao.save(user);
			System.out.println("u"+userStatus);
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}
	
	
	
	
}
