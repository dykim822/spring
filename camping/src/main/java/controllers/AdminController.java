package controllers;
import javax.servlet.http.HttpSession;

import logic.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ShopService;
import utils.WebConstants;
@Controller
public class AdminController {
	@Autowired
	private ShopService shopService;
	@RequestMapping(value="adminMain")
	public String admin(HttpSession session, Model model){
		Member loginUser = (Member)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser != null){
			model.addAttribute("loginUser", loginUser);
		}
		return "admin/adminMain";
	}
	@RequestMapping(value="insert")
	public String insert(){
		shopService.insert();
		return "redirect:main.html";
	}
} 