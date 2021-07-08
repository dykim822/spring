package com.ch.ch14.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ch.ch14.model.Emp;

@Repository
public interface EmpDao extends JpaRepository<Emp, Integer>{
	@Query("select x from Emp x where deptno=:deptno")
	public List<Emp> empList(@Param("deptno") int deptno); 
	@Query("select x from Emp x order by empno")
	public List<Emp> empList2(); 
	@Query("select x from Emp x order by x.empno" )
	public List<Emp> list();
	@Query("select x from Emp x where empno=:empno")
	public Emp select(@Param("empno") int empno);
	@SuppressWarnings("unchecked")
	public Emp saveAndFlush(Emp emp); 
//	public int saveAndFlush(Emp emp);
	@Transactional
	@Modifying
	@Query("delete from Emp where empno=:empno")
	public int delete(@Param("empno") int empno);
	@Query("select x, y from Emp x, Dept y where x.deptno=y.deptno")
	public List<Emp> allEmpList();
}