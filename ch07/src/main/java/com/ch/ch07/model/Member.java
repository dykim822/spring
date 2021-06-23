package com.ch.ch07.model;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class Member {
	private String id;
	private String name;
	private String fileName;
	// upload용
	private MultipartFile file;
	// uploadForm.jsp에서 input tag내 name="file"과 일치해야 한다
}
