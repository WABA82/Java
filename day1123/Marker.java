package day1123;

/**
 * @author owner ��ī���� ������� �����Ͽ�, �߻�ȭ�� �����ϰ� ������� Ŭ����<br>
 *         ��ī�� - ����� Ư�� : ��, ��, �Ѳ� =&gt; ���� <br>
 *         ��ī�� - ������ Ư�� : ���� =&gt; �޼ҵ� <br>
 * 
 *         ����)<br>
 *         �⺻�����ڸ� ����Ͽ� ��ü�� ������ �� setter method�� ȣ���Ͽ� ���� ������ �� ����Ѵ�.<br>
 *         Marker m = new Marker();<br>
 *         m.setXxx(��); <br>
 * 
 *         Ŭ������ ��������� �ڷ����̰� ������ ������Ÿ���̴�.
 *
 */
public class Marker {
	private String color; // ��ī���� ��
	private int body; // ��ī���� ��ü�� ����
	private int cap; // ��ī���� �Ѳ��� ����

	/**
	 * �⺻������ : ��ī�� ��ü�� �����Ǹ� ������, �Ѳ�1��, ��ü1���� ��ī�� ��ü�� �����մϴ�.<br>
	 * 11-26-2018 �ڵ� �߰�
	 */
	public Marker() {
		this("������", 1, 1);
		System.out.println("��ī �⺻������");
//		�����ִ� �����ڸ� ȣ���Ͽ� ���� ����.
//		color = "������";
//		body = 1;
//		cap = 1;
	}// �⺻������

	/**
	 * �⺻������ �����ε� - ���ڰ� �ִ� ��ī���� �����ϴ� ������.
	 * 
	 * @param color - ��ī���� ����
	 * @param cap   - �Ѳ��� ����
	 * @param body  - ��ü�� ����
	 */
	public Marker(String color, int cap, int body) {
		this.color = color;
		this.cap = cap;
		this.body = body;
		System.out.println("��ī �����ε��� ������");
	}// ������ �����ε�

	/**
	 * ������ ��ī�� ��ü�� ���� �����ϴ� ��.<br>
	 * ������,�Ķ���,�������� �����Ѵ�. �� �̿��� ���� ���������� ó���Ѵ�.
	 * 
	 * @param color �� �Է�
	 */
	public void setColor(String color) {
		// �ν��Ͻ������� ������ ���� ���� ���� ����.
		if (!(color.equals("������") || color.equals("�Ķ���") || color.equals("������"))) {
			color = "������";
		}
		this.color = color;
	}

	/**
	 * ������ ��ī�� ��ü�� ��ü�� ������ �����ϴ� ��.
	 * 
	 * @param body ��ü ���� �Է�
	 */
	public void setBody(int body) {
		this.body = body;
	}

	/**
	 * ������ ��ī�� ��ü�� �Ѳ��� ������ �����ϴ� ��.
	 * 
	 * @param cap �Ѳ� ���� �Է�.
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}

	/**
	 * ������ ��ī�� ��ü�� ���� ��ȯ�ϴ� �޼ҵ�
	 * 
	 * @return color
	 */
	public String getColor() {
		return color;
	}// getColor

	/**
	 * ������ ��ü�� ������ �ִ� ��ü�� ����
	 * 
	 * @return body
	 */
	public int getBody() {
		return body;
	}

	/**
	 * ������ ��ü�� ������ �ִ� �Ѳ��� ����
	 * 
	 * @return cap
	 */
	public int getCap() {
		return cap;
	}

	/**
	 * �Էµ� �޼����� ������ ��ī������ ĥ�ǿ� ���� ��.
	 * 
	 * @param msg ���ڿ� �޽��� �Է�
	 * @return �� + ���ڿ�
	 */
	public String write(String msg) {
		return color + "�� ��ī������ ĥ�ǿ�\"" + msg + "\"�� ����";
	}
}// ��Ŀ Ŭ����
