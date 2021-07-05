package com.ch.ch15.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.ch15.model.Dept;
import com.ch.ch15.model.Emp;
import com.ch.ch15.service.DeptService;
import com.ch.ch15.service.EmpService;
@Controller
public class EmpController {
	@Autowired
	private EmpService es;
	@Autowired
	private DeptService ds;	//부서 번호에 대한 정보 때문에 필요하다!
	@RequestMapping("empList")
	public String empList(int deptno, Model model) {
		Dept dept = ds.select(deptno);	// 부서 이름 갖고 오기 위해 사용
		List<Emp> empList = es.list(deptno);
		model.addAttribute("dept", dept);
		model.addAttribute("empList", empList);
		return "/emp/empList";
	}
	@RequestMapping("empSelect")
	public String empSelect(int empno, Model model) {
		Emp emp = es.select(empno);
		model.addAttribute("emp", emp);
		return "/emp/empSelect";
	}
	@RequestMapping("empInsertForm")
	public String empInsertForm(int deptno, Model model) {
		List<Dept> deptList = ds.list();	// 부서코드 선택하기 위해
		List<Emp> empList = es.empList();	// 관리자 사번을 선택하기 위해(없는 사번을 입력하는 것을 방지하기 위해)
		model.addAttribute("deptList", deptList);
		model.addAttribute("empList", empList);
		model.addAttribute("deptno", deptno);
		return "/emp/empInsertForm";
	}
	@RequestMapping(value = "empNoChk", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String empNoChk(int empno) {
		String data = "";
		Emp emp = es.select(empno);
		if(emp == null) {
			data = "사용 가능한 사번입니다";
		} else {
			data = "사용 중이니 다른 사번을 사용하세요";
		}
		return data;
	}
	@RequestMapping("empInsert")
	public String empInsert(Emp emp, Model model) {
		int result = 0;
		// emp는 화면에서 입력한 데이터/ emp2는 사번으로 DB에서 조회한 데이터
		Emp emp2 = es.select(emp.getEmpno());
		if(emp2 == null) {
			result = es.insert(emp);
		} else {
			result = -1;	// 이미 존재하는 데이터이므로 입력 불가
		}
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empInsert";
	}
	@RequestMapping("empUpdateForm")
	public String empUpdateForm(int empno, Model model) {
		Emp emp = es.select(empno);		// 직원 조회용
		List<Dept> deptList = ds.list();
		List<Emp> empList = es.empList();
		model.addAttribute("emp", emp);
		model.addAttribute("deptList", deptList);
		model.addAttribute("empList", empList);
		return "/emp/empUpdateForm";
	}
	@RequestMapping("empUpdate")
	public String empUpdate(Emp emp, Model model) {
		int result = es.update(emp);
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empUpdate";
	}
	@RequestMapping("empDelete")
	public String empDelete(int empno, Model model) {
		Emp emp = es.select(empno);
		int result = es.delete(empno);
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empDelete";
	}
	@RequestMapping("allEmpList")
	public String allEmpList(Model model) {
		List<Emp> list = es.list();
		model.addAttribute("list", list);
		return "/emp/allEmpList";
	}
}
