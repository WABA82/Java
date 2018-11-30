package day1115;
/*
 ����
1. ������ �Ҵ�� ���� ����϶��� 2������ ����ϰ� ������� ~�� ����Ͽ�
    ����� �����ϰ� �Էµ� �״���� 10������ ���.
    ��� ��)  " ��� �ΰ��"  10��  1010
                 "���� �ΰ��"  -10 �� 10

2. 2147483647�� ������ ���� 2byte�� ���� 2byte ���� �и��Ͽ� ����غ�����. 
    ��� ��) ���� 2byte -> 32767
                ���� 2byte - > 65535

3. ||�� ������� �� ������ true��� ������ �������� �ʴ� ���� ������ �� �ִ�
     �ڵ带 �ۼ��ϼ���.
*/
class Work {
	public static void main(String[] args) {
		
		int i = 10;
		int j = 2147483647;
		boolean flag1, flag2, flag3;


		
		/*
		1. ������ �Ҵ�� ���� ����϶��� 2������ ����ϰ� ������� ~�� ����Ͽ� ����� �����ϰ� �Էµ� �״���� 10������ ���.
		��� ��)	"��� �ΰ��"  10��  1010
				"���� �ΰ��"  -10 �� 10
		*/
		System.out.println( i >=0 ? "����� ���"+ i + "��(��)" + Integer.toBinaryString(i) : "������ ���"+ i + "��(��)" + (~i + 1) );
		
		System.out.println("-------------------------------------------"); // �ٹٲ�
		

		/*
		2. 2147483647�� ������ ���� 2byte�� ���� 2byte ���� �и��Ͽ� ����غ�����. 
		��� ��) ���� 2byte -> 32767
                ���� 2byte - > 65535
		*/
		System.out.println("���� 2byte -> " + (j>>16) + ", ���� 2byte -> " + (j>>47));
		System.out.println("���� 2byte -> " + (j>>16) + ", ���� 2byte -> " + (j&0x0000FFFF));
		
		System.out.println("-------------------------------------------"); // �ٹٲ�

		/*
		3. ||�� ������� �� ������ true��� ������ �������� �ʴ� ���� ������ �� �ִ� �ڵ带 �ۼ��ϼ���.
		*/
		
		flag1 = true;
		flag2 = true;
		flag3 = true;

		flag3 =	(flag1 = 1>0) ||
				(flag2 = 1<0); // ������ false�̳� ������ true�̹Ƿ� �������� �ʴ´�.

		System.out.println("���� : " + flag1 + ", ���� : " + flag2  + ", ��ü���� : " + flag3);

		
		
	}
}