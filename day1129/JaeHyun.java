package day1129;

/**
 * @author owner<br>
 *         Person Ŭ������ ��� �޾� ���� ���� �ϴ� Ŭ���� �Դϴ�.
 */
public class JaeHyun extends Person {

	// ���� ���� �Ƿ� - �ɹ�����
	public int pesLevel;

	public JaeHyun() {

		/*
		 * 1.��üȭ�Ҷ��� �⺻ �� - �ʱ�ȭ. 
		 * 2.pesLevel = 1~10����.
		 */
		pesLevel = 5;
	}

	// ������ �� ����� ��ȯ�ϴ� �޼ҵ�
	public String pesLevel(int otherLevel) {
		// ����� ���� ����ϴ� ���׼� - ����
		String result = "";

		if (pesLevel > otherLevel) {
			pesLevel++;
			result = "�̰��. ^^";
			if (pesLevel > 10) {
				pesLevel = 10;
			}
		} else if (pesLevel < otherLevel) {
			pesLevel--;
			result = "......";
			if (pesLevel < 1) {
				pesLevel = 1;
			}
		} else {
			result = "����...�� �� ������";
		}

		return result;
	}

}
