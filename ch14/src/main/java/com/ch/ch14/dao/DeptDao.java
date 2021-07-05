package com.ch.ch14.dao;
import java.util.List;

import javax.transaction.Transactional;

//import org.apache.ibatis.annotations.Param;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ch.ch14.model.Dept;
@Repository
public interface DeptDao extends JpaRepository<Dept, Integer> {
	@Query("select x from Dept x order by x.deptno")
	List<Dept> list();
	@Query("select x from Dept x where deptno=:deptno")
	Dept select(@Param("deptno") int deptno);
	Dept saveAndFlush(Dept dept);	// 수정, 입력이 모두 포함되어 있다 => save
	@Transactional
	@Modifying
	@Query("delete from Dept d where d.deptno=:deptno")
	int delete(@Param("deptno") int deptno);

}
