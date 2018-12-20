package day1204;

/**
 * @author owner<br>
 *         ����Ŭ������ static���� ó�� ����� �� �ִ� ��øŬ����.
 *
 */
public class NestedOuter {

	int i;
	static int j = 12;

	// �⺻������.
	public NestedOuter() {
		System.out.println("�ٱ�Ŭ������ ������");
	}

	// �ٱ�Ŭ������ �ν��Ͻ� �޼ҵ�
	public void outInstMethod() {
		System.out.println("�ٱ� Ŭ������ �ν��Ͻ� �޼ҵ�");
	}

	// �ٱ�Ŭ������ �ν��Ͻ� �޼ҵ�
	public static void outStaticMethod() {
		System.out.println("�ٱ� Ŭ������ ����ƽ �޼ҵ�");
	}

	/* Nested Ŭ���� ���� */
	static class NestedInner {
//		�ν��Ͻ����� - ����ƽ Ŭ���������� �ν��Ͻ��ڿ��� �������� �ʴ´�.
//		int in_i; 
		static int in_j;// ����ƽ����

		public void inMethod() {
			System.out.println("���� Ŭ������ �ν��Ͻ� �޼ҵ�");
		}

		public static void inStatMethod() {
			System.out.println("���� Ŭ������ �ν��Ͻ� �޼ҵ�\n");

			System.out.println("���ʿ��� �ٱ�Ŭ������ �ڿ� ����� static�� ����� �� �ֽ��ϴ�. " + NestedOuter.j);

			// �ٱ� Ŭ������ �ν��Ͻ��ڿ� ���.
			NestedOuter no = new NestedOuter();
			no.outInstMethod();
		}

	}
	/* Nested Ŭ���� �� */

	public static void main(String[] args) {

		// static ������ ����� ������ ��üȭ���� Ŭ������.������,
		// Ŭ������.�޼ҵ������ ����Ѵ�.

//		NestedOuter no = new NestedOuter();
		NestedInner.inStatMethod();

	}
}
