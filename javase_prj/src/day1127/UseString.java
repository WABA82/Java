package day1127;

/**
 * @author owner 문자열 저장소의 주소를 저장하고, 문자열을 다루는 기능을 제공하는 스트링클래스의 메소드 사용.<br>
 *         자바에서 제공하는 클래스의 이름과 내가 만든 클래스의 이름이 같다면 내가 만든 클래스를 먼저 사용한다.<br>
 *         자바에서 제공하는 클래스를 사용 할 때마다 "full path : 패키지명을 모두 기술하여 클래스를 사용하는 것"로 사용해야
 *         한다.
 *
 */
public class UseString {

	public static void main(String[] args) {
		System.out.println("안녕");
		// 기본형 형식 사용. String s = "문자열";
		String str = "AbcdEfg";
		// 참조형 형식 사용. String s = new String("문자열")
		String mail = new String("vkfqkddl123@naver.com");

		// 문자열 확인
		System.out.println(str);
		System.out.println(mail);

		// 문자열의 길이 : .length()
		System.out.println(str + "의 길이 " + str.length());
		System.out.println(mail + "의 길이 " + mail.length());

		// 문자열을 모두 대문자로 : .toUpperCase()
		System.out.println(str + "을 대문자로" + str.toUpperCase());
		System.out.println(mail + "을 대문자로 " + mail.toUpperCase());

		// 문자열을 모두 소문자로 : .toLowerCase()
		System.out.println(str + "을 소문자로 " + str.toLowerCase());
		System.out.println(mail + "을 소문자로 " + mail.toLowerCase());

		// 인덱스 찾기 : .indexOf("문자열")
		System.out.println(str + "에서 'd'의 인덱스 : " + str.indexOf("d"));
		System.out.println(str + "에서 'z'의 인덱스 : " + str.indexOf("z"));
		System.out.println(mail + "에서 \"@\"의 인덱스 : " + mail.indexOf("@"));

		// 뒤에서 부터 인덱스 찾기 : .lastIndexOf("문자열")
		str = "AbcdEfAg"; // 리터럴 변경
		System.out.println(str + "문자열 뒤에서 부터 'A'의 인덱스 : " + str.lastIndexOf("A"));

		// 특정 인덱스의 문자얻기 : .charAt(2)
		System.out.println(str + "에서 2 인덱스에 해당하는 문자 " + str.charAt(2));

		// 문자열(sub) 자르기 : .subString();
		System.out.println(str + "에서 2~5번째 해당하는 문자열 " + str.substring(2, 5)); // 값은 "cdE"가 나온다. 5번 인덱스 앞까지만 출력(null문자
																				// 때문에)
		System.out.println(mail + "에서 메일 주소만 얻기 " + mail.substring(0, mail.indexOf("@"))); // "@"의 인덱스 번호 까지 출력
		System.out.println(mail + "에서 도메인 주소만 얻기 " + mail.substring(mail.indexOf("@") + 1, mail.length())); // "@"의 인덱스
																											// 번호 까지 출력
		// .subString()은 시작 인덱스만 넣게되면 문자열의 시작부터 끝까지 반환
		System.out.println(mail + "에서 도메인 주소만 얻기 " + mail.substring(mail.indexOf("@") + 1)); // "@"의 인덱스 번호 까지 출력

		// 앞뒤 공백 자르기 : .trim()
		str = "   A BC   "; // 리터럴 변경
		System.out.println("[" + str + "] 에서 앞뒤공백제거 [" + str.trim() + "]");

		// 문자열 붙이기
		str = "Abcd"; // 리터럴변경
		String str1 = str.concat("Efg");
		String str2 = str + "Efg";
		System.out.println(str1);
		System.out.println(str2);

		// 문자열 완벽하게 같은지 비교 : .equlas("문자열");
		str = "이재찬";
		System.out.println(str + "은(는) " + (str.equals("이재찬") ? "반장" : "평민"));

		// 문자열이 이 문자열로 시작하는지 : .startsWith("문자열")
		str = "피씨방";
		if (str.startsWith("씨방")) {
			System.out.println("욕은 사용하실수 없습니다.");
		} else {
			System.out.println(str);
		}

		str = "서울시 강남구";
		System.out.println(str + "은(는) " + (str.startsWith("서울") ? "서울시" : "경기도"));

		// 특정 문자열로 끝났는지
		str = "서울시 강남구 역삼동";
		System.out.println(str + "은(는) " + (str.endsWith("동") ? "도시" : "시골"));

		// 치환-문자열 내의 모든 문자열을 찾아서 변경 : .replace()
		str = "나 지금 피씨방인데 넌 어디니 씨방새야!";
//		System.out.println(str.replace("씨방", "**"));
		System.out.println(str.replace("씨", "*").replaceAll("방", "*"));
		
		// 치환을 사용해 공백을 empty로 변경하기
		str = "   A  BC  ";
		System.out.println(str.replace(" ", ""));
		
		// 기본데이터타입을 String으로 변경하기 : String.valueOf()
		int i = 27;
		System.out.println(String.valueOf(i));
		double d = 11.27;
		str = d+""; //+ empty를 이용해서 문자열을 만들수 있지만 메소드를 사용하는게 더 좋다.
		System.out.println(str);
		
		//객체 생성을 하지 않았을 때 그 클래스가 제공하는 메소드를 사용할 수 없다.
		str = ""; //empty는 객체가 생성되었지만 값이 없는 것.
		str = null; //null은 String 객체가 생성되지 않은 것.
//		System.out.println(str.isEmpty());
		
		////////////////////////////////////11-28-2018 split메소드 사용 코드 추가 ////////////////////////////////////////
		
		String data = "123456-1234567";
		
		//.split() : 메소드에서 .으로 구분하기 위해서는 [.]으로 작성해야 한다.
		String[] arr = data.split("-");
		System.out.println("구분된 배열 방의 갯수 : " + arr.length);
		
		System.out.println(arr[1]);
		
		for(String name : arr) {
			System.out.println(name);
		}
		
	}// 메인 메소드

}// 클래스
