package com.ch.mybatis.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ch.mybatis.model.Member;
import com.ch.mybatis.model.MemberPhoto;
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
	
	//아래와 같이하면 jsp를 거쳐가야한다
	/*
	 * @RequestMapping("idChk") public String idChk(String id, Model model) { String
	 * msg = ""; Member member = ms.select(id); if (member == null) { msg =
	 * "사용 가능한 아이디 입니다"; } else { msg = "이미 사용 중인 아이디 입니다"; }
	 * model.addAttribute("msg", msg); return "idChk"; }
	 */
	 
	@RequestMapping(value = "idChk", produces = "text/html;charset=utf-8")
	@ResponseBody	// jsp로 가지말고 바로 본문을 전달
	public String idChk(String id) {
		String msg = "";
		Member member = ms.select(id);
		if (member == null) {
			msg = "사용 가능한 아이디 입니다";
		} else {
			msg = "이미 사용 중인 아이디 입니다";
		}
		return msg;
	}
	@RequestMapping("join")
	public String join(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		// member는 화면에서 입력한 데이터, member2는 DB에서 id로 조회한 데이터
		Member member2 = ms.select(member.getId());
		if(member2 == null) {
			String fileName = member.getFile().getOriginalFilename();
			member.setFileName(fileName); // joinForm.jsp에서 fileName은 넘겨주지 않았기때문에 setFileName이 필요하다
			String real = session.getServletContext().getRealPath("/resources/upload");
			FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
			result = ms.insert(member);	// 성공하면 1, 실패하면 0
		} else {
			result = -1;	// 이미 있으니 입력x
		}
		model.addAttribute("result", result);
		return "join";
	}
	@RequestMapping("loginForm")
	public String loginForm() {
		return "loginForm";
	}
	@RequestMapping("login")
//	loginForm.jsp에서 Member 객체에 id, password만 입력되고 나머지는 null값으로 넘겨준다
	public String login(Member member, Model model, HttpSession session) {
//		login(Member member)시 요청한 데이터와 동시에 객체를 생성 & 데이터를 입력
		int result = 0;	// 암호가 다름
		Member member2 = ms.select(member.getId());
		// 항상 null인지 먼저 확인해야 한다!
		if(member2 == null || member2.getDel().equals("y")) {
			result = -1;	// DB에 없는 ID
		} else if(member2.getPassword().equals(member.getPassword())) {
			result = 1;	// 아이디와 비밀번호가 DB것과 입력 데이터가 일치
			session.setAttribute("id", member.getId());
		}
		model.addAttribute("result", result);
		return "login";
	}
	@RequestMapping("main")
//	public String main(Member member, Model model, HttpSession session)로 Member객체 생성하면 90line member=null은 필요없다
//	member객체 생성과 동시에 자동적으로 null값이므로!(넘어온 데이터가 없으므로)
	public String main(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		Member member = null;	// if문 내에서 지역변수를 사용할 수 없으므로 선언!
		if(id != null && !id.equals("")) {
			member = ms.select(id);
		}
		model.addAttribute("member", member);
		return "main";
	}
	@RequestMapping("view")
	public String view(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "view";
	}
	@RequestMapping("view2")
	public String view2(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		List<MemberPhoto> list = ms.listPhoto(id);
		model.addAttribute("member", member);
		model.addAttribute("list", list);
		
//		for (MemberPhoto mp : list) {
//			System.out.println(mp.getFileName());
//		}
		 
		return "view2";
	}
	@RequestMapping("updateForm")
	public String updateForm(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "updateForm";
	}
	@RequestMapping("update")
	public String update(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
//		fileName은 null일수도 있고 값을 가지고 올 수도 있다
//		null이면 그냥 사용하겠다는 의미/ null이 아니면 수정하겠다는 의미
		String fileName = member.getFile().getOriginalFilename();
		if(fileName != null && !fileName.equals("")) {
			member.setFileName(fileName); // joinForm.jsp에서 fileName은 넘겨주지 않았기때문에 setFileName이 필요하다
			String real = session.getServletContext().getRealPath("/resources/upload");
			FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
		}
		result = ms.update(member);
		model.addAttribute("result", result);
		return "update";
	}
	@RequestMapping("delete")
	public String delete(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		int result = ms.delete(id);
		if(result > 0) {
			session.invalidate();
		}
		model.addAttribute("result", result);
		return "delete";
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
	@RequestMapping("joinForm2")
	public String joinForm2() {
		return "joinForm2";
	}
	@RequestMapping("join2")
	public String join2(Member member, Model model, HttpSession session, MultipartHttpServletRequest mhr) throws IOException {
		int result = 0;
		// member는 화면에서 입력한 데이터, member2는 DB에서 id로 조회한 데이터
		Member member2 = ms.select(member.getId());
		if(member2 == null) {
			// 여러개 파일명을 한꺼번에 받아온다
			List<MultipartFile> list = mhr.getFiles("file");
			// 사진을 여러개 갖는 list, 하나씩 photo에 저장하고 photos에 add
			List<MemberPhoto> photos = new ArrayList<MemberPhoto>();
			String real = session.getServletContext().getRealPath("/resources/upload");
			// list의 사진을 하나씩 뽑아서 photos에 저장
			for(MultipartFile mf : list) {
				MemberPhoto mp = new MemberPhoto();
				String fileName = mf.getOriginalFilename();
				mp.setFileName(fileName);
				mp.setId(member.getId());
				// photos에는 그림 하나짜리 mp가 여러개 저장되어 있다
				photos.add(mp);
				// 파일 업로드
				FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
				// view.do와 비교 mf.getBytes() !!!
				fos.write(mf.getBytes());
				fos.close();
				member.setFileName(fileName);	// 의미없지만 에러 방지용 코드(?)
			}
			result = ms.insert(member);	// 성공하면 1, 실패하면 0
			if(result > 0) {
				ms.insertPhoto(photos);
			}
		} else {
			result = -1;	// 이미 있으니 입력x
		}
		model.addAttribute("result", result);
		return "join";
	}
}
