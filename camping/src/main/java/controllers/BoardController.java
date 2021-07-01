package controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import logic.Board;
import logic.Member;
import logic.PagingBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ShopService;
import utils.WebConstants;
@Controller
public class BoardController {
	@Autowired
	private ShopService shopService;	
	@RequestMapping(value="boardList")
	public String boardList(Model model, Board board, HttpServletRequest request, HttpSession session, String currentPage){
		int start = 1;		
		if (currentPage != null && !currentPage.equals(""))
			start = Integer.parseInt(currentPage);
		board.setStart(start);
		List<Board> list = shopService.getBoardList(board);
		int total = shopService.getTotalRecordBoard(board);
		PagingBean pb = new PagingBean(request, total);		
		model.addAttribute("list", list);
		model.addAttribute("pb", pb);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "board/boardList";
	}	
	@RequestMapping(value="boardlistBybCode")
	public String boardListByCode(Model model, Board board, HttpServletRequest request, HttpSession session, String currentPage){
		int start = 1;		
		if (currentPage != null && !currentPage.equals(""))
			start = Integer.parseInt(currentPage);	
		board.setStart(start);
		/*List<Board> list = shopService.getBoardList(board);
		int total = shopService.getTotalRecordBoard(board);*/
	//	if(bCode != null){
		List<Board> list = shopService.getBoardBybCode(board);
		int	total =shopService.totalBoardBybCode(board);
	//	}
		PagingBean pb = new PagingBean(request, total);		
		model.addAttribute("list", list);
		model.addAttribute("pb", pb);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "board/boardList";
	}	
	@RequestMapping(value="searchBoard")
	public String searchBoard(Model model, Board board, HttpServletRequest request, HttpSession session, String currentPage){
		int start = 1;		
		if (currentPage != null && !currentPage.equals(""))
			start = Integer.parseInt(currentPage);
		
		board.setStart(start);
		String search = request.getParameter("search");
		String query = request.getParameter("query");	
		board.setSearch(search);
		board.setQuery(query);
		List<Board> searchList = shopService.getBoardList(board);
		
		int total = shopService.getTotalRecordBoard(board);
		PagingBean pb = new PagingBean(request, total);
		model.addAttribute("list", searchList);
		model.addAttribute("pb", pb);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "board/boardList";
	}
	
	@RequestMapping(value="boardDelete")
	public String boardDelete(Integer bId, HttpSession session, Model model){
		shopService.deleteBoard(bId);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "redirect:boardList.html";
	}
	
	@RequestMapping(value="boardDetail")
	public String boardDetail(Integer bId, Model model, HttpSession session){
		Board board = shopService.getBoardBybId(bId);
		shopService.hitUpdateBoard(bId);
		model.addAttribute("board", board);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "board/boardDetail";
	}	
	@RequestMapping(value={"boardEdit"}, method=RequestMethod.GET)
	public String boardEdit(Integer bId, Model model, HttpSession session){
		Board board = shopService.getBoardBybId(bId);
		model.addAttribute("board", board);
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "board/boardEdit";
	}	
	@RequestMapping(value={"boardEdit"}, method=RequestMethod.POST)
	public String boardEdit(Board board){
		shopService.updateBoard(board);
		return "redirect:boardList.html";
	}
	
	@RequestMapping(value={"boardReg"}, method=RequestMethod.GET)
	public String boardReg(HttpSession session, Model model){	
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "board/boardReg";
	}	
	@RequestMapping(value={"boardReg"}, method=RequestMethod.POST)
	public String boardReg(Board board){
		shopService.insertBoard(board);
		return "redirect:boardList.html";
	}	
}