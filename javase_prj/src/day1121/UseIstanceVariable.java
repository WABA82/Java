package day1121;

/**
 * @author owner Instance(member) 변수 : 객체가 생성될 때 메모리(Heap)에 할당 되고, 그 주소를 저장한
 *         변수(객체, instance, object)를 사용하여 접근하는 변수.<br>
 *         자동초기화가 된다.
 */
public class UseIstanceVariable {

	// 인스턴스 변수 선언
	int i; // 정수형 초기화값 0
	int j;
	double d; // 실수형 초기화 값 0.0
	char c; // 문자형 초기화값 \u0000
	boolean b; // 불린형 초기화 값 false;
	String str; // 참조데이터타입 초기화값 null;
	UseIstanceVariable jaehyun; // 참조데이터타입 초기화값 null;

	public static void main(String[] args) { // static 영역은 가장 먼저 메모리(method영역)에 로드 되므로, 생성될지도 모르는 instance변수를 사용 할 수 없다.

		// 객체화를 하면 객체가 메모리(heap)생성되고, 그 주소를 메모리(stack)에 저장
		// 객체화 문법 : 클래스명 객체명 = new 클래스명();
		UseIstanceVariable a = new UseIstanceVariable(); // 좌항-stack메모리 = 우항-heap에 생성
		UseIstanceVariable b = new UseIstanceVariable();

		// 객체화된 객체명에 클래스명의 heap주소 저장
		System.out.println("객체 출력(heap주소) " + a);
		System.out.println("객체 출력(heap주소) " + b);

		a.i = 300;
		a.j = 500;

		System.out.println("a객체의 맴버변수 i = " + a.i);
		System.out.println("a객체의 맴버변수 i = " + a.j);

		// 인스턴스(맴버) 변수는 자동 초기화가 된다.
		System.out.println("b 객체 i : " + b.i + ", b 객체 j : " + b.j);

		// --------------------------------------------------------------------------중요-----------------------------------------------------------------------------------------//
		System.out.println(); // 줄바꿈
		System.out.println("----------------------자동 초기화 값-------------------");
		System.out.println("정수형 : " + b.i);
		System.out.println("실수형 : " + b.d);
		System.out.println("문자형 : " + b.c);
		System.out.println("불린형 : " + b.b);
		System.out.println("참조형 : " + b.str);
		System.out.println("참조형 : " + b.jaehyun);
		// --------------------------------------------------------------------------중요-----------------------------------------------------------------------------------------//
	}

}
