package day1129;

/*
 * 
 */
/**
 * @author owner<> ��Ӱ����� ��Ŭ���� : ����ڽ��� ������ �� Ư¡ ���� �θ𿡰� ���ǵ� �ڵ�� �ڽĿ��� ����� �� �ִ�.
 */
public class TestSuper {

	public int pub_i; // ��� �ִ� �ڽ��̵� �ڽĿ��� ��밡��.
	protected int pro_i; // ���� ����Ű�� �ڽ�, �ٸ� ��Ű������ ��밡��
	private int pri_i; // �θ�Ŭ���� �ȿ����� ��밡��.
	int def_i; // ���� ��Ű���� �ڽĿ��� ��밡��, ��Ű���� �ٸ��� ���Ұ�

	public TestSuper() {
		System.out.println("�θ�Ŭ������ �⺻������");
	}
	public void SuperMethod() {
		System.out.println("�θ�Ŭ������ �⺻������");
	}

}
