package day1129;

/**
 * @author owner ����� �߻�ȭ�Ͽ� ���� Ŭ����<br>
 *         ������ Ư¡ : ��, ��, �� �̸�<br>
 *         ������ Ư¡ : �Դ´�.<br>
 *         ��üȭ) Person ��ü�� = new Person(); <br>
 *         ������ ��ü�� �Դ� ���� �� �� �ִ�.
 *
 */
public class Person {
	private String name;// �̸�
	private int eye, nose, mouth;// ��,��,��

	/**
	 * �⺻������<br>
	 * �⺻�� - �� = 2, �� = 1, �� = 1<br>
	 * 
	 */
	public Person() {
		this(2, 1, 1);
//		eye = 2;
//		nose = 1;
//		mouth = 1;
	}

	/**
	 * �⺻������ �����ε�<br>
	 * 
	 * @param i_eye   - �ԷµǴ� ���� ����
	 * @param i_nose  - �ԷµǴ� ���� ����
	 * @param i_mouth - �ԷµǴ� ���� ����
	 */
	public Person(int eye, int nose, int mouth) {

//		this�� ����Ͽ� �����ؾ��Ѵ�. this.eye��  class Person�� �Ӽ��� private year�κ��� ����Ų��.
		this.eye = eye;
		this.nose = nose;
		this.mouth = mouth;
	}

	/**
	 * ������ ��� ��ü�� �̸��� �����ϴ� ��.
	 * 
	 * @param i_name �̸�
	 */
	public void setName(String i_name) {
		this.name = i_name;
	}

	/**
	 * ������ ��� ��ü�� ���� ������ �����ϴ� ��<br>
	 * ������ ���� ������ �ִ� 3�� ���� ������ �� �ֽ��ϴ�<br>
	 * 3���� �Ѿ�� 2���� �����ȴ�.
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
	 * ������ ��� ��ü�� ������ �ִ� ���� ���� ��ȯ
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
	 * �����ε� : ������ ������ ��ü�� �Ĵ翡�� �ֹ��� ������ �Դ� ���� ����.
	 * 
	 * @return
	 */
	public String eat() {
		return name + "�� ������ ���� �Դ´�.";
	}

	public String eat(String menu, int price) {
		return name + "�� �Ĵ翡�� " + menu + "�� ������ " + price + "�� ���� ��Դ´�.";
	}
}