package day1218;

public class ConstrThrowsSub extends ConstrThrows {

	public ConstrThrowsSub() throws ClassNotFoundException {
		// 수퍼클래스의 생성자가 Compile throws를 하면 서브클래스도 같은 예외를 throws를 해야한다. //
		// 수퍼클래스의 생성자가 Compile throws를 하면 서브클래스는 반드시 예외를 처리해야 한다. //
		super();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
