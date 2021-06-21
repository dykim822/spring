package com.ch.helloworld;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// 요청한 url, RequestMethod.Get -> get방식
	// @GetMapping, @PostMapping 쓰면된다
	// @RequestMapping get/post 구별하지 않고 사용 가능, method/class에서 사용가능
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	@RequestMapping("home")
	public String home2(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	@RequestMapping("color")
	public String color(Model model) {
		String[] color = {"red", "orange", "yellow", "green", "blue", "navy", "violet"};
		int num = (int)(Math.random()*7);	// 0부터 6까지 정수
		model.addAttribute("color", color[num]);
		return "color";
	}
	@RequestMapping("gugu")
	public String gugu(Model model) {
		int num = (int)(Math.random()*8) + 2;
		model.addAttribute("num", num);
		return "gugu";
	}
	@RequestMapping("colorForm")
	public String colorForm() {
		return "colorForm";
	}
	@RequestMapping("color2")
	public String color2(String color, Model model) {
		model.addAttribute("color", color);
		return "color";
	}
	@RequestMapping("guguForm")
	public String guguForm() {
		return "guguForm";
	}
	@RequestMapping("gugu2")
	public String gugu2(int num, Model model) {
		model.addAttribute("num", num);
		return "gugu";
	}
}
