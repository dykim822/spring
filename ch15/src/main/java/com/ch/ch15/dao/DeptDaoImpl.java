package com.ch.ch15.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ch.ch15.model.Dept;
@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	private HibernateTemplate ht;
	@SuppressWarnings("unchecked")
	public List<Dept> list() {
		return (List<Dept>) ht.find("from Dept");
	}
	public Dept select(int deptno) {
		return ht.get(Dept.class, deptno);
	}
	public int insert(Dept dept) {
		ht.save(dept);
		return 1;
	}
	public int update(Dept dept) {
		ht.update(dept);
		return 1;
	}
	public int delete(int deptno) {
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		ht.delete(dept);
		return 1;
	}
}