package com.websystique.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Orders")
public class Order  {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@Column(name = "customerID", nullable = false)
	private int customerID;
	

	@Column(name = "customerName", nullable = false)
	private String customerName;
	

	@Column(name = "productName", nullable = false)
	private String productName;
	

	@Column(name = "amount", nullable = false)
	private int amount;
	
	
	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "createdDate", nullable = false)
	private String createdDate;
	

	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	

}
