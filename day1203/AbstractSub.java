package day1203;

/**
 * @author owner<br>
 *         �߻�Ŭ������ ��ӹ޾� �߻�޼ҵ带 �����ϴ� ����Ŭ����
 */
public class AbstractSub extends AbstractSuper {

	public void subMethod() {
		System.out.println("���� �޼ҵ�!!!!!!!");
	}

	@Override
	public void absMethod() {
		// �߻� �޼ҵ�� ���۷� ȣ���� �� ����.
		System.out.println("�������̵��� ����Ŭ������ �޼ҵ�");
	}

	@Override
	// ���� ������(Ȯ�۵Ǵ� ������) ��ȯ��, �̸�, �Ű������� ���ƾ� �Ѵ�.
	public String absMethod1(int i) {
		return String.valueOf(i).concat("- ����");
	}

	public static void main(String[] args) {
		// �ڽ�Ŭ������ ��üȭ �Ǹ� �߻�Ŭ������ ��üȭ�� �ȴ�.
		AbstractSub as = new AbstractSub();
		// �ڽ�Ŭ������ ��üȭ : �θ��� ����, ,method, �ڽ��� ���� method
		as.i = 12;
		// ����Ŭ������ �Ϲ� �޼ҵ�.
		as.method();

		// �������̵��� ����Ŭ������ �޼ҵ�.
		as.absMethod();
		System.out.println(as.absMethod1(3));
		as.subMethod();

		// is a ������ ��üȭ : ��ü������
		// ����Ŭ������ ��ü�� = new ����Ŭ����������();
		AbstractSuper as1 = new AbstractSub();

		// ������ �ڿ� ��� ����
		as1.i = 100;
		as1.method();

		// ���꿡�� �������̵��� �޼ҵ尡 ������ ������ �������̵��� �޼ҵ� ���.
		as1.absMethod();
		System.out.println(as1.absMethod1(2018));
		
		//is a ����� ��üȭ �ϸ� �ڽ��� ���� �޼ҵ�� ȣ�� �Ұ�
	}

}
