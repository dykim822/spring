package com.ch.ch09.service;
import java.util.List;
import com.ch.ch09.model.Board;
public interface BoardService {
	List<Board> list(int startRow, int endRow);
	int getTotal();
	int getMaxNum();
	int insert(Board board);
}
