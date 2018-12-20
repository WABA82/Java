package day1205;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author owner<br>
 *         ������ �ִ� ��¥ ������ ���� ��.<br>
 *         ������ - java.text.SimpleDateFormat<br>
 *         ��¥���� - java.util.Date<br>
 */
public class UseDate {

	public UseDate() {
		Date date = new Date();
		System.out.println(date);

//		Locale - �ٸ� ������ ��¥ �������� �����Ͽ� ������ ��.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM��dd�� a EEEE HH(hh,kk)��:mm:ss", Locale.FRANCE);
		String formatDate = sdf.format(date);
		System.out.println(formatDate);
		
		Calendar cal = new GregorianCalendar(); 
	}

	public static void main(String[] args) {
		new UseDate();
	}

}
