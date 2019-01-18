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
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int y_day = cal.get(Calendar.DAY_OF_YEAR);
		System.out.printf("%d-%d-%d 오늘은 올해의 %d번 째 날입니다.\n", year, month, day, y_day);

		// 요일 : 일-1, 월-2, 화-3, 수-4, 목-5, 금-6, 토-7
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);

//		String week = "";

//		switch (day_of_week) {
//		case Calendar.SUNDAY:
//			week = "일요일";
//			break;
//		case Calendar.MONDAY:
//			week = "월요일";
//			break;
//		case Calendar.TUESDAY:
//			week = "화요일";
//			break;
//		case Calendar.WEDNESDAY:
//			week = "수요일";
//			break;
//		case Calendar.THURSDAY:
//			week = "목요일";
//			break;
//		case Calendar.FRIDAY:
//			week = "금요일";
//			break;
//		case Calendar.SATURDAY:
//			week = "토요일";
//		}
		String[] weekTitle = { "일", "월", "화", "수", "목", "금", "토" };
		System.out.printf("오늘은 %s요일 입니다.", weekTitle[day_of_week - 1]);

		int am_pm = cal.get(Calendar.AM_PM);

//		switch (am_pm) {
//		case Calendar.AM:
//			
//			break;
//
//		default Calendar.PM:
//			break;
//		}
		System.out.printf("%d, %s\n", am_pm, (am_pm == Calendar.AM) ? "오전" : "오후");

		int hour = cal.get(Calendar.HOUR);
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.printf("%d(%d) : %d : %d\n", hour, hour24, minute, second);

		/* 캘린더 클래스의 set 메소드 사용 입니다. */
		System.out.println("--------------------------------------------");
		System.out.printf("설정 전 %d-%d-%d %s요일\n", cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH) + 1,
				cal1.get(Calendar.DAY_OF_MONTH), "일,월,화,수,목,금,토".split(",")[cal.get(Calendar.DAY_OF_WEEK) - 1]);

		// set 메소드
		cal1.set(Calendar.YEAR, 2019);
		cal1.set(Calendar.MONTH, 4); // 4는 5월달을 의미 합니다.
		cal1.set(Calendar.DAY_OF_MONTH, 15);

		System.out.printf("설정 후 %d-%d-%d %s요일", cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH) + 1,
				cal1.get(Calendar.DAY_OF_MONTH), "일,월,화,수,목,금,토".split(",")[cal.get(Calendar.DAY_OF_WEEK) - 1]);

		System.out.println("이번달의 마지막날 : " + cal.getActualMaximum(Calendar.DATE));

	}

	public static void main(String[] args) {
		new UseCalendar();
	}

}
