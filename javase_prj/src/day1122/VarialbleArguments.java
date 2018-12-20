package day1122;

/**
 * @author owner 가변인자형 : 매개변수는 하나인데 인수를 여러개 넣을 수 있는 기능.<br>
 *         메소드 안에서는 배열로 취급된다.
 */
public class VarialbleArguments {

	/**
	 * 같은 데이터형으로 된 입력 값을 여러개 사용할 때
	 * 
	 * @param param 가변 인자형
	 */
	public void test(int... param) {
		for (int val : param) {
			System.out.println(val);
		} // for 종료\
		System.out.println("test 메소드 호출");
	}// test 메소드

	/**
	 * 가변 인수를 받기위한 매개변수는 가장 마지막에만 사용할 수 있다.
	 * 
	 * @param i
	 * @param d
	 * @param j
	 */
	public void test1(int i, double d, int... j) {
		System.out.println("처음 매개변수 : " + i);
		System.out.println("처음 매개변수 : " + d);
		System.out.println("배열 매개변수 : " + j);

		for (int idx = 0; idx < j.length; idx++) {
			System.out.println(j[idx]);
		}

	}
	
	public void printName(String name) {
		System.out.println(name+"님 안녕하세요.");
	}
	
	public static void main(String[] args) {

		VarialbleArguments va = new VarialbleArguments();
		va.test1(1, 3.14, 10, 20, 30, 40, 50, 60);

		String name = new String();
		name = "이재찬";
		va.printName(name);
		
		System.out.println("\"안녕하세요.\" ");

		
		
	}// main 메소드

}// class 필드
