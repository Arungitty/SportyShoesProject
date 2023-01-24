package com.spring.boot.mysql.connector.sprotyshoes.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Users;



public interface UsersDao {
	
	    // create operation
		Integer createUsers(Users user) throws SQLException;
		
		// Read/Retrieve operations
		List<Users> findUsersByUserName(String userFirstName, String userLastName) throws SQLException;
		Users findUsersByUserIdAndUserPassword(Integer userId, String userPassword) throws SQLException;
		List<Users> findAllUser() throws SQLException;
		Users findUsersByUserId(Integer userId) throws SQLException;
		
		// Update operations
		Integer updatePasswordByUserId(String changeUserPassword, Integer userId) throws SQLException;
		Integer updateUserFirstNameByUserId(String changeUserFirstName , Integer userId) throws SQLException;
		Integer updateUserLastNameByUserId(String changeUserLastName , Integer userId) throws SQLException;
		
		
}








