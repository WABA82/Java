package day1123;

/**
 * @author owner 마카펜을 대상으로 선정하여, 추상화를 진행하고 만들어진 클래스<br>
 *         마카펜 - 명사적 특지 : 색, 몸, 뚜껑 =&gt; 변수 <br>
 *         마카펜 - 동사적 특지 : 쓴다 =&gt; 메소드 <br>
 * 
 *         사용법)<br>
 *         기본생성자를 사용하여 객체를 생성한 후 setter method를 호출하여 값을 설정한 후 사용한다.<br>
 *         Marker m = new Marker();<br>
 *         m.setXxx(값); <br>
 * 
 *         클래스는 사용자정의 자료형이고 참조형 테이터타입이다.
 *
 */
public class Marker {
	private String color; // 마카펜의 색
	private int body; // 마카펜의 몸체의 갯수
	private int cap; // 마카펜의 뚜껑의 갯수

	/**
	 * 기본생성자 : 마카펜 객체가 생성되면 검은색, 뚜껑1개, 몸체1개인 마카펜 객체를 생성합니다.<br>
	 * 11-26-2018 코드 추가
	 */
	public Marker() {
		this("검은색", 1, 1);
		System.out.println("마카 기본생성자");
//		인자있는 생성자를 호출하여 값을 설정.
//		color = "검은색";
//		body = 1;
//		cap = 1;
	}// 기본생성자

	/**
	 * 기본생성자 오버로딩 - 인자가 있는 마카펜을 생성하는 생성자.
	 * 
	 * @param color - 마카펜의 색상
	 * @param cap   - 뚜껑의 갯수
	 * @param body  - 몸체의 갯수
	 */
	public Marker(String color, int cap, int body) {
		this.color = color;
		this.cap = cap;
		this.body = body;
		System.out.println("마카 오버로딩된 생성자");
	}// 생성자 오버로딩

	/**
	 * 생성된 마카펜 객체의 색을 설정하는 일.<br>
	 * 검은색,파란색,빨간색만 설정한다. 그 이외의 색은 검은색으로 처리한다.
	 * 
	 * @param color 색 입력
	 */
	public void setColor(String color) {
		// 인스턴스변수에 설정될 값에 대한 검증 수행.
		if (!(color.equals("검은색") || color.equals("파란색") || color.equals("빨간색"))) {
			color = "검은색";
		}
		this.color = color;
	}

	/**
	 * 생성된 마카펜 객체의 몸체의 갯수를 설정하는 일.
	 * 
	 * @param body 몸체 갯수 입력
	 */
	public void setBody(int body) {
		this.body = body;
	}

	/**
	 * 생성된 마카펜 객체의 뚜껑의 갯수를 설정하는 일.
	 * 
	 * @param cap 뚜껑 갯수 입력.
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}

	/**
	 * 생성된 마카펜 객체의 색을 반환하는 메소드
	 * 
	 * @return color
	 */
	public String getColor() {
		return color;
	}// getColor

	/**
	 * 생성된 객체가 가지고 있는 몸체의 갯수
	 * 
	 * @return body
	 */
	public int getBody() {
		return body;
	}

	/**
	 * 생성된 객체가 가지고 있는 뚜껑의 갯수
	 * 
	 * @return cap
	 */
	public int getCap() {
		return cap;
	}

	/**
	 * 입력된 메세지를 생성된 마카펜으로 칠판에 쓰는 일.
	 * 
	 * @param msg 문자열 메시지 입력
	 * @return 색 + 문자열
	 */
	public String write(String msg) {
		return color + "인 마카펜으로 칠판에\"" + msg + "\"를 쓴다";
	}
}// 마커 클래스
