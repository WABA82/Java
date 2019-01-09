package day0108;

/**
 * @author owner<br>
 *         사용자 정의 예외 처리 클래스<br>
 *         Exception/RuntimeException 상속
 */
@SuppressWarnings("serial")
public class LoginException extends Exception {

	public LoginException() {
		this("로그인 실패");
	}// 생성자

	public LoginException(String msg) {
		super(msg); // 예외처리 객체를 사용하여 예외메세지를 출력 할 수 있다.
	}// 생성자
}// class
