package day0313;

public class TestVO {

	private String firstName;
	private int age;

	public TestVO() {
		System.out.println("TestVO�� �⺻ ������");
	}// ������

	public TestVO(String firstName, int age) {
		this.firstName = firstName;
		this.age = age;
		System.out.println("TestVO�� �����ִ� ������");
	}// �����ִ� ������

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getAge() {
		return age;
	}

}// class
