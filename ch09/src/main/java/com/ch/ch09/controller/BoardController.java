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
	public String list(Board board, String pageNum, Model model) {
		if(pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int rowPerPage = 10;	// 한 화면에 보여주는 게시글 갯수
		//int total = bs.getTotal();
		int total = bs.getTotal(board);	// 추가
		int startRow = (currentPage -1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		board.setStartRow(startRow);	// 추가
		board.setEndRow(endRow);		// 추가
		List<Board> list = bs.list(board);	// startRow, endRow 전부 묶어서 보낸다
		//List<Board> list = bs.list(startRow, endRow);	/ 추가하면서 필요없다
		int num = total - startRow + 1;	// 게시글 번호 순서대로 정렬하기 위한 변수
		// 페이징 처리는 별도 PagingBean 클래스로 관리!
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		String[] title = {"작성자", "제목", "내용", "제목+내용"};
		//매개변수로 넘어온 데이터를 다시 전달할 때는 model.addAttribute() 생략 가능하다!
		//	model.addAttribute("board", board);	생략해도 넘어간다!
		model.addAttribute("title", title);		// 검색 옵션에 한글 넣기용
		model.addAttribute("pb", pb);	// paginbean pb
		model.addAttribute("list", list);
		model.addAttribute("num", num);
		return "list";
	}
	@RequestMapping("insertForm")
	public String insertForm(int num, String pageNum, Model model) {
		int ref = 0, re_level = 0, re_step = 0;
	//	num이 0이면 처음 글쓰기, 0이 아니면 답글
		if(num != 0) {	// 답변글
			Board board = bs.select(num);
			// ref; 답변이 같은 것끼리 모아서 보여주기 위한 의도
			// re_level; 들여쓰기(답변글은 본글보다 들여써야 보기 좋다)
			// re.step; 같은 ref 중에서 답변글의 순서를 정하기 위해
			ref = board.getRef();
			re_step = board.getRe_step();
			re_level = board.getRe_level();
		}
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
		if(board.getNum() != 0) {	// 답글인 경우
			// 글을 읽고 ref가 같고 re_step이 읽은 글의 re_step보다 크면 그 글의 re_step + 1
			bs.updateStep(board);
			board.setRe_level(board.getRe_level() + 1);
			board.setRe_step(board.getRe_step() + 1);
			// 답변글의 ref는 읽은 글의 ref를 그대로 사용
		} else {
			board.setRef(number);	// 답변글이 아닐 떄는 num과 같다
		}
		board.setNum(number);
		int result = bs.insert(board);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "insert";
	}
	@RequestMapping("view")
	public String view(int num, String pageNum, Model model) {
		bs.updateReadCount(num);	// 조회수 count
		Board board = bs.select(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "view";
	}
	@RequestMapping("updateForm")
	public String updateForm(int num, String pageNum, Model model) {
		Board board = bs.select(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "updateForm";
	}
	@RequestMapping("update")
	public String update(Board board, String pageNum, Model model) {
		int result = bs.update(board);
		model.addAttribute("board", board);	// 글 수정 후 view로 넘어갈 때 필요
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "update";
	}
	@RequestMapping("deleteForm")
	public String deleteForm(int num, String pageNum, Model model) {
		Board board = bs.select(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "deleteForm";
	}
	@RequestMapping("delete")
	public String delete(int num, String pageNum, Model model) {
		int result = bs.delete(num);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "delete";
	}
}
