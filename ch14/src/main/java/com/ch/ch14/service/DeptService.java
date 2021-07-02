package com.ch.ch14.service;
import java.util.List;

import com.ch.ch14.model.Dept;
public interface DeptService {
	List<Dept> list();
	Dept select(int deptno);
	int insert(Dept dept);
	int update(Dept dept);
	int delete(int deptno);

}
