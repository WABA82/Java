package day1207;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * ���� 1.
 * main method�� arguments�� ��¥�� ������ �Է� �޾� 
 * �Է¹��� ��¥�� ������ �����ϰ� ����ϴ� method �� �ۼ��ϼ���.
 * ��) java Test 4 12 30 32 35 15 4   
 * ���) 4 ȭ 12 �� 15 �� 30 ��   
 */
public class Work {

	private String[] titleOfWeek = { "��", "��", "ȭ", "��", "��", "��", "��" };

	public Work() {

	}

	public void set(String i_day) {

//		int init_day = Integer.parseInt(i_day);
		Set<String> daySet = new HashSet<>();

		// �Էµ� �Ű������� daySet�� �߰�. 
		daySet.add(i_day);

		Iterator<String> it = daySet.iterator();

	}

	public void get() {

	}

	public static void main(String[] args) {

		Work work = new Work();
		String i_day = "1";

		work.set(i_day);

	}
}
