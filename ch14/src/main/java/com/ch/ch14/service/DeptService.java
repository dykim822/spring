package com.ch.ch14.service;
import java.util.List;

import com.ch.ch14.model.Dept;

public interface DeptService {
	List<Dept> list();
	Dept select(int deptno);
	Dept insert(Dept dept);
	Dept update(Dept dept);
	int delete(int deptno);

}