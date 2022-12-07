package kr.jobtc.springboot.di_step2;

public class Main {
	
	public Main(Sql sql) {
		sql.crud();
	}	
	public static void main(String[] args) {
		Assembler ab = new Assembler();
		Main m = new Main(ab.getSql());		//출력값 바꾸고싶으면 Assembler 외부조립기에서 바꾸면 된다.
		
	}
	
}
