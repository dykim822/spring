package com.ch.ch09.dao;
import java.util.List;
import com.ch.ch09.model.Board;
public interface BoardDao {
	List<Board> list(int startRow, int endRow);
	int getTotal();
	int getMaxNum();
	int insert(Board board);
}
