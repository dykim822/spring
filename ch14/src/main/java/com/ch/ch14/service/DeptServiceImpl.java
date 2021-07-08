package com.ch.ch14.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.ch14.dao.DeptDao;
import com.ch.ch14.model.Dept;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao dd;
	public List<Dept> list() {
		return dd.list();
	}
	public Dept select(int deptno) {
		return dd.select(deptno);
	}
	public Dept insert(Dept dept) {
		return dd.saveAndFlush(dept);
	}
	public Dept update(Dept dept) {
		return dd.saveAndFlush(dept);
	}
	public int delete(int deptno) {
		return dd.delete(deptno);
	}
}

