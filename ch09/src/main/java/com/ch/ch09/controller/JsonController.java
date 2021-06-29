package com.ch.ch09.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ch.ch09.model.Board;
import com.ch.ch09.service.BoardService;
@RestController	// 6장 복습
public class JsonController {
	@Autowired
	private BoardService bs;
	@RequestMapping("jsonBoard")
	public List<Board> jsonBoard(Board board) {
		board.setStartRow(1);
		board.setEndRow(10);
		List<Board> list = bs.list(board);
		return list;
	}
}
