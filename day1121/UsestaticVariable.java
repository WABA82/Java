package day1121;

/**
 * @param args static (class) 변수 : 클래스가 실행되면 가장 처음 메모리(method영역)에 올라가고, 모든 객체가
 *             하나의 변수를 참조하여 사용하는 변수.<br>
 * 
 */
public class UsestaticVariable {
	public static int i; // static 변수(전역).

	int j;// 인스턴스 변수 : 객체화해서 사용가능.

	public void test() {
		i = 100;
		j = 200;
		System.out.println(i + " / " + j);
	}// test method

	public static void main(String[] args) {
		UsestaticVariable.i = 2000; // static(class) 변수의 사용 : 클래스명.변수명
		System.out.println(UsestaticVariable.i);

		// 객체화
		UsestaticVariable usv = new UsestaticVariable();
		UsestaticVariable usv1 = new UsestaticVariable();
		usv.j = 5000; // 인스턴스 변수는 생성된 객체가 각각 사용한다.
		usv1.j = 10000;
		
//		usv.i=20; -- 객체명으로 사용하면 특정 객체에 속한 (member변수)가 아니므로 사용은 가능하지만 권장하는 문법이 아니다.
		UsestaticVariable.i = 20;
		System.out.println("usv객체 인스턴스변수 : " + usv.j + ", 스태틱변수 : " + UsestaticVariable.i);
		System.out.println("usv1객체 인스턴스변수 : " + usv1.j + ", 스태틱변수 : " + UsestaticVariable.i);
		


//		j=200;
//		System.out.println(i+" / "+j);
	}// main method

}// class field
