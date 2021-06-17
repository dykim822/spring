package hib.dao;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import hib.model.Person;
import hib.service.PersonService;

public class Ex01 {
	private static PersonService ps;
	private static Scanner sc;
	public static void main(String[] args) {
		AbstractApplicationContext ac = new GenericXmlApplicationContext("classpath:db.xml");
		ps = ac.getBean(PersonService.class);
		sc = new Scanner(System.in);
		String command = "";
		while(true) {
			help();
			command = sc.nextLine();
			if(command.equals("6")) {
				break;
			} else if(command.equals("1")) {
				insert();
			} else if(command.equals("2")) {
				select();
			} else if(command.equals("3")) {
				update();
			} else if(command.equals("4")) {
				delete();
			} else if(command.equals("5")) {
				list();
			}
		}
		sc.close();
		ac.close();
		System.out.println("프로그램 종료");
	}
	private static void delete() {
		System.out.println("삭제할 아이디를 입력하세요");
		String id = sc.nextLine();
		int result = ps.delete(id);
		if(result > 0) {
			System.out.println("삭제 성공!");
		}
	}
	private static void list() {
		ps.list();
	}
	private static void update() {
		System.out.println("수정할 아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		int result = ps.update(person);
		if(result > 0) {
			System.out.println("수정 성공!");
		}
	}
	private static void select() {
		System.out.println("조회할 아이디를 입력하세요");
		String id = sc.nextLine();
		ps.select(id);
	}
	private static void insert() {
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		int result = ps.insert(person);
		if(result > 0) {
			System.out.println("입력 성공!");
		}
	}
	private static void help() {
		System.out.println();
		System.out.println("명령어를 선택하세요");
		System.out.println("1. 입력");
		System.out.println("2. 조회");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 목록");
		System.out.println("6. 종료");
		System.out.println("===> ");
	}
}
