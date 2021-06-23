package com.ch.ch06.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
public class Customer {
	private int id;
	@NotBlank
	@Length(max = 10)
	private String name;
	@NotBlank
	@Length(max = 60)
	private String address;
	@NotBlank
	@Email
	@Pattern(regexp = ".+@.+\\..+")
	private String email;

	public Customer() {
	}
	public Customer(String name, String address, String email) {
		this.name = name;
		this.address = address;
		this.email = email;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}