package day1115;
/*
����(����)������
 ? �� : 
*/
class Operator6 {
	public static void main(String[] args) {
		int i = 12;
		System.out.println(i +" ��(��) "+ (i>=0 ? "���" : "����"));
		//���밪
		System.out.println(i +"�� ���밪 "+ (i>=0 ? i : -i));

		//������ ���� ¦������ Ȧ������ �Ǵ��ϴ� ���׿�����
		System.out.println((i%2) == 0 ? "¦��": "Ȧ��");
	}//main
}//class
