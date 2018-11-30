package day1126;

/**
 * @author owner 클래스가 객체로 생성될 때 기본적으로 가지고 있어야할 기본값을 설정하거나, 기본적으로 수행될 코드를 정의하는
 *         method 일종.
 *
 */
public class TestConstructor {

	/**
	 * 기본생성자 - default 생성자 : 클래스를 만들었을 때 보이지는 않지만 클래스의 이름을 가진 메소드가 함께 만들어 진다. 디컴파일러를
	 * 이용하면 볼수 있음.
	 */
	public TestConstructor() {
		System.out.println("기본 생성자");
//		TestConstructor(300); -- 생성자를 메소드 호출하듯 호출할 수 없다.
	}// 생성자 메소드

	/**
	 * 인자있는 생성자 : 기본생성자의 오버로딩.
	 * 
	 * @param i - 임의의 값
	 */
	public TestConstructor(int i) {
		System.out.println("인자있는 생성자" + i);
	}// 생성자 메소드

	public void test() {
		System.out.println("테스트용 메소드");
		temp();
	}//테스트
	public void temp() {
		System.out.println("-------------------------템프 메소드!!!");
	}//템프

	public static void main(String[] args) {

		// 오버로딩 된 생성자를 사용하여 객체화를 다양하게 할 수 있음.
		TestConstructor tc = new TestConstructor();
		TestConstructor tc1 = new TestConstructor(1);

		System.out.println(tc);
		System.out.println(tc1);
		
		tc.test();

	}// 메인 메소드

}// 클래스