package day1123;

/**
 * @author owner ��ī���� ������ Ŭ������ ����ϴ� Ŭ����<br>
 *         4.��ü���� 5.������ ��ü ���.
 *
 */
public class UseMarker {

	public static void main(String[] args) {
		// ������ ��ī�� 1�� ����
		Marker black = new Marker();

		//�����ڸ� ���� �߱� ������ set�޼ҵ带 ����� �ʿ� ����.
//		black.setColor("������");
//		black.setBody(1);
//		black.setCap(1);
		
		System.out.printf("������ ��ī�� ��[%s], ��ü[%d], �Ѳ�[%d]\n", black.getColor(), black.getBody(), black.getCap());

		// ������ ��ü�� ���.
		System.out.println(black.write("�ȳ��ϼ���!"));

		System.out.println();

		// ������ ��ī�� 5�� ���� 
		Marker red = new Marker("������",5,5); //�����ε� �� ������ ���.

		System.out.printf("������ ��ī�� ��[%s], ��ü[%d], �Ѳ�[%d]\n", red.getColor(), red.getBody(), red.getCap());
		// ��ü�� ���.
		System.out.println(red.write("���� ������ ��Ŀ �Դϴ�. "));

	}// ���� �޼ҵ�

}// Ŭ����
