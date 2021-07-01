package controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import logic.Cart;
import logic.Member;
import logic.PagingBean;
import logic.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ShopService;
import utils.WebConstants;
@Controller
public class MemberController {
	@Autowired
	private ShopService shopService;	
	@RequestMapping(value="joinList")
	public String joinList(Model model, HttpServletRequest request,
			HttpSession session, String currentPage){
		int total = shopService.getTotalRecordMember();
		int start = 1;		
		if (currentPage != null && !currentPage.equals(""))
			start = Integer.parseInt(currentPage);
		List<Member> memberList = shopService.getMemberList(start);
		PagingBean pb = new PagingBean(request, total);
		model.addAttribute("memberList", memberList);
		model.addAttribute("pb", pb);
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "joinus/joinList";	
	}	
/*	@RequestMapping(value={"user"})
	public String user(HttpServletRequest request, Model model){
		String mId = request.getParameter("mId");
		String mIdcheck = shopService.getMid(mId);
		if(mIdcheck ==null){
			model.addAttribute("mId", mId);
			model.addAttribute("message", "사용가능한 ID입니다");
		}else{
			model.addAttribute("message","다른 거 써");
		}
		return "joinus/join";
	}*/
	@RequestMapping(value="user")
	public String user(String mId, Model model){
		String msg = "";
		String mIdcheck = shopService.getMid(mId);
		if(mIdcheck ==null){
			msg =  "사용가능한 ID입니다";
		}else{
			msg = "다른 거 사용하세요";
		}
		model.addAttribute("message",msg);
		return "joinus/user";
	}
	@RequestMapping(value={"join"}, method=RequestMethod.GET)
	public String join(){		
		return "joinus/join";
	}	
	@RequestMapping(value={"join"}, method=RequestMethod.POST)
	public String join(Member member , Model model, HttpSession session){	
		shopService.createMember(member);
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "joinus/joinSuccess";
	}	
	@RequestMapping(value={"joinSuccess"}, method=RequestMethod.GET)
	public String joinSuccess(String mId, Model model){		
		Member member = shopService.getMember(mId);
		model.addAttribute("member", member);
		return "joinus/joinSuccess";
	}	
	@RequestMapping(value={"login"}, method=RequestMethod.GET)
	public String login(){
		return "joinus/login";
	}	
	@RequestMapping(value={"login"}, method=RequestMethod.POST)
	public String login(String mId, String password, Model model, HttpSession session){
		Member member = shopService.getMemberBymIdAndPassword(mId, password);
		if(member == null){
			model.addAttribute("message", "ID또는 암호가 다릅니다");
			return "joinus/login";
		}else {
			session.setAttribute(WebConstants.USER_KEY, member);
			if(session.getAttribute(WebConstants.CART_KEY) == null){
				session.setAttribute(WebConstants.CART_KEY, this.shopService.getCart());
			}
			model.addAttribute("loginUser", member);
			model.addAttribute("member", member);
			if(member.getmId().matches("master")){						
				return "admin/adminMain";	
			}else{
				return "joinus/loginSuccess";
			}
		}
	}	
	@RequestMapping(value="mypage")
	public String mypage(String mId, Model model, HttpSession session){
		Member member = shopService.getMember(mId);
		model.addAttribute("member", member);
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "joinus/mypage";
	}	
	@RequestMapping(value="logout")
	public String clear(Model model, HttpSession session){
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if(cart == null){
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}
		cart.clearAll();
		session.setAttribute(WebConstants.USER_KEY, null);
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cart", cart);
		return "joinus/logout";
	}	
	@RequestMapping(value="memberClear")
	public String memberClear(HttpSession session, Model model, String mId){
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if(cart == null){
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}
		cart.clearAll();
		session.setAttribute(WebConstants.USER_KEY, null);
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		shopService.deleteMember(mId);
		model.addAttribute("loginUser", loginUser);
		return "redirect:main.html";
	}	
	@RequestMapping(value={"editMember"}, method=RequestMethod.GET)
	public String editMember(HttpSession session, Model model, String mId){
		Member member = shopService.getMember(mId);
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			model.addAttribute("loginUser", loginUser);
		}
		model.addAttribute("member", member);
		return "joinus/editMember";
	}	
	@RequestMapping(value={"editMember"}, method=RequestMethod.POST)
	public String editMember(HttpSession session, Model model, Member member){
		shopService.updateMember(member);
		Member loginUser = (Member) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			model.addAttribute("loginUser", loginUser);
		}
		return "joinus/editSuccess";
	}	
}