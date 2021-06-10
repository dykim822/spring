package sample03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
// Ex01 MessageBeanKr, MessageBeanEn 결합도를 낮출 수 있다
public class Ex01 {
	public static void main(String[] args) {
//		객체를 생성하고 관리하는 인터페이스
		AbstractApplicationContext ac = new FileSystemXmlApplicationContext("beans01.xml");
		MessageBean mb = ac.getBean("mb", MessageBean.class);	//getBean(beans01.xml에서 설정한 id, ~)
		mb.sayHello("김동윤");
		ac.close();
	}
}
// ctrl + shift + O; 필요없는 import문 삭제
// Ex01은 수정하지 않고 beans01.xml에서 class만 바꿔주면 된다!
// Ex01은 프로그램, beans01.xml은 문서와 같은 역할을 한다