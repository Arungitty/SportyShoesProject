package com.spring.boot.mysql.connector.sprotyshoes.demo.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Order;



public interface OrderDao {
	
	// create operation
		Integer createOrder(Order order) throws SQLException;
		
		// Read/Retrieve operations
		List<Order> findOrdersInAscendingOrderByOrderDate(Timestamp orderDate) throws SQLException;
		List<Order> findOrdersInDescendingOrderByOrderDate(Timestamp orderDate) throws SQLException;
		List<Order> findOrdersInAscendingOrderByOrderId(Integer orderId) throws SQLException;
		List<Order> findOrdersInDescendingOrderByOrderId(Integer orderId) throws SQLException;
		List<Order> findOrdersByProductId(Integer productId) throws SQLException;
		List<Order> findOrdersByUserId(Integer userId) throws SQLException;
		List<Order> findAllOrder() throws SQLException;
		
		// Update operations
		
		// Delete operations
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
