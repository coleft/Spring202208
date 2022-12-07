package kr.jobtc.springboot.di_step3;

public class Oracle implements Sql{

	public Oracle() {
		System.out.println("Oracle....");
	}
	
	@Override
	public void crud() {
		System.out.println("Oracle.crud....");
	}

}
