package kr.jobtc.springboot.aop_step2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class AopConfig {	//이게 Assembler입니다.
	
	@Bean
	public AopDao getAopDao() {
		return new AopDao();
	}
	
	@Bean
	public Logout getLogout() {
		return new Logout();
	}
	
}
