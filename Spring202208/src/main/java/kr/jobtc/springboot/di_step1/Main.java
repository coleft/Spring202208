package kr.jobtc.springboot.di_step1;

public class Main {
	
	public Main(Mysql m) {
		m.crud();
	}
	public Main(Oracle ora) {
		ora.crud();
	}
	public Main(Mssql ms) {
		ms.crud();
	}
	public static void main(String[] args) {
		Mysql my = new Mysql();
		Main m = new Main(my);
		//외부 환경의 변화
		Oracle ora = new Oracle();
		m = new Main(ora);
		
		Mssql ms = new Mssql();
		m = new Main(ms);
	}
	
}
