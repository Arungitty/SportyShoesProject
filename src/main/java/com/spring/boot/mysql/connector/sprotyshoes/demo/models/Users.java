package com.spring.boot.mysql.connector.sprotyshoes.demo.models;

import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Users implements Comparable<Users> {
	
	Integer userId;
	String userFirstName;
	String userLastName;
	@JsonFormat(pattern="yyyy-MM-dd")
	Timestamp userSignUpDate;
	String password;
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Users(Integer userId, String userFirstName, String userLastName, Timestamp userSignUpDate, String password) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userSignUpDate = userSignUpDate;
		this.password = password;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public Timestamp getUserSignUpDate() {
		return userSignUpDate;
	}


	public void setUserSignUpDate(Timestamp userSignUpDate) {
		this.userSignUpDate = userSignUpDate;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	 
    @Override
    public int hashCode() {
    	return Objects.hash(password,userId);
    }
	
    
    @Override
    public boolean equals(Object obj) {
    	if(this==obj)
    		return true;
    	if(obj==null)
    		return false;
    	if(getClass()!=obj.getClass())
    		return false;
        Users other=(Users)obj;
        return Objects.equals(password,other.password)&& Objects.equals(userId,other.userId);
    
    }

	@Override
	public int compareTo(Users o) {
		if(this.userId<o.userId) {
			return -1;
		}
		if (this.userId>o.userId) {
			return 1;
		}
		if(this.equals(o)){
			return 0;
		}
	    
		return this.password.compareTo(o.password);
	}


	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userSignUpDate=" + userSignUpDate + ", password=" + password + "]";
	}

}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


