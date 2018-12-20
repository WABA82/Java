package day1218;

/**
 * @author owner<br>
 *         ��ü ���� : �����Ǵ� ��ü�� Cloneable�������̽��� �ݵ�� �����ؾ� �մϴ�.
 *
 */
public class ObjectClone implements Cloneable {

	private int i;

	public static void main(String[] args) {
		ObjectClone oc = new ObjectClone();
		oc.i = 100;

		try {
			ObjectClone oc1 = (ObjectClone) oc.clone();
			System.out.println("���� ����");
			System.out.println("���� : " + oc + "/ ������ : " + oc1);
			oc.i = 200;
			System.out.println("���� : " + oc.i + "/ ������" + oc1.i);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	} // ���� �޼ҵ� //

} // Ŭ���� //
