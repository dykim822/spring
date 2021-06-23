package com.ch.ch07.controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ch.ch07.model.Member;
@Controller
public class UploadController {
	@RequestMapping("uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}
	@RequestMapping("uploadForm3")
	public String uploadForm3() {
		return "uploadForm3";
	}
	@RequestMapping("upload")
//	RequestParam에는 input태그의 name이 들어간다
	public String upload(@RequestParam("file") MultipartFile mf, Member member,
			Model model, HttpSession session) throws IOException {
		String fileName = mf.getOriginalFilename();
		String real = session.getServletContext().getRealPath("/resources/upload");
		FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
		fos.write(mf.getBytes());
		fos.close();
		// pc에 저장할 때 아래 코드 사용
		//mf.transferTo(new File("c:/spring/"+fileName));
		int fileSize = (int)mf.getSize();
		model.addAttribute("fileName",fileName);
		model.addAttribute("fileSize",fileSize);
		model.addAttribute("member",member);
		return "upload";
	}
	@RequestMapping("upload2")
//	RequestParam에는 input태그의 name이 들어간다
	public String upload(Member member,	Model model, HttpSession session) throws IOException {
//		fileName1이 원래 파일명
		String fileName1 = member.getFile().getOriginalFilename();
		// 파일명을 변경하고 싶을 때
		UUID uuid = UUID.randomUUID();
		String fileName = uuid + "_" + fileName1;
		String real = session.getServletContext().getRealPath("/resources/upload");
		FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
		fos.write(member.getFile().getBytes());
		fos.close();
		
		int fileSize = (int)member.getFile().getSize();
		model.addAttribute("fileName",fileName);
		model.addAttribute("fileSize",fileSize);
		model.addAttribute("member",member);
		return "upload";
	}
	@RequestMapping("upload3")
	public String upload3(MultipartHttpServletRequest mhr,HttpSession session, Model model) throws IOException {
		String real = session.getServletContext().getRealPath("/resources/upload");
		//파일이 여러개인 경우에는 데이터가 mhr에 포함되어 넘어온다
		String name = mhr.getParameter("name");
		String id = mhr.getParameter("id");
		// 파일을 여러개 저장하기 위해서는 List에 포함시킨다
		List<MultipartFile> fileList = mhr.getFiles("file");
		List<String> list = new ArrayList<String>();
		// 하나씩 추출하여 list에 담기
		for(MultipartFile mf:fileList) {
			String fileName = mf.getOriginalFilename();
			list.add(fileName);
			FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
			fos.write(mf.getBytes());
			fos.close();
		}
		// jsp에 전달
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("list", list);
		return "upload3";
	}
}
