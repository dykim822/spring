package com.ch.ch14.service;
import java.util.List;
import com.ch.ch14.model.Emp;
public interface EmpService {
	List<Emp> list(int deptno);
	Emp select(int empno);
	List<Emp> empList();
	Emp insert(Emp emp);
	int delete(int empno);
	Emp update(Emp emp);
	List<Emp> allEmpList();

}