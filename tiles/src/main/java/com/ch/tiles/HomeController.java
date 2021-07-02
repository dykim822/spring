package com.ch.tiles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	@RequestMapping("home/home")
	public String home() {
		return "home/home";
	}
	@RequestMapping("home/first")
	public String first() {
		return "home/first";
	}
	@RequestMapping("test/second")
	public String second() {
		return "test/second";
	}
	@RequestMapping("test/third")
	public String third() {
		return "test/third";
	}
	@RequestMapping("nolay/test1")
	public String test1() {
		return "nolay/test1";
	}
}
