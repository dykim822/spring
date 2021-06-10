package sample07;
public class MessageBeanImpl implements MessageBean {
//	setter method injection
	private String name;
	private String greeting;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void sayHello() {
		System.out.println(name + ", " + greeting);
	}

}
