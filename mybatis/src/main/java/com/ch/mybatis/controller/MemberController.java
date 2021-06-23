package com.ch.mybatis.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.mybatis.service.MemberService;
@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
//	index.jsp ->(Controller) joinForm.do -> joinForm.jsp
	@RequestMapping("joinForm")
	public String joinForm() {
		return "joinForm";
	}
}
