package com.ch.ch06.service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.ch.ch06.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	private Map<Integer, Customer> map = new HashMap<Integer, Customer>();
	private int nextId;
	@PostConstruct	// 객체를 생성한 후 가장 먼저 실행한다
	public void init() {
		// customer 객체 4개를 생성하여 map형식으로 메모리에 저장
		register(new Customer("승희", "마포", "k1@korea.com"));
		register(new Customer("철수", "강남", "k2@korea.com"));
		register(new Customer("영희", "신촌", "k3@korea.com"));
		register(new Customer("민수", "대구", "k4@korea.com"));
	}
	private void register(Customer customer) {
		customer.setId(++nextId);	//1씩 증가하여 Id값을 세팅
		map.put(customer.getId(), customer);
	}
	@Override
	public Collection<Customer> list() {
		return map.values();
	}
	@Override
	public Customer select(int id) {
		return map.get(id);
	}
	@Override
	public void delete(int id) {
		map.remove(id);
	}
}
