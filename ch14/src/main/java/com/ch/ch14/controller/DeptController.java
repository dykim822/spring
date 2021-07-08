package com.ch.ch14.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.ch14.model.Dept;
import com.ch.ch14.service.DeptService;
@Controller
public class DeptController {
	@Autowired
	private DeptService ds;
	@RequestMapping("deptList")
	public String deptList(Model model) {
		List<Dept> list = ds.list();
		model.addAttribute("list", list);
		return "/dept/deptList";
	}
	@RequestMapping("insertDeptForm")
	public String insertDeptForm() {
		return "/dept/insertDeptForm";
	}
	@RequestMapping(value="deptNoChk", 
			produces="text/html;charset=utf-8")
	@ResponseBody
	public String deptNoChk(int deptno) {
		String msg = "";
		Dept dept  = ds.select(deptno); 
		if (dept == null) msg="사용가능한 부서코드입니다";
		else msg="사용중이니 다른 부서코드를 사용하시오";
		return msg;
	}
	@RequestMapping("deptInsert")
	public String deptInsert(Dept dept, Model model) {
		// 부서코드 중복된 경우 입력 금지
		Dept dt = ds.select(dept.getDeptno());
		int result = 0;
		if (dt == null) {
			Dept dt2 = ds.insert(dept);
			if (dt2 != null) result = 1;
		} else result = -1;
		model.addAttribute("result", result);
		return "/dept/deptInsert";
	}
	@RequestMapping("updateForm")
	public String updateForm(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		model.addAttribute("dept", dept);
		return "/dept/updateForm";
	}
	@RequestMapping("deptUpdate")
	public String deptUpdate(Dept dept, Model model) {
		Dept result = ds.update(dept);
		model.addAttribute("result", result);
		return "/dept/deptUpdate";
	}
	@RequestMapping("deptDelete")
	public String deptDelete(int deptno, Model model) {
		int result = ds.delete(deptno);
		model.addAttribute("result", result);
		return "/dept/deptDelete";
	}
}