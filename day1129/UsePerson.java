package day1129;

import java.util.Date;

public class UsePerson {

	public static void main(String[] args) {
		HongGilDong gd = new HongGilDong();
		gd.setName("ȫ�浿"); // Person�� �޼ҵ� ���
		System.out.println("�� : " + gd.getEye() + ", �� : " + gd.getNose() + ", �� : " + gd.getMouth());
		System.out.println(gd.eat());
		System.out.println(gd.eat("����", 1));

		// �ڽŸ��� Ư¡
		System.out.println(gd.fight(6));// 7 -> 8
		System.out.println(gd.fight(7));// 8 -> 9
		System.out.println(gd.fight(9));// ��� 9 -> 9
		System.out.println(gd.fight(10));// ���� 9 -> 8
		System.out.println(gd.fight(9));// ���� 8 -> 7

		System.out.println("------------------------------");

		// Clark Ŭ������ Person�� Ŭ������ ��� ����.
		Clark superman = new Clark();

		// person Ŭ���� �޼ҵ� ���
		superman.setName("Ŭ�� ĵƮ"); // person�� �޼ҵ�
		System.out.println(superman.getEye() + " / " + superman.getNose() + " / " + superman.getMouth() + " / "
				+ superman.getName());
		System.out.println(superman.eat());
		System.out.println(superman.eat("������ũ", 10));

		// Clark Ŭ���� �޼ҵ� ���
		String stone = "¯��";
		System.out.println(stone + "�� ���� ��� " + superman.power(stone) + "���� ��ȭ : " + superman.power);

		stone = "Ŭ���䳪��Ʈ";
		System.out.println(stone + "�� ���� ��� " + superman.power(stone) + "���� ��ȭ : " + superman.power);

		stone = "���̾Ƹ��";
		System.out.println(stone + "�� ���� ��� " + superman.power(stone) + "���� ��ȭ : " + superman.power);

		System.out.println("------------------------------");

		// JaeHyunŬ������ PersonŬ������ ��� ����
		JaeHyun jay = new JaeHyun();
		jay.setName("����");
		
		//PersonŬ������ �޼ҵ� ���
		System.out.println(jay.getEye() + " / " + jay.getNose() + " / " + jay.getMouth() + " / "
				+ jay.getName());
		System.out.println(jay.eat());
		System.out.println(jay.eat("������ũ", 10));

		//JaeHyun Ŭ���� �޼ҵ� ���
		int otherLevel = 1;
		System.out.println(otherLevel + "�� ���� �� ��� " + jay.pesLevel(otherLevel) + "������ ��ȭ : " + superman.power);
	}

}
