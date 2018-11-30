package day1126;

/**
 * @author owner Ŭ������ ��ü�� ������ �� �⺻������ ������ �־���� �⺻���� �����ϰų�, �⺻������ ����� �ڵ带 �����ϴ�
 *         method ����.
 *
 */
public class TestConstructor {

	/**
	 * �⺻������ - default ������ : Ŭ������ ������� �� �������� ������ Ŭ������ �̸��� ���� �޼ҵ尡 �Բ� ����� ����. �������Ϸ���
	 * �̿��ϸ� ���� ����.
	 */
	public TestConstructor() {
		System.out.println("�⺻ ������");
//		TestConstructor(300); -- �����ڸ� �޼ҵ� ȣ���ϵ� ȣ���� �� ����.
	}// ������ �޼ҵ�

	/**
	 * �����ִ� ������ : �⺻�������� �����ε�.
	 * 
	 * @param i - ������ ��
	 */
	public TestConstructor(int i) {
		System.out.println("�����ִ� ������" + i);
	}// ������ �޼ҵ�

	public void test() {
		System.out.println("�׽�Ʈ�� �޼ҵ�");
		temp();
	}//�׽�Ʈ
	public void temp() {
		System.out.println("-------------------------���� �޼ҵ�!!!");
	}//����

	public static void main(String[] args) {

		// �����ε� �� �����ڸ� ����Ͽ� ��üȭ�� �پ��ϰ� �� �� ����.
		TestConstructor tc = new TestConstructor();
		TestConstructor tc1 = new TestConstructor(1);

		System.out.println(tc);
		System.out.println(tc1);
		
		tc.test();

	}// ���� �޼ҵ�

}// Ŭ����