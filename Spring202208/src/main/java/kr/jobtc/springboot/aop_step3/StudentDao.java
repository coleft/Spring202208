package kr.jobtc.springboot.aop_step3;

public class StudentDao {	//log출력은 여기에 없다는 점을 기억해. log출력하는 부분이 관심사이다. 비즈니스로직(여기)으로부터 분리되어 있다. AOP를 바라볼 때, 공부할 때, 분리되어 있다.
	public void insert() {
		System.out.println("StudentDao.insert()....");
	}
	public void update() {
		System.out.println("StudentDao.update()....");
	}
	public void select() {
		System.out.println("StudentDao.select()....");
	}
	public void delete() {
		System.out.println("StudentDao.delete()....");
	}
}
