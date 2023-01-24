package com.spring.boot.mysql.connector.sprotyshoes.demo.models;

import java.util.Objects;



public class Admins implements Comparable <Admins> {
	
	Integer adminId;
	String adminFirstName;
	String adminLastName;
	String adminPassword;
	
	public Admins() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admins(Integer adminId, String adminFirstName, String adminLastName,String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
	    this.adminPassword= adminPassword;
	 }

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}
  
	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	    public int hashCode() {
	    	return Objects.hash(adminFirstName,adminId);
	    }
		
	    
	    @Override
	    public boolean equals(Object obj) {
	    	if(this==obj)
	    		return true;
	    	if(obj==null)
	    		return false;
	    	if(getClass()!=obj.getClass())
	    		return false;
	        Admins other=(Admins)obj;
	        return Objects.equals(adminFirstName,other.adminFirstName)&& Objects.equals(adminId,other.adminId);
	    
	    }

		@Override
		public int compareTo(Admins o) {
			if(this.adminId<o.adminId) {
				return -1;
			}
			if (this.adminId>o.adminId) {
				return 1;
			}
			if(this.equals(o)){
				return 0;
			}
		    
			return this.adminFirstName.compareTo(o.adminFirstName);
		}
	
}
