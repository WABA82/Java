package day1205;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author owner<br>
 *         형식이 있는 날짜 정보를 얻을 때.<br>
 *         형식이 - java.text.SimpleDateFormat<br>
 *         날짜정보 - java.util.Date<br>
 */
public class UseDate {

	public UseDate() {
		Date date = new Date();
		System.out.println(date);

//		Locale - 다른 나라의 날짜 형식으로 변경하여 제공할 때.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월dd일 a EEEE HH(hh,kk)시:mm:ss", Locale.FRANCE);
		String formatDate = sdf.format(date);
		System.out.println(formatDate);
		
		Calendar cal = new GregorianCalendar(); 
	}

	public static void main(String[] args) {
		new UseDate();
	}

}
