package day0423;

public class TestService2 {

	private TestDAO td;// ������ ���� ���� ��ü�� �ν��Ͻ� ������ �����Ѵ�.
	private TestDAO2 td2;// ������ ���� ���� ��ü�� �ν��Ͻ� ������ �����Ѵ�.

	public TestService2() {
		System.out.println("�⺻ �����ڸ� ����Ͽ� ��ü ����.");
	}// ������

	// interface�� ������ ���� ������ ������� �ȴ�.
	public TestService2(TestDAO td, TestDAO2 td2) {
		this.td = td;
		this.td2 = td2;
		System.out.println("�Ű������� �������� �������� ������ ����");
	}// ������

}// class
