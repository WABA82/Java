package day1130;

public class RunConstr {
	
	public static void main(String[] args) {

		//부모 기본, 부모인자 300, 자식인자 200, 자식기본
//		SubConstr sc = new SubConstr();
		
		//부모 인자100, 부모기본, 자식기본, 자식인자100
		@SuppressWarnings("unused")
		SubConstr sc1 = new SubConstr(100);
	}//메인 메소드 종료

}//클래스 필드 종료
