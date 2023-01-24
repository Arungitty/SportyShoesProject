package com.spring.boot.mysql.connector.sprotyshoes.demo.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Order;
import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Product;
import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Users;
import com.spring.boot.mysql.connector.sprotyshoes.demo.service.AllService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private AllService allService;

	
	public UserController() {
		super();
	 }
	
    @PostMapping("/create")
	public String createUsers(@RequestBody Users user) {
    	  try {
  			if(Boolean.TRUE.equals(this.allService.addUser(user))) {
  				return "New user record added successfully";
  			}
  		} catch(SQLException ex){
  			System.out.println("Exception occured while inserting a new user record!/n" +ex);
  		}
  		
  		 return "Failed to insert a new user record";
        }	 
  		

    @GetMapping("/getproductbyname")
    public String get(String productName){
    	try {
    		List<Product> products=this.allService.getProductByProductName(productName);
    		return  products.toString();
    		} catch(SQLException ex){
    		 System.out.println("Exception occured while fetching the record of Product!" +productName+ "/n" +ex);
    	   }
           
    	return "Something went wrong while fetching the record of worker!/n" +productName ;
     }	  

    @GetMapping("/getproductbyproductid")
    public String get(Integer productId){
    	try {
    		Product product= new Product();
    		product=this.allService.getProduct(productId);
    		return product== null ? "Empty set!"	: product.toString();
    		} catch(SQLException ex){
    		 System.out.println("Exception occured while fetching the record of Product!" +productId + "/n" +ex);
    	   }
           
    	return "Something went wrong while fetching the record of worker!/n" +productId ;
     }	  

    @GetMapping("/alluserdetails")
 	public String getAllUserDetail() {
		
		try {
			List<Users> users= this.allService.getAllUser();
		 
	       return users.isEmpty() ? "Empty set" : users.toString();
		 } catch(SQLException ex) {
			System.out.println("Exception occured while fetching all user record!/n" +ex);
		    }
	
		  return "Something went wrong while fetching all user records";
	  }  

    @GetMapping("/getorderbyproductid")
    public String getOrderThroughProductId(Integer productId){
    	try {
    		List<Order> orders=this.allService.getOrdersByProductId(productId);
    		return orders== null ? "Empty set!"	: orders.toString();
    	  } catch(SQLException ex){
    		 System.out.println("Exception occured while fetching the record of Product!" +productId+ "/n" +ex);
    	   }
           
    	return "Something went wrong while fetching the record of product!/n" +productId ;
     }	  


    @GetMapping("/allOrderdetail")
 	public String getAllOrderDetail() {
		
		try {
			List<Order> orders= this.allService.getAllOrder();
		    return orders.isEmpty() ? "Empty set" : orders.toString();
		  } catch(SQLException ex) {
			System.out.println("Exception occured while fetching all order record!/n" +ex);
		    }
	
		  return "Something went wrong while fetching all order records";
	  }  

    @PostMapping("/updateuserpassword")
    public String updateUserPassword(Integer userId, String changeUserPassword){
    	try {
    		if(Boolean.TRUE.equals(this.allService.ByUserIdUpdatePassword(userId, changeUserPassword))) {
    	    return String.format("Password updated successfully:-", changeUserPassword );
    		 }
    		} catch(SQLException ex){
    		 return  String.format("Exception occured while updating the record of users whose id is:-" +changeUserPassword +ex);
    	 }
    
       return String.format("Failed to update the record of worker whose id is:-", changeUserPassword);
     }	

    @PostMapping("/updateuserfirstname")
    public String updateUserName(Integer userId, String changeUserFirstName){
    	try {
    		if(Boolean.TRUE.equals(this.allService.byUserIdUpdateUserFirstName( changeUserFirstName ,userId))) {
    	    return String.format("User first name changed successfully:-", changeUserFirstName );
    		 }
    		} catch(SQLException ex){
    		 return  String.format("Exception occured while updating the first name of user whose id is:-" +userId +ex);
    	 }
    
       return String.format("Failed to update the first name of user whose id is:-", userId);
     }	

}







