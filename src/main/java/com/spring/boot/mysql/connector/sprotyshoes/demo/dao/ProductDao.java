package com.spring.boot.mysql.connector.sprotyshoes.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.boot.mysql.connector.sprotyshoes.demo.models.Product;



public interface ProductDao {
	
	// create operation
		Integer createProduct(Product product) throws SQLException;
		
		// Read/Retrieve operations
		Product findProductByProductId(Integer productId) throws SQLException;
		List<Product> findProductByProductName(String productName) throws SQLException;
		List<Product> findAllProduct() throws SQLException;
		
		// Update operations
		Integer updateProductByProductId(Integer productId) throws SQLException;
		Integer updateProductNameByProductId(String productName, Integer productId) throws SQLException;
		Integer updateProductMSRPByProductId(Integer MSRP, Integer productId) throws SQLException;
		Integer updateProductQuantityByProductId(Integer productQuantity, Integer productId) throws SQLException;
		Integer updateProductVendorNameByProductId(String productVendor, Integer productId) throws SQLException;
		
		// Delete operations
		Integer deleteProductByProductId(Integer productId) throws SQLException;
	
	
	
	
	
	
	
	
	
	

}
