package sample06;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
//	GenericXmlApplicationContext 사용 시 xml파일이 같은 폴더 내에 있어도 된다
public class Ex01 {
	public static void main(String[] args) {
//		AbstractApplicationContext ac = new GenericXmlApplicationContext("/sample06/beans06.xml");
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("/sample06/beans06.xml");
		Vehicle vc = ac.getBean(Vehicle.class);
		vc.ride();
		ac.close();
	}
}
