package sample01;
// Ex01은 MessageBeanKr을 사용한다
//   "         "	    을 의존한다
// 좋은 시스템: 결합도는 낮고, 응지보가 높은 시스템
public class Ex01 {
	public static void main(String[] args) {
//		MessageBeanKr mbk = new MessageBeanKr();
		MessageBeanEn mbe = new MessageBeanEn();
//		mbk.sayHello("동윤");
		mbe.sayHello("Danny");
	}
}
