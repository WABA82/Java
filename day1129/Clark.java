package day1129;

/**
 * @author owner<br>
 * ����� ����Ư¡�� Person���� �����ٰ� ����ϰ� �ڽŸ��� Ư¡�� ������ Ŭ����<br>
 *
 */
public final class Clark extends Person {
	
	public int power;
	
	/**
	 * �⺻ ������ : ��ü�� �����Ǹ� power�� 9�� �����˴ϴ�.
	 */
	public Clark() { //�⺻ ������
		super(3,1,1);
		power = 9;
	}// ��
	
	/**
	 * �ԷµǴ� ���� ������ ���� ���� ��ȭ�� �ް��ϰ� ��ȭ�Ѵ�.
	 * @param stone ���� ����
	 * @return ���� ��ȭ
	 */
	public String power(String stone) {
		String result = "";
		
		//���� ���� ��ȭ�ϴ� ���� ��ȭ
		if(stone.equals("Ŭ���䳪��Ʈ")) {
			power = 0;
			result = "���� ���� ~(_-_)~";
		}else if(stone.equals("���̾Ƹ��")) {
			power = 10;
			result = "�����մϴ�. ~m(^o^)m~";
		}else {
			power = 12;
			result = "������. --+";
		}// end else~if;
		
		return result;
	}

	@Override
	public String eat() {
		return getName() + "��(��) ������ ���� �Դ´�.";
	}

	@Override
	public String eat(String menu, int price) {
		return getName() + "��(��) ����������� " + menu + "�� ������ " + price + "�޷� ���� ��Դ´�.";
	}
	
}//Clark Ŭ����

