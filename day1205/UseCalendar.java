package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author owner<br>
 *         Calendar : 단일 날짜 정보를 얻을 때.
 */
public class UseCalendar {

	public UseCalendar() {
		/* 캘린더 클래스의 인스턴스 얻기 */
		Calendar cal = Calendar.getInstance();

		/* 캘린더 클래스의 인스턴스 얻기 : is a */
		Calendar cal1 = new GregorianCalendar();

		/* 캘린더 클래스의 인스턴스 얻기 : 서브클래스의 객체화 */
		GregorianCalendar gc = new GregorianCalendar();

		System.out.println(cal);
		System.out.println(cal1);
		System.out.println(gc);

		int year = cal.get(Calendar.YEAR);

		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println(year + " " + month);
	}

	public static void main(String[] args) {
		new UseCalendar();
	}

}
