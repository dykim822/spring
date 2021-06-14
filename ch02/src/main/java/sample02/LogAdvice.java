package sample02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;
// MethodInterceptor 메서드를 실행할 때 가로채서 먼저 실행
public class LogAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("작업 시작 : "+methodName);
		// 실제 본 작업 실행 : 여기서는 sayHello()
		Object obj = invocation.proceed();
		sw.stop();
		System.out.println("작업 종료 : "+sw.getTotalTimeSeconds()+"초");
		return obj;
	}

}
