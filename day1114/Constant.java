package day1114;
/*
Constant(���)�� ���
���� : class field������
*/

class Constant { 
	//constant ���� : constant�� �޼ҵ� �ȿ����� ������ �� ����.
	public static final int MAX_SCORE=100;
	public static final int MIN_SCORE=0;


	public static void main(String[] args) {
		System.out.println(MAX_SCORE+ "/" +MIN_SCORE);

		System.out.println(Constant.MAX_SCORE+ "/" +Constant.MIN_SCORE);

		int my_score=95;
		my_score = 93;
		my_score = 85;

		System.out.println("������ �ְ����� " + Constant.MAX_SCORE + "���̰�, �������� " + Constant.MIN_SCORE + "�Դϴ�. ȹ�������� " + my_score + 
							"�̰�, �ְ����� ȹ�������� ���̴� " + (MAX_SCORE - my_score) + "�Դϴ�.");
		System.out.println("long �ִ밪 : " + Long.MAX_VALUE + " / �ּҰ� : " + Long.MIN_VALUE);


	}
}
