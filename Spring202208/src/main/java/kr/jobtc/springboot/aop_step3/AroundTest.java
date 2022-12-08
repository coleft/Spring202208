package kr.jobtc.springboot.aop_step3;

import org.springframework.stereotype.Component;

@Component
public class AroundTest {	//실제 비즈니스 로직이 실행될 것이다.
	public void crud() {
		System.out.println("AroundTest.crud()....");
	}
}
