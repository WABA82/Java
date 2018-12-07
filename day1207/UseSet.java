package day1207;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.xml.sax.Locator;

import day1129.Person;

/**
 * @author owner<br>
 *         JCF - Set�� ��� : �˻��� ����� ������(get x), �ߺ����� �������� �ʴ� ���.
 *
 */
public class UseSet {

	public UseSet() {
		// 1.5 ���Ͽ����� ���׸��� �������� �ʰ� ��ü�� ����.
		Set<String> set = new HashSet<String>();
		set.add("���ü�");
		set.add("������");
		set.add("������");
		set.add("������");
		set.add("������");
		set.add("������");
		set.add("�̺���");
		set.add("������"); // �ߺ����� �������� �ʴ´�.
		System.out.println(set.size() + " / " + set);
		set.remove("������"); // ����������
		System.out.println(set.size() + " / " + set);

		// �迭�� ����
		String[] names = new String[set.size()];
		set.toArray(names);
		for (String temp : set) {
			System.out.println(temp);
		}

		// set�� ��� ��(Element)�� �� ���
		Iterator<String> ita = set.iterator();
		String name = "";
		while (ita.hasNext()) {
			name = ita.next(); // �ش����� ���� ���
			System.out.println(name);
		} // end while

		// ��� ���� �� ����
		set.clear();
		System.out.println("clear�޼ҵ� ��� �� " + set);
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}// constructor

	public int[] lotto() {
		int[] lottoNum = new int[6];
		Random random = new Random();
		for (int i = 0; i < lottoNum.length; i++) {
			lottoNum[i] = random.nextInt(45) + 1; // �ߺ� ���� �߻� �� �� �ִ�.
			for (int j = 0; j < i; j++) {
				if (lottoNum[i] == lottoNum[j]) {
					i--;
//					break;
				}
			}
		}

		return lottoNum;
	}

	public Integer[] lottoUseSet() {
		Integer[] lottoNum = new Integer[6];
		Set<Integer> set = new HashSet<>();
		Random random = new Random();
		for (;;) {
			set.add(random.nextInt(45) + 1); // �ߺ� ���� �߻� �� �� �ִ�.
			if (set.size() == 6) {
				break;
			}
		}
		set.toArray(lottoNum);

		return lottoNum;
	}

	public static void main(String[] args) {
		UseSet us = new UseSet();

		int[] lotto = us.lotto();

		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);

		}

		System.out.println("���ϴ� Set�� ����� ����Դϴ�.");

		Integer[] lottoUseSet = us.lottoUseSet();

		for (int i = 0; i < lottoUseSet.length; i++) {
			System.out.println(lottoUseSet[i]);

		}

	}// main

}// class
