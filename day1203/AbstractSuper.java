package day1203;

/**
 * @author owner<br>
 *         ����� �������� ����� ����Ŭ����-��üȭ�� ���� �ʴ´�.<br>
 *         �ڽ�Ŭ������ �ݵ�� �����ؾ��� �߻�޼ҵ带 ������.<br>
 */
public abstract class AbstractSuper {

	int i;

	public AbstractSuper() {
		// �ڽ�Ŭ������ ������ ���� ȣ��ȴ�.
		System.out.println("AbstractSuper ����Ŭ���� ������ �Դϴ�.");
	}

	public void method() {
		System.out.println("����Ŭ������ ���� �ϴ� �Ϲ� �޼ҵ�");
	}

	// �߻� �޼ҵ� ��� ���� ����Ŭ�������� ������ ����(�������̵�)�ؾ� �Ǵ� ����� ����
	public abstract void absMethod();

	public abstract String absMethod1(int i);

//	public static void main(String[] args) {
//		new AbstractSuper();
//	}// ���� �޼ҵ�
}// �߻�Ŭ���� �ʵ�
