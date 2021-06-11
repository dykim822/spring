package sample17;

import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
// Spring Boot에서는 beans.xml 파일을 사용하지 않고 Javacode를 이용한다
public class Ex01 {
//	전역변수(여러 메서드에서 같이 사용하겠다는 의미), static 클래스 변수, 객체를 생성하지 않고 바로 사용하겠다는 의미
	private static MemberService ms = null;
	private static Scanner sc = null;
	public static void main(String[] args) {
		AbstractApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
		ms = ac.getBean(MemberService.class);
		sc = new Scanner(System.in);
		while(true) {
			System.out.println("명령어를 입력하세요");
			String command = sc.nextLine();
			if(command.equals("1")) {
				break;
			} else if(command.startsWith("2")) {	//insert로 시작하면
				insert();
			} else if(command.startsWith("5")) {
				select();
			} else if(command.equals("6")) {
				list();
			} else if(command.startsWith("3")) {
				update();
			} else if(command.startsWith("4")) {
				delete();
			} else {
				help();
			}
		}
		System.out.println("프로그램 종료");
		sc.close();
		ac.close();
	}
	private static void delete() {
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		int result = ms.delete(id);
		if(result > 0) {
			System.out.println("삭제 성공");
		}
	}
	private static void update() {
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pass = sc.nextLine();
		System.out.println("비밀번호를 한번 더 입력하세요");
		String confirmPass = sc.nextLine();
		System.out.println("이름를 입력하세요");
		String name = sc.nextLine();
		System.out.println("이메일를 입력하세요");
		String email = sc.nextLine();
		if(!pass.equals(confirmPass)) {
			System.out.println("비밀번호와 비밀번호 확인이 다릅니다");
			return;
		}
		Member member = new Member(id, pass, name, email, new Date());
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
	private static void select() {
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		Member member = ms.select(id);
		if(member == null) {
			System.out.println("존재하지 않는 데이터입니다");
		} else {
			System.out.println(member);
		}
		
	}
	private static void insert() {
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pass = sc.nextLine();
		System.out.println("비밀번호를 한번 더 입력하세요");
		String confirmPass = sc.nextLine();
		System.out.println("이름를 입력하세요");
		String name = sc.nextLine();
		System.out.println("이메일를 입력하세요");
		String email = sc.nextLine();
		if(!pass.equals(confirmPass)) {
			System.out.println("비밀번호와 비밀번호 확인이 다릅니다");
		}
		Member member = new Member(id, pass, name, email, new Date());
		int result = ms.insert(member);
		if(result > 0) {
			System.out.println("입력에 성공하였습니다");
			return;
		}
	}
	private static void help() {
		System.out.println("명령어를 선택하세요");
		System.out.println("1. 종료");
		System.out.println("2. 입력");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 조회");
		System.out.println("6. 전체 목록");		
	}
}
