package day1203;

public class TestSub extends TestSuper {

	int i;

	public TestSub() {
		super();
		System.out.println("����Ŭ���� ������");
	}

	public void subMethod() {
		System.out.println("����Ŭ���� �޼ҵ�");
	}

	@Override
	public void printI() {
		System.out.println("����Ŭ�������� �������̵��� printI�޼ҵ� : " + i + ", ����Ŭ������ i = " + super.i);
	}

}
