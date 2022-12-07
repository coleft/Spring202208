package kr.jobtc.springboot.di_step3;

public class Mssql implements Sql{

	public Mssql() {
		System.out.println("Mssql....");
	}
	
	@Override
	public void crud() {
		System.out.println("Mssql.crud....");
		
	}
	
}
