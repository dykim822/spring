package sample09;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
//		classpath나 genericxml은 시작점이 src/main/java
		AbstractApplicationContext ac = new GenericXmlApplicationContext("/sample09/beans09.xml");
		MessageBean mb = ac.getBean(MessageBean.class);
		mb.sayHello();
		ac.close();
	}
}
