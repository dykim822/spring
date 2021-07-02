package com.ch.ch13;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	@RequestMapping("home")
	public String home() {
		return "home";
	}
	@RequestMapping("first")
	public String first() {
		return "first";
	}
	@RequestMapping("second")
	public String second() {
		return "second";
	}
	@RequestMapping("third")
	public String third() {
		return "third";
	}
	
}
