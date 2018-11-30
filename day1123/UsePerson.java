package day1123;

/**
 * @author owner 사람을 추상화 하여 만든 Person 클래스를 사용하는 클래스 입니다.
 *
 */
public class UsePerson {

	public static void main(String[] args) {
		
		//객체 생성 : heap에 생성되고 instance 변수는 자동 초기화가 됩니다.
		Person teaksung = new Person();
		teaksung.setName("정택성");

//		기본생성자 만듬
//		teaksung.setEye(2);
//		teaksung.setNose(1);
//		teaksung.setMouth(1);
		
		//생성된 객체 확인하기.
		System.out.format("생성된 사람 객체 정보 : 눈[%d], 코[%d], 입[%d], 이름[%s] \n", teaksung.getEye(),teaksung.getNose(), teaksung.getMouth(), teaksung.getName());
		
		//생성된 객체에서 정의된 일을 사용.
		System.out.println(teaksung.eat());
		System.out.println(teaksung.eat("육회비빔밥",8000));
		
		System.out.println("----------------------------------------------------------------");
		
		//객체 생성 : heap에 생성되고 instance 변수는 자동 초기화가 됩니다.
		Person jinban = new Person(3, 1, 1);
				jinban.setName("천진반");
				
				//생성된 객체 확인하기.
				System.out.format("생성된 사람 객체 정보 : 눈[%d], 코[%d], 입[%d], 이름[%s] \n", jinban.getEye(),jinban.getNose(), jinban.getMouth(), jinban.getName());
				
				//생성된 객체에서 정의된 일을 사용.
				System.out.println(jinban.eat());
				System.out.println(jinban.eat("선두",1));
		
		
	}

}
