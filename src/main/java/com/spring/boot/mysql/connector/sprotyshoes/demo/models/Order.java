package com.spring.boot.mysql.connector.sprotyshoes.demo.models;

import java.sql.Timestamp;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)
public class Order implements Comparable<Order> {
	
	// All are data member(Data members name same as column name of table worker) 
		Integer userId;
	    Integer orderId;
		Integer productId;
	    @JsonFormat(pattern="yyyy-MM-dd")
		Timestamp orderDate;
		String orderProductName;
		
		
    public Order() {
	 super();
	 }

    public Order(Integer userId, Integer orderId, Integer productId, Timestamp orderDate,String orderProductName) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.productId= productId;
		this.orderDate = orderDate;
	    this.orderProductName= orderProductName;
     }

	public Integer getUserId() {
		return userId;
	 }

	public void setUserId(Integer userId) {
		this.userId = userId;
	 }

	public Integer getOrderId() {
		return orderId;
	 }

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	 }

	public Integer getProductId() {
		return productId;
	 }

	public void setProductId(Integer productId) {
		this.productId = productId;
	 }

	public Timestamp getOrderDate() {
		return orderDate;
	 }

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	 }
	
	public String getOrderProductName() {
		return orderProductName;
	 }

	public void setOrderProductName(String orderProductName) {
		this.orderProductName = orderProductName;
	 }

	@Override
    public int hashCode() {
    	return Objects.hash(orderProductName, orderId);
     }
	
    @Override
    public boolean equals(Object obj) {
    	if(this==obj)
    		return true;
    	if(obj==null)
    		return false;
    	if(getClass()!=obj.getClass())
    		return false;
       Order other=(Order)obj;
        return Objects.equals(orderProductName,other.orderProductName)&& Objects.equals(orderId,other.orderId);
     }

	@Override
	public int compareTo(Order o) {
		if(this.orderId<o.orderId) {
			return -1;
		}
		if (this.orderId>o.orderId) {
			return 1;
		}
		if(this.equals(o)){
			return 0;
		}
	    
		return this.orderProductName.compareTo(o.orderProductName);
	 }

	@Override
	public String toString() {
		return "Order [userId=" + userId + ", orderId=" + orderId + ", productId=" + productId + ", orderDate="
				+ orderDate + ", orderProductName=" + orderProductName + "]";
	 }

}    
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	


