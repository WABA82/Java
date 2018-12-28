package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * 프로그램이 실행되면 "디렉토리명 입력 : " 메세지가 출력됩니다. 
 * 사용자가 디렉토리 "예) c:/dev" 를 입력했을 때 
 * 디렉토리라면  해당 디렉토리내 파일 정보를 JOptionPane.showMessageDioalog에 출력 하는 프로그램 작성
 * 출력 
 * 이름           유형   크기        마지막으로 수정한날짜
 * apis           폴더    
 * test.java     파일   164byte    yyyy-MM-dd a hh:mm
 * 디렉토리가 아니라면 "파일은 취급하지 않습니다." console출력
*/
public class Wk1FileFinder {

	/* 인스턴스 변수 선언 */
	String inputPath; // 입력값을 저장할 변수 : BufferedReader의 값 예정

	/* 생성자 */
	public Wk1FileFinder() {
		/* 메시지 출력 */
		System.out.println("디렉토리 입력 : ex) c:/dev/temp");
		try { // try~catch 시작 //

			/* IO스트림 생성 */
			BufferedReader bufferedR = new BufferedReader(new InputStreamReader(System.in));
			inputPath = bufferedR.readLine(); // 변수 : 입력된 값(폴더경로) 저장 //
			bufferedR.close(); // 스트림 닫기 //

			/* File의 객체 생성(inputPath) */
			File file = new File(inputPath);

			/* StringBuilder 생성 */
			StringBuilder view = new StringBuilder();
			view.append("출력\n[이름]\t [유형]\t [크기]\t [수정날짜]\n")
					.append("-------------------------------------------------------------------------------");

			/* if문 : 파일객체 유형 검사 (파일 or 디렉토리) */
			if (file.isDirectory()) {

				JTextArea printTextArea = new JTextArea(10, 50);
				printTextArea.append(view.toString());
				JScrollPane hasPrintTextArea = new JScrollPane(printTextArea);
				JOptionPane.showMessageDialog(null, hasPrintTextArea);

			} else {
				System.out.println("디렉토리만 입력 가능합니다.");
			} // end if //

		} catch (IOException e) {
			e.printStackTrace();
		} // try~catch 종료 //
	} // 생성자 종료 //

	public static void main(String[] args) {
		new Wk1FileFinder();
	}

}