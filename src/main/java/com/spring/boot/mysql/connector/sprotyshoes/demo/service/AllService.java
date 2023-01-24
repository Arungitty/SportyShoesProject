package com.spring.boot.mysql.connector.sprotyshoes.demo.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.spring.boot.mysql.connector.demo.models.Worker;
import com.spring.boot.mysql.connector.sprotyshoes.demo.dao.AdminsDao;
import com.spring.boot.mysql.connector.sprotyshoes.demo.dao.OrderDao;
import com.spring.boot.mysql.connector.sprotyshoes.demo.dao.ProductDao;
import com.spring.boot.mysql.connector.sprotyshoes.demo.dao.UsersDao;
import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Admins;
import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Order;
import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Product;
import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Users;


@Service
public class AllService {
	
	@Autowired
	private AdminsDao adminsRepository;

	@Autowired
	private UsersDao usersRepository;
	
	@Autowired
	private ProductDao productRepository;
	
	@Autowired
	private OrderDao orderRepository;
	
	
	public AllService() {
		super();
	 }

	public Boolean addAdmins(Admins admin) throws SQLException{
    	
    	return  this.adminsRepository.createAdmins(admin) > 0;
     }
	
	
	public Integer byAdminIdUpdateAdminPassword(Integer adminId,String changePassword) throws SQLException {
		
		Integer recordsUpdated= this.adminsRepository.updateAdminPasswordByAdminId(adminId,changePassword);
	    return  recordsUpdated;
	 }
	 
    public Boolean addUser(Users user) throws SQLException{
    	
    	return  this.usersRepository.createUsers(user) > 0;
     }

    public Users getUserByUserIdAndUserPassword(Integer userId, String userPassword) throws SQLException{
		
		return this.usersRepository.findUsersByUserIdAndUserPassword(userId, userPassword);
	 }
    
    public Users getUserByUserId(Integer userId) throws SQLException{
		
		return this.usersRepository.findUsersByUserId(userId);
	 }

    public List<Users> getUser(String userFirstName, String userLastName) throws SQLException{
		
		return this.usersRepository.findUsersByUserName(userFirstName, userLastName);
	 }

    public List<Users> getAllUser() throws SQLException{
		
		return this.usersRepository.findAllUser();
	 }
   
    public Boolean ByUserIdUpdatePassword(Integer userId, String changeUserPassword) throws SQLException{
		
    	Users user= this.usersRepository.findUsersByUserId(userId);
		user.setPassword(changeUserPassword);
	   
		return this.usersRepository.updatePasswordByUserId(changeUserPassword, userId)> 0;
	 }
	
    public Boolean byUserIdUpdateUserFirstName(String changeUserFirstName , Integer userId) throws SQLException{
		
		Users user= this.usersRepository.findUsersByUserId(userId);
		user.setPassword(changeUserFirstName);
	   
		return this.usersRepository.updatePasswordByUserId(changeUserFirstName, userId)> 0;
	 }
	
    public Boolean byUserIdUpdateUserLastName(String changeUserLastName , Integer userId) throws SQLException{
		
		Users user= this.usersRepository.findUsersByUserId(userId);
		user.setPassword(changeUserLastName);
	   
		return this.usersRepository.updatePasswordByUserId(changeUserLastName, userId)> 0;
	 }
	
    public Boolean updateProducts(Integer productId) throws SQLException{
		
		Product product= this.productRepository.findProductByProductId(productId);
		product.setProductId(productId);
	  
		return this.productRepository.updateProductByProductId(productId) > 0;
	 }
    
    public Boolean addProduct(Product product) throws SQLException{
    	
    	return  this.productRepository.createProduct(product) > 0;
     }
	
    public Product getProduct(Integer productId) throws SQLException{
		
		return this.productRepository.findProductByProductId(productId);
	 }

    public List<Product> getProductByProductName(String productName) throws SQLException{
		
		return this.productRepository.findProductByProductName(productName);
	 }
    
	public List<Product> getAllProduct() throws SQLException{
		
		return this.productRepository.findAllProduct();
	 }
    
    
    public Boolean updateProductNameThroughProductId(Integer productId, String changeProductName) throws SQLException{
		
		Product product= this.productRepository.findProductByProductId(productId);
		product.setProductName(changeProductName);
	   
		return this.productRepository.updateProductNameByProductId(changeProductName, productId)> 0;
	 }
    
    public Boolean updateMSRPThroughProductId(Integer productId, Integer changeProductMSRP) throws SQLException{
		
		Product product= this.productRepository.findProductByProductId(productId);
		product.setProductMSRP(changeProductMSRP);
	   
		return this.productRepository.updateProductMSRPByProductId(changeProductMSRP, productId)> 0;
	 } 

    public Boolean updateProductQuantityThroughProductId(Integer productId, Integer changeProductQuantity) throws SQLException{
		
		Product product= this.productRepository.findProductByProductId(productId);
		product.setProductQuantity(changeProductQuantity);
	   
		return this.productRepository.updateProductQuantityByProductId(changeProductQuantity, productId)> 0;
	 } 

    public Boolean updateProductVendorNameThroughProductId(Integer productId, String changeProductVendorName) throws SQLException{
		
		Product product= this.productRepository.findProductByProductId(productId);
		product.setProductVendorName(changeProductVendorName);
	   
		return this.productRepository.updateProductVendorNameByProductId(changeProductVendorName, productId)> 0;
	 } 

    public Boolean deleteProduct(Integer ProductId) throws SQLException{
		
		Integer recordsDeleted= this.productRepository.deleteProductByProductId(ProductId);
		
		return recordsDeleted > 0;
	 }
   
    public List<Order> getOrdersInAscendingOrderByOrderDate(Timestamp orderDate) throws SQLException{
		
		return this.orderRepository.findOrdersInAscendingOrderByOrderDate(orderDate);
	 }
	
    public List<Order> getOrdersInDescendingOrderByOrderDate(Timestamp orderDate) throws SQLException{
		
		return this.orderRepository.findOrdersInDescendingOrderByOrderDate(orderDate);
	 }
	
    public List<Order> getOrdersInAscendingOrderByOrderId(Integer orderId) throws SQLException{
		
		return this.orderRepository.findOrdersInAscendingOrderByOrderId(orderId);
	 }
	
    public List<Order> getOrdersInDescendingOrderByOrderId(Integer orderId) throws SQLException{
		
		return this.orderRepository.findOrdersInDescendingOrderByOrderId(orderId);
	 }
	
    public List<Order> getOrdersByProductId(Integer productId) throws SQLException{
		
		return this.orderRepository.findOrdersByProductId(productId);
	 }
   
    public List<Order> getOrdersByUserId(Integer UserId) throws SQLException{
		
		return this.orderRepository.findOrdersByUserId(UserId);
	 }
    public List<Order> getAllOrder() throws SQLException{
		
		return this.orderRepository.findAllOrder();
	 }

    public Boolean addOrder(Order order) throws SQLException{
    	
    	return  this.orderRepository.createOrder(order) > 0;
     }
}







