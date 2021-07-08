package com.ch.ch14.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ch.ch14.model.Dept;
import com.ch.ch14.model.Emp;
import com.ch.ch14.service.DeptService;
import com.ch.ch14.service.EmpService;
@Controller
public class EmpController {
	@Autowired
	private EmpService  es;
	@Autowired
	private DeptService ds;
	@RequestMapping("empList")
	public String empList(int deptno, Model model) {
		Dept dept = ds.select(deptno);
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
		List<Dept> deptList = ds.list();
		List<Emp> empList = es.empList();
//		deptno 현재 조회중인 부서코드
		model.addAttribute("deptno", deptno);
		model.addAttribute("deptList", deptList);
		model.addAttribute("empList", empList);
		return "/emp/empInsertForm";
	}
	@RequestMapping(value="empChk", 
		produces="text/html;charset=utf-8")
	@ResponseBody
	public String empChk(int empno) {
		String msg = "";
		Emp emp = es.select(empno);
		if (emp == null) msg="사용 가능한 사번입니다";
		else msg="사용중인 사번이니 다른 번호를 사용하시오";
		return msg;
	}
	@RequestMapping("empInsert")
	public String empInsert(Emp emp, Model model) {
		int result = 0;
		Emp emp2 = es.select(emp.getEmpno());
		if (emp2==null) {
			Emp emp3 = es.insert(emp);
			if (emp3 != null) result = 1;
		}	else result = -1;
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empInsert";
	}
	@RequestMapping("empDelete")
	public String empDelete(int empno, Model model) {
		Emp emp = es.select(empno);
		int result = es.delete(empno);
		model.addAttribute("result", result);
		// 성공후에 해당 데이터 부서 직원목록으로 가기 위해
		model.addAttribute("emp", emp);
		return "/emp/empDelete";
	}
	@RequestMapping("empUpdateForm")
	public String empUpdateForm(int empno, Model model) {
		Emp emp = es.select(empno);
		// 관리자 사번을 선택 
		List<Emp> empList = es.empList();
		// 부서코드를 선택
		List<Dept> deptList = ds.list();
		model.addAttribute("emp", emp);
		model.addAttribute("empList",  empList);
		model.addAttribute("deptList", deptList);
		return "/emp/empUpdateForm";
	}
	@RequestMapping("empUpdate")
	public String empUpdate(Emp emp, Model model) {
		Emp emp2 = es.update(emp);
		model.addAttribute("result", emp2);
		model.addAttribute("emp",emp);
		return "/emp/empUpdate"; 
	}
	@RequestMapping("allEmpList")
	public String allEmpList(Model model) {
		List<Emp> list = es.allEmpList();
		model.addAttribute("list", list);
		return "/emp/allEmpList";
	}
}