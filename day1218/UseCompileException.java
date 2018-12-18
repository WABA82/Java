package day1218;

/**
 * @author owner<br>
 *         컴파일 예외 : byte code(.class파일)을 생성하기 위해 처리해야 하는 예외.
 */
public class UseCompileException {

	public static void main(String[] args) {
		try {
			Object obj = Class.forName("java.lang.String");
			System.out.println(obj);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("죄송합니다.");
			System.err.println("예외메시지 출력" + cnfe.getMessage());
			System.err.println("예외메시지 출력 2단계 " + cnfe);
			cnfe.printStackTrace();
//			System.out.println("****"); // println은 printStackTrace보다 빠르게 출력 될수 있다. //
		} finally {
			System.out.println("사용해 주셔서 감사합니다.");
		}
	}

}// 클래스 //
