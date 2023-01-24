package com.spring.boot.mysql.connector.sprotyshoes.demo.dao;

import java.sql.SQLException;

import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Admins;


public interface AdminsDao {

	// create operation
		Integer createAdmins(Admins admin) throws SQLException;
		
		// Read/Retrieve operations
		
		Admins findAdminByAdminId(Integer adminId) throws SQLException;
		// Update operations
		
		Integer updateAdminPasswordByAdminId(Integer adminId,String changePassword) throws SQLException;
		
		// Delete operations
		

}









