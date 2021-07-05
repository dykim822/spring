package com.ch.ch15.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ch.ch15.model.Emp;
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private HibernateTemplate ht;
	@SuppressWarnings("unchecked")
	public List<Emp> list(int deptno) {
		return (List<Emp>) ht.find("from Emp where deptno=?", deptno);
	}
	public Emp select(int empno) {
		return ht.get(Emp.class, empno);
	}
	@SuppressWarnings("unchecked")
	public List<Emp> empList() {
		return (List<Emp>) ht.find("from Emp order by ename");
	}
	public int insert(Emp emp) {
		ht.save(emp);
		return 1;
	}
	public int update(Emp emp) {
		ht.update(emp);
		return 1;
	}
	public int delete(int empno) {
		Emp emp = new Emp();
		emp.setEmpno(empno);
		ht.delete(emp);
		return 1;
	}
	@SuppressWarnings("unchecked")
	public List<Emp> list() {
		return (List<Emp>) ht.find("from Emp e, Dept d where e.deptno=d.deptno");
	}
}