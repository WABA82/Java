package day1114;
/*
�ڵ�����ȯ : �ڹٿ��� int�� ������ ���������� �����ϸ� �ڵ����� int������Ÿ������ ��ȯ�� �ִ� ��.
��������ȯ : ������ ���������� �Ͻ������� ��ȯ�Ͽ� ����ϴ� ��.
*/

class UseCasting {
	public static void main(String[] args) {
		
		//byte b1 = 10, b2 = 20; //�ڵ�����ȯ
		//int result = b1 + b2; //������ ����� int�� �ڵ�����ȯ�ȴ�.
		//System.out.println(b1 + " + " + b2 + " = " + result);

		byte b1 = 10, b2 = 20; //��������ȯ
		byte result = (byte)(b1 + b2); //������ ����� int�� �ڵ�����ȯ�ȴ�.
		System.out.println(b1 + " + " + b2 + " = " + result);

		double d = 11.14;
		float f = (float)d;

		System.out.println("double : " + d + ", float : " + f);

		float f1 = (float)2018.11; //����� ��밡��
		System.out.println("f1 : " + f1);

		//long l = (long)2147483648; - ������� literal���� ũ�ٸ� casting�� �����ϱ����� Error�߻�00.

		int i = (int)f1;
		System.out.println("int : " +i+ ", float : " + f1);

		char c = 'A';
		System.out.println(c + "�� unicode(ASCll code)��" + (int)c);
		
		//����(�⺻��<->������) �ٸ��� ������ȯ�� ���� �ʴ´�.
	//	String s = "11";
	//	int i = (int)s;

	}//main
}//class