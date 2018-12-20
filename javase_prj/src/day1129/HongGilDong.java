package day1129;

/**
 * @author owner<br>
 *         사람의 공통 특징을 Person클래스 로부터 사용하고 자신만의 특징만(싸움을 잘한다)정의
 *
 */
public class HongGilDong extends Person {

	private int level; // 홍길동의 싸움레벨

	/**
	 * 홍길동은 싸움을 평민보다 잘하므로 7로 시작
	 */
	public HongGilDong() {
		super();
		level = 7;
	}// HongGilDong

	/**
	 * 싸움하는 메소드 : 입력된 레벨보다 낮다면 패, 입력된 레벨보다 높다면 승리 입력된 레벨과 같다면 비김. 승리하면 레벨이 1증가, 패배
	 * 하면 레벨 1감소, 비기면 레벨변화 없음 레벨은 최대 10, 최소 1을 가진다.
	 * 
	 * @param inputLevel - 싸움 상대자의 레벨
	 * @return 싸움의 결과
	 */
	public String fight(int inputLevel) {
		String result = "";

		if (level > inputLevel) { // 승리
			result = "이겼다.s('.^)V";
			level++;
			if (level > 10) {
				level = 10;
			} // end if
		} else if (level < inputLevel) { // 패배
			result = "졌다.~(_-_)~";
			level--;
			if (level < 1) {
				level = 1;
			} // end if
		} else { // 비김
			result = "비김 --+;;";
		} // end else if

		return result;
	}
	
	/**
	 * Person클래스의 eat()를 HongGilDong클래스에서 오버라이딩.<br>
	 * 장소) 식당 --> 주막
	 * 화폐단위) 원 --> 냥
	 */
	@Override
	public String eat(String menu, int price) {
		return getName() + "이 주막에서 " + menu + "인 음식을 " + price + "냥 내고 사먹는다.";
	}
	
	@Override
	public String toString() {
		return "홍길동 객체의 눈 : " + getEye() + ", 코 : " + getNose() + ", 입 : " + getMouth();
	}
	
}//
