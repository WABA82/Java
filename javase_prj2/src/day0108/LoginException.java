package day0108;

/**
 * @author owner<br>
 *         ����� ���� ���� ó�� Ŭ����<br>
 *         Exception/RuntimeException ���
 */
@SuppressWarnings("serial")
public class LoginException extends Exception {

	public LoginException() {
		this("�α��� ����");
	}// ������

	public LoginException(String msg) {
		super(msg); // ����ó�� ��ü�� ����Ͽ� ���ܸ޼����� ��� �� �� �ִ�.
	}// ������
}// class
