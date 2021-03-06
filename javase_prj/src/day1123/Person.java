package day1123;

/**
 * @author owner 사람을 추상화하여 만든 클래스<br>
 *         명사적 특징 : 눈, 코, 입 이름<br>
 *         동사적 특징 : 먹는다.<br>
 *         객체화) Person 객체명 = new Person(); <br>
 *         생성된 객체로 먹는 일을 할 수 있다.
 *
 */
public class Person {
	private String name;// 이름
	private int eye, nose, mouth;// 눈,코,입

	/**
	 * 기본생성자<br>
	 * 기본값 - 눈 = 2, 코 = 1, 입 = 1<br>
	 * 
	 */
	public Person() {
		this(2, 1, 1);
//		eye = 2;
//		nose = 1;
//		mouth = 1;
	}

	/**
	 * 기본생성자 오버로딩<br>
	 * 
	 * @param i_eye   - 입력되는 눈의 갯수
	 * @param i_nose  - 입력되는 코의 갯수
	 * @param i_mouth - 입력되는 입의 갯수
	 */
	public Person(int eye, int nose, int mouth) {

//		this를 사용하여 구분해야한다. this.eye는  class Person의 속성인 private year부분을 가르킨다.
		this.eye = eye;
		this.nose = nose;
		this.mouth = mouth;
	}

	/**
	 * 생성된 사람 객체에 이름을 설정하는 일.
	 * 
	 * @param i_name 이름
	 */
	public void setName(String i_name) {
		this.name = i_name;
	}

	/**
	 * 생성된 사람 객체의 눈의 갯수를 설정하는 일<br>
	 * 설정할 눈의 갯수는 최대 3개 까지 설정할 수 있습니다<br>
	 * 3개가 넘어가면 2개로 설정된다.
	 * 
	 * @param eye_cnt
	 */
	public void setEye(int eye_cnt) {

		if (eye_cnt > 3) {
			eye_cnt = 2;
		}

		this.eye = eye_cnt;
	}

	public void setNose(int nose_cnt) {

		if (nose_cnt > 1) {
			nose_cnt = 1;
		}

		this.nose = nose_cnt;
	}

	public void setMouth(int mouth) {
		this.mouth = mouth;
	}

	public String getName() {
		return name;
	}

	/**
	 * 생성된 사람 객체가 가지고 있는 눈의 갯수 반환
	 * 
	 * @return
	 */
	public int getEye() {
		return eye;
	}

	public int getNose() {
		return nose;
	}

	public int getMouth() {
		return mouth;
	}

	/**
	 * 오버로드 : 다형성 생성된 객체가 식당에서 주무한 음식을 먹는 일을 구현.
	 * 
	 * @return
	 */
	public String eat() {
		return name + "이 집에서 밥을 먹는다.";
	}

	public String eat(String menu, int price) {
		return name + "이 식당에서 " + menu + "인 음식을 " + price + "원 내고 사먹는다.";
	}
}
