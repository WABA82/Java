package day1119;

/**
 * ���ǹ��� ���<br> 
 * ���� if�� : ���ǿ� �´� ��쿡�� �ڵ带 �����ؾ��� ��.<br>
 * ����) <br>
 * if(���ǽ�){<br>
 * ���ǿ� ���� �� ���� �����...;<br>
 * 			}
 * 
 * @author Owner
 */

public class TestIf {
	
	//Constant : ������ ���ó�� ����� ��. (���� �������� ���ϴ� ����)
	public static final int FLAG_VALUE = 1250;
	public static final int FLAG_CNT = 20;

	public static void main(String[] args) {

		int i = -10;

		if (i < 0) {
			i = -i;
		} // end if
		System.out.println(i);

		// �̸��� �Է¹޾� �̸��� "������"�̸� �̸��� ����ϱ� ��
		// "������" ����ϰ� �׷��� �ʴٸ� �̸��� ���
		if (args[0].equals("������")) {			
				System.out.println("����");			
		}
		System.out.println( args[0] );
		
		//���������� ���ڿ��� ������ ��ȯ
		int p = Integer.parseInt(args[1]);
		int j = Integer.parseInt(args[2]);
		
		System.out.println(p + " + " +  j + " = " + (p+j));

		// args[3]�� �Է¹޾� �� ���� 20�̳� ��� 1250�� �Է¼��� ���Ͽ� ����ϰ� �׷��� ������ 20���� ũ�ٸ� 1250�� 10%�� ����
		// ���� �Է¼��� ���Ͽ� ���
		int input_value = Integer.parseInt(args[3]);
		int sum = TestIf.FLAG_VALUE;
		
		if ( input_value < TestIf.FLAG_CNT ) {
			sum = (int)(TestIf.FLAG_VALUE + TestIf.FLAG_VALUE * 0.1); 
		}// end if
			System.out.println(sum * input_value);

	}// main

}// class
