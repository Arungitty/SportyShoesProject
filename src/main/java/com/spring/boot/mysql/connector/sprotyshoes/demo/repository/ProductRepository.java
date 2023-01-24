package com.spring.boot.mysql.connector.sprotyshoes.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.spring.boot.mysql.connector.demo.models.Worker;
import com.spring.boot.mysql.connector.sprotyshoes.demo.dao.ProductDao;
import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Product;
import com.spring.boot.mysql.connector.sprotyshoes.demo.utils.DatabaseConnection;

@Repository
public class ProductRepository implements ProductDao {
	
	private final Connection connection;
	
	
	@Autowired
	public ProductRepository(DatabaseConnection db) {        // Parameterized Constructor
		super();
		this.connection = db.getConnection();
	 }
	
	@Override
	public Integer createProduct(Product product) throws SQLException{
	
		String insertProductFormat= """
		   INSERT INTO Product(PRODUCT_ID,PRODUCT_NAME,PRODUCT_VENDOR_NAME,PRODUCT_CATEGORY,PRODUCT_QUANTITY,PRODUCT_MSRP) Values(?,?,?,?,?,?) """;
	      
	    try(PreparedStatement preparedStatement=connection.prepareStatement( insertProductFormat);){
	    	preparedStatement.setInt(1,product.getProductId());
	    	preparedStatement.setString(2, product.getProductName());
	        preparedStatement.setString(3, product.getProductVendorName());
	        preparedStatement.setString(4, product.getProductCategory());
	        preparedStatement.setInt(5, product.getProductQuantity());
	        preparedStatement.setInt(6, product.getProductMSRP());
	        return preparedStatement.executeUpdate();
	     }   
	 }
	
	@Override
	public Product findProductByProductId(Integer productId) throws SQLException{
	
		String getProductFormat="""
			SELECT *
			FROM 
			   Product
			WHERE
			   PRODUCT_ID= ? """;	
	
	    try(PreparedStatement preparedStatement=connection.prepareStatement(getProductFormat);){
	    	
	    	preparedStatement.setInt(1, productId);
	        ResultSet rs= preparedStatement.executeQuery();
	        if(!rs.isBeforeFirst()){
	        	return null;
	        }
	        
	       Product product= new Product();
	       while(rs.next()) {
	    	   product.setProductId(rs.getInt("PRODUCT_Id"));
	    	   product.setProductName(rs.getString("PRODUCT_Name"));
	    	   product.setProductVendorName(rs.getString("PRODUCT_VENDOR_Name"));
	           product.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
	           product.setProductQuantity(rs.getInt("PRODUCT_QUANTITY"));
	           product.setProductMSRP(rs.getInt("PRODUCT_MSRP"));
	        }
	     
	       return product;
	    }     
	 }
	
	@Override
	public List<Product> findProductByProductName(String productName) throws SQLException{
	
		String getProductbyProductNameFormat="""
				SELECT *
				  FROM
				 Product
				  WHERE
				   PRODUCT_NAME= ? """; 
		
	    try(PreparedStatement preparedStatement= connection.prepareStatement(getProductbyProductNameFormat);){
	    	preparedStatement.setString(1, productName);
	    	ResultSet rs= preparedStatement.executeQuery();
	   
			List<Product>products= new ArrayList<>();
	    
	    	if(!rs.isBeforeFirst()){
	    	  return products;
	    	}
	    	 
	    	Product product= new Product();
	    	 while(rs.next()) {
		    	   product.setProductId(rs.getInt("PRODUCT_Id"));
		    	   product.setProductName(rs.getString("PRODUCT_Name"));
		    	   product.setProductVendorName(rs.getString("PRODUCT_VENDOR_Name"));
		           product.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
		           product.setProductQuantity(rs.getInt("PRODUCT_QUANTITY"));
		           product.setProductMSRP(rs.getInt("PRODUCT_MSRP"));
		           products.add(product);
	    	  }
		    
	    	 return products;
		   }     
	   }
	
	@Override
	public List<Product> findAllProduct() throws SQLException {
		
		String getAllProductFormat="""
				SELECT *
				  FROM
				 Product 
				   """; 
		
	    try(PreparedStatement preparedStatement= connection.prepareStatement(getAllProductFormat);){
	    	
	    	ResultSet rs= preparedStatement.executeQuery();
	   
			List<Product>products= new ArrayList<>();
	    
	    	if(!rs.isBeforeFirst()){
	    	  return products;
	    	}
	    	   
	    	  while(rs.next()){
	    	    Product product= new Product();
	    	    product.setProductId(rs.getInt("PRODUCT_Id"));
		        product.setProductName(rs.getString("PRODUCT_Name"));
		    	product.setProductVendorName(rs.getString("PRODUCT_VENDOR_Name"));
		        product.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
		        product.setProductQuantity(rs.getInt("PRODUCT_QUANTITY"));
		        product.setProductMSRP(rs.getInt("PRODUCT_MSRP"));
		        products.add(product);
	    	  }
		    
	    	 return products;
	      }
	  }	

	@Override
	public Integer updateProductNameByProductId(String changeProductName, Integer productId) throws SQLException{
		
		String updateProductNameByProductId= """
				UPDATE Product
				 SET
				PRODUCT_NAME= PRODUCT_NAME * ?
				 WHERE
				PRODUCT_ID= ? """;
			 	
	  try(PreparedStatement preparedStatement= connection.prepareStatement(updateProductNameByProductId);){
		  
		  preparedStatement.setString(1,changeProductName);
		  preparedStatement.setInt(2,productId);
	      
		  return preparedStatement.executeUpdate();
	   }
     }			

	@Override
	public Integer updateProductMSRPByProductId(Integer changeProductMSRP, Integer productId) throws SQLException{
		
		String updateProductMSRPByProductId= """
				UPDATE Product
				 SET
				PRODUCT_MSRP= PRODUCT_MSRP* ?
				 WHERE
				PRODUCT_ID= ? """;
			 	
	  try(PreparedStatement preparedStatement= connection.prepareStatement(updateProductMSRPByProductId);){
		  
		  preparedStatement.setInt(1,changeProductMSRP);
		  preparedStatement.setInt(2,productId);
	      
		  return preparedStatement.executeUpdate();
	   }
     }			

	@Override
	public Integer updateProductQuantityByProductId(Integer changeProductQuantity, Integer productId) throws SQLException{
		
		String updateProductQuantityByProductId= """
				UPDATE Product
				 SET
				PRODUCT_QUANTITY= PRODUCT_QUANTITY* ?
				 WHERE
				PRODUCT_ID= ? """;
			 	
	  try(PreparedStatement preparedStatement= connection.prepareStatement(updateProductQuantityByProductId);){
		  
		  preparedStatement.setInt(1,changeProductQuantity);
		  preparedStatement.setInt(2,productId);
	      
		  return preparedStatement.executeUpdate();
	   }
     }			

	@Override
	public Integer updateProductVendorNameByProductId(String changeProductVendorName, Integer productId) throws SQLException{
		
		String updateProductVendorNameByProductId= """
				UPDATE Product
				 SET
				PRODUCT_VENDOR_NAME= PRODUCT_VENDOR_NAME * ?
				 WHERE
				PRODUCT_ID= ? """;
			 	
	  try(PreparedStatement preparedStatement= connection.prepareStatement(updateProductVendorNameByProductId);){
		  
		  preparedStatement.setString(1,changeProductVendorName);
		  preparedStatement.setInt(2,productId);
	      
		  return preparedStatement.executeUpdate();
	   }
     }			

	 @Override
	 public Integer updateProductByProductId(Integer productId) throws SQLException{
		
		String updateProductFormat= """
				UPDATE Product
				 SET
				  PRODUCT_ID= ?,
				  PRODUCT_NAME= ?,
				  PRODUCT_VENDOR_NAME= ?,
				  PRODUCT_CATEGORY= ?,
				  PRODUCT_QUANTITY= ?,
				  PRODUCT_MSRP= ?
				   WHERE
				    PRODUCT_ID= ? """;
				
		try(PreparedStatement preparedStatement= connection.prepareStatement(updateProductFormat);){
			Product product= new Product();
			preparedStatement.setInt(1,product.getProductId());
		    preparedStatement.setString(2, product.getProductName());
		    preparedStatement.setString(3,product.getProductVendorName());
		    preparedStatement.setString(4,product.getProductCategory());
		    preparedStatement.setInt(5,product.getProductQuantity());
		    preparedStatement.setInt(6, product.getProductMSRP());
		    preparedStatement.setInt(7, product.getProductId());
		    
		    return preparedStatement.executeUpdate(updateProductFormat);
		 }
	 } 
      
	 @Override
	 public Integer deleteProductByProductId(Integer productId) throws SQLException{
			
			String deleteProductFormat= """
					DELETE FROM Product
					  WHERE
					 PRODUCT_ID= ? """;
					
		   try(PreparedStatement preparedStatement= connection.prepareStatement(deleteProductFormat);){
			   
			   preparedStatement.setInt(1,productId);
		    // preparedStatement.setInt(1,10);  
			   
			   return preparedStatement.executeUpdate();
		   }
		}

}	
	


