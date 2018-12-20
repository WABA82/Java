package day1204;

import static java.lang.Integer.MAX_VALUE;
//import static java.lang.Byte.MAX_VALUE; - ���� �̸��� ����� �ϳ��� �޴´�.

//import�� ������ �޼ҵ��� �̸������� ���´�.
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

/**
 * @author owner<br>
 *         �ٸ� Ŭ������ static����(Constant)�� method�� ���� Ŭ������ �ִ� �� ó�� ����� ��<br>
 *         import static ��Ű����.Ŭ������.������ / �޼ҵ��.
 *
 */
public class TestStaticImport {

	public static void main(String[] args) {

		// MAX_VALUE�� IntegerŬ������ ����̴�.
		int i = MAX_VALUE;
		System.out.println(i);
		System.out.println(MAX_VALUE);

		int year = parseInt("2018");
		int month = parseInt("12");
		int day = parseInt("02");

		System.out.println(year + " / " + month + " / " + day);
		System.out.println(toBinaryString(year) + " / " + toBinaryString(month) + " / " + toBinaryString(day));

	}

}
