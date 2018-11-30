package day1129;

/**
 * @author owner<br>
 *         ����� ���� Ư¡�� PersonŬ���� �κ��� ����ϰ� �ڽŸ��� Ư¡��(�ο��� ���Ѵ�)����
 *
 */
public class HongGilDong extends Person {

	private int level; // ȫ�浿�� �ο򷹺�

	/**
	 * ȫ�浿�� �ο��� ��κ��� ���ϹǷ� 7�� ����
	 */
	public HongGilDong() {
		super();
		level = 7;
	}// HongGilDong

	/**
	 * �ο��ϴ� �޼ҵ� : �Էµ� �������� ���ٸ� ��, �Էµ� �������� ���ٸ� �¸� �Էµ� ������ ���ٸ� ���. �¸��ϸ� ������ 1����, �й�
	 * �ϸ� ���� 1����, ���� ������ȭ ���� ������ �ִ� 10, �ּ� 1�� ������.
	 * 
	 * @param inputLevel - �ο� ������� ����
	 * @return �ο��� ���
	 */
	public String fight(int inputLevel) {
		String result = "";

		if (level > inputLevel) { // �¸�
			result = "�̰��.s('.^)V";
			level++;
			if (level > 10) {
				level = 10;
			} // end if
		} else if (level < inputLevel) { // �й�
			result = "����.~(_-_)~";
			level--;
			if (level < 1) {
				level = 1;
			} // end if
		} else { // ���
			result = "��� --+;;";
		} // end else if

		return result;
	}
	
	/**
	 * PersonŬ������ eat()�� HongGilDongŬ�������� �������̵�.<br>
	 * ���) �Ĵ� --> �ָ�
	 * ȭ�����) �� --> ��
	 */
	@Override
	public String eat(String menu, int price) {
		return getName() + "�� �ָ����� " + menu + "�� ������ " + price + "�� ���� ��Դ´�.";
	}
	
	@Override
	public String toString() {
		return "ȫ�浿 ��ü�� �� : " + getEye() + ", �� : " + getNose() + ", �� : " + getMouth();
	}
	
}//
