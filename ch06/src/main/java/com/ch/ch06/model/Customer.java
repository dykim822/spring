package com.ch.ch06.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
public class Customer {
	private int id;
	//화면에서 입력할 때 이름이 빈값이면 에러 출력
	@NotBlank
	@Length(max = 10)	// 이름이 10넘으면 에러 발생
	private String name;
	@NotBlank
	@Length(max = 60)
	private String address;
	@NotBlank
	@Email
	@Pattern(regexp = ".+@+\\..+")
	private String email;
	public Customer() {}
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
