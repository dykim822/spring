package com.ch.ch09.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.ch09.model.Board;
import com.ch.ch09.service.BoardService;
import com.ch.ch09.service.PagingBean;
@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	@RequestMapping("list")
	public String list(String pageNum, Model model) {
		if(pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage = 10;	// 한 화면에 보여주는 게시글 갯수
		int total = bs.getTotal();
		int startRow = (currentPage -1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		List<Board> list = bs.list(startRow, endRow);
		int num = total - startRow + 1;	// 게시글 번호 순서대로 정렬하기 위한 변수
		// 페이징 처리는 별도 PagingBean 클래스로 관리!
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		model.addAttribute("pb", pb);	// paginbean pb
		model.addAttribute("list", list);
		model.addAttribute("num", num);
		return "list";
	}
	@RequestMapping("insertForm")
	public String insertForm(int num, String pageNum, Model model) {
		int ref = 0, re_level = 0, re_step = 0;
		model.addAttribute("num", num);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("ref", ref);
		model.addAttribute("re_level", re_level);
		model.addAttribute("re_step", re_step);
		return "insertForm";
	}
	@RequestMapping("insert")
	public String insert(Board board, String pageNum, Model model,
				HttpServletRequest request) {
		// 게시글에 욕설 등으로 Ip추적을 위한 용도
		board.setIp(request.getRemoteAddr());
		int number = bs.getMaxNum();	// 게시글 글번호 생성 용도
		board.setRef(number);
		board.setNum(number);
		int result = bs.insert(board);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "insert";
	}
}
