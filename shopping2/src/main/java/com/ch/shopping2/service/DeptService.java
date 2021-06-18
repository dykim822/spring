package com.ch.shopping2.service;
import java.util.List;
import com.ch.shopping2.model.Dept;
public interface DeptService {
	List<Dept> list();

	Dept select(int deptno);

}
