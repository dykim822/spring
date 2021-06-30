package com.ch.ch10.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.ch10.dao.BoardDao;
import com.ch.ch10.model.Board;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao bd;
//	@Override
//	public List<Board> list(int startRow, int endRow) {
//		return bd.list(startRow, endRow);
//	}
	@Override
	public List<Board> list(Board board) {
		return bd.list(board);
	}
//	@Override
//	public int getTotal() {
//		return bd.getTotal();
//	}
	@Override
	public int getTotal(Board board) {
		return bd.getTotal(board);
	}
	@Override
	public int getMaxNum() {
		return bd.getMaxNum();
	}
	@Override
	public int insert(Board board) {
		return bd.insert(board);
	}
	@Override
	public void updateReadCount(int num) {
		bd.updateReadCount(num);
	}
	@Override
	public Board select(int num) {
		return bd.select(num);
	}
	@Override
	public int update(Board board) {
		return bd.update(board);
	}
	@Override
	public int delete(int num) {
		return bd.delete(num);
	}
	@Override
	public void updateStep(Board board) {
		bd.updateStep(board);
	}
}
