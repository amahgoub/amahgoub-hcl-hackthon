package com.ing.hackthon.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ing.hackthon.userStatistics.User;

/**
 * Entity class for holding the product information
 */
@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="product_group_id")
	private ProductGroup group;
	
	public Product(int id, String name, int userId, int groupId) {
		super();
		this.id = id;
		this.name = name;
		this.user = new User(userId, "", "", "");
		this.group = new ProductGroup(groupId, "");
	}

	public Product(){

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ProductGroup getGroup() {
		return group;
	}
	public void setGroup(ProductGroup group) {
		this.group = group;
	}
	
	
}
