package sample05;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
//	생성자를 통해서 이름과 인사말을 받는다
	public MessageBeanImpl(String name, String greeting) {
		this.name = name;
		this.greeting = greeting;
	}
	public void sayHello() {
		System.out.println(name + ", " + greeting);
	}

}
