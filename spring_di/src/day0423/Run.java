package day0423;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		// 1. Spring Container 생성.
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("day0423/applicationContext.xml");
		System.out.println("////////////////////////// 생성자 의존성 주입");
		TestService ts = ac.getBean("ts", TestService.class);
		System.out.println(ts);

		System.out.println("////////////////////////// method 의존성 주입");
		TestService ts1 = ac.getBean("ts1", TestService.class);
		System.out.println(ts1.getTd());

		System.out.println("////////////////////////// 매개변수가 여러개인 생성자의 의존성 주입");
		TestService2 ts2 = ac.getBean("ts2", TestService2.class);
		System.out.println(ts2);

		System.out.println("////////////////////////// 기본형, String 데이터형을 의존성 주입");
		PrimitiveTypeInjection pti = ac.getBean("pti", PrimitiveTypeInjection.class);
		System.out.println(pti);

	}// main

}// class
