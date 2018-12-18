package day1218;

/**
 * @author owner<br>
 *         사용자 정의 예외처리 클래스
 */

/* 1. Exception이나 RuntimeException을 상속 받는다. */
@SuppressWarnings("serial")
public class TobaccoException extends RuntimeException {

	public TobaccoException() {
		this("담배예외 - 폐암의 원인 흡연! 그래도 피우시겠습니까?");
	}

	public TobaccoException(String msg) {
		super(msg);
	}

}
