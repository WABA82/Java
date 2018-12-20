package day1122;

/**
 * @author owner 특수문자 : 문자열내 \로 시작하는 기능을 가진 문자.
 *
 */
public class UseEscapeCharacter {

	public static void main(String[] args) {
		System.out.println("이\t재현");
		System.out.println("이\t\t재현");
		System.out.println("이\n재현");
		System.out.println("이\r재현"); //윈도우 줄바꿈
		System.out.println("\'이재현\'");
		System.out.println("\"이재현\"");
		System.out.println("이재\\현");
		System.out.println("이재\b현"); //백스페이스 이지만 지워지지 않는다.
		System.out.println("이재\f현"); //프린터 기기를 사용할 때 줄바꿈
	}

}
