package sample05;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
//	DI Dependency Injection 의존성 주입 => 제어의 역전 IoC
// 	AOP 관점 지향 프로그래밍
public class Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new FileSystemXmlApplicationContext("beans02.xml");
//		MessageBean mb = ac.getBean(MessageBean.class);
		MessageBean mb = ac.getBean("A" ,MessageBean.class);
		mb.sayHello();
		ac.close();
	}
}
