package day1120;


/**
 * �پ��� for�� ����
 * @author owner
 */
public class TestFor2 {
	
	public static void main(String[] args) {
		//���ѷ���
//		for ( ; ; ) {
//			System.out.println("���ѷ���");
//		}//end for
//		System.out.println(""); // ERR : ���ѷ��� ������ ���� �ڵ�� ����
		
		
		//�����ϴ� ���ѷ���
		for (int i = 0 ; ; i++) {
			System.out.println(i + "��");
			if(i == 50 ) {
				break; // ���� for������ break�� ������ �ִ� for���� ����������.
			}
		}//�����ϴ� ���ѷ���
		
		//�������� ������ �ִ� for��
		for (int i = 0 , j = 10, k = 30 ; i < 10; i++, j++, k--) {
			System.out.println(i + " " + j + " " + k);
		}
		
		//���ǽ��� �߸� �����ϸ� ����loop
		//for (false) �̸� ���ѷ����� ����. 
//		for (int i = 0 ; i  < 10 ; i--) {
//			
//		}
		
		int i = 0;
		for ( i = 0 ; i < 10 ; i ++); {
			System.out.println( "�ݺ��� " + i );
		}
		
	}//main
	
}//class
