package controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import logic.Board;
import logic.Member;
import logic.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ShopService;
import utils.WebConstants;
@Controller
public class MainController {
	@Autowired
	private ShopService shopService;	
	@RequestMapping(value="main")
	public String boardList(Model model, HttpSession session){
		List<Board> boardListByDate = shopService.getBoardByDate();
		List<Product> productListByHit = shopService.getProductListbyHit();
		model.addAttribute("boardListByDate", boardListByDate);
		model.addAttribute("productListByHit", productListByHit);
		//     String id = (String)session.getAttribute("id");
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "main";
	}	
	@RequestMapping(value="vote")
	public String vote(Model model, Integer pId, HttpServletRequest request){
		if(pId == null){
			return "redirect:main.html";
		} else {		
			Product p = shopService.getProductBypId(pId);
			shopService.voteCodeUpdateProduct(pId);
			List<Board> boardListByDate = shopService.getBoardByDate();
			List<Product> productListByHit = shopService.getProductListbyHit();
			model.addAttribute("boardListByDate", boardListByDate);
			model.addAttribute("productListByHit", productListByHit);
			model.addAttribute("message", p.getpName() + "에 투표했습니다");
			Member loginUser = (Member) request.getAttribute(WebConstants.USER_KEY);
			if(loginUser != null){
				model.addAttribute("loginUser", loginUser);
			}
			return "main";
		}
	}	
}