package com.ch.ch14.dao;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.ch14.model.Dept;
@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	private SqlSessionTemplate sst;
	@Override
	public List<Dept> list() {
		return sst.selectList("deptns.list"); 
	}
	@Override
	public Dept select(int deptno) {
		return sst.selectOne("deptns.select", deptno);
	}
	@Override
	public int insert(Dept dept) {
		return sst.insert("deptns.insert", dept);
	}
	@Override
	public int update(Dept dept) {
		return sst.update("deptns.update", dept);
	}
	@Override
	public int delete(int deptno) {
		return sst.delete("deptns.delete", deptno);
	}
}
