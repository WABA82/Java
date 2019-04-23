package day0423;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		// 1. Spring Container ����.
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("day0423/applicationContext.xml");
		System.out.println("////////////////////////// ������ ������ ����");
		TestService ts = ac.getBean("ts", TestService.class);
		System.out.println(ts);

		System.out.println("////////////////////////// method ������ ����");
		TestService ts1 = ac.getBean("ts1", TestService.class);
		System.out.println(ts1.getTd());

		System.out.println("////////////////////////// �Ű������� �������� �������� ������ ����");
		TestService2 ts2 = ac.getBean("ts2", TestService2.class);
		System.out.println(ts2);

		System.out.println("////////////////////////// �⺻��, String ���������� ������ ����");
		PrimitiveTypeInjection pti = ac.getBean("pti", PrimitiveTypeInjection.class);
		System.out.println(pti);

	}// main

}// class
