package day1123;

/**
 * @author J : 라면을 추상화하여 만든 클래스;
 *
 */
public class Work {

	private String maker;
	private String name;
	private int cntSoup;
	private int nuddle;
//	private int cooking_time;

	public Work() {
		this(1, 1);
	}

	public Work(int cntSoup, int nuddle) {
		this.cntSoup = cntSoup;
		this.nuddle = nuddle;
	}

	/**
	 * 라면 제조사를 세팅하는 메소드
	 * 
	 * @param input_maker 제조사이름
	 */
	public void setMaker(String input_maker) {
		this.maker = input_maker;
	}

	/**
	 * 라면 제조국을 세팅하는 메소드
	 * 
	 * @param input_country
	 */
	public void setName(String input_name) {
		this.name = input_name;
	}

//	/**
//	 * 스프갯수를 설정하는 메소드
//	 * @param input_cnt
//	 */
//	public void setCntSoup(int input_cnt) {
//		this.cntSoup = input_cnt;
//	}

//	/**
//	 * 면의 갯수를 설정하는 메소드
//	 * 
//	 * @param input_nuddle
//	 */
//	public void setNuddle(int input_nuddle) {
//		this.cntSoup = input_nuddle;
//	}

//	/**
//	 * 요리 해야 하는 시간을 설정하는 메소드
//	 * @param input_time
//	 */
//	public void setCookingTime(int input_time) {
//		this.cooking_time=input_time;
//	}

	// --------------------------------//--------------------------------//--------------------------------//--정의
	// 메소드 종료

	public String getMaker() {
		return maker;
	}

	public String getName() {
		return name;
	}

	public int getCntSoup() {
		return cntSoup;
	}

	public int getNuddle() {
		return nuddle;
	}
//	public int getCookingTime() {
//		return cooking_time;
//	}

	// --------------------------------//--------------------------------//--------------------------------//--값
	// 반환 메소드 종료

	public String being_ramyun() {
		return name + "은(는) " + "끓여야 먹을 수 있는 라면이 됩니다.";
	}

	public String being_ramyun(int minute) {
		return name + "은(는)  " + minute + "분 동안 끓여야 가장 맛있는 라면이 됩니다.";
	}

	// --------------------------------//--------------------------------//--------------------------------//--사용
	// 메소드 종료

}
