package day1207;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author owner Map : KVP�� �Ǿ��ִ� �ڷᱸ��, Ű�� ����Ͽ� ���� ��� ��.
 *
 */
public class UseMap {

	public UseMap() {
		// 1.5 ������ ��� ���׸� ���Ұ�, ��ü�� ��밡��.
		Map<String, String> map = new HashMap<>();

		// �Ҵ�) - Ű�� ����, ���� �ߺ�����, ������� ���� �߰� ���� �ʴ´�.
		map.put("Oracle", "��뷮 �����ͺ��̽�");
		map.put("Java", "���α׷��� ���");
		map.put("Python", "���α׷��� ���");
		map.put("Java", "�Ϻ��Ѱ�ü������."); // ���� Ű�� ����ϸ� ���߿� �Էµ� Ű�� �����.
		map.put("HTML", "Markup Language"); // ���� Ű�� ����ϸ� ���߿� �Էµ� Ű�� �����.
		System.out.println(map.size() + " / " + map);

		// ���) - Ű�� ����Ͽ� ���� ���� �� �ִ�. - ã�� Ű�� ���ٸ� null�� ��ȯ�Ѵ�.
		String val = map.get("Java");
		String val1 = map.get("HTML1"); // - ���� Ű�� �־��� ��.
		System.out.println(val);
		System.out.println(val1);

		// Ű�� �����ϴ� ��?)
		String key = "Java";
		boolean flag = map.containsKey(key);
		System.out.println(key + " Ű�� ���� " + flag);

		// Map�� �� ����
		map.remove(key);
		System.out.println("���� �� : " + map);

		// ��� Ű ��� - Set���.
		Set<String> allKey = map.keySet();
		System.out.println("���� ���� ��� Ű : " + allKey);

		// ��� �� ��� - Iterator
		Iterator<String> ita = allKey.iterator();
		String value = "";
		while (ita.hasNext()) {
			// �� Ű�� ����Ͽ� Map�� ���� ��´�.
			value = map.get(ita.next());
			System.out.println(value);
		}

		// ����
		map.clear();
		System.out.println("��� ���� : " + map.size() + " / " + map);

	}// ������

	/**
	 * �⺻�����ڸ� ����ϸ� 16���� ���� �ڵ�����.<br>
	 * ��Ƽ�����忡�� �������� ����.<br>
	 * �����Ͱ� ��ü �� ������ �� 75%ä������ �� ���� ���� �˻��� �Ѵ�.<br>
	 */
	public void useHashMap(String key) {
		Map<String, String> map = new HashMap<>();

		// �Ҵ�)
		map.put("���ʺ���", "Ǯ�� ���� ������ ���´�.");
		map.put("��������", "���濡 ���忡�� �����Ѵ�.");
		map.put("���乫��", "�ƹ��͵� ���� ������ �� �ݷ��ϰ� �ƹ��͵� ���� �ʰڴ�.");
		map.put("���γ���", "�����ϸ� �θǽ� �ϰ��ϸ� �ҷ�.");
		map.put("�̺θ�õ", "���� ��� ��ȥ�ϸ� ��õ���� ���ϸ� ��õ����.");
		map.put("��������", "�� ���� ���� ����");
		map.put("����ġ��", "�Լ��� ������ ¡�׷�����.");
		map.put("���ü���", "���α��� �ڶ�.");

		// �� ���)
		if (map.containsKey(key)) {
			String value = map.get(key); // �� ���
			System.out.println(key + " �� ���� " + value);
		} else {
			System.out.println(key + " ���ڼ���� �غ���� �ʾҽ��ϴ�.");
		}
	}

	/**
	 * �⺻�����ڸ� ����ϸ� 11���� ���� �ڵ�����.<br>
	 * ��Ƽ�����忡�� �������� �Ұ���.<br>
	 * �����Ͱ� ��ü �� ������ �� 75%ä������ �� ���� ���� �˻��� �Ѵ�.<br>
	 */
	public void useHashTable(String key) {
		Map<String, String> bloodmap = new Hashtable<>();

		// �� �Ҵ�)
		bloodmap.put("A", "�����ϴ�.ģ���ϴ�. ^o^b");
		bloodmap.put("B", "�����巴�� --");
		bloodmap.put("AB", "������ @.,@");
		bloodmap.put("O", "�����δ��ϴ�.~(^^~)(~^^)~");
		bloodmap.put("A", "�ҽ��ϴ�.");

		// �� ��� )
		String value = bloodmap.get(key.toUpperCase());

		if (!bloodmap.containsKey(key.toUpperCase())) {
			System.out.println(key + "�������� ����� ���� �ƴմϴ�.");
		} else {
			System.out.println(key.toUpperCase() + "Ư¡�� : " + value);
		} // end if
	}// useHashTable

	public static void main(String[] args) {
		UseMap um = new UseMap();

		System.out.println("----------------�ؽ����̺� ���----------------");
		um.useHashTable("b");
		System.out.println("----------------�ؽø� ���----------------");
		um.useHashMap("�ϳ��ϳ�");
	}// main

}// class
