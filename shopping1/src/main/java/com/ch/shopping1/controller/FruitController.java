package com.ch.shopping1.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import com.ch.shopping1.ItemService;
import com.ch.shopping1.model.Item;
public class FruitController implements Controller {
	@Autowired
	private ItemService is;
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Item> list = is.list();
		mav.addObject("list", list);	// jsp에 데이터 전달/ request.setAttribute 기능
		mav.setViewName("/WEB-INF/views/fruitList.jsp");	// 화면 jsp
		return mav;
	}

}
