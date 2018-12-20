package day1122;

/**
 * @author owner 
 * method의 4가지 형태
 */
public class MethodType {

	/**
	 * 반환형 없고 매개변수 없는 형 - 고정 일
	 */
	public void typeA() {
		System.out.println("안녕하세요.");
	}// typeA method

	/**
	 * 반환형 없고 매개변수 있는 형 - 가변 일
	 * 
	 * @param i 출력하고 싶은 값
	 */
	public void typeB(int i) {
		System.out.println(i + "번 안녕");
	}// typeB method

	/**
	 * 반환형 있고 매개변수 없는 형 - 고정 값
	 * 
	 * @return 년.월을 실수형으로 반환
	 */
	public double typeC() {
		return 2018.11;
	}// typeC method

	/**
	 * 반환형 있고 매개변수 있는 형 - 가변 값<>
	 *
	 * @param d 정수로 만들고 실수 값
	 * @return i 를 리턴
	 * 
	 */
	public int typeD(double d) {
		
		int i = (int)(d);
		
		return i;
	}// typeD method

	public static void main(String[] args) {

		MethodType mt = new MethodType();

		// 1. 고정 일 method 호출
		mt.typeA();

		// 2. 가변 일 method 호출
		mt.typeB(21);

		// 3. 고정 값 method 호출
		double i = mt.typeC(); // typeC 메소드는 값만 가지고 있는 메소드 이기 때문에 사용하기 전 값을 담을 변수를 사용해야 한다.
		System.out.println( "고정값 : " + i);
		
		// 4. 가변 값 method 호출
		int j = mt.typeD(300.003); // typeC 메소드는 값만 가지고 있는 메소드 이기 때문에 사용하기 전 값을 담을 변수를 사용해야 한다.
		System.out.println( "가변값 : " + j);
		

	}// main method

}// class field
