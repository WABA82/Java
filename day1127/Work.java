package day1127;

/**
 * @author owner<br>
 *         주민번호 입력받아 처린하는 프로그램 작성.<br>
 *         각 작업은 method 정의하고 호출하여 결과를 받아서 처리.<br>
 *         1-1. 생성자는 주민번호를 받아 instance변수에 할당한다.<br>
 *         1-2. 주민번호의 길이를 체크하여 14자가 아니면 false반환<br>
 *         1-3. 주민번호의 6번째 자리가 '-'이 아니면 false반환<br>
 *         1-4. 주민번호의 유효성검증항 유효하면 true/false반환 234567892345를 곱한 값을 더하여 11로 나눈
 *         나머지 값을 얻고 11에서 그 값을 빼고 10으로 나눈 나머지가 주민번호의 끝자리와 같다면 true/false<br>
 *         1-5 생년월일을 반환한는 일. "1988-11-11"<br>
 *         1-6 나이를 반환하는 일 31<br>
 *         1-7성별을 반환 남, 여<br>
 *         1-8 내국인/외국인 반환 1234 / 5678<br>
 *         1-9 띠 반환 "양띠"<br>
 *
 */
public class Work {

	private String ssn;
	private String birthYear;

	// 1-1. 생성자는 주민번호를 받아 instance변수에 할당한다.<br>
	public Work(String ssn) {
		this.ssn = ssn.substring(0, (ssn.indexOf('-'))) + ssn.substring((ssn.indexOf('-') + 1));
		System.out.println(this.ssn);
	}// 주민번호 입력 받는 생성자

	// 1-2. 주민번호의 길이를 체크하여 14자가 아니면 false반환<br>
	public boolean ssnCheck() {
		boolean flag = (ssn.length() == 14);
//		if (ssn.length() == 14) {
//			flag = true;
//		} // if 종료
		return flag;
	}

	// 1-3. 주민번호의 6번째 자리가 '-'이 아니면 false반환<br>
	public boolean ssnCheck1() {
		boolean flag = (ssn.indexOf("-") == 6);
//		if (ssn.indexOf("-") == 6) {
//			flag = true;
//		}
		return flag;
	}

	/*
	 * 1-4. 주민번호의 유효성검증항 유효하면 true/false반환 234567892345를 곱한 값을 더하여 11로 나눈 나머지 값을 얻고
	 * 11에서 그 값을 빼고 10으로 나눈 나머지가 주민번호의 끝자리와 같다면 true/false
	 */
	public boolean ssnCheck2() {
		boolean flag = false;
		String numssn = ssn.substring(0, 12);
		int[] temp = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		int value = 0;

		for (int i = 0; i < 12; i++) {
			value = value + (temp[i] * Integer.parseInt(numssn.substring(i, i + 1)));
		}

		if (((11 - (value % 11)) % 10) == Integer.parseInt(ssn.substring(12, 13))) {
			flag = true;
		}
		return flag;
	}

	// 1-5 생년월일을 반환한는 일. "1988-11-11"<br>
	public String retbirth() {

		String year = "";
		String birth = ssn.substring(0, 2) + " - " + ssn.substring(2, 4) + " - " + ssn.substring(2, 4);

		if (ssn.substring(7, 8).equals("0") || ssn.substring(7, 8).equals("9")) {
			year = "18";
		} else if (ssn.substring(7, 8).equals("1") || ssn.substring(7, 8).equals("2") || ssn.substring(7, 8).equals("5")
				|| ssn.substring(7, 8).equals("6")) {
			year = "19";
		} else if (ssn.substring(7, 8).equals("3") || ssn.substring(7, 8).equals("4") || ssn.substring(7, 8).equals("7")
				|| ssn.substring(7, 8).equals("8")) {
			year = "20";
		}

		birthYear = (year + ssn.substring(0, 2));

		return year + birth;
	}// 메소드3번

//	-------------------------------------------------------------------------------------------------------------------------------------여기서 부터 하기 

	// 1-6 나이를 반환하는 일 31<br>
	public int retage() {
		int age = 0;
		int thisyear = 2018;
		int birthyear = Integer.parseInt(birthYear);
		age = (thisyear - birthyear) + 1;
		return age;
	}

	// 1-7성별을 반환 남, 여<br>
	public String retgender() {
		String gender = "여";

		return gender;
	}

	// 1-8 내국인/외국인 반환 1234 / 5678<br>
	public String retNation() {
		String nation = "외국인";
		
		return nation;
	}

	// 1-9 띠 반환 "양띠"<br>
	public String retBand() {
		int birth = 1990;
		String[] KBAND = { "원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양" };

		return KBAND[birth % 12];
	}

	public static void main(String[] args) {
		// test객체 생성
		Work test = new Work("123456-1234567");
		System.out.println(test.ssnCheck2());

	}// 메인 메소드

}// 클래스 필드
