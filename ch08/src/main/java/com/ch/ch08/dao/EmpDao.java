package com.ch.ch08.dao;
import java.util.List;
import com.ch.ch08.model.Emp;
public interface EmpDao {
	List<Emp> list(int deptno);
	Emp select(int empno);
	List<Emp> empList();

}
