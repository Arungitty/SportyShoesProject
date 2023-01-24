package com.spring.boot.mysql.connector.sprotyshoes.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.mysql.connector.sprotyshoes.demo.dao.AdminsDao;
import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Admins;
import com.spring.boot.mysql.connector.sprotyshoes.demo.utils.DatabaseConnection;


@Repository
public class AdminsRepository implements AdminsDao{

	private final Connection connection;

	@Autowired
	public AdminsRepository(DatabaseConnection db) {
		super();
		this.connection = db.getConnection();
	}
	

	@Override
	public Integer createAdmins(Admins admin) throws SQLException{
	
		String insertAdminsFormat= """
		   INSERT INTO Admins(ADMIN_ID,ADMIN_FIRST_NAME,ADMIN_LAST_NAME,ADMIN_PASSWORD) Values(?,?,?,?) """;
	      
	    try(PreparedStatement preparedStatement=connection.prepareStatement(insertAdminsFormat);){
	    	preparedStatement.setInt(1,admin.getAdminId());
	    	preparedStatement.setString(2, admin.getAdminFirstName());
	        preparedStatement.setString(3, admin.getAdminLastName());
	        preparedStatement.setString(4, admin.getAdminPassword());
	        
	        return preparedStatement.executeUpdate();
	    }   
	}
				
	@Override
	public Admins findAdminByAdminId(Integer adminId) throws SQLException{
	
		String getAdminsFormat="""
			SELECT *
			FROM 
			   Admins
			WHERE
			   ADMIN_ID= ? """;
	
	    try(PreparedStatement preparedStatement=connection.prepareStatement(getAdminsFormat);){
	    	
	    	preparedStatement.setInt(1, adminId);
	        ResultSet rs= preparedStatement.executeQuery();
	        if(!rs.isBeforeFirst()){
	        	return null;
	        }
	        
	      Admins admin=new Admins();
	       while(rs.next()) {
	    	  admin.setAdminId(rs.getInt("ADMIN_ID"));
	    	  admin.setAdminFirstName(rs.getString("ADMIN_FIRST_NAME"));
	    	  admin.setAdminLastName(rs.getString("ADMIN_LAST_NAME"));
	          admin.setAdminPassword(rs.getString("ADMIN_PASSWORD"));
	        }
	      return admin;
	   }     
	}
	
	  @Override
	  public Integer updateAdminPasswordByAdminId(Integer adminId,String changePassword) throws SQLException{
			
			String updateAdminPasswordByAdminId= """
					UPDATE Admins
					 SET
					  ADMIN_PASSWORD= ADMIN_PASSWORD * ?
					 WHERE
					   ADMIN_ID= ? """;
				 	
		 try(PreparedStatement preparedStatement= connection.prepareStatement(updateAdminPasswordByAdminId);){
			  
			  preparedStatement.setString(1,changePassword);
			  preparedStatement.setInt(2,adminId);
		      
			  return preparedStatement.executeUpdate();
		  }
	   }			

}





