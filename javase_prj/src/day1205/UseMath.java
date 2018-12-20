package day1205;

/**
 * @author owner<br>
 *         Math클래스의 사용 : 모든 메소드가 스태틱이기 때문에 개체화를 하지 않는다.
 *
 */
public class UseMath {

	public UseMath() {

		int i = -12;

		// 절대값 메소드
		System.out.println(i + "의 절대값 " + Math.abs(i));

		// 올림 메소드
		System.out.println(Math.ceil(10.1));

		// 반올림 메소드
		System.out.println(Math.round(10.5));

		// 내림 메소드
		System.out.println(Math.floor(10.5));

		double d = Math.random();
		System.out.println(d);
		System.out.println("범위를 설정한 난수 " + d * 5);
		System.out.println("번위를 설정한 난수에서 정수" + (int) (d * 10));

		// A(65)~Z(90), a(97)~z(122)중 하나의 문자를 반환하는 일.
		System.out.println((char) ((int) (d * 26) + 65));

	}

	// 영문자대문자, 소문자, 숫자로 이루어진 임의의 비밀번호 8자리를 생성하여 반환하는 일
	public char[] createPassword() {
		char[] tempPass = new char[8];
		String flag = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		for (int i = 0; i < tempPass.length; i++) {
			tempPass[i] = flag.charAt((int) (Math.random() * flag.length()));
			System.out.print(tempPass[i]);
		}
		return tempPass;
	}

	public static void main(String[] args) {
		new UseMath().createPassword();
	}

}
