package com.spring.boot.mysql.connector.sprotyshoes.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.mysql.connector.sprotyshoes.demo.dao.OrderDao;

import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Order;
import com.spring.boot.mysql.connector.sprotyshoes.demo.utils.DatabaseConnection;

@Repository
public class OrderRepository implements OrderDao{
	
	private final Connection connection;
    
	
	@Autowired
	public OrderRepository(DatabaseConnection db) {
		super();
		this.connection = db.getConnection();
	 }
	
	@Override
	public Integer createOrder(Order order) throws SQLException{
	
		String insertOrderFormat= """
		   INSERT INTO Order(ORDER_ID,USER_ID,PRODUCT_ID,ORDER_DATE,ORDER_PRODUCT_NAME) Values(?,?,?,?,?) """;
	      
	    try(PreparedStatement preparedStatement=connection.prepareStatement(insertOrderFormat);){
	    	preparedStatement.setInt(1,order.getOrderId());
	    	preparedStatement.setInt(2, order.getUserId());
	        preparedStatement.setInt(3, order.getProductId());
	        preparedStatement.setTimestamp(4, order.getOrderDate());
	        preparedStatement.setString(5,order.getOrderProductName());
	        return preparedStatement.executeUpdate();
	    }   
	}
	
	@Override
	public List<Order> findOrdersInAscendingOrderByOrderDate(Timestamp orderDate) throws SQLException{
	
		String getOrderDateOrderFormat="""
				SELECT *
				  FROM
				 Order
				  WHERE
				   ORDER_DATE= ? """; 
		
	    try(PreparedStatement preparedStatement= connection.prepareStatement(getOrderDateOrderFormat);){
	    	preparedStatement.setTimestamp(1, orderDate);
	    	ResultSet rs= preparedStatement.executeQuery();
	   
			ArrayList<Order>orders= new ArrayList<Order>();
	    
	    	if(!rs.isBeforeFirst()){
	    	  return orders;
	    	}
	    	   
	    	  while(rs.next()){
	    	    Order order= new Order();
	    	    order.setUserId(rs.getInt("USER_ID"));
	    	    order.setOrderId(rs.getInt("ORDER_ID"));
	    	    order.setProductId(rs.getInt("PRODUCT_ID"));
	    	    order.setOrderDate(rs.getTimestamp("ORDER_DATE"));
	    	    order.setOrderProductName(rs.getString("ORDER_PRODUCT_NAME"));
	    	    orders.add(order);
	    	    Collections.sort(orders);
	    	  }
	    	    return orders;
	         }   
	   }	  
	
	@Override
	public List<Order> findOrdersInDescendingOrderByOrderDate(Timestamp orderDate) throws SQLException{
	
		String getOrderDateOrderFormat="""
				SELECT *
				  FROM
				 Order
				  WHERE
				   ORDER_DATE= ? """; 
		
	    try(PreparedStatement preparedStatement= connection.prepareStatement(getOrderDateOrderFormat);){
	    	preparedStatement.setTimestamp(1, orderDate);
	    	ResultSet rs= preparedStatement.executeQuery();
	   
			ArrayList<Order>orders= new ArrayList<Order>();
	    
	    	if(!rs.isBeforeFirst()){
	    	  return orders;
	    	}
	    	   
	    	  while(rs.next()){
	    	    Order order= new Order();
	    	    order.setUserId(rs.getInt("USER_ID"));
	    	    order.setOrderId(rs.getInt("ORDER_ID"));
	    	    order.setProductId(rs.getInt("PRODUCT_ID"));
	    	    order.setOrderDate(rs.getTimestamp("ORDER_DATE"));
	    	    order.setOrderProductName(rs.getString("ORDER_PRODUCT_NAME"));
	    	    orders.add(order);
	    	    Collections.sort(orders,Collections.reverseOrder());
	    	  }
	    	    return orders;
	         }   
	   }	  
	
	@Override
	public List<Order> findOrdersInAscendingOrderByOrderId(Integer orderId)throws SQLException{
	
		String getOrderIdOrderFormat="""
				SELECT *
				  FROM
				 Order
				  WHERE
				   ORDER_ID= ? """; 
		
	    try(PreparedStatement preparedStatement= connection.prepareStatement(getOrderIdOrderFormat);){
	    	
	    	 while(orderId!=0){
	    		preparedStatement.setInt(1, orderId);	
	    	 }
	    	
	    	ResultSet rs= preparedStatement.executeQuery();
	   
			ArrayList<Order>orders= new ArrayList<Order>();
	    
	    	if(!rs.isBeforeFirst()){
	    	  return orders;
	    	}
	    	   
	    	  while(rs.next()){
	    	    Order order= new Order();
	    	    order.setUserId(rs.getInt("USER_ID"));
	    	    order.setOrderId(rs.getInt("ORDER_ID"));
	    	    order.setProductId(rs.getInt("PRODUCT_ID"));
	    	    order.setOrderDate(rs.getTimestamp("ORDER_DATE"));
	    	    order.setOrderProductName(rs.getString("ORDER_PRODUCT_NAME"));
	    	    orders.add(order);
	    	    Collections.sort(orders);
	    	  }
	    	    return orders;
	         }   
	   }	  
	
	@Override
	public List<Order> findOrdersInDescendingOrderByOrderId(Integer orderId)throws SQLException{
	
		String getOrderIdOrderFormat="""
				SELECT *
				  FROM
				 Order
				  WHERE
				   ORDER_ID= ? """; 
		
	    try(PreparedStatement preparedStatement= connection.prepareStatement(getOrderIdOrderFormat);){
	    	
	    	 while(orderId!=0){
	    		preparedStatement.setInt(1, orderId);	
	    	 }
	    	
	    	ResultSet rs= preparedStatement.executeQuery();
	   
			ArrayList<Order>orders= new ArrayList<Order>();
	    
	    	if(!rs.isBeforeFirst()){
	    	  return orders;
	    	}
	    	   
	    	  while(rs.next()){
	    	    Order order= new Order();
	    	    order.setUserId(rs.getInt("USER_ID"));
	    	    order.setOrderId(rs.getInt("ORDER_ID"));
	    	    order.setProductId(rs.getInt("PRODUCT_ID"));
	    	    order.setOrderDate(rs.getTimestamp("ORDER_DATE"));
	    	    order.setOrderProductName(rs.getString("ORDER_PRODUCT_NAME"));
	    	    orders.add(order);
	    	    Collections.sort(orders,Collections.reverseOrder());
	    	  }
	    	    return orders;
	         }   
	   }	  
	
	@Override
	public List<Order> findOrdersByProductId(Integer productId)throws SQLException{
	
		String getOrdersByProductIdFormat="""
				SELECT *
				  FROM
				 Order
				  WHERE
				   PRODUCT_ID= ? """; 
		
	    try(PreparedStatement preparedStatement= connection.prepareStatement(getOrdersByProductIdFormat);){
	    	
	    	 while(productId!=0){
	    		preparedStatement.setInt(1, productId);	
	    	 }
	    	
	    	ResultSet rs= preparedStatement.executeQuery();
	   
			ArrayList<Order>orders= new ArrayList<Order>();
	    
	    	if(!rs.isBeforeFirst()){
	    	  return orders;
	    	}
	    	   
	    	  while(rs.next()){
	    	    Order order= new Order();
	    	    order.setUserId(rs.getInt("USER_ID"));
	    	    order.setOrderId(rs.getInt("ORDER_ID"));
	    	    order.setProductId(rs.getInt("PRODUCT_ID"));
	    	    order.setOrderDate(rs.getTimestamp("ORDER_DATE"));
	    	    order.setOrderProductName(rs.getString("ORDER_PRODUCT_NAME"));
	    	    orders.add(order);
	    	  }
	    	    return orders;
	         }   
	   }	  
	
	@Override
	public List<Order> findOrdersByUserId(Integer userId)throws SQLException{
	
		String getOrdersByUserIdFormat="""
				SELECT *
				  FROM
				 Order
				  WHERE
				   USER_ID= ? """; 
		
	    try(PreparedStatement preparedStatement= connection.prepareStatement(getOrdersByUserIdFormat);){
	    	
	    	 while(userId!=0){
	    		preparedStatement.setInt(1, userId);	
	    	 }
	    	
	    	ResultSet rs= preparedStatement.executeQuery();
	   
			ArrayList<Order>orders= new ArrayList<Order>();
	    
	    	if(!rs.isBeforeFirst()){
	    	  return orders;
	    	}
	    	   
	    	  while(rs.next()){
	    	    Order order= new Order();
	    	    order.setUserId(rs.getInt("USER_ID"));
	    	    order.setOrderId(rs.getInt("ORDER_ID"));
	    	    order.setProductId(rs.getInt("PRODUCT_ID"));
	    	    order.setOrderDate(rs.getTimestamp("ORDER_DATE"));
	    	    order.setOrderProductName(rs.getString("ORDER_PRODUCT_NAME"));
	    	    orders.add(order);
	    	  }
	    	    return orders;
	         }   
	   }	  
	
	@Override
	public List<Order> findAllOrder()throws SQLException {
		
		String getAllOrderFormat="""
				SELECT *
				  FROM
				Order
				   """; 
		
	    try(PreparedStatement preparedStatement= connection.prepareStatement(getAllOrderFormat);){
	    	
	    	ResultSet rs= preparedStatement.executeQuery();
	   
			List<Order>orders= new ArrayList<>();
	    
	    	if(!rs.isBeforeFirst()){
	    	  return orders;
	    	}
	    	   
	    	  while(rs.next()){
	    		  Order order= new Order();
		    	  order.setUserId(rs.getInt("USER_ID"));
		    	  order.setOrderId(rs.getInt("ORDER_ID"));
		    	  order.setProductId(rs.getInt("PRODUCT_ID"));
		    	  order.setOrderDate(rs.getTimestamp("ORDER_DATE"));
		    	  order.setOrderProductName(rs.getString("ORDER_PRODUCT_NAME"));
		    	  orders.add(order);
		    	  }
		       return orders;
		    }   
	    }
	
}
