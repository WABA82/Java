package day1123;

/**
 * @author j : Work클래스를 사용하는 메소드 입니다.
 *
 */
public class UseWork {

	public static void main(String[] args) {

		// 객체생성
		Work shinramyun = new Work(2,1);

		shinramyun.setMaker("농심");
		shinramyun.setName("신라면");
//		shinramyun.setNuddle(1);
//		shinramyun.setCntSoup(2);

		// 객체에 입력한 정보 반환 받아보기
		System.out.printf("생성된 라면객체 정보는 : 제조사[%s], 라면이름[%s], 스프갯수[%d], 면의갯수[%d] \\n ", shinramyun.getMaker(),
				shinramyun.getName(),  shinramyun.getCntSoup(), shinramyun.getNuddle());

		// 객체의 작동 확인
		System.out.println(shinramyun.being_ramyun());
		System.out.println(shinramyun.being_ramyun(3));
	}

}
