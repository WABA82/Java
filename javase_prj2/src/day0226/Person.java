package day0226;

public class Person {

	private String name;

	public Person(String name) {
		this.name = name;
		System.out.println("신입사원 " + name + "님 입사하셨습니다.");
	}// 생성자

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println(name + "님이 퇴사하셨습니다.");
	}

	public String getName() {
		return name;
	}// getName()

}// class
