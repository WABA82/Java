package day1203;

public class TestSub2 extends TestSuper {

	int i;

	public TestSub2() {
		super();
		System.out.println("����Ŭ����2 ������");
	}

	public void subMethod() {
		System.out.println("����Ŭ����2 �޼ҵ�");
	}

	@Override
	public void printI() {
		System.out.println("����Ŭ����2���� �������̵��� printI�޼ҵ� : " + i + ", ����Ŭ������ i = " + super.i);
	}

}
