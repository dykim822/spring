package com.ch.ch15.dao;
import java.util.List;

import com.ch.ch15.model.Dept;
public interface DeptDao {
	List<Dept> list();
	Dept select(int deptno);
	int insert(Dept dept);
	int update(Dept dept);
	int delete(int deptno);

}
