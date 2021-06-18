package com.ch.shopping2.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.shopping2.dao.DeptDao;
import com.ch.shopping2.model.Dept;
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
}
