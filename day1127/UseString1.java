package day1127;

public class UseString1 {
	// 이메일을 입력받아 이메일의 유효성(5자 이상이고 "@"과 "."이 있어야 한다.)을 검증하여 불린형으로 결과를 만들어 반환하는 일을 하는 메소드를 만들어 호출하여 사용해보기.
	private boolean emailChecker(String email) {
		boolean flag;
		return  flag = (email.length() > 5 && email.contains("@") && email.contains("."));
	}// 이메일체커 메소드 종료
	
	public static void main(String[] args) {
		//객체화
		UseString1 us1 = new UseString1();
		
		String email = "fkrkeifj@naver.com";
		
		//
		if (us1.emailChecker(email)) {
			System.out.println(email + "는 유효");
		}else
			System.out.println(email + "는 무효");
		
	}// 메인 메소드

}// 클래스 필드
