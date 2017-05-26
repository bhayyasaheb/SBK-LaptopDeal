package com.sbk.shoppingbackend.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Table(name="User_Detail")
@Component
public class User {

	/**
	 * Private fields
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Please Enter First Name!")
	private String first_name;
	
	@NotBlank(message="Please Enter Last Name!")
	private String last_name;
	
	@NotBlank(message="Please Select The Role!")
	private String role;
	
	private boolean enabled=true;
	
	@Size(min=6, max=15,message="Your Password must between 6 and 15 characters")
	@NotBlank(message="Please Enter Password!")
	private String password;
	
	@Email
	@NotBlank(message="Please Enter your  Email Address!")
	private String email;
	
	@NotBlank(message="Please Enter Contact Number!")
	//@Length(max=10,min=10,message="Phone number is not valid. Should be of length 10.")
	//@NumberFormat(style=Style.NUMBER)
	private String contact_number;
	
	/*@NotBlank(message="Please Enter Address!")
	private String address;*/
	
	@NotBlank(message="Please Enter Date of Birth!")
	private String dob;
	
	@OneToOne(mappedBy= "user" , cascade = CascadeType.ALL)
	private Cart cart;
	
	/*@OneToMany(mappedBy ="user", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Order> order;*/
	
	/*@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="address_id")
	private List<Address> address;

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}*/
	
	/*public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}*/

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

		
	/**
	 * Setter and Getter method
	 */
	
	public int getId() {
		return id;
	}

	/*public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}*/

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", role=" + role
				+ ", enabled=" + enabled + ", password=" + password + ", email=" + email + ", contact_number="
				+ contact_number + ", dob=" + dob + ", cart=" + cart + "]";
	}

	
	
}
