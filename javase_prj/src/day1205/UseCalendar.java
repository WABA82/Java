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
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int y_day = cal.get(Calendar.DAY_OF_YEAR);
		System.out.printf("%d-%d-%d ������ ������ %d�� ° ���Դϴ�.\n", year, month, day, y_day);

		// ���� : ��-1, ��-2, ȭ-3, ��-4, ��-5, ��-6, ��-7
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);

//		String week = "";

//		switch (day_of_week) {
//		case Calendar.SUNDAY:
//			week = "�Ͽ���";
//			break;
//		case Calendar.MONDAY:
//			week = "������";
//			break;
//		case Calendar.TUESDAY:
//			week = "ȭ����";
//			break;
//		case Calendar.WEDNESDAY:
//			week = "������";
//			break;
//		case Calendar.THURSDAY:
//			week = "�����";
//			break;
//		case Calendar.FRIDAY:
//			week = "�ݿ���";
//			break;
//		case Calendar.SATURDAY:
//			week = "�����";
//		}
		String[] weekTitle = { "��", "��", "ȭ", "��", "��", "��", "��" };
		System.out.printf("������ %s���� �Դϴ�.", weekTitle[day_of_week - 1]);

		int am_pm = cal.get(Calendar.AM_PM);

//		switch (am_pm) {
//		case Calendar.AM:
//			
//			break;
//
//		default Calendar.PM:
//			break;
//		}
		System.out.printf("%d, %s\n", am_pm, (am_pm == Calendar.AM) ? "����" : "����");

		int hour = cal.get(Calendar.HOUR);
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.printf("%d(%d) : %d : %d\n", hour, hour24, minute, second);

		/* Ķ���� Ŭ������ set �޼ҵ� ��� �Դϴ�. */
		System.out.println("--------------------------------------------");
		System.out.printf("���� �� %d-%d-%d %s����\n", cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH) + 1,
				cal1.get(Calendar.DAY_OF_MONTH), "��,��,ȭ,��,��,��,��".split(",")[cal.get(Calendar.DAY_OF_WEEK) - 1]);

		// set �޼ҵ�
		cal1.set(Calendar.YEAR, 2019);
		cal1.set(Calendar.MONTH, 4); // 4�� 5������ �ǹ� �մϴ�.
		cal1.set(Calendar.DAY_OF_MONTH, 15);

		System.out.printf("���� �� %d-%d-%d %s����", cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH) + 1,
				cal1.get(Calendar.DAY_OF_MONTH), "��,��,ȭ,��,��,��,��".split(",")[cal.get(Calendar.DAY_OF_WEEK) - 1]);

		System.out.println("�̹����� �������� : " + cal.getActualMaximum(Calendar.DATE));

	}

	public static void main(String[] args) {
		new UseCalendar();
	}

}
