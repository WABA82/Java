package day1205;

import java.util.Calendar;

import javax.jws.soap.SOAPBinding.Use;

/**
 * @author owner<br>
 *         1970-01-00 00:00:00초로 부터 현재날짜의 시간을 os로 얻어내는
 *         System.currentTImeMillis() 사용.<br>
 *
 */
public class UseCurrentTime {

	public void test() {
		long st = System.currentTimeMillis();
		long sum = 0;
		for (int i = 0; i < 50000; i++) {
			sum = sum + i;
			System.out.println(i);
		}
		long et = System.currentTimeMillis();
		System.out.println((et - st) + "ms");
	}

	public static void main(String[] args) {
		UseCurrentTime uct = new UseCurrentTime();
		uct.test();

	}// 메인 메소드

}//
