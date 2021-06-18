package com.ch.shopping2.dao;
import java.util.List;
import com.ch.shopping2.model.Dept;
public interface DeptDao {
	List<Dept> list();

	Dept select(int deptno);

}
