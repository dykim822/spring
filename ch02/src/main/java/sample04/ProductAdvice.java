package sample04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect		// 공통관심사항 처리하는 클래스
@Component	// 객체 생성
public class ProductAdvice {
	@Pointcut("execution(* getProduct(String))")
	private void helloPointcut() {}
	@Before("helloPointcut()")
	public void before() {			// 본 작업 전에 실행
		System.out.println("before");
	}
	@Around("helloPintcut()")		// 본 작업 앞 뒤로 실행
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("작업전 around");
		Object obj = pjp.proceed();
		System.out.println("작업후 around");
		return obj;
	}
	@After("helloPintcut()")		// 본 작업 후에 실행
	public void after() {
		System.out.println("after");
	}
	// 실행한 후에 결과 값을 받아오고 싶을 때
	@AfterReturning(pointcut = "helloPintcut()", returning = "product")
	public void aftterRe(Product product) {
		System.out.println("afterRe : "+product);
	}
	// 실행할 때 에러가 발생할 경우
	@AfterThrowing(pointcut = "helloPintcut()", throwing = "ex")
	public void afterTh(Throwable ex) {
		System.out.println(ex.getMessage());
	}
}
