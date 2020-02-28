package com.ing.hackthon.productDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ing.hackthon.product.Product;

/**
 * Entity for the product details domain object
 */
@Entity
@Table(name="product_details")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="account")
	private String account;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="number_of_hits")
	private int numberOfHits;
	
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public ProductDetails() {
	}
	
	public ProductDetails(int id, String account, double balance, int productId) {
		super();
		this.id = id;
		this.account = account;
		this.balance = balance;
		this.product = new Product(id, "", 0, 0);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getNumberOfHits() {
		return numberOfHits;
	}

	public void setNumberOfHits(int numberOfHits) {
		this.numberOfHits = numberOfHits;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
