package day1218;

import java.util.Random;

/**
 * @author owner<br>
 *         throws : 메소드 내에서 발생한 예외를 메소드를 호출한 곳에서 처리하는 throws의 사용.
 */
public class UseThrows {

	public void test() throws ClassNotFoundException {
		String className = "day1217.UseRuntimeException";

		if (new Random().nextBoolean()) {
			className = "java.lang.Integer";
		}

		Object obj = Class.forName(className);
		System.out.println("클래스 로딩 : " + obj);
	}

	public static void main(String[] args) {
		UseThrows ut = new UseThrows();
		try {
			ut.test(); // 메소드를 호출하여 일을 수행하다보면 문제가 발생할 수도 있다. //
		} catch (ClassNotFoundException e) {
			System.err.println("죄송합니다.");
			e.printStackTrace();
//			System.out.println("정상출력"); //printStackTrace 내용 중간에 출력 될수 있다.
		}
	}
}
