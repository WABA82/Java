package day1115;
/*
�������� : 
	-�Ϲݳ�
		&& : ���װ� ������ ��� ���϶��� ���̴�.

		|| : ���װ� ������ ��� �����϶��� ������ ��ȯ�Ѵ�.
	
	-��Ʈ��
		& : ������Ʈ�� ������Ʈ ��� 1�� ��� 1�� ������.
		
		| : ������Ʈ�� ������Ʈ ��� 0�� ��� 0�� ������.
		
		^ : ������Ʈ�� ������Ʈ �߿��� ���� �ϳ��� 1�� ��쿡 1�� ������.
*/
class Operator5 {
	public static void main(String[] args) {
		boolean flag1 = true, 
				flag2 = false, 
				flag3 = true, 
				flag4 = false;

		int i = 0, j = 0;

		//�ص� ����
		System.out.println("-------------&&-------------");
		System.out.println(flag1 + "&&" + flag3 + " = " + (flag1 && flag3));
		System.out.println(flag1 + "&&" + flag2 + " = " + (flag1 && flag2));
		System.out.println(flag2 + "&&" + flag1 + " = " + (flag2 && flag1));
		System.out.println(flag2 + "&&" + flag4 + " = " + (flag2 && flag4));

		//���� ����
		System.out.println("-------------||-------------");
		System.out.println(flag1 + "||" + flag3 + " = " + (flag1 || flag3));
		System.out.println(flag1 + "||" + flag2 + " = " + (flag1 || flag2));
		System.out.println(flag2 + "||" + flag1 + " = " + (flag2 || flag1));
		System.out.println(flag2 + "||" + flag4 + " = " + (flag2 || flag4));


		System.out.println("----------------------------");
		flag1 = false;
		flag2 = false;
		flag3 = false;
		// AND���� ������ false�̸� ������ ������ ���� �ʴ´�.
		flag3 = (flag1 = 3>4) && (flag2 = 5>4); //flag2�� true ������ flag1�� false�̱� ������ ���ױ��� ������ ���� �ʴ´�.
		System.out.println("���� : " + flag1 + ", ���� : " + flag2 + ", ��ü���� : " + flag3 );

		//��Ʈ�� 
		System.out.println("----------------------------");

		i = 28; // 0001 1100
		j = 48; // 0011 0000
		System.out.println(i + " & " + j + " = " + (i&j)); // 16

		i = 16; // 0001 0000
		j = 3;	// 0000 0011
		System.out.println(i + " | " + j + " = " + (i|j)); // 19
		
		i = 10; // 0000 1010
		j = 12; // 0000 1100
		System.out.println(i + " ^ " + j + " = " + (i^j)); // 6



	}
}
