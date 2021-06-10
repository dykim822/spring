package sample09;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
	private Output out1;	//Spring은 기본적으로 interface로 접근하는걸 권장
	public void setName(String name) {
		this.name = name;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public void setOut1(Output out1) {
		this.out1 = out1;
	}
	public void sayHello() {
		String msg = name + ", " + greeting + " !";
		System.out.println(msg);	// Console로 출력
		out1.output(msg);	// 파일로 출력
	}

}
