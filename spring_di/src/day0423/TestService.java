package day0423;

public class TestService {

	private TestDAO td;// ������ ���� ���� ��ü�� �ν��Ͻ� ������ �����Ѵ�.

	public TestService() {
		System.out.println("�⺻ �����ڸ� ����Ͽ� ��ü ����.");
	}// ������

	// interface�� ������ ���� ������ ������� �ȴ�.
	public TestService(TestDAO td) {
		this.td = td;
		System.out.println("������ ������ ����");
	}// ������

	/* method ������ ���� */

	// method ������ ���� : �ݵ�� �⺻�����ڰ� �����ؾ� �Ѵ�.
	public void setTd(TestDAO td) {
		this.td = td;
	}// setTd

	// method ������ ���� : �ݵ�� �⺻�����ڰ� �����ؾ� �Ѵ�.
	public TestDAO getTd() {
		return td;
	}// setTd

}// class
