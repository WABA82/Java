package day0108;

/**
 * @author owner<br>
 *         샐행 중 인 JVM에서 하나의 객체가 만들어지고, 하나의 객체만 사용되는 Pattern.
 */
public class Singleton {
	private static Singleton single;

	/* 1.클래스외부에서 객체화를 할 수 없도록 private로 만든다. */
	private Singleton() {
	}// 생성자

	public static Singleton getInstance() {
		/* 객체가 생성되어 있지 않다면 객체를 생성 */
		if (single == null) {
			single = new Singleton();
		} // end if

		/* 객체가 이미 있다면 생성되어 있는 객체가 반환된다 */
		return single;
	}// getInstance

}// class
