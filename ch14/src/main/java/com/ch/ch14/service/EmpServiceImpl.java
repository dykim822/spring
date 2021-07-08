package com.ch.ch14.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.ch14.dao.EmpDao;
import com.ch.ch14.model.Emp;
@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpDao ed;
	public List<Emp> list(int deptno) {
		return ed.empList(deptno);
	}
	public Emp select(int empno) {
		return ed.select(empno);
	}
	public List<Emp> empList() {
		return ed.list();
	}
	public Emp insert(Emp emp) {
		return ed.saveAndFlush(emp);
	}
	public int delete(int empno) {
		return ed.delete(empno);
	}
	public Emp update(Emp emp) {
		return ed.saveAndFlush(emp);
	}
	public List<Emp> allEmpList() {
		return ed.allEmpList();
	}
 
}