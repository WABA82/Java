package day1203;

/**
 * @author owner<br>
 *         Default�޼ҵ� : �������̽����� �߻�޼ҵ尡 �ƴѵ����� �� �ִ� �޼ҵ�<br>
 *         Default�޼ҵ带 ����ϱ� ���ؼ��� ������ ��üȭ�� �ؾ��Ѵ�. - �������̽�Ŭ������ ���������� ��üȭ�� �� �� ����
 *         ������ is a������ ��üȭ�� �ؾ��Ѵ�.
 */
public interface UseDefault {
	public void test();

	public default void temp() {
		System.out.println("�������̽����� ����Ʈ �޼ҵ带 ����� ����Դϴ�.");
	}
}
