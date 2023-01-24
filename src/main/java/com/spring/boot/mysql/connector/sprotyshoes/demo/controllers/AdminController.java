package com.spring.boot.mysql.connector.sprotyshoes.demo.controllers;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Admins;
import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Order;
import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Product;
import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Users;
import com.spring.boot.mysql.connector.sprotyshoes.demo.service.AllService;



@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AllService allService;

	
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/createAdmins")
	public String create(@RequestBody Admins admin) {
		
		  try {
			if(Boolean.TRUE.equals(this.allService.addAdmins(admin))) {
				return "New admin record added successfully";
			}
		} catch(SQLException ex){
			System.out.println("Exception occured while inserting a new admin record!/n" +ex);
		}
		
		 return "Failed to insert a new admin record";
      }	 
	
	@PostMapping("/createusers")
	public String create(@RequestBody Users user) {
		
		  try {
			if(Boolean.TRUE.equals(this.allService.addUser(user))) {
				return "New user record added successfully";
			}
		} catch(SQLException ex){
			System.out.println("Exception occured while inserting a new user record!/n" +ex);
		}
		
		 return "Failed to insert a new user record";
      }	 
		
	@PostMapping("/createorders")
	public String createOrders(@RequestBody Order order) {
		
		  try {
			if(Boolean.TRUE.equals(this.allService.addOrder(order))) {
				return "New Order record added successfully";
			}
		} catch(SQLException ex){
			System.out.println("Exception occured while inserting a new Order record!/n" +ex);
		}
		
		 return "Failed to insert a new Order record";
      }	 
	
	@PostMapping("/updatepassword")
    public String updateAdminPassword(Integer adminId,String changePassword) throws SQLException{
    	try {
    		if(Boolean.TRUE.equals(this.allService.byAdminIdUpdateAdminPassword(adminId,changePassword))) {
    	    return String.format("Record of adminid updated successfully", adminId);
    		 }
    		} catch(SQLException ex){
    		 return  String.format("Exception occured while updating the record of admin whose id is:-" +adminId +ex);
    	 }
    
       return String.format("Failed to update the record of admin whose id is:-", adminId);
    }	

	@GetMapping("/listofuser")
 	public String getAll() {
		
		try {
			List<Users> users= this.allService.getAllUser();
		 
	       return users.isEmpty() ? "Empty set" :users.toString();
		  } catch(SQLException ex) {
			System.out.println("Exception occured while fetching all worker record!/n" +ex);
		    }
	
		  return "Something went wrong while fetching all workers records";
	  }  
	
	 @GetMapping("/getusersbytheirname")
	 public ResponseEntity<List<Users>> getAllUsers(@RequestParam(required=false) String userFirstName,String userLastName){
	        try {
	    		List<Users> users= new ArrayList<>();
	    		
	    		if(userFirstName== null && userLastName==null){
	    			users= this.allService.getAllUser();
	    		 } else {
	    			 users= this.allService.getUser(userFirstName,userLastName);
	   		        }
	    		System.out.println(users.toString());		
	    	    return users.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
	    	    		: new ResponseEntity<>(users,HttpStatus.OK);
	   	       } catch(Exception ex){
	    		  System.out.println("Exception occur while fetching worker records!/n" +ex);
	    	      return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	     	 }
	    }	
	    	
     @GetMapping("/getuserbyuserid")
     public String get(Integer userId){
     	
     	try {
     		Users user=this.allService.getUserByUserId(userId);
     		return user== null ? "Empty set!" : user.toString();
     		 } catch(SQLException ex){
     		 System.out.println("Exception occured while fetching the record of user!" +userId + "/n" +ex);
     	      }
        return "Something went wrong while fetching the record of user!/n" +userId ;
      }	  
    
     @GetMapping("/getlistofallproduct")
     public String getAllProducts() {
 		
 		try {
 			List<Product> products= this.allService.getAllProduct();
 		 
 	       return products.isEmpty() ? "Empty set" : products.toString();
 		 } catch(SQLException ex) {
 			System.out.println("Exception occured while fetching all product record!/n" +ex);
 		    }
 	
 		  return "Something went wrong while fetching all product records";
 	   }  
	
	 @PostMapping("/createproduct")
	 public String create(@RequestBody Product product) {
		 try {
			   if(Boolean.TRUE.equals(this.allService.addProduct(product))) {
			    return "New product record added successfully";
				}
			  } catch(SQLException ex){
				System.out.println("Exception occured while inserting a new product record!/n" +ex);
			     }
		 return "Failed to insert a new product record";
	   }	 
	 
	 @GetMapping("/getproductbyproductid")
     public String getProducts(Integer productId){
     	
     	try {
     		Product product=this.allService.getProduct(productId);
     		return product== null ? "Empty set!" : product.toString();
     		} catch(SQLException ex){
     		 System.out.println("Exception occured while fetching the record of product!" +  productId + "/n" +ex);
     	    }
        return "Something went wrong while fetching the record of product!/n" +productId ;
      }	  
	
	 @PostMapping("/updateproduct")
	 public String update(Integer productId){
	    try {
	    	  if(Boolean.TRUE.equals(this.allService.updateProducts(productId))) {
	    	  return String.format("Record of product id updated successfully", productId);
	    	    }
	         } catch(SQLException ex){
	    	   return  String.format("Exception occured while updating the record of product whose id is:-" +productId +ex);
	    	  }
	    
	       return String.format("Failed to update the record of product whose id is:-", productId);
	   }	
	 
	 @PostMapping("/delete")
	 public String delete(Integer productId){
	    	try {
	    		if(Boolean.TRUE.equals(this.allService.deleteProduct(productId))) {
	    	    return String.format("Record of product id deleted successfully", productId);
	    		 }
	    		} catch(SQLException ex){
	    		 return  String.format("Exception occured while deleting the record of product whose id is:-" +productId +ex);
	    	   }
	     
	       return String.format("Failed to delete the record of product whose id is:-", productId);
	    }
	 
	 @GetMapping("/listorderinascendingbyorderdate")
	    public ResponseEntity<List<Order>> getAllOrderInAscending(@RequestParam(required=false) Timestamp orderDate){
	    	try {
	    		List<Order> orders= new ArrayList<>();
	    		
	    		if(orderDate== null){
	    			orders= this.allService.getAllOrder();
	    		 } else {
	    			orders= this.allService.getOrdersInAscendingOrderByOrderDate(orderDate);
	   		        }
	    		System.out.println(orders.toString());		
	    	    return orders.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
	    	    		: new ResponseEntity<>(orders,HttpStatus.OK);
	   	    } catch(Exception ex){
	    		System.out.println("Exception occur while fetching order records!/n" +ex);
	    	    return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	     	}
	     }	
	 
	 @GetMapping("/listorderindescendingbyorderdate")
	    public ResponseEntity<List<Order>> getAllOrderInDescending(@RequestParam(required=false) Timestamp orderDate){
	    	try {
	    		List<Order> orders= new ArrayList<>();
	    		
	    		if(orderDate== null){
	    			orders= this.allService.getAllOrder();
	    		 } else {
	    			orders= this.allService.getOrdersInDescendingOrderByOrderDate(orderDate);
	   		        }
	    		System.out.println(orders.toString());		
	    	    return orders.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
	    	    		: new ResponseEntity<>(orders,HttpStatus.OK);
	   	    } catch(Exception ex){
	    		System.out.println("Exception occur while fetching order records!/n" +ex);
	    	    return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	     	}
	     }	
	
	 @GetMapping("/listorderindescendingbyorderid")
	    public ResponseEntity<List<Order>> getAllOrderInDescendingByOrderId(@RequestParam(required=false) Integer orderId){
	    	try {
	    		List<Order> orders= new ArrayList<>();
	    		
	    		if(orderId== null){
	    			orders= this.allService.getAllOrder();
	    		 } else {
	    			orders= this.allService.getOrdersInDescendingOrderByOrderId(orderId);
	   		        }
	    		System.out.println(orders.toString());		
	    	    return orders.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
	    	    		: new ResponseEntity<>(orders,HttpStatus.OK);
	   	    } catch(Exception ex){
	    		System.out.println("Exception occur while fetching order records!/n" +ex);
	    	    return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	     	}
	     }	
	 
	 @GetMapping("/listorderinascendingbyorderid")
	    public ResponseEntity<List<Order>> getAllOrderInAscendingByOrderId(@RequestParam(required=false) Integer orderId){
	    	try {
	    		List<Order> orders= new ArrayList<>();
	    		
	    		if(orderId== null){
	    			orders= this.allService.getAllOrder();
	    		 } else {
	    			orders= this.allService.getOrdersInAscendingOrderByOrderId(orderId);
	   		        }
	    		System.out.println(orders.toString());		
	    	    return orders.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
	    	    		: new ResponseEntity<>(orders,HttpStatus.OK);
	   	    } catch(Exception ex){
	    		System.out.println("Exception occur while fetching order records!/n" +ex);
	    	    return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	     	}
	     }	
	 
	 @GetMapping("/getallordersbyproductid")
     public String getOrdersThroughProductId(Integer productId){
     	
     	try {
     		List<Order> orders= new ArrayList<>();
     	    orders=this.allService.getOrdersByProductId(productId);
     		return orders== null ? "Empty set!" : orders.toString();
     		} catch(SQLException ex){
     		 System.out.println("Exception occured while fetching the record of order!" +  productId + "/n" +ex);
     	    }
        return "Something went wrong while fetching the record of order!/n" +productId ;
      }	  
	 
	 @GetMapping("/getallordersbyuserid")
     public String getOrdersThroughUserId(Integer userId){
     	
     	try {
     		List<Order> orders= new ArrayList<>();
     	    orders=this.allService.getOrdersByUserId(userId);
     		return orders== null ? "Empty set!" : orders.toString();
     		} catch(SQLException ex){
     		 System.out.println("Exception occured while fetching the record of order!" + userId + "/n" +ex);
     	    }
        return "Something went wrong while fetching the record of order!/n" +userId ;
      }	  
	 
	 @GetMapping("/getproductbyproductname")
	    public String get(String productName){
	    	try {
	    		List<Product> products= new ArrayList<>();
	    		products=this.allService.getProductByProductName(productName);
	    		return products== null ? "Empty set!" : products.toString();
	    		} catch(SQLException ex){
	    		 System.out.println("Exception occured while fetching the record of product!" + productName + "/n" +ex);
	    	     }
	           
	    	return "Something went wrong while fetching the record of product!/n" +productName ;
	     }	  
	  
}









