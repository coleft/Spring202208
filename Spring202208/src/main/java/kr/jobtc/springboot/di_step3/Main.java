package kr.jobtc.springboot.di_step3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public Main(Sql m) {
		m.crud();
	}	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Assembler.class);
		Sql m = (Sql)context.getBean("getMember");
		m.crud();
	}
	
}
