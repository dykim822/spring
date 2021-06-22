package com.ch.ch06.service;
import java.util.Collection;
import com.ch.ch06.model.Customer;
public interface CustomerService {
	Collection<Customer> list();
	Customer select(int id);
	void delete(int id);

}
