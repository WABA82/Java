package day1206;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * ����
 * 1. �Ʒ��� �����͸� ó���ϴ� ���α׷��� �ۼ��ϼ���.
 * "������,�̺���,������,���ü�,������,������"�� �����Ͱ� �����ϰ�, ������ 0~100�� ���̷� �߻��� �� �ֽ��ϴ�.
 * ���α׷��� ����Ǹ� ���� ����߿� 2�� �̻��� ����ó�� ����� �̰�, 2���� �̸��� ������ �����Ͽ� ����ϴ� ���� �ϴ� ���α׷� �ۼ�.
 * �ߺ� �̸��� �� �� ����.
 * 
 * ��� ��)
 * ������ 89
 * ���ü� 77
 * ������ 90
 * 
 * ���� xx��
 */
public class Work1206 {

	public static void main(String[] args) {

		// ListŬ����
		ArrayList<String> name = new ArrayList<>();

		// RandomŬ����
		Random r = new Random();

		name.add("������");
		name.add("�̺���");
		name.add("������");
		name.add("���ü�");
		name.add("������");
		name.add("������");

		// ���� ũ�� Ȯ��)
		System.out.println(name.size());

		int[] score = { r.nextInt(101), r.nextInt(101), r.nextInt(101), r.nextInt(101), r.nextInt(101),
				r.nextInt(101) };

		String[] nameArr = new String[name.size()];
		name.toArray(nameArr);

		// �迭 Ȯ��)

		String temp;
		int random;

		for (int i = 0; i < 6; i++) {
			random = r.nextInt(6);
			temp = nameArr[i];
			nameArr[i] = nameArr[random];
			nameArr[random] = temp;
		}

		for (int i = r.nextInt(5); i < nameArr.length; i++) {
			System.out.print(nameArr[i] + " ");
			System.out.println(score[i]);
		}

	}

}
