package sample16;

import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01 {
//	전역변수(여러 메서드에서 같이 사용하겠다는 의미), static 클래스 변수, 객체를 생성하지 않고 바로 사용하겠다는 의미
	private static MemberService ms = null;
	public static void main(String[] args) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("/sample16/beans16.xml");
		ms = ac.getBean(MemberService.class);
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("명령어를 입력하세요");
			String command = sc.nextLine();
			if(command.equals("x")) {
				break;
			} else if(command.startsWith("insert")) {	//insert로 시작하면
				insert(command.split(","));				//입력한 명령어 중 ','로 나누어서 배열로 변경
			} else if(command.startsWith("select")) {
				select(command.split(","));
			} else if(command.equals("list")) {
				list();
			} else if(command.startsWith("update")) {
				update(command.split(","));
			} else if(command.startsWith("delete")) {
				delete(command.split(","));
			} else {
				help();
			}
		}
		System.out.println("프로그램 종료");
		sc.close();
		ac.close();
	}
	private static void delete(String[] str) {
		if(str.length != 2) {
			help();
			return;		//잘못 입력하면 메서드 종료
		}
		int result = ms.delete(str[1]);
		if(result > 0) {
			System.out.println("삭제 성공");
		}
	}
	private static void update(String[] str) {
		if(str.length != 6) {
			help();
			return;		//잘못 입력하면 메서드 종료
		}
		if(!str[2].equals(str[3])) {
			System.out.println("비밀번호가 비밀번호 확인과 일치하지 않습니다");
			return;
		}
		Member member = new Member(str[1], str[2], str[4], str[5], new Date());
		int result = ms.update(member);
		if(result > 0) {
			System.out.println("수정에 성공하였습니다");
		}
	}
	private static void list() {
		Collection<Member> list = ms.list();
		if(list == null || list.size() == 0) {
			System.out.println("데이터가 없습니다");
		} else {
			for(Member member : list) {
				System.out.println(member);
			}
		}
	}
	private static void select(String[] str) {
		if(str.length != 2) {
			help();
			return;		//잘못 입력하면 메서드 종료
		}
		Member member = ms.select(str[1]);
		if(member == null) {
			System.out.println("존재하지 않는 데이터입니다");
		} else {
			System.out.println(member);
		}
		
	}
	private static void insert(String[] str) {
		if(str.length != 6) {
			help();
			return;		//잘못 입력하면 메서드 종료
		}
		if(!str[2].equals(str[3])) {
			System.out.println("비밀번호가 비밀번호 확인과 일치하지 않습니다");
			return;
		}
		Member member = new Member(str[1], str[2], str[4], str[5], new Date());
		int result = ms.insert(member);
		if(result > 0) {
			System.out.println("입력에 성공하였습니다");
		}
	}
	private static void help() {
		System.out.println("잘못된 명령어 입니다");
		System.out.println("다음 중에서 명령어를 사용하세요");
		System.out.println("insert,id,pass,confirmPass,name,email");
		System.out.println("select,id");
		System.out.println("list");
		System.out.println("update,id,pass,confirmPass,name,email");
		System.out.println("delete,id");
		System.out.println("x");
		
	}
}
