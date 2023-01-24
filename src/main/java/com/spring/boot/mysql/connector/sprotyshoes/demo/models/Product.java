package com.spring.boot.mysql.connector.sprotyshoes.demo.models;


import java.util.Objects;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown=true)
public class Product implements Comparable<Product> {
	
	// All are data member(Data members name same as column name of table worker) 
		Integer productId;
		String productName;
		String productVendorName;
		String productCategory;
		Integer productQuantity;
		Integer productMSRP;
		
		
	 public Product() {
	    super();
	  }

     public Product(Integer productId, String productName, String productVendorName, String productCategory,
			Integer productQuantity, Integer productMSRP) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productVendorName = productVendorName;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
		this.productMSRP = productMSRP;
	  }

	public Integer getProductId() {
		return productId;
	 }

	public void setProductId(Integer productId) {
		this.productId = productId;
	 }

	public String getProductName() {
		return productName;
	 }

	public void setProductName(String productName) {
		this.productName = productName;
	 }

	public String getProductVendorName() {
		return productVendorName;
	 }

	public void setProductVendorName(String productVendorName) {
		this.productVendorName = productVendorName;
	 }

	public String getProductCategory() {
		return productCategory;
	 }

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	 }

	public Integer getProductQuantity() {
		return productQuantity;
	 }

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	 }

	public Integer getProductMSRP() {
		return productMSRP;
	 }

	public void setProductMSRP(Integer productMSRP) {
		this.productMSRP = productMSRP;
	 }
	
	@Override
	public int hashCode() {
	return Objects.hash(productCategory,productId);
	 }
	
	@Override
    public boolean equals(Object obj) {
    	if(this==obj)
    		return true;
    	if(obj==null)
    		return false;
    	if(getClass()!=obj.getClass())
    		return false;
        Product other= new Product();
        return Objects.equals(productCategory,other.productCategory)&& Objects.equals(productId,other.productId);
     }

	@Override
	public int compareTo(Product o) {
		if(this.productId<o.productId) {
			return -1;
		}
		if (this.productId>o.productId) {
			return 1;
		}
		if(this.equals(o)){
			return 0;
		}
	    
		return this.productCategory.compareTo(o.productCategory);
	 }

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productVendorName="
				+ productVendorName + ", productCategory=" + productCategory + ", productQuantity=" + productQuantity
				+ ", productMSRP=" + productMSRP + "]";
	 } 
	
}	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	


