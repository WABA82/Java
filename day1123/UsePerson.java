package day1123;

/**
 * @author owner ����� �߻�ȭ �Ͽ� ���� Person Ŭ������ ����ϴ� Ŭ���� �Դϴ�.
 *
 */
public class UsePerson {

	public static void main(String[] args) {
		
		//��ü ���� : heap�� �����ǰ� instance ������ �ڵ� �ʱ�ȭ�� �˴ϴ�.
		Person teaksung = new Person();
		teaksung.setName("���ü�");

//		�⺻������ ����
//		teaksung.setEye(2);
//		teaksung.setNose(1);
//		teaksung.setMouth(1);
		
		//������ ��ü Ȯ���ϱ�.
		System.out.format("������ ��� ��ü ���� : ��[%d], ��[%d], ��[%d], �̸�[%s] \n", teaksung.getEye(),teaksung.getNose(), teaksung.getMouth(), teaksung.getName());
		
		//������ ��ü���� ���ǵ� ���� ���.
		System.out.println(teaksung.eat());
		System.out.println(teaksung.eat("��ȸ�����",8000));
		
		System.out.println("----------------------------------------------------------------");
		
		//��ü ���� : heap�� �����ǰ� instance ������ �ڵ� �ʱ�ȭ�� �˴ϴ�.
		Person jinban = new Person(3, 1, 1);
				jinban.setName("õ����");
				
				//������ ��ü Ȯ���ϱ�.
				System.out.format("������ ��� ��ü ���� : ��[%d], ��[%d], ��[%d], �̸�[%s] \n", jinban.getEye(),jinban.getNose(), jinban.getMouth(), jinban.getName());
				
				//������ ��ü���� ���ǵ� ���� ���.
				System.out.println(jinban.eat());
				System.out.println(jinban.eat("����",1));
		
		
	}

}
