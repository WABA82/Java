package day1205;

/**
 * @author owner<br>
 *         문자열을 힙메모리에 저장하고 사용하는 클래스 - StringBuffer, StringBuilder.<br>
 *
 */
public class UseStringBuilder {

	public void useStringBuffer() {
		StringBuffer sb = new StringBuffer();

		// .append() : 값을 추가하고 문자열을 반환.
		sb.append("오늘은 ").append(12).append("월 5일 ").append("수요일 입니다.");
		System.out.println(sb);

		// .insert(인덱스, 값) : 값을 삽입.
		sb.insert(3, " 2018년");
		System.out.println(sb);

		// .delete(시작인덱스, 끝인덱스 + 1) : 값을 삭제.
		sb.delete(0, 2);
		System.out.println(sb);

		// .reverse() : 문자열 거꾸로
		sb.reverse();
		System.out.println(sb);

	}

	public void useStringBuilder() {
		StringBuilder sb = new StringBuilder();

		// .append() : 값을 추가하고 문자열을 반환.
		sb.append("오늘은 ").append(12).append("월 5일 ").append("수요일 입니다.");
		System.out.println(sb);

		// .insert(인덱스, 값) : 값을 삽입.
		sb.insert(3, " 2018년");
		System.out.println(sb);

		// .delete(시작인덱스, 끝인덱스 + 1) : 값을 삭제.
		sb.delete(0, 2);
		System.out.println(sb);

		// .reverse() : 문자열 거꾸로
		sb.reverse();
		System.out.println(sb);
	}

	public static void main(String[] args) {
		UseStringBuilder usb = new UseStringBuilder();

		usb.useStringBuilder();

		usb.useStringBuffer();

		String str = "안녕하세요?";
		System.out.println(str);

		// 긴 문자열 : 연산자를 사용하는 문자열을 긴 문자열이라 한다.
		String str1 = "안";
		// new
		// StringBuilder().append(str1).append("녕").append("하").append("세").append("요?");
		System.out.println(str1 + "녕" + "하" + "세" + "요?");

	}

}
