package com.ch.shopping2.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ch.shopping2.model.Dept;
@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	private JdbcTemplate jt;
	@Override
	public List<Dept> list() {
		List<Dept> list = jt.query("select * from dept order by deptno",
				new BeanPropertyRowMapper<Dept>(Dept.class));
		return list;
	}
	@Override
	public Dept select(int deptno) {
		Dept dept = jt.queryForObject("select * from dept where deptno=?",
				new BeanPropertyRowMapper<Dept>(Dept.class), deptno);
		return dept;
//		이제 데이터는 Controller로 이동
	}
}
