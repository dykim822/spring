package sample04;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
//	결정한다 => beans02.xml에서 제어한다
//	제어의 역전 IOC (Inversion Of Control) => 결합도를 낮출 수 있다 loosely coupled
public class Ex01 {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new FileSystemXmlApplicationContext("beans02.xml");
//		Vehicle vc = ac.getBean("vc", Vehicle.class);
//		Vehicle vc = (Vehicle)ac.getBean("vc");
		Vehicle vc = ac.getBean(Vehicle.class);
		vc.ride("손님");
		ac.close();
	}
}
