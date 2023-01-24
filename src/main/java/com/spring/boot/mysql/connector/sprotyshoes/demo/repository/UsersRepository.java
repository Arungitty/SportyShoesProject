package com.spring.boot.mysql.connector.sprotyshoes.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.mysql.connector.sprotyshoes.demo.dao.UsersDao;
import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Users;
import com.spring.boot.mysql.connector.sprotyshoes.demo.utils.DatabaseConnection;

@Repository
public class UsersRepository implements UsersDao {
	
	 private final Connection connection;
	 
	 
	 @Autowired
	 public UsersRepository(DatabaseConnection db) {
		super();
		this.connection = db.getConnection();
	  }
	 
	 @Override
	 public Integer createUsers(Users user) throws SQLException{
		   String insertUsersFormat= """
			   INSERT INTO Users(USER_ID,USER_FIRST_NAME,USER_LAST_NAME,USER_SIGNUP_DATE,USER_PASSWORD) Values(?,?,?,?,?) """;
		      
		    try(PreparedStatement preparedStatement=connection.prepareStatement(insertUsersFormat);){
		    	preparedStatement.setInt(1,user.getUserId());
		    	preparedStatement.setString(2, user.getUserFirstName());
		        preparedStatement.setString(3, user.getUserLastName());
		        preparedStatement.setTimestamp(4, user.getUserSignUpDate());
		        preparedStatement.setString(5, user.getPassword());
		        
		        return preparedStatement.executeUpdate();
		    }   
		}
	 
	 @Override
	 public Users findUsersByUserId(Integer userId) throws SQLException{
		
			String getUsersFormat="""
				SELECT *
				FROM 
				    Users
				WHERE
				   USER_ID=	? """;
		
		    try(PreparedStatement preparedStatement=connection.prepareStatement(getUsersFormat);){
		    	
		    	preparedStatement.setInt(1, userId);
		        ResultSet rs= preparedStatement.executeQuery();
		        if(!rs.isBeforeFirst()){
		        	return null;
		        }
		        
		       Users user= new Users();
		       while(rs.next()) {
		    	   user.setUserId(rs.getInt("USER_ID"));
		    	   user.setUserFirstName(rs.getString("USER_FIRST_NAME"));
		    	   user.setUserLastName(rs.getString("USER_LAST_NAME"));
		           user.setUserSignUpDate(rs.getTimestamp("USER_SIGNUP_DATE"));
		           user.setPassword(rs.getString("USER_PASSWORD"));
		         }
		       return user;
		    }     
	    }
		 
	 @Override
	 public List<Users> findUsersByUserName(String userFirstName, String userLastName) throws SQLException{
		
			String getUsersFormat="""
				SELECT *
				 FROM 
				  Users
				 WHERE
				   USER_FIRST_NAME= ? 
				   USER_LAST_NAME= ? """;
					     
		try(PreparedStatement preparedStatement=connection.prepareStatement(getUsersFormat);){
		    	
		    	preparedStatement.setString(1, userFirstName);
		        preparedStatement.setString(2,userLastName);
		    	ResultSet rs= preparedStatement.executeQuery();
		        if(!rs.isBeforeFirst()){
		        	return null;
		        }
		       
		       ArrayList<Users> users= new ArrayList<Users>();
		       Users user= new Users();
		       while(rs.next()) {
		    	   user.setUserId(rs.getInt("USER_ID"));
		    	   user.setUserFirstName(rs.getString("USER_FIRST_NAME"));
		    	   user.setUserLastName(rs.getString("USER_LAST_NAME"));
		           user.setUserSignUpDate(rs.getTimestamp("USER_SIGNUP_DATE"));
		           user.setPassword(rs.getString("USER_PASSWORD"));
		           users.add(user);
		       }
		     
		       return users;
		   }     
		}
    
	 @Override
	 public Users findUsersByUserIdAndUserPassword(Integer userId, String userPassword) throws SQLException{
		
			String getUsersFormat="""
				SELECT *
				 FROM 
				   Users
				 WHERE
				   USER_Id= ? 
				     AND
				   USER_PASSWORD= ? """;
					     
		try(PreparedStatement preparedStatement=connection.prepareStatement(getUsersFormat);){
		    	
		    	preparedStatement.setInt(1, userId);
		    	preparedStatement.setString(2, userPassword);
		    	ResultSet rs= preparedStatement.executeQuery();
		        if(!rs.isBeforeFirst()){
		        	return null;
		        }
		        
		       Users user= new Users();
		       while(rs.next()) {
		    	   user.setUserId(rs.getInt("USER_ID"));
		    	   user.setUserFirstName(rs.getString("USER_FIRST_NAME"));
		    	   user.setUserLastName(rs.getString("USER_LAST_NAME"));
		           user.setUserSignUpDate(rs.getTimestamp("USER_SIGNUP_DATE"));
		           user.setPassword(rs.getString("USER_PASSWORD"));
		        }
		     
		       return user;
		   }     
		}
	
	 @Override
		public List<Users> findAllUser() throws SQLException {
			
			String getAllUsersFormat="""
					SELECT *
					  FROM
					 Users
					   """; 
			
		    try(PreparedStatement preparedStatement= connection.prepareStatement(getAllUsersFormat);){
		    	
		    	ResultSet rs= preparedStatement.executeQuery();
		   
				List<Users>users= new ArrayList<>();
		    
		    	if(!rs.isBeforeFirst()){
		    	  return users;
		    	}
		    	   
		    	  while(rs.next()){
		    	   Users user= new Users();
		    	   user.setUserId(rs.getInt("USER_ID"));
		    	   user.setUserFirstName(rs.getString("USER_FIRST_NAME"));
		    	   user.setUserLastName(rs.getString("USER_LAST_NAME"));
		           user.setUserSignUpDate(rs.getTimestamp("USER_SIGNUP_DATE"));
		           user.setPassword(rs.getString("USER_PASSWORD"));
		           users.add(user);
		    	  }
		        return users;
		        }   
		    }
	 @Override
	 public Integer updatePasswordByUserId(String changeUserPassword, Integer userId) throws SQLException{
			
			String updatePasswordByUserId= """
					UPDATE Users
					 SET
					PASSWORD= PASSWORD * ?
					 WHERE
					USER_ID= ? """;
				 	
		  try(PreparedStatement preparedStatement= connection.prepareStatement(updatePasswordByUserId);){
			  
			  preparedStatement.setString(1,changeUserPassword);
			  preparedStatement.setInt(2,userId);
		      
			  return preparedStatement.executeUpdate();
		  }
	  }			
	
	 @Override
	 public Integer updateUserFirstNameByUserId(String changeUserFirstName , Integer userId) throws SQLException{
			
			String updateUserFirstNameByUserId= """
					UPDATE Users
					 SET
					USER_FIRST_NAME= USER_FIRST_NAME * ?
					 WHERE
					USER_ID= ? """;
				 	
		  try(PreparedStatement preparedStatement= connection.prepareStatement(updateUserFirstNameByUserId);){
			  
			  preparedStatement.setString(1,changeUserFirstName);
			  preparedStatement.setInt(2,userId);
		      
			  return preparedStatement.executeUpdate();
		  }
	  }			
	
	 @Override
	 public Integer updateUserLastNameByUserId(String changeUserLastName , Integer userId) throws SQLException{
			
			String updateUserLastNameByUserId= """
					UPDATE Users
					 SET
					USER_Last_NAME= USER_Last_NAME * ?
					 WHERE
					USER_ID= ? """;
				 	
		  try(PreparedStatement preparedStatement= connection.prepareStatement(updateUserLastNameByUserId);){
			  
			  preparedStatement.setString(1,changeUserLastName);
			  preparedStatement.setInt(2,userId);
		      
			  return preparedStatement.executeUpdate();
		  }
	  }			
	
}




