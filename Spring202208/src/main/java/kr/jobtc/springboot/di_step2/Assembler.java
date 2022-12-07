package kr.jobtc.springboot.di_step2;

// 객체를 생성하여 리턴해주는 외부 조립기 역할
public class Assembler {
	
	public Sql getSql() {
		return new Oracle();
	}
	
}
