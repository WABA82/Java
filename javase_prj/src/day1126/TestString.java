package day1126;

/**
 * @author owner 문자열에 대한 비교
 *
 */
public class TestString {

	public static void main(String[] args) {
		String str = "ABC"; // 기본형 형식으로 선언한 문자열은 문자열 저장소의 주소를 저장하기 때문에 ==비교를 사용할 수 있다.
		if (str == "ABC") {
			System.out.println("기본형 : ==사용 : 같음");
		} else {
			System.out.println("기본형 : ==사용 : 다름");
		} // if 종료

		String str1 = new String("ABC"); // 참조형 형식으로 사용하면 변수는 heap주소를 저장하고 heap에 만들어진 객체가 문자열 저장소의 주소를 저장한다.
		if (str1 == "ABC") {
			System.out.println("참조형 : ==사용 : 같음");
		} else {
			System.out.println("참조형 : ==사용 : 다름");
		} // if 종료

		System.out.println("equals 메소드 =====================================================");

		// .equals() : 문자열이 만들어지는 형식이 어떻든 간에 문자열을 비교해주는 메소드.
		if (str.equals("ABC")) {
			System.out.println("기본형 : equals사용 : 같음");
		} else {
			System.out.println("기본형 : equals사용 : 다름");
		}

		if (str1.equals("ABC")) {
			System.out.println("기본형 : equals사용 : 같음");
		} else {
			System.out.println("기본형 : equals사용 : 다름");
		}

	}// 메인 메소드

}// 클래스 필드
