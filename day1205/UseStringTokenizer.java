package day1205;

import java.util.StringTokenizer;

/**
 * @author owner<br>
 *         문자열을 특정문자로 구분하는 StringTokenizer의 사용.
 */
public class UseStringTokenizer {

	public UseStringTokenizer() {
		System.out.println("기본 생성자 입니다.");

		// 공백으로 구분 : 매개변수 1인 생성자 사용.
		String msg = "오늘은 수요일 입니다. 날씨는 -5도입니다.";
		StringTokenizer stk = new StringTokenizer(msg);
		System.out.println(stk.countTokens() + "개");

		/* while 반복문을 사용하여 토큰들을 구할 수 있다. */
		while (stk.hasMoreTokens()) { // 토큰이 존재하는지? boolean
			System.out.println(stk.nextToken()); // 토큰을 얻고 포인터를 다음으로 이동
		}

		System.out.println("\n/*******************************/\n"); // 구분선

		// 특정문자로 구분 : 매개변수가 2개인 생성자 사용.
		String names = "이재현,이재찬~정택성,김희철.김정운~김정윤,공선의";
		StringTokenizer stk1 = new StringTokenizer(names, ",");
		System.out.println(stk1.countTokens() + "개");

		/* while 반복문을 사용하여 토큰들을 구할 수 있다. */
		while (stk1.hasMoreTokens()) { // 반환형 boolean
			System.out.println(stk1.nextToken()); // 토큰을 얻고 포인터를 다음으로 이동
		}

		System.out.println("\n/*******************************/\n"); // 구분선

		// 구분하는 문자도 토큰으로 만들기 : 매개변수 3개인 생성자 사용.
		StringTokenizer stk2 = new StringTokenizer(names, ",.~", false);
		System.out.println(stk2.countTokens() + "개");

		/* while 반복문을 사용하여 토큰들을 구할 수 있다. */
		while (stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}

	}

	public static void main(String[] args) {

		new UseStringTokenizer();

	}

}
