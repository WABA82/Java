package day1129;

import java.util.Arrays;

/**
 * @author owner<br>
 *         ����� ���� ��������(���� ���� Ŭ����) ����Ͽ� �迭�� ����<br>
 *         ������ �迭 �ϳ��� �������� �پ��� ���� �����ϰ� ����� �� �ִ�.<br>
 *
 */
public class UseCalssArray {

	public UseCalssArray() {
		//1. ����) ��������[] �迭�� = null;
		Data[] dataArr = null;
		
		//2. ����)
		dataArr = new Data[4];
		
		//3. �Ҵ�) �迭�� [���� ��ȣ] = new ������();
		dataArr[0] = new Data("������",27,"gong@daum.net",'G');
		dataArr[1] = new Data("�����",29,"kim@daum.net",'K');
		dataArr[2] = new Data("������",25,"choi@daum.net",'C');
		//����� �Ҵ� ���) ��ü���� �� ���� �߰�
		Data d = new Data();
		dataArr[3] = d;
		//�ּҴ� �ϳ� �̹Ƿ� �迭���� ����Ͽ� �޼ҵ带 ȣ�� �Ǵ� ��ü���� ����Ͽ� method�� ȣ���ϵ� �����ϰ� ���� ����ȴ�.
		dataArr[3].setName("���ü�");
		dataArr[3].setAge(26);
		d.setEmail("jung@jung.net");
		d.setInitail('D');
		
//		System.out.println(Arrays.toString(dataArr));// �ּ� ���
		
		//4. ���)
		//�迭������ ���.
		System.out.println(dataArr[0].getName());
		//��ü�� �����Ͽ� ���.
		Data temp = dataArr[0];
		System.out.println(temp.getName());
		
		//5. for) �ϰ�ó��
		Data tempData = null;
		for(int i = 0 ; i < dataArr.length ; i++) {
			tempData = dataArr[i];
			System.out.println("[" + tempData.getName() + "] ," +
								"[" + tempData.getAge() + "] ," +
								"[" + tempData.getEmail() + "] ," +
								"[" + tempData.getInitial() + "]" );
		}
		
		System.out.println("");
		
		// for~each)
		for(Data tempData1 : dataArr) {
			System.out.println("[" + tempData1.getName() + "], " +
					"[" + tempData1.getAge() + "], " +
					"[" + tempData1.getEmail() + "], " +
					"[" + tempData1.getInitial() + "]" );
		}
		
		
	}

	public static void main(String[] args) {
		new UseCalssArray();
	}

}
