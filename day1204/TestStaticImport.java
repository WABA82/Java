package day1204;

import static java.lang.Integer.MAX_VALUE;
//import static java.lang.Byte.MAX_VALUE; - 같은 이름의 상수는 하나만 받는다.

//import할 때에는 메소드의 이름까지만 적는다.
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

/**
 * @author owner<br>
 *         다른 클래스의 static변수(Constant)나 method를 현재 클래스의 있는 것 처럼 사용할 때<br>
 *         import static 패키지명.클래스명.변수명 / 메소드명.
 *
 */
public class TestStaticImport {

	public static void main(String[] args) {

		// MAX_VALUE는 Integer클래스의 상수이다.
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
