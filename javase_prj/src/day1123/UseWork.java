package day1123;

/**
 * @author j : WorkŬ������ ����ϴ� �޼ҵ� �Դϴ�.
 *
 */
public class UseWork {

	public static void main(String[] args) {

		// ��ü����
		Work shinramyun = new Work(2,1);

		shinramyun.setMaker("���");
		shinramyun.setName("�Ŷ��");
//		shinramyun.setNuddle(1);
//		shinramyun.setCntSoup(2);

		// ��ü�� �Է��� ���� ��ȯ �޾ƺ���
		System.out.printf("������ ��鰴ü ������ : ������[%s], ����̸�[%s], ��������[%d], ���ǰ���[%d] \\n ", shinramyun.getMaker(),
				shinramyun.getName(),  shinramyun.getCntSoup(), shinramyun.getNuddle());

		// ��ü�� �۵� Ȯ��
		System.out.println(shinramyun.being_ramyun());
		System.out.println(shinramyun.being_ramyun(3));
	}

}
