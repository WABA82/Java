package day0313;

public class TestVO {

	private String firstName;
	private int age;

	public TestVO() {
		System.out.println("TestVO의 기본 생성자");
	}// 생성자

	public TestVO(String firstName, int age) {
		this.firstName = firstName;
		this.age = age;
		System.out.println("TestVO의 인자있는 생성자");
	}// 인자있는 생서자

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
