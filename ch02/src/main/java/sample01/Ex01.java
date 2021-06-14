package sample01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new GenericXmlApplicationContext("/sample01/beans01.xml");
		MessageBean mb = ac.getBean(MessageBean.class);
		mb.sayHello();
		ac.close();
	}
}
