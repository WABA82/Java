package day1126;

/**
 * @author owner 메소드를 호출하는 객체의 주소로 변경되어 사용되는 this.
 *
 */
public class ThisKeyword {

	private int i;

	/**
	 * this를 사용하지 않은 메소드
	 * 
	 * @param i - 정수형
	 * @param t - 참조형데이터타입
	 */
	public void useInstance(int i, ThisKeyword tk) {
		tk.i = i; // 파라미터(스택메모리) 변수의 값을 인스턴스(힙메모리) 변수에 올림.
		System.out.println("전달된 객체 : " + tk);
	}//

	/**
	 * this를 사용하는 메소드
	 * 
	 * @param i - 정수형
	 */
	public void useThis(int i) {
		this.i = i; // *중요*) this는 method를 호출하는 객체의 주소로 변환되는 키워드.
		System.out.println("메소드를 호출한 객체의 주소 : " + this);
	}//

	public static void test() {
		System.out.println("static method");
	}

	public static void main(String[] args) {
		ThisKeyword tk = new ThisKeyword();
		System.out.println("생성된 객체 : " + tk);

		tk.useInstance(300, tk);
		System.out.println("전달한 객체의 인스턴스 변수의 값 : " + tk.i);

		System.out.println("========================================");

		tk.useThis(900);
		System.out.println("this를 사용하여 변경한 인스턴스 변수의 값 : " + tk.i);

		System.out.println("========================================");

		ThisKeyword.test();

	}// 메인 메소드

}// 클래스
