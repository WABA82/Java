package day1206;

import java.text.DecimalFormat;

/**
 * @author owner<br>
 *         DecimalFormat : 숫자를 문자열로 변경.
 */
public class UseDecimalFormat {

	public UseDecimalFormat() {
		int temp = 20181206;
		System.out.println(temp);

		DecimalFormat df = new DecimalFormat("0,000,000,000");
		DecimalFormat df1 = new DecimalFormat("#,###,###,###");

		System.out.println("패턴0 : " + df.format(temp));
		System.out.println("패턴# : " + df1.format(temp));

		// 실수를 사용할때에는 반올림한다.
		DecimalFormat df2 = new DecimalFormat("#,###.00");
		System.out.println("소수자릿수 표현 : " + df2.format(201812.064));
		System.out.println("소수자릿수 표현 : " + df2.format(201812.065));
	}

	public static void main(String[] args) {
		new UseDecimalFormat();
	}// 메인

}// 클래스
