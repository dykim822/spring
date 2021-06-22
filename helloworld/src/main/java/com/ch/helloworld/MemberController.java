package com.ch.helloworld;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MemberController {
	@RequestMapping("mem1")
	public Member mem1() {
		Member member = new Member();
		member.setAddr("마포");
		member.setAge(25);
		member.setGender("남자");
		member.setHobby("스타");
		member.setName("임요환");
		return member;
	}
	@RequestMapping("mem1List")
	public List<Member> mem1List() {
		List<Member> list = new ArrayList<Member>();
		for(int i = 0; i < 10; i++) {
			Member member = new Member();
			member.setAddr("마포"+i);
			member.setAge(25+i);
			member.setGender("남자");
			member.setHobby("스타"+i);
			member.setName("임요환"+i);
			list.add(member);
		}
		return list;
	}
}
