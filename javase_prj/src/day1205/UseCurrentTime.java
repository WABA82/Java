package day1205;

import java.util.Calendar;

import javax.jws.soap.SOAPBinding.Use;

/**
 * @author owner<br>
 *         1970-01-00 00:00:00�ʷ� ���� ���糯¥�� �ð��� os�� ����
 *         System.currentTImeMillis() ���.<br>
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

	}// ���� �޼ҵ�

}//
