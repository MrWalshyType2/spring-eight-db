package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="asda")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int salesId; 			// 1
	
	@Column(name = "fk_product_id")
	private int productId;			// 101
	
	@Column(length = 20, name = "product") // max length of 20 chars
	private String productName;	// Coke
	
//	@Column(columnDefinition="varchar(40)") // Defines max length of 40 chars
//	private String description;
	
	private int quantity;			// 13
	private float price;			// 2.0
	
	// Calculated columns don't need to be stored
	@Transient // Specifies a non-persistent field (Not stored in a db)
	private float total;			// 26.0
	
	@Transient
	private float tax;				// 1.50
	
	@Transient
	private float net;				// 27.50
	
	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	public float getTax() {
		return tax;
	}
	
	public void setTax(float tax) {
		this.tax = tax;
	}
	
	public float getNet() {
		return net;
	}
	
	public void setNet(float net) {
		this.net = net;
	}
	
	
}
