package com.ch.ch09.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ch.ch09.model.Board;
@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate sst;
//	@Override
//	public List<Board> list(int startRow, int endRow) {
////		return sst.selectList("boardns.list", startRow, endRow);	// 이렇게 하면 에러발생
//		Map<String , Integer> map = new HashMap<String, Integer>();
//		map.put("startRow", startRow);
//		map.put("endRow", endRow);
//		return sst.selectList("boardns.list", map);		// 매개변수 2개이상을 쓸 수 없기 때문에 Map으로 묶어서 보내야 한다
//	}
	@Override
	public List<Board> list(Board board) {
		return sst.selectList("boardns.list", board);	// map으로 보내지않고 board로 한꺼번에 보내면 된다!
	}
//	@Override
//	public int getTotal() {
//		return sst.selectOne("boardns.getTotal");
//	}
	@Override
	public int getTotal(Board board) {
		return sst.selectOne("boardns.getTotal", board);
	}
	@Override
	public int getMaxNum() {
		return sst.selectOne("boardns.getMaxNum");
	}
	@Override
	public int insert(Board board) {
		return sst.insert("boardns.insert", board);
	}
	@Override
	public void updateReadCount(int num) {
		sst.update("boardns.updateReadCount", num);
	}
	@Override
	public Board select(int num) {
		return sst.selectOne("boardns.select", num);
	}
	@Override
	public int update(Board board) {
		return sst.update("boardns.update", board);
	}
	@Override
	public int delete(int num) {
		return sst.update("boardns.delete", num);
	}
	@Override
	public void updateStep(Board board) {
		sst.update("boardns.updateStep", board);
	}
}
