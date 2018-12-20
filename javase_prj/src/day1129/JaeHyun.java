package day1129;

/**
 * @author owner<br>
 *         Person 클래스를 상속 받아 나를 정의 하는 클래스 입니다.
 */
public class JaeHyun extends Person {

	// 나의 위닝 실력 - 맴버변수
	public int pesLevel;

	public JaeHyun() {

		/*
		 * 1.객체화할때의 기본 값 - 초기화. 
		 * 2.pesLevel = 1~10까지.
		 */
		pesLevel = 5;
	}

	// 위닝을 한 결과를 반환하는 메소드
	public String pesLevel(int otherLevel) {
		// 결과에 따라 출력하는 리액션 - 변수
		String result = "";

		if (pesLevel > otherLevel) {
			pesLevel++;
			result = "이겼다. ^^";
			if (pesLevel > 10) {
				pesLevel = 10;
			}
		} else if (pesLevel < otherLevel) {
			pesLevel--;
			result = "......";
			if (pesLevel < 1) {
				pesLevel = 1;
			}
		} else {
			result = "비겼네...한 판 더하자";
		}

		return result;
	}

}
