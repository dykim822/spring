package com.ch.ch15.dao;
import java.util.List;

import com.ch.ch15.model.Emp;
public interface EmpDao {
	List<Emp> list(int deptno);
	Emp select(int empno);
	List<Emp> empList();
	int insert(Emp emp);
	int update(Emp emp);
	int delete(int empno);
	List<Emp> list();

}
