package day1114;
/*
���� - �⺻�� ��������
������ : byte, short, int, long
������ : char
�Ǽ��� : float, double
Boolean : boolean
*/

class PrimitibveDataType {
	public static void main(String[] args) {
		//������
		byte a = 10;
		byte b1=10, b2=20;
		int result = b1 + b2;
		short b = 20;
		int c = 30;
		long d = 40; //�Ҵ�Ǵ� ���� 4byte�̹Ƿ� literal�� ��ȯ�� �ʿ䰡 ����.
//		long e = 2147483648L; // 4byte�� literal�� ������ ���� �����Ƿ� literal�� ũ�⸦ ���� - ����ø� ����� �Ѵ�.
		
		System.out.println("byte : " + a + ", short : " + b + ", int : " + c + ", long : " + d);
		System.out.println(result);
		
		//������ : unicode �� : \u0000
		char f = 66; // 66�� �빮��B�� ���� �����ڵ��̴�.
		char g = '0';
		char h = '��';
		
		System.out.println("char : " + f +", "+ g +", "+ h);

		//�Ǽ��� : 
		float j = 3.14F; //����� - ����(�Ǽ��� literal�� 8byte)�̰� ����(float ���������� 4byte�̹Ƿ�) �� �Ҵ��� ���� ����ø� �Ѵ�.
		double k = 3.14D; //������ ���� ������ literal�� �����Ƿ� ������ �����ϴ�.

		System.out.println("float : " + j);
		System.out.println("double : " +k);

		//�Ҹ���
		boolean l = true;
		boolean m = false;

		System.out.println("BOOLEAN : " + l +", " + m );
	}//main
}//class
