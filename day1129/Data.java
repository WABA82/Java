package day1129;

/**
 * @author owner<br>
 *         �̸�, ���� , �̸���, (��)�̴ϼ��� �����ϴ� Ŭ����<br>
 *
 */
public class Data {
	private String name;
	private int age;
	private String email;
	private char initial;

	public Data() {
		System.out.println("Date Default Constructor");
	}// �⺻ ������

	public Data(String name, int age, String email, char initial) {
		System.out.println("Date Constructor");
		this.name = name;
		this.age = age;
		this.email = email;
		this.initial = initial;
	}// �⺻ ������ - �����ε�

//set method ���� �κ� - ����
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setInitail(char initial) {
		this.initial = initial;
	}
//set method ���� �κ� - ��

//get method ���� �κ� - ����
	public String getName() {
		return name;
	}//

	public int getAge() {
		return age;
	}//

	public String getEmail() {
		return email;
	}//

	public char getInitial() {
		return initial;
	}//
	
	public String toString() {
		return "�̸� : " + name + ", ���� : " + age + ", �̸��� : " + email + ", �̴ϼ� : " + initial + "\n";
	}
	
//get method ���� �κ� - ��

}// Ŭ���� �ʵ� ����
