package sample08;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans08.xml");
		Vehicle vh = ac.getBean(Vehicle.class);
		vh.ride();
		ac.close();
	}
}
