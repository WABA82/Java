package day1126;

/**
 * @author owner this를 사용한 생성자 호출
 *
 */
public class ThisConstructor {

	public ThisConstructor() {
		System.out.println("기본생성자");
	}// 기본생성자

	public ThisConstructor(int i) {
		this(); // this(); 는 생성자 메소드에서 무조건 1번째줄에 나와야 한다.
		System.out.println("인자 있는 생성자 : " + i);
	}// 기본생성자

	public static void main(String[] args) {
		new ThisConstructor(22); // 객체를 한번만 실행할 때
	}

}
