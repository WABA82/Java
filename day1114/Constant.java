package day1114;
/*
Constant(상수)의 사용
선언 : class field에서만
*/

class Constant { 
	//constant 선언 : constant는 메소드 안에서는 선언할 수 없다.
	public static final int MAX_SCORE=100;
	public static final int MIN_SCORE=0;


	public static void main(String[] args) {
		System.out.println(MAX_SCORE+ "/" +MIN_SCORE);

		System.out.println(Constant.MAX_SCORE+ "/" +Constant.MIN_SCORE);

		int my_score=95;
		my_score = 93;
		my_score = 85;

		System.out.println("점수의 최고점은 " + Constant.MAX_SCORE + "점이고, 최저점은 " + Constant.MIN_SCORE + "입니다. 획득점수는 " + my_score + 
							"이고, 최고점과 획득점수의 차이는 " + (MAX_SCORE - my_score) + "입니다.");
		System.out.println("long 최대값 : " + Long.MAX_VALUE + " / 최소값 : " + Long.MIN_VALUE);


	}
}
