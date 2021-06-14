package sample01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustromBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("⑤ 초기화 전 Bean에 대한 처리 실행");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("⑧ 초기화 후 Bean에 대한 처리 실행");
		return bean;
	}

}
