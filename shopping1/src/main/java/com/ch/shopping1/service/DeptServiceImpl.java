package com.ch.shopping1.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.shopping1.dao.DeptDao;
import com.ch.shopping1.model.Dept;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao dd;

	@Override
	public List<Dept> list() {
		List<Dept> list = dd.list();
//		System.out.println("service = "+list);
		return list;
	}
}
