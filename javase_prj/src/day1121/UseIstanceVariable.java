package day1121;

/**
 * @author owner Instance(member) ���� : ��ü�� ������ �� �޸�(Heap)�� �Ҵ� �ǰ�, �� �ּҸ� ������
 *         ����(��ü, instance, object)�� ����Ͽ� �����ϴ� ����.<br>
 *         �ڵ��ʱ�ȭ�� �ȴ�.
 */
public class UseIstanceVariable {

	// �ν��Ͻ� ���� ����
	int i; // ������ �ʱ�ȭ�� 0
	int j;
	double d; // �Ǽ��� �ʱ�ȭ �� 0.0
	char c; // ������ �ʱ�ȭ�� \u0000
	boolean b; // �Ҹ��� �ʱ�ȭ �� false;
	String str; // ����������Ÿ�� �ʱ�ȭ�� null;
	UseIstanceVariable jaehyun; // ����������Ÿ�� �ʱ�ȭ�� null;

	public static void main(String[] args) { // static ������ ���� ���� �޸�(method����)�� �ε� �ǹǷ�, ���������� �𸣴� instance������ ��� �� �� ����.

		// ��üȭ�� �ϸ� ��ü�� �޸�(heap)�����ǰ�, �� �ּҸ� �޸�(stack)�� ����
		// ��üȭ ���� : Ŭ������ ��ü�� = new Ŭ������();
		UseIstanceVariable a = new UseIstanceVariable(); // ����-stack�޸� = ����-heap�� ����
		UseIstanceVariable b = new UseIstanceVariable();

		// ��üȭ�� ��ü�� Ŭ�������� heap�ּ� ����
		System.out.println("��ü ���(heap�ּ�) " + a);
		System.out.println("��ü ���(heap�ּ�) " + b);

		a.i = 300;
		a.j = 500;

		System.out.println("a��ü�� �ɹ����� i = " + a.i);
		System.out.println("a��ü�� �ɹ����� i = " + a.j);

		// �ν��Ͻ�(�ɹ�) ������ �ڵ� �ʱ�ȭ�� �ȴ�.
		System.out.println("b ��ü i : " + b.i + ", b ��ü j : " + b.j);

		// --------------------------------------------------------------------------�߿�-----------------------------------------------------------------------------------------//
		System.out.println(); // �ٹٲ�
		System.out.println("----------------------�ڵ� �ʱ�ȭ ��-------------------");
		System.out.println("������ : " + b.i);
		System.out.println("�Ǽ��� : " + b.d);
		System.out.println("������ : " + b.c);
		System.out.println("�Ҹ��� : " + b.b);
		System.out.println("������ : " + b.str);
		System.out.println("������ : " + b.jaehyun);
		// --------------------------------------------------------------------------�߿�-----------------------------------------------------------------------------------------//
	}

}
