package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author owner<br>
 *         Calendar : ���� ��¥ ������ ���� ��.
 */
public class UseCalendar {

	public UseCalendar() {
		/* Ķ���� Ŭ������ �ν��Ͻ� ��� */
		Calendar cal = Calendar.getInstance();

		/* Ķ���� Ŭ������ �ν��Ͻ� ��� : is a */
		Calendar cal1 = new GregorianCalendar();

		/* Ķ���� Ŭ������ �ν��Ͻ� ��� : ����Ŭ������ ��üȭ */
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
