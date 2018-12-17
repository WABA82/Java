package day1217;

/**
 * @author owner<br>
 *         RuntimeException : JVM에서 자동으로 예외처리를 해주는 Exception의 연습입니다.
 *
 */
public class UseRuntimeException {

	public static void main(String[] args) {

		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int result = 0;
			result = num1 / num2;
			System.out.println(num1 + " / " + num2 + " = " + result);
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.err.println("배열의 인덱스가 잘못 되었습니다.");
			/* 예외 이유 */
			System.err.println("처리 1단계" + aioobe.getMessage());
			/* 예외 이유 + 예외 객체 */
			System.err.println("처리 2단계" + aioobe);
			/* 자세한 정보 */
			aioobe.printStackTrace();
		} catch (NumberFormatException nfe) {
			System.err.println("입력값이 숫자 형태가 아닙니다.");
			/* 예외 이유 */
			System.err.println("처리 1단계" + nfe.getMessage());
			/* 예외 이유 + 예외 객체 */
			System.err.println("처리 2단계" + nfe);
			/* 자세한 정보 */
			nfe.printStackTrace();
		} catch (ArithmeticException ae) {
			System.err.println("숫자를 0으로 나눌 수 없습니다.");
			/* 예외 이유 */
			System.err.println("처리 1단계" + ae.getMessage());
			/* 예외 이유 + 예외 객체 */
			System.err.println("처리 2단계" + ae);
			/* 자세한 정보 */
			ae.printStackTrace();
		} catch (Exception e) { /* 가장 최상위 객체는 맨 마지막에 나와야 합니다. */
			System.err.println("인지하지 못한 예외 입니다.");
			e.printStackTrace();
		} finally {
			System.out.println("반드시 실행되어야 할 코드");
		}

	}
}
