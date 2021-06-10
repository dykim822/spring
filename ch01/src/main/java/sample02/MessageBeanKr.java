package sample02;
// interface 구현한다는 것은 interface에 있는 메서드 overriding 재정의 해야한다!
public class MessageBeanKr implements MessageBean {
	public void sayHello(String name) {
		System.out.println("안녕하세요 " + name + "님!");
	}

}
