package day1123;

/**
 * @author J : ����� �߻�ȭ�Ͽ� ���� Ŭ����;
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
	 * ��� �����縦 �����ϴ� �޼ҵ�
	 * 
	 * @param input_maker �������̸�
	 */
	public void setMaker(String input_maker) {
		this.maker = input_maker;
	}

	/**
	 * ��� �������� �����ϴ� �޼ҵ�
	 * 
	 * @param input_country
	 */
	public void setName(String input_name) {
		this.name = input_name;
	}

//	/**
//	 * ���������� �����ϴ� �޼ҵ�
//	 * @param input_cnt
//	 */
//	public void setCntSoup(int input_cnt) {
//		this.cntSoup = input_cnt;
//	}

//	/**
//	 * ���� ������ �����ϴ� �޼ҵ�
//	 * 
//	 * @param input_nuddle
//	 */
//	public void setNuddle(int input_nuddle) {
//		this.cntSoup = input_nuddle;
//	}

//	/**
//	 * �丮 �ؾ� �ϴ� �ð��� �����ϴ� �޼ҵ�
//	 * @param input_time
//	 */
//	public void setCookingTime(int input_time) {
//		this.cooking_time=input_time;
//	}

	// --------------------------------//--------------------------------//--------------------------------//--����
	// �޼ҵ� ����

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

	// --------------------------------//--------------------------------//--------------------------------//--��
	// ��ȯ �޼ҵ� ����

	public String being_ramyun() {
		return name + "��(��) " + "������ ���� �� �ִ� ����� �˴ϴ�.";
	}

	public String being_ramyun(int minute) {
		return name + "��(��)  " + minute + "�� ���� ������ ���� ���ִ� ����� �˴ϴ�.";
	}

	// --------------------------------//--------------------------------//--------------------------------//--���
	// �޼ҵ� ����

}
