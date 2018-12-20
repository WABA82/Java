package day1123;

/**
 * @author owner 마카펜을 구현한 클래스를 사용하는 클래스<br>
 *         4.객체생성 5.생성된 객체 사용.
 *
 */
public class UseMarker {

	public static void main(String[] args) {
		// 검은색 마카펜 1개 생성
		Marker black = new Marker();

		//생성자를 정의 했기 때문에 set메소드를 사용할 필요 없음.
//		black.setColor("검은색");
//		black.setBody(1);
//		black.setCap(1);
		
		System.out.printf("생성된 마카펜 색[%s], 몸체[%d], 뚜껑[%d]\n", black.getColor(), black.getBody(), black.getCap());

		// 생성된 객체의 사용.
		System.out.println(black.write("안녕하세요!"));

		System.out.println();

		// 빨간색 마카펜 5개 생성 
		Marker red = new Marker("빨간색",5,5); //오버로딩 된 생성자 사용.

		System.out.printf("생성된 마카펜 색[%s], 몸체[%d], 뚜껑[%d]\n", red.getColor(), red.getBody(), red.getCap());
		// 객체의 사용.
		System.out.println(red.write("저는 빨간색 마커 입니다. "));

	}// 메인 메소드

}// 클래스
