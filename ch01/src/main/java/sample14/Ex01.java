package sample14;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new GenericXmlApplicationContext("/sample14/beans14.xml");
		BookService ps = ac.getBean(BookService.class);
		Book book = ps.getBook();
		System.out.println(book);
		ac.close();
	}
}
