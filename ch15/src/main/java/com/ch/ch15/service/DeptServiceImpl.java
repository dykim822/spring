package com.ch.ch15.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.ch15.dao.DeptDao;
import com.ch.ch15.model.Dept;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao dd;
	@Override
	public List<Dept> list() {
		return dd.list();
	}
	@Override
	public Dept select(int deptno) {
		return dd.select(deptno);
	}
	@Override
	public int insert(Dept dept) {
		return dd.insert(dept);
	}
	@Override
	public int update(Dept dept) {
		return dd.update(dept);
	}
	@Override
	public int delete(int deptno) {
		return dd.delete(deptno);
	}
}
