package kr.jobtc.springboot.member;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public Main(Member m) {
		m.crud();
	}
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Assembler.class);
		Member m = (Member)context.getBean("getMember");
		m.crud();
	}
	
}
