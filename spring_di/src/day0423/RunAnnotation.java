package day0423;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunAnnotation { 

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("day0423/applicationContext3.xml");

		TestService3 ts3 = ac.getBean(TestService3.class);

		System.out.println(ts3);
		System.out.println(ts3.getTestDAO3()); // @Autowired »ç¿ë.
	}// main

}// class
