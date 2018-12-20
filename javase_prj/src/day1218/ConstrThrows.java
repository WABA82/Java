package day1218;

/**
 * @author owner<br>
 *         생성자에서 예외 날리는 경우
 *
 */
public class ConstrThrows {

	public ConstrThrows() throws ClassNotFoundException {
		Class.forName("java.lang.Object");
		System.out.println("객체가 생성 되었습니다.");
	}

	public static void main(String[] args) {

		try {
			ConstrThrows ct = new ConstrThrows();
			System.out.println("객체화 성공" + ct);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("객체화중 예외 발생");
			cnfe.printStackTrace();
		}

	}

}
