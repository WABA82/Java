package day0226;

/**
 * Garbage Collector�� ȣ���Ͽ� ��ü�� �Ҹ� ��Ű��(�޸��� ���������� Ȯ���ȴ�.)
 * 
 * @author owner
 *
 */
public class UseGarbageCollector {

	public static void main(String[] args) {
		Person p = new Person("������");
		p = new Person("������");
		p = new Person("���ü�");
		p = new Person("������");
		p = new Person("������"); // ���� �������� �ּҰ� ����.

		System.gc(); // ������ �ݷ��͸� ȣ���ϸ� �ڵ����� finalize()�޼ҵ� ȣ����. - ���� �������� �ּҸ� ������ ������ �ּҵ��� ������ �ȴ�.

		System.out.println("���� ��� : " + p.getName()); // ���� ����� Ȯ��.
	}// main

}// class
