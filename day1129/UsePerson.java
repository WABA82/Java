package day1129;

import java.util.Date;

public class UsePerson {

	public static void main(String[] args) {
		HongGilDong gd = new HongGilDong();
		gd.setName("홍길동"); // Person의 메소드 사용
		System.out.println("눈 : " + gd.getEye() + ", 코 : " + gd.getNose() + ", 입 : " + gd.getMouth());
		System.out.println(gd.eat());
		System.out.println(gd.eat("국밥", 1));

		// 자신만의 특징
		System.out.println(gd.fight(6));// 7 -> 8
		System.out.println(gd.fight(7));// 8 -> 9
		System.out.println(gd.fight(9));// 비김 9 -> 9
		System.out.println(gd.fight(10));// 진다 9 -> 8
		System.out.println(gd.fight(9));// 진다 8 -> 7

		System.out.println("------------------------------");

		// Clark 클래스는 Person의 클래스를 상속 받음.
		Clark superman = new Clark();

		// person 클래스 메소드 사용
		superman.setName("클락 캔트"); // person의 메소드
		System.out.println(superman.getEye() + " / " + superman.getNose() + " / " + superman.getMouth() + " / "
				+ superman.getName());
		System.out.println(superman.eat());
		System.out.println(superman.eat("스테이크", 10));

		// Clark 클래스 메소드 사용
		String stone = "짱돌";
		System.out.println(stone + "을 맞은 결과 " + superman.power(stone) + "힘의 변화 : " + superman.power);

		stone = "클립토나이트";
		System.out.println(stone + "을 맞은 결과 " + superman.power(stone) + "힘의 변화 : " + superman.power);

		stone = "다이아몬드";
		System.out.println(stone + "을 맞은 결과 " + superman.power(stone) + "힘의 변화 : " + superman.power);

		System.out.println("------------------------------");

		// JaeHyun클래스는 Person클래스를 상속 받음
		JaeHyun jay = new JaeHyun();
		jay.setName("재현");
		
		//Person클래스의 메소드 사용
		System.out.println(jay.getEye() + " / " + jay.getNose() + " / " + jay.getMouth() + " / "
				+ jay.getName());
		System.out.println(jay.eat());
		System.out.println(jay.eat("스테이크", 10));

		//JaeHyun 클래스 메소드 사용
		int otherLevel = 1;
		System.out.println(otherLevel + "을 게임 한 결과 " + jay.pesLevel(otherLevel) + "레벨의 변화 : " + superman.power);
	}

}
