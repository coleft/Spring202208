package kr.jobtc.springboot.di_step3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Assembler {
		
	@Bean
	public Sql getSql() {	//getSql결과 자체가 하나의 빈이다.
		return new Oracle();
	}
	
}
