package day1203;

/**
 * @author owner<br>
 *         ����Ŭ�������� ������ �޼ҵ带 ����Ŭ����(����Ŭ����)���� ������������ �������̵��ؾ� �Ѵ�.<br>
 *         �������̽����� ��ӿ��� �߻�޼ҵ带 �������̵� ���� �ʴ´�. ������ ������ �� ���� ������...<br>
 *
 */
public interface SuperInterface extends InterA, InterB { // �������̽��z �θ� ������ ���� �� �ִ�.

	// ���� X ����� ����� �� �ִ�.
	public static final int FLAGVALUE = 12;

	// �Ϲ� �޼ҵ� X �߻�޼ҵ常 ����� �� �ִ�.
	// abstract ���� �����ϴ�.
	public abstract void method_A();

	public abstract void method_B(int i);

}
