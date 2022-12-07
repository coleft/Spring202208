package kr.jobtc.springboot.member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Assembler {
	
	@Bean
	public Member getMember() {	//getSql결과 자체가 하나의 빈이다.
		return new RegisterMember();
	}
	
}
