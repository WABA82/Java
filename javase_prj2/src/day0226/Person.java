package day0226;

public class Person {

	private String name;

	public Person(String name) {
		this.name = name;
		System.out.println("���Ի�� " + name + "�� �Ի��ϼ̽��ϴ�.");
	}// ������

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println(name + "���� ����ϼ̽��ϴ�.");
	}

	public String getName() {
		return name;
	}// getName()

}// class
