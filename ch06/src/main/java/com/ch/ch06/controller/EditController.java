package com.ch.ch06.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ch.ch06.model.Customer;
import com.ch.ch06.service.CustomerService;
@Controller
// 클래스에 @RequestMapping을 정의하면 이 클래스의 모든 메서드에 공통으로 사용 가능
@RequestMapping("/customer/{id}")
// 이 session이 있는 Controller에서 editCustomer라는 이름으로 저장하여 같이 사용
@SessionAttributes("editCustomer")
public class EditController {
	@Autowired
	private CustomerService cs;
	@RequestMapping("/edit")
	public String edit(@PathVariable int id, Model model) {
		Customer customer = cs.select(id);
//		customer에 있는 데이터를 editCustomer라는 이름으로 jsp에 전달
		model.addAttribute("editCustomer", customer);
		return "redirect:enter";
	}
	
//	redirect:enter		@RequestMapping("/customer/{id}/enter")
//	redirect:/enter		@RequestMapping("/enter")
	
	@RequestMapping(value = "/enter", method = RequestMethod.GET)	// customer/{id}/enter
//	ModelAttribute는 객체로된 데이터를 받아올 때 사용
//	session에 저장되어 있는 editCustomer 데이터를 customer에 저장시킴
	public String enter(@ModelAttribute("editCustomer") Customer customer) {
		return "/customer/edit/enter";
	}
	@RequestMapping(value = "/enter", params = "event_process")
	public String review(@Valid @ModelAttribute("editCustomer") Customer customer, Errors errors) {
		if(errors.hasErrors()) {
			return "customer/edit/enter";
		} else {
			return "customer/edit/review";
		}
	}
	@RequestMapping(value = "review", params = "event_confirm")
	public String  edit(@ModelAttribute("editCustomer") Customer customer, SessionStatus ss) {
		cs.update(customer);
		// 세션 메모리에 있던 editCustomer 데이터를 삭제(그만 사용)
		ss.setComplete();
//		redirect:/customer는 class위에 있는 RequestMapping에 포함된 조건을 제외한다는 의미
		return "redirect:/customer";
	}
	@RequestMapping(value = "review", params = "event_cancel")
	public String cancel() {
//		/가 없으면 /customer/{id}/enter를 실행
		return "redirect:enter";
	}
}
