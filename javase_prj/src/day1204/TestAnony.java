package day1204;

/**
 * @author owner<br>
 *         �������̽��� �޼ҵ��� �Ű������϶� ����ϴ� ���.<br>
 * 
 */
public class TestAnony {

	public void useAnonyInter(AnonyInter ai) {
		System.out.println(ai.getmsg() + " " + ai.getname());
	}

	public static void main(String[] args) {
		// �������̽��� �����ϰ� ����Ŭ������ ����� is a ���谴üȭ�� �Ѵ�.
		AnonyInter ai = new AnonyImpl();
		// TestAnony�� �ν��Ͻ��ڿ��� ����ϱ� ���� ��üȭ
		TestAnony ta = new TestAnony();

		// �ν��Ͻ��޼ҵ� ȣ��
		ta.useAnonyInter(ai);

		System.out.println("-----------���ϴ� �͸�Ŭ������ ����Դϴ�.-----------");

		/* �͸�Ŭ���� ���� */
		ta.useAnonyInter(new AnonyInter() {

			@Override
			public String getname() {
				return "������" + test();
			}

			@Override
			public String getmsg() {
				return "�´���";
			}

			public String test() {
				return " ������ �޼ҵ�";
			}

		});
		/* �͸�Ŭ���� ���� */

	}
}
