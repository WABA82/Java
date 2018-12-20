package day1206;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author owner<br>
 *         List : �ߺ����� ����ϸ� �˻��� ����� �ְ�, ������� ���� �Է��ϴ� ������ ������Ÿ��.<br>
 *
 */
public class UseList {

	// ������
	public UseList() {
		/* JCF1.4 ���� : */
		// JDK1.4������ Generic�� �������� �ʰ� ��ü�� ����ȴ�.
//		List a_list = new ArrayList();
//		// �� �߰� : jdk1.5 ���� ������ ��ü�θ� ���� ���� �� �ֽ��ϴ�.
//		a_list.add(new Integer(10));
//		a_list.add(new Short((short) 10));
//		a_list.add("������");
//		System.out.println(a_list.size());
//		System.out.println(((Integer) a_list.get(0)).intValue() + 10);

		/* JCF1.5 �̻� : ���׸�, ����ڽ�, ��ڽ� */
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(new Integer(30));
//		list.add("�����"); - ���׸��� ����߱� ������ ���������� ��ġ ���Ѿ� �Ѵ�.

		System.out.println("ũ��" + list.size());
		System.out.println(list.get(0) + 10);

		// for�� ���.
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	// �޼ҵ�
	public void useArrayList() {
		ArrayList<String> al = new ArrayList<>(); // �� �������� ����
		List<String> al1 = new ArrayList<>(100); // ���� ũ�⸦ ������

		// �� �߰� : ������� �߰��ȴ�.
		al.add("������");
		al.add("���ü�");
		al.add("������");
		al.add("�����");
		al.add("������"); // �ߺ��� ���尡��.
		al.add("������");
		al.add("������"); // �ߺ��� ���尡��.
		al.add("������");
		// Ȯ��
		System.out.println(al + " / " + al1);
		// ���� ũ��
		System.out.println("al ũ��" + al.size() + " / al1�� ũ�� : " + al1.size());

		// �迭�� �����ϱ�
		String[] names = new String[al.size()];
		al.toArray(names);

		// Ư�� �ε��� �� ���� :
		al.remove(4);
		System.out.println(al.size() + " / " + al);
		// ���� ������ ���� :
		al.remove("������");
		System.out.println(al.size() + " / " + al);

		// for each����
		for (String name : al) {
			System.out.println(name);
		}

		// ��� ���� �� ���� :
		al.clear();
		System.out.println("��ü ���� �� : " + al.size() + " / " + al);

		// �迭�� ��
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);
		}
		System.out.println();

	}

	// �޼ҵ�
	public void useVector() {

		Vector<String> vec = new Vector<String>(); // �� �������� ����
		List<String> vec1 = new Vector<String>(100); // ���� ũ�⸦ ������

		// �� �߰� : ������� �߰��ȴ�.
		vec.add("������");
		vec.add("���ü�");
		vec.add("������");
		vec.add("�����");
		vec.add("������"); // �ߺ��� ���尡��.
		vec.add("������");
		vec.add("������"); // �ߺ��� ���尡��.
		vec.add("������");
		// Ȯ��
		System.out.println(vec + " / " + vec1);
		// ���� ũ��
		System.out.println("vec ũ��" + vec.size() + " / al1�� ũ�� : " + vec1.size());

		// �迭�� �����ϱ�
		String[] names = new String[vec.size()];
		vec.toArray(names);

		// Ư�� �ε��� �� ���� :
		vec.remove(4);
		System.out.println(vec.size() + " / " + vec);
		// ���� ������ ���� :
		vec.remove("������");
		System.out.println(vec.size() + " / " + vec);

		// for each����
		for (String name : vec) {
			System.out.println(name);
		}

		// ��� ���� �� ���� :
		vec.clear();
		System.out.println("��ü ���� �� : " + vec.size() + " / " + vec);

		// �迭�� ��
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);
		}
		System.out.println();
	}

	// �޼ҵ�
	public void useLinkedList() {
		LinkedList<String> ll = new LinkedList<>(); // �� �������� ����
		List<String> ll1 = new LinkedList<>(); // ���� ũ�⸦ ������

		// �� �߰� : ������� �߰��ȴ�.
		ll.add("������");
		ll.add("���ü�");
		ll.add("������");
		ll.add("�����");
		ll.add("������"); // �ߺ��� ���尡��.
		ll.add("������");
		ll.add("������"); // �ߺ��� ���尡��.
		ll.add("������");
		// Ȯ��
		System.out.println(ll + " / " + ll1);
		// ���� ũ��
		System.out.println("ll ũ��" + ll.size() + " / al1�� ũ�� : " + ll1.size());

		// �迭�� �����ϱ�
		String[] names = new String[ll.size()];
		ll.toArray(names);

		// Ư�� �ε��� �� ���� :
		ll.remove(4);
		System.out.println(ll.size() + " / " + ll);
		// ���� ������ ���� :
		ll.remove("������");
		System.out.println(ll.size() + " / " + ll);

		// for each����
		for (String name : ll) {
			System.out.println(name);
		}

		// ��� ���� �� ���� :
		ll.clear();
		System.out.println("��ü ���� �� : " + ll.size() + " / " + ll);

		// �迭�� ��
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		UseList ul = new UseList();
		System.out.println("----------ArrayList----------");
		ul.useArrayList();
		System.out.println("------------Vector-----------");
		ul.useVector();
		System.out.println("----------LinkedList----------");
		ul.useLinkedList();
	}

}
