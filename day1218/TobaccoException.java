package day1218;

/**
 * @author owner<br>
 *         ����� ���� ����ó�� Ŭ����
 */

/* 1. Exception�̳� RuntimeException�� ��� �޴´�. */
@SuppressWarnings("serial")
public class TobaccoException extends RuntimeException {

	public TobaccoException() {
		this("��迹�� - ����� ���� ��! �׷��� �ǿ�ðڽ��ϱ�?");
	}

	public TobaccoException(String msg) {
		super(msg);
	}

}
