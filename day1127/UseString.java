package day1127;

/**
 * @author owner ���ڿ� ������� �ּҸ� �����ϰ�, ���ڿ��� �ٷ�� ����� �����ϴ� ��Ʈ��Ŭ������ �޼ҵ� ���.<br>
 *         �ڹٿ��� �����ϴ� Ŭ������ �̸��� ���� ���� Ŭ������ �̸��� ���ٸ� ���� ���� Ŭ������ ���� ����Ѵ�.<br>
 *         �ڹٿ��� �����ϴ� Ŭ������ ��� �� ������ "full path : ��Ű������ ��� ����Ͽ� Ŭ������ ����ϴ� ��"�� ����ؾ�
 *         �Ѵ�.
 *
 */
public class UseString {

	public static void main(String[] args) {
		System.out.println("�ȳ�");
		// �⺻�� ���� ���. String s = "���ڿ�";
		String str = "AbcdEfg";
		// ������ ���� ���. String s = new String("���ڿ�")
		String mail = new String("vkfqkddl123@naver.com");

		// ���ڿ� Ȯ��
		System.out.println(str);
		System.out.println(mail);

		// ���ڿ��� ���� : .length()
		System.out.println(str + "�� ���� " + str.length());
		System.out.println(mail + "�� ���� " + mail.length());

		// ���ڿ��� ��� �빮�ڷ� : .toUpperCase()
		System.out.println(str + "�� �빮�ڷ�" + str.toUpperCase());
		System.out.println(mail + "�� �빮�ڷ� " + mail.toUpperCase());

		// ���ڿ��� ��� �ҹ��ڷ� : .toLowerCase()
		System.out.println(str + "�� �ҹ��ڷ� " + str.toLowerCase());
		System.out.println(mail + "�� �ҹ��ڷ� " + mail.toLowerCase());

		// �ε��� ã�� : .indexOf("���ڿ�")
		System.out.println(str + "���� 'd'�� �ε��� : " + str.indexOf("d"));
		System.out.println(str + "���� 'z'�� �ε��� : " + str.indexOf("z"));
		System.out.println(mail + "���� \"@\"�� �ε��� : " + mail.indexOf("@"));

		// �ڿ��� ���� �ε��� ã�� : .lastIndexOf("���ڿ�")
		str = "AbcdEfAg"; // ���ͷ� ����
		System.out.println(str + "���ڿ� �ڿ��� ���� 'A'�� �ε��� : " + str.lastIndexOf("A"));

		// Ư�� �ε����� ���ھ�� : .charAt(2)
		System.out.println(str + "���� 2 �ε����� �ش��ϴ� ���� " + str.charAt(2));

		// ���ڿ�(sub) �ڸ��� : .subString();
		System.out.println(str + "���� 2~5��° �ش��ϴ� ���ڿ� " + str.substring(2, 5)); // ���� "cdE"�� ���´�. 5�� �ε��� �ձ����� ���(null����
																				// ������)
		System.out.println(mail + "���� ���� �ּҸ� ��� " + mail.substring(0, mail.indexOf("@"))); // "@"�� �ε��� ��ȣ ���� ���
		System.out.println(mail + "���� ������ �ּҸ� ��� " + mail.substring(mail.indexOf("@") + 1, mail.length())); // "@"�� �ε���
																											// ��ȣ ���� ���
		// .subString()�� ���� �ε����� �ְԵǸ� ���ڿ��� ���ۺ��� ������ ��ȯ
		System.out.println(mail + "���� ������ �ּҸ� ��� " + mail.substring(mail.indexOf("@") + 1)); // "@"�� �ε��� ��ȣ ���� ���

		// �յ� ���� �ڸ��� : .trim()
		str = "   A BC   "; // ���ͷ� ����
		System.out.println("[" + str + "] ���� �յڰ������� [" + str.trim() + "]");

		// ���ڿ� ���̱�
		str = "Abcd"; // ���ͷ�����
		String str1 = str.concat("Efg");
		String str2 = str + "Efg";
		System.out.println(str1);
		System.out.println(str2);

		// ���ڿ� �Ϻ��ϰ� ������ �� : .equlas("���ڿ�");
		str = "������";
		System.out.println(str + "��(��) " + (str.equals("������") ? "����" : "���"));

		// ���ڿ��� �� ���ڿ��� �����ϴ��� : .startsWith("���ڿ�")
		str = "�Ǿ���";
		if (str.startsWith("����")) {
			System.out.println("���� ����ϽǼ� �����ϴ�.");
		} else {
			System.out.println(str);
		}

		str = "����� ������";
		System.out.println(str + "��(��) " + (str.startsWith("����") ? "�����" : "��⵵"));

		// Ư�� ���ڿ��� ��������
		str = "����� ������ ���ﵿ";
		System.out.println(str + "��(��) " + (str.endsWith("��") ? "����" : "�ð�"));

		// ġȯ-���ڿ� ���� ��� ���ڿ��� ã�Ƽ� ���� : .replace()
		str = "�� ���� �Ǿ����ε� �� ���� �������!";
//		System.out.println(str.replace("����", "**"));
		System.out.println(str.replace("��", "*").replaceAll("��", "*"));
		
		// ġȯ�� ����� ������ empty�� �����ϱ�
		str = "   A  BC  ";
		System.out.println(str.replace(" ", ""));
		
		// �⺻������Ÿ���� String���� �����ϱ� : String.valueOf()
		int i = 27;
		System.out.println(String.valueOf(i));
		double d = 11.27;
		str = d+""; //+ empty�� �̿��ؼ� ���ڿ��� ����� ������ �޼ҵ带 ����ϴ°� �� ����.
		System.out.println(str);
		
		//��ü ������ ���� �ʾ��� �� �� Ŭ������ �����ϴ� �޼ҵ带 ����� �� ����.
		str = ""; //empty�� ��ü�� �����Ǿ����� ���� ���� ��.
		str = null; //null�� String ��ü�� �������� ���� ��.
//		System.out.println(str.isEmpty());
		
		////////////////////////////////////11-28-2018 split�޼ҵ� ��� �ڵ� �߰� ////////////////////////////////////////
		
		String data = "123456-1234567";
		
		//.split() : �޼ҵ忡�� .���� �����ϱ� ���ؼ��� [.]���� �ۼ��ؾ� �Ѵ�.
		String[] arr = data.split("-");
		System.out.println("���е� �迭 ���� ���� : " + arr.length);
		
		System.out.println(arr[1]);
		
		for(String name : arr) {
			System.out.println(name);
		}
		
	}// ���� �޼ҵ�

}// Ŭ����
