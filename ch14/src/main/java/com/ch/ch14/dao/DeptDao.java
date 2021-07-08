package com.ch.ch14.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ch.ch14.model.Dept;
@Repository
public interface DeptDao extends JpaRepository<Dept, Integer>{
	@Query("select x from Dept x order by x.deptno" )
	public List<Dept> list();
	@Query("select x from Dept x where deptno=:deptno")
	public Dept select(@Param("deptno") int deptno); 
	@SuppressWarnings("unchecked")
	public Dept saveAndFlush(Dept dept); 
	@Transactional
	@Modifying
	@Query("delete from Dept d where d.deptno=:deptno")
	public int delete(@Param("deptno") int deptno); 
}