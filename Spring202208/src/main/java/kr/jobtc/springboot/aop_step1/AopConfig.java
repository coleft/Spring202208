package kr.jobtc.springboot.aop_step1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopConfig {	//이게 Assembler입니다.
	
	@Bean
	public AopDao getAopDao() {
		return new AopDao();
	}
	
}
