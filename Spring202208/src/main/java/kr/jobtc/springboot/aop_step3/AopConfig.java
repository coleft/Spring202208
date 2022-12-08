package kr.jobtc.springboot.aop_step3;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy	//니가 알아서 해줘!!->대리인을 섭외한다.ㅋㅋ
@Aspect	//aspectJ
//@Configuration	//그냥 Configuration
public class AopConfig {	//이게 Assembler입니다.
	
	LocalDate now = LocalDate.now();
	LocalDate parisNow = LocalDate.now(ZoneId.of("Europe/Paris"));
	
	public AopConfig() {
		System.out.println("AopConfig()");
	}
	
	@Bean
	public AopDao getAopDao() {
		return new AopDao();
	}
	
	
	@Bean
	public AroundTest getAroundTest() {
		return new AroundTest();
	}
	
	@Bean
	public StudentDao getStudentDao() {
		return new StudentDao();
	}
	
	@Before("execution(* kr.jobtc.springboot.aop_step3.StudentDao.select(..))")
	public void stdDaoBeforeAdvice(JoinPoint jp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");
		Date d = Calendar.getInstance().getTime();
		String nal = sdf.format(d);
		
		//실행될 메서드명
		String log = (nal + " >>> " + jp.getSignature().getName());
		System.out.println(log);
		writeLog(log);
	}
	
	@Around("execution(* kr.jobtc.springboot.aop_step3.StudentDao.update(..))" 
			+ " || execution(* kr.jobtc.springboot.aop_step3.StudentDao.insert(..))"
			+ " || execution(* kr.jobtc.springboot.aop_step3.StudentDao.delete(..))"
			)
	public void stdDaoAroundAdvice(ProceedingJoinPoint jp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");
		Date d = Calendar.getInstance().getTime();
		String nal = sdf.format(d);
		
		//실행될 메서드명
		String log = "login pass : " + (nal + " >>> " + jp.getSignature().getName());
		try {
			jp.proceed();
		}catch (Throwable e) {
			e.printStackTrace();
		}
		log += ("...end of around aop.....");
		writeLog(log);		
	}
	
	public void writeLog(String log) {
		//log file
		FileWriter fw;
		SimpleDateFormat fileNameFrm = new SimpleDateFormat("yyyy-MM-dd");
		String logFile = fileNameFrm.format(new Date()) + ".log";
		
		try {
			fw = new FileWriter(logFile, true);
			fw.write(log);
			fw.write("\n");
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Before("execution(* kr.jobtc.springboot.aop_step3.AopDao.*(..))")	//마지막 * 대신에 select 써도 됩니다.
	public void beforeAdvice(JoinPoint jp) {	//aop가 구현되기 위한 장소
		System.out.println("log....");
		// 실행될 메서드명
		System.out.println(jp.getSignature().getName());
	}
	
	@Around("execution(* kr.jobtc.springboot.aop_step3.AroundTest.*(..))")
	public void aroundAdvice(ProceedingJoinPoint jp) {
		System.out.println("비즈니스 로직을 처리하기 전에......");
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("비즈니스 로직을 처리한 후에......");
	}
	
	 
}
