package sample02;

public class Ex01 {
//	interface 사용시 결합도를 낮춘다 loosely coupled
	public static void main(String[] args) {
//		MessageBean mb = new MessageBeanEn();
		MessageBean mb = new MessageBeanKr();
		mb.sayHello("김동윤");
	}
}
