package day1129;

/**
 * @author owner<br>
 *         이름, 나이 , 이메일, (성)이니셜을 저장하는 클래스<br>
 *
 */
public class Data {
	private String name;
	private int age;
	private String email;
	private char initial;

	public Data() {
		System.out.println("Date Default Constructor");
	}// 기본 생성자

	public Data(String name, int age, String email, char initial) {
		System.out.println("Date Constructor");
		this.name = name;
		this.age = age;
		this.email = email;
		this.initial = initial;
	}// 기본 생성자 - 오버로딩

//set method 정의 부분 - 시작
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setInitail(char initial) {
		this.initial = initial;
	}
//set method 정의 부분 - 끝

//get method 정의 부분 - 시작
	public String getName() {
		return name;
	}//

	public int getAge() {
		return age;
	}//

	public String getEmail() {
		return email;
	}//

	public char getInitial() {
		return initial;
	}//
	
	public String toString() {
		return "이름 : " + name + ", 나이 : " + age + ", 이메일 : " + email + ", 이니셜 : " + initial + "\n";
	}
	
//get method 정의 부분 - 끝

}// 클래스 필드 종료
