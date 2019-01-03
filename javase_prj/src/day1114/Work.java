package day1114;
/*
1. �Ʒ��� ���� ������ ������ ����� ����� ������.

   �̴ϼ� : 'K', ���� : �ڽ��ǳ���, �޴��÷� : 1.5, ������ �÷� : 0.8

   ��� : ���� �̴ϼ��� 'K'�̰�, xx���Դϴ�. �÷��� �޴� xx, ������ xx�Դϴ�.

2. �⺻�� ���������� �����Ǵ� Ŭ������ Wrapper Class��� �Ѵ�. 
   Java Document���� WrapperŬ������ ����� �����ϴ��� ã�ƺ��� 
   �׿� ���� �ּҰ��� �ִ밪�� ��� �Ѵ�. 
 
   ��� :  byte�� �ּҰ� :  -128  �ִ밪 : 127 
*/
class Work {
	public static void main(String[] args) {
		char initial = 'L';
		int age = 26;
		double l_eye, r_eye;
		l_eye = 1.5;
		r_eye = 0.8;

		System.out.println("���� �̴ϼ��� "+ initial +"�̰�, " + age + "���Դϴ�. " + 
							"�÷��� �޴� " + l_eye + ", ������ "+ r_eye + " �Դϴ�.");

		//Wrapper class : Byte
		System.out.println("byte�� �ּҰ� : " + Byte.MIN_VALUE + " �ִ밪 : " + Byte.MAX_VALUE);

		//Wrapper class : Short
		System.out.println("Short�� �ּҰ� : " + Short.MIN_VALUE + " �ִ밪 : " + Short.MAX_VALUE);

		//Wrapper class : Integer
		System.out.println("Integer�� �ּҰ� : " + Integer.MIN_VALUE + " �ִ밪 : " + Integer.MAX_VALUE);

		//Wrapper class : Long
		System.out.println("Long�� �ּҰ� : " + Long.MIN_VALUE + " �ִ밪 : " + Long.MAX_VALUE);

		//Wrapper class : Float
		System.out.println("Float�� �ּҰ� : " + Float.MIN_VALUE + " �ִ밪 : " + Float.MAX_VALUE);

		//Wrapper class : Double
		System.out.println("Double�� �ּҰ� : " + Double.MIN_VALUE + " �ִ밪 : " + Double.MAX_VALUE);

		//Wrapper class : Character
		System.out.println("Character�� �ּҰ� : " + (int)Character.MIN_VALUE + " �ִ밪 : " + (int)Character.MAX_VALUE);

		//Wrapper class : Boolean
//		System.out.println("Character�� �ּҰ� : " + (char)Boolean.TRUE + " �ִ밪 : " + (char)Boolean.FALSE);
	}
}