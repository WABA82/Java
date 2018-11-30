package day1127;

/**
 * @author owner<br>
 *         �ֹι�ȣ �Է¹޾� ó���ϴ� ���α׷� �ۼ�.<br>
 *         �� �۾��� method �����ϰ� ȣ���Ͽ� ����� �޾Ƽ� ó��.<br>
 *         1-1. �����ڴ� �ֹι�ȣ�� �޾� instance������ �Ҵ��Ѵ�.<br>
 *         1-2. �ֹι�ȣ�� ���̸� üũ�Ͽ� 14�ڰ� �ƴϸ� false��ȯ<br>
 *         1-3. �ֹι�ȣ�� 6��° �ڸ��� '-'�� �ƴϸ� false��ȯ<br>
 *         1-4. �ֹι�ȣ�� ��ȿ�������� ��ȿ�ϸ� true/false��ȯ 234567892345�� ���� ���� ���Ͽ� 11�� ����
 *         ������ ���� ��� 11���� �� ���� ���� 10���� ���� �������� �ֹι�ȣ�� ���ڸ��� ���ٸ� true/false<br>
 *         1-5 ��������� ��ȯ�Ѵ� ��. "1988-11-11"<br>
 *         1-6 ���̸� ��ȯ�ϴ� �� 31<br>
 *         1-7������ ��ȯ ��, ��<br>
 *         1-8 ������/�ܱ��� ��ȯ 1234 / 5678<br>
 *         1-9 �� ��ȯ "���"<br>
 *
 */
public class Work {

	private String ssn;
	private String birthYear;

	// 1-1. �����ڴ� �ֹι�ȣ�� �޾� instance������ �Ҵ��Ѵ�.<br>
	public Work(String ssn) {
		this.ssn = ssn.substring(0, (ssn.indexOf('-'))) + ssn.substring((ssn.indexOf('-') + 1));
		System.out.println(this.ssn);
	}// �ֹι�ȣ �Է� �޴� ������

	// 1-2. �ֹι�ȣ�� ���̸� üũ�Ͽ� 14�ڰ� �ƴϸ� false��ȯ<br>
	public boolean ssnCheck() {
		boolean flag = (ssn.length() == 14);
//		if (ssn.length() == 14) {
//			flag = true;
//		} // if ����
		return flag;
	}

	// 1-3. �ֹι�ȣ�� 6��° �ڸ��� '-'�� �ƴϸ� false��ȯ<br>
	public boolean ssnCheck1() {
		boolean flag = (ssn.indexOf("-") == 6);
//		if (ssn.indexOf("-") == 6) {
//			flag = true;
//		}
		return flag;
	}

	/*
	 * 1-4. �ֹι�ȣ�� ��ȿ�������� ��ȿ�ϸ� true/false��ȯ 234567892345�� ���� ���� ���Ͽ� 11�� ���� ������ ���� ���
	 * 11���� �� ���� ���� 10���� ���� �������� �ֹι�ȣ�� ���ڸ��� ���ٸ� true/false
	 */
	public boolean ssnCheck2() {
		boolean flag = false;
		String numssn = ssn.substring(0, 12);
		int[] temp = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };
		int value = 0;

		for (int i = 0; i < 12; i++) {
			value = value + (temp[i] * Integer.parseInt(numssn.substring(i, i + 1)));
		}

		if (((11 - (value % 11)) % 10) == Integer.parseInt(ssn.substring(12, 13))) {
			flag = true;
		}
		return flag;
	}

	// 1-5 ��������� ��ȯ�Ѵ� ��. "1988-11-11"<br>
	public String retbirth() {

		String year = "";
		String birth = ssn.substring(0, 2) + " - " + ssn.substring(2, 4) + " - " + ssn.substring(2, 4);

		if (ssn.substring(7, 8).equals("0") || ssn.substring(7, 8).equals("9")) {
			year = "18";
		} else if (ssn.substring(7, 8).equals("1") || ssn.substring(7, 8).equals("2") || ssn.substring(7, 8).equals("5")
				|| ssn.substring(7, 8).equals("6")) {
			year = "19";
		} else if (ssn.substring(7, 8).equals("3") || ssn.substring(7, 8).equals("4") || ssn.substring(7, 8).equals("7")
				|| ssn.substring(7, 8).equals("8")) {
			year = "20";
		}

		birthYear = (year + ssn.substring(0, 2));

		return year + birth;
	}// �޼ҵ�3��

//	-------------------------------------------------------------------------------------------------------------------------------------���⼭ ���� �ϱ� 

	// 1-6 ���̸� ��ȯ�ϴ� �� 31<br>
	public int retage() {
		int age = 0;
		int thisyear = 2018;
		int birthyear = Integer.parseInt(birthYear);
		age = (thisyear - birthyear) + 1;
		return age;
	}

	// 1-7������ ��ȯ ��, ��<br>
	public String retgender() {
		String gender = "��";

		return gender;
	}

	// 1-8 ������/�ܱ��� ��ȯ 1234 / 5678<br>
	public String retNation() {
		String nation = "�ܱ���";
		
		return nation;
	}

	// 1-9 �� ��ȯ "���"<br>
	public String retBand() {
		int birth = 1990;
		String[] KBAND = { "������", "��", "��", "����", "��", "��", "ȣ����", "�䳢", "��", "��", "��", "��" };

		return KBAND[birth % 12];
	}

	public static void main(String[] args) {
		// test��ü ����
		Work test = new Work("123456-1234567");
		System.out.println(test.ssnCheck2());

	}// ���� �޼ҵ�

}// Ŭ���� �ʵ�
