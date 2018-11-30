package day1122;

/*숙제 
아래의 업무를 처리하는 method를 type에 알맞게 작성하고 API주석을
 설정한 후 호출하여 결과를 본 후 Java Doc을 생성해보세요.
- API주석은 어떤 형태의 method인지를 주석으로 기술할것.

1. 자신의 이름을 반환하는 method작성.
2. 나이를 입력받아 태어난 해를 반환하는  method 작성.
3. 문자를 입력받아 해당 문자의 Unicode 값을 반환하는 method 작성.
4. 숫자를 입력받아 숫자가  영문자, 숫자의 범위에 있을 때 해당 숫자의
    문자를  출력하는 일을 하는 method  작성
5. 호출하면 자신의 주소를 출력하는  method 작성.
6. 친구의 이름을 입력받아 출력하는  method 작성(친구는 n명 입니다.) */

public class Work {

//----------------------------------------------------------------------------------------	
	// (고정 값 - 반환형 O String, 매개변수 X)
	public String myName() { // 1. 자신의 이름을 반환하는 method작성.

		String x = "이재현";

		return x;
	}//
//----------------------------------------------------------------------------------------	
	// (가변 값 - 반환형 O int, 매개변수 O int)

	public int birthYear(int age) { // 2. 나이를 입력받아 태어난 해를 반환하는 method 작성.
		int thisyear = 2018;
		int re_value;
		re_value = thisyear - age + 1;
		return re_value;
	}

//----------------------------------------------------------------------------------------	
	// (가변 값 - 반환형 O int, 매개변수 O char)
	public int returnUnicode(char c) { // 3. 문자를 입력받아 해당 문자의 Unicode 값을 반환하는 method 작성.
		int code = c;
		return code;
	}

//----------------------------------------------------------------------------------------	
	// (가변 일 - 반환형 O void, 매개변수 O int)
	public void returnChar(int inputvaule) { // 4. 숫자를 입력받아 숫자가 영문자, 숫자의 범위에 있을 때 해당 숫자의 문자를 출력하는 일을 하는 method 작성

		int i = inputvaule;

		if (i > 64 && i < 91) {
			char c = (char) i;
			System.out.println(c);
		} else {
			System.out.println("65 ~ 91 사이의 값만 입력해주세요.");
		}

	}

//----------------------------------------------------------------------------------------	
	// (고정 일 - 반환형 O void, 매개변수 X)
	public void myAddress() { // 5. 호출하면 자신의 주소를 출력하는 method 작성.\
		System.out.println("경기도 --- --- --- -- ---");
	}

//----------------------------------------------------------------------------------------	
	// (고정 일 - 반환형 O void, 매개변수 O String)
	public void friendName(String... name) { // 6. 친구의 이름을 입력받아 출력하는 method 작성(친구는 n명 입니다.)
		System.out.printf("친구는 %3d명 입니다.", name.length);
	}

//----------------------------------------------------------------------------------------	
	public static void main(String[] args) { // 출력용 메인 메소드.
		Work work = new Work();

		work.myName(); // 1. 자신의 이름을 반환하는 method작성.
		work.birthYear(26);// 2. 나이를 입력받아 태어난 해를 반환하는 method 작성.
		int code = work.returnUnicode('A'); // 3. method에서 반환된 값을 저장할 변수.
		System.out.println(code); // 3. 문자를 입력받아 해당 문자의 Unicode 값을 반환하는 method 작성.
		work.myAddress();//// 5. 호출하면 자신의 주소를 출력하는 method 작성.\
		work.returnChar(90); // 4. 숫자를 입력받아 숫자가 영문자, 숫자의 범위에 있을 때 해당 숫자의 문자를 출력하는 일을 하는 method 작성
		work.friendName("김정운", "이재현", "정택성");// 6. 친구의 이름을 입력받아 출력하는 method 작성(친구는 n명 입니다.)

	}// 메인 메소드

}// 클래스 필드
