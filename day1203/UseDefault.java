package day1203;

/**
 * @author owner<br>
 *         Default메소드 : 인터페이스에서 추상메소드가 아닌동작할 수 있는 메소드<br>
 *         Default메소드를 사용하기 위해서는 무조건 객체화를 해야한다. - 인터페이스클래스는 직접적으로 객체화를 할 수 없기
 *         때문에 is a관계의 객체화를 해야한다.
 */
public interface UseDefault {
	public void test();

	public default void temp() {
		System.out.println("인터페이스에서 디폴트 메소드를 사용한 결과입니다.");
	}
}
