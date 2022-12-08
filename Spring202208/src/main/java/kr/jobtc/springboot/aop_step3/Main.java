package kr.jobtc.springboot.aop_step3;

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
		AroundTest at = (AroundTest)context.getBean("getAroundTest");
		at.crud();//jp.proceed()에 의해서 실행됨

		
		System.out.println("-".repeat(50));
		StudentDao sdao = (StudentDao)context.getBean("getStudentDao");
		sdao.insert();
		sdao.update();
		sdao.select();
		sdao.delete();
		
		
		
		
	}
}
