package kr.jobtc.springboot.aop_step1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AopConfig.class);
		AopDao dao = (AopDao)context.getBean("getAopDao"); //출력 Type이 T이다.
		
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		
	}
}
