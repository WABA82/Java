package day1119;


/**
 *	else~if : ������ ���� ������ ���� ��. <br>
 *	����) <br>
 *		if(���ǽ�) { <br>
 *			���ǿ� ���� �� ���� ����; <br>
 *		}else if (���ǽ�) { <br>
 *			���ǿ� ���� �� ���� ����; <br>
 *		}else if (���ǽ�) { <br>
 *			���ǿ� ���� �� ���� ����; <br>
 *		}else	{ <br>
 *			��� ���ǿ� ���� ���� �� ������ ����;
 *		}
 *
 * @author owner
 */
public class TestElseIf {
	public static final int BAND = 12;
	public static final String[] KBAND = { "������", "��", "��", "����", "��", "��", "ȣ����", "�䳢", "��", "��", "��", "��" };

	public static void main(String[] args) {
		
		int i = Integer.parseInt(args[0]);
		
		System.out.print( i + "��(��) ");
		if (i < 0 ) {
			System.out.println("0���� �۾Ƽ� ����");
		} else if ( i > 100 ) {
			System.out.println("100���� Ŀ�� ����");
		} else {
			System.out.println("�Է¼���");			
		}// end if
			
		//�̸��� �Է� �޾� "������"�̸� ���� "�̺���, �ڿ���, ������, ������" �̸� ������ �׷��� ������ "���"�� �̸� �տ� ����ϼ���. "��å �̸�"
		String i_value = args[1];
	
		if ( i_value.equals( "������") ) {
			System.out.print("���� ");
		} else if(i_value.equals( "�̺���") || i_value.equals( "�ڿ���") || i_value.equals( "������") || i_value.equals( "������")) {
			System.out.print("���� ");
		}else {
			System.out.print("��� ");
		}
		System.out.println(i_value + "�� �ȳ��ϼ���.");
		
		// �¾��(1995)�� �Է¹޾� ��(12) ���ϱ�
		// �� �� �� �� �䳢 ȣ���� �� �� ���� �� �� ������
		// 11 10 9 8 7 6 5 4 3 2 1 0
		
		int i_birth = Integer.parseInt( args[2] );
		if (i_birth % BAND == 11) {
			System.out.println("��");			
		} else if (i_birth % BAND == 10) {
			System.out.println("��");			
		} else if (i_birth % BAND == 9) {
			System.out.println("��");			
		} else if (i_birth % BAND == 8) {
			System.out.println("��");			
		} else if (i_birth % BAND == 7) {
			System.out.println("�䳢");			
		} else if (i_birth % BAND == 6) {
			System.out.println("ȣ����");			
		} else if (i_birth % BAND == 5) {
			System.out.println("��");			
		} else if (i_birth % BAND == 4) {
			System.out.println("��");			
		} else if (i_birth % BAND == 3) {
			System.out.println("����");			
		} else if (i_birth % BAND == 2) {
			System.out.println("��");			
		} else if (i_birth % BAND == 1) {
			System.out.println("��");			
		} else if (i_birth % BAND == 0) {
			System.out.println("������");			
		} else {
			System.out.println("�츦 �� �� �� �����ϴ�.");
		}//end if
		
		int j =0;
		int birth = Integer.parseInt( args[2] );
		j = birth%KBAND.length;
		System.out.println(KBAND[j]);

	}// main

}// class
