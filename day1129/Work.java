package day1129;

/*
숙제 1.
번호,이름,주소,나이,성별을  저장할 수 있는 클래스를 만들고 
아래와 같은 값을 입력합니다.

입력값
1, 이재찬, 서울시 강남구 역삼동, 28,남자
2, 이재현, 서울시 동대문구 답십리동, 27,남자
3, 김정운, 수원시 영통구 영통동, 26,남자
4, 정택성, 서울시 구로구 구로동,27, 남자
5, 정택순, 서울시 동작구 상도동,29,여자
6, 김건하, 경기도 부천시 부천동,26,남자
7, 이재순, 서울시 광진구 광나루동,27,여자
 
1. 위의값을 배열에 입력하는 method를 작성할것.
2. 배열에 입력된 값을 출력하는 method 를 작성할것.
   2-1번 method 에서 서울시에 살고 있는 인원수를 출력 할것.
   		ex)"서울시 거주자 x명"
   2-2번 method 에서 나이의 합을 출력 할것.
   		ex)"나이 합 x살"
   2-3번 method 에서 가장 나이가 많은 사람의 이름을 출력 할 것.
   		ex)"최고령자 "정택순(여자)"
*/
public class Work {

	private int num;
	private String name;
	private String address;
	private int age;
	private String gender;

	public Work() {

	}

	public Work(int num, String name, String address, int age, String gender) {
		this.num = num;
		this.name = name;
		this.address = address;
		this.age = age;
		this.gender = gender;
	}

//////////////////////////////set 메소드//////////////////////
	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
//////////////////////////////set 메소드//////////////////////

//////////////////////////////get 메소드//////////////////////
	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public String getAdrress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}
//////////////////////////////get 메소드//////////////////////

//////////////////////////////print 메소드////////////////////

//	2. 배열에 입력된 값을 출력하는 method 를 작성할것.
//	   2-1번 method 에서 서울시에 살고 있는 인원수를 출력 할것.
//	   		ex)"서울시 거주자 x명"
//	   2-2번 method 에서 나이의 합을 출력 할것.
//	   		ex)"나이 합 x살"
//	   2-3번 method 에서 가장 나이가 많은 사람의 이름을 출력 할 것.
//	   		ex)"최고령자 "정택순(여자)"

	public void printClassArray(Work[] wk) { // 객체 배열을 매게변수로 받는 매소드
		System.out.println("--------------출력 메소드 입니다.-------------------");

		// 2-1번 method 에서 서울시에 살고 있는 인원수를 출력 할것. ex)"서울시 거주자 x명"
		int addrTemp = 0;
		String addrData = null;
		for (int i = 0; i < wk.length; i++) {
			addrData = wk[i].getAdrress();
			System.out.println(addrData);

			if (addrData.startsWith("서울시")) {
				addrTemp++;
			} // end if

		} // end for i
		System.out.println("서울시에 살고 있는 인원수 : " + addrTemp);

		// 2-2번 method 에서 나이의 합을 출력 할것. ex)"나이 합 x살"

		int addAge = 0;
		int ageData = 0;
		for (int i = 0; i < wk.length; i++) {
			ageData = wk[i].getAge();
			addAge += ageData;
		}
		System.out.println("method 인원들의 나이의 합 : " + addAge);

//		2-3번 method 에서 가장 나이가 많은 사람의 이름을 출력 할 것. ex)"최고령자 "정택순(여자)"

		int maxAge = 0;
		int comAgeData = 0;
		String person = "";
		for (int i = 0; i < wk.length; i++) {
			comAgeData = wk[i].getAge();
			
			if (maxAge < comAgeData) {
				maxAge = comAgeData;
			}//end if
			
			if (maxAge == wk[i].getAge()) {
				person = wk[i].getName();
			}//end if
		
		}
		System.out.println("나이가 가장 많은 사람의 이름 출력 : " + person);

	}// print 메소드 끝

	public static void main(String[] args) {
		Work[] wk = new Work[7]; // 객체 배열 생성
		System.out.println(wk.length); // 생성된 객체배열의 길이 확인

		wk[0] = new Work(1, "이재찬", "서울시 강남구 역삼동", 28, "남자");
		wk[1] = new Work(2, "이재현", "서울시 동대문구 답십리동", 27, "남자");
		wk[2] = new Work(3, "김정운", "수원시 영통구 영통동", 26, "남자");
		wk[3] = new Work(4, "정택성", "서울시 구로구 구로동", 27, "남자");
		wk[4] = new Work(5, "정택순", "서울시 동작구 상도동", 29, "여자");
		wk[5] = new Work(6, "김건하", "경기도 부천시 부천동", 26, "남자");
		wk[6] = new Work(7, "이재순", "서울시 광진구 광나루동", 27, "여자");

		new Work().printClassArray(wk);
	}

}
