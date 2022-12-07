package kr.jobtc.springboot.aop_step3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@Aspect
@EnableAspectJAutoProxy
public class AopConfig {	//이게 Assembler입니다.
	
	public AopConfig() {
		System.out.println("AopConfig()");
	}
	
	@Bean
	public AopDao getAopDao() {
		return new AopDao();
	}
	
	@Before("execution(* kr.jobtc.springboot.aop_step3.AopDao.*(..))")	//마지막 * 대신에 select 써도 됩니다.
	public void beforeAdvice(JoinPoint jp) {	//aop가 구현되기 위한 장소
		System.out.println("log....");
		// 실행될 메서드명
		System.out.println(jp.getSignature().getName());
	}
	
}
