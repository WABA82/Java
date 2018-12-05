package day1205;

/**
 * @author owner<br>
 *         ���ڿ��� ���޸𸮿� �����ϰ� ����ϴ� Ŭ���� - StringBuffer, StringBuilder.<br>
 *
 */
public class UseStringBuilder {

	public void useStringBuffer() {
		StringBuffer sb = new StringBuffer();

		// .append() : ���� �߰��ϰ� ���ڿ��� ��ȯ.
		sb.append("������ ").append(12).append("�� 5�� ").append("������ �Դϴ�.");
		System.out.println(sb);

		// .insert(�ε���, ��) : ���� ����.
		sb.insert(3, " 2018��");
		System.out.println(sb);

		// .delete(�����ε���, ���ε��� + 1) : ���� ����.
		sb.delete(0, 2);
		System.out.println(sb);

		// .reverse() : ���ڿ� �Ųٷ�
		sb.reverse();
		System.out.println(sb);

	}

	public void useStringBuilder() {
		StringBuilder sb = new StringBuilder();

		// .append() : ���� �߰��ϰ� ���ڿ��� ��ȯ.
		sb.append("������ ").append(12).append("�� 5�� ").append("������ �Դϴ�.");
		System.out.println(sb);

		// .insert(�ε���, ��) : ���� ����.
		sb.insert(3, " 2018��");
		System.out.println(sb);

		// .delete(�����ε���, ���ε��� + 1) : ���� ����.
		sb.delete(0, 2);
		System.out.println(sb);

		// .reverse() : ���ڿ� �Ųٷ�
		sb.reverse();
		System.out.println(sb);
	}

	public static void main(String[] args) {
		UseStringBuilder usb = new UseStringBuilder();

		usb.useStringBuilder();

		usb.useStringBuffer();

		String str = "�ȳ��ϼ���?";
		System.out.println(str);

		// �� ���ڿ� : �����ڸ� ����ϴ� ���ڿ��� �� ���ڿ��̶� �Ѵ�.
		String str1 = "��";
		// new
		// StringBuilder().append(str1).append("��").append("��").append("��").append("��?");
		System.out.println(str1 + "��" + "��" + "��" + "��?");

	}

}
