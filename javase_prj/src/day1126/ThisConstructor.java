package day1126;

/**
 * @author owner this�� ����� ������ ȣ��
 *
 */
public class ThisConstructor {

	public ThisConstructor() {
		System.out.println("�⺻������");
	}// �⺻������

	public ThisConstructor(int i) {
		this(); // this(); �� ������ �޼ҵ忡�� ������ 1��°�ٿ� ���;� �Ѵ�.
		System.out.println("���� �ִ� ������ : " + i);
	}// �⺻������

	public static void main(String[] args) {
		new ThisConstructor(22); // ��ü�� �ѹ��� ������ ��
	}

}
