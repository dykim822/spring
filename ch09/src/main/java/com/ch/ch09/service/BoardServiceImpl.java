package com.ch.ch09.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.ch09.dao.BoardDao;
import com.ch.ch09.model.Board;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao bd;
	@Override
	public List<Board> list(int startRow, int endRow) {
		return bd.list(startRow, endRow);
	}
	@Override
	public int getTotal() {
		return bd.getTotal();
	}
	@Override
	public int getMaxNum() {
		return bd.getMaxNum();
	}
	@Override
	public int insert(Board board) {
		return bd.insert(board);
	}
}
