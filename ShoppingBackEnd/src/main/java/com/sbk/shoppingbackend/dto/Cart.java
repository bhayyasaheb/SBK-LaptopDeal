package com.sbk.shoppingbackend.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private int id;
	
	@OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
	private List<CartItems> cartItems;

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "Number_of_Items")
	private int noOfCartItems;
	
	@Column(name="cart_grand_total")
	private double grandTotal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

		public double getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

	public int getNoOfCartItems() {
		return noOfCartItems;
	}

	public void setNoOfCartItems(int noOfCartItems) {
		this.noOfCartItems = noOfCartItems;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", cartItems=" + cartItems + ", user=" + user + ", noOfCartItems=" + noOfCartItems
				+ ", grandTotal=" + grandTotal + "]";
	}

	
		
	
	
}
