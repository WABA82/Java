package day1206;

import java.util.Random;

/**
 * @author owner<br>
 *         Random 클래스 사용 : 난수를 얻기위한 객체.
 *
 */
public class UseRandom {
	public UseRandom() {
		Random r = new Random();
		double d = r.nextDouble();

		// 실수난수
		System.out.println(d);
		// 번위난수
		System.out.println(d * 5);
		// 정수난수
		System.out.println((int) (d * 5));

		// 정수난수
		int i = r.nextInt();
		System.out.println(i);
		System.out.println(i % 5);
		System.out.println(Math.abs(i % 5));

		int j = r.nextInt(5);
		System.out.println(j);

		/* 불린의 난수 */
		Boolean b = r.nextBoolean();
		System.out.println(b);
	}

	public static void main(String[] args) {
		new UseRandom();
	}

}
