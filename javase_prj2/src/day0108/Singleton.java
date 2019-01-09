package day0108;

/**
 * @author owner<br>
 *         ���� �� �� JVM���� �ϳ��� ��ü�� ���������, �ϳ��� ��ü�� ���Ǵ� Pattern.
 */
public class Singleton {
	private static Singleton single;

	/* 1.Ŭ�����ܺο��� ��üȭ�� �� �� ������ private�� �����. */
	private Singleton() {
	}// ������

	public static Singleton getInstance() {
		/* ��ü�� �����Ǿ� ���� �ʴٸ� ��ü�� ���� */
		if (single == null) {
			single = new Singleton();
		} // end if

		/* ��ü�� �̹� �ִٸ� �����Ǿ� �ִ� ��ü�� ��ȯ�ȴ� */
		return single;
	}// getInstance

}// class
