package day1113;

//�������� ���� ���
class UseLocalVariable{
	public static void main(String[] args){
		
		//1. �������� ���� : �������� ������;
		int i;	
		int j = 11; // ������ �ʱ�ȭ : ������ �����ϸ鼭 �� �Ҵ�

		//2. �� �Ҵ� : ������ = ��;
		i=100;
		
		//3.�� ��� : ���, ����, ���Ҵ�
		System.out.println(i);
		System.out.println(j);

		//int i = 200; // error ���� �̸��� ������ ����� ����.

		//�������� �ѱ۷� �����ϳ� �Ϲ������� ������� �ʴ´�.
		int ����=300;
		System.out.println(����);
	
//		long l = 3000000000L ;
	}

}