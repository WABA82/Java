package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;
import kr.co.sist.memo.view.MemoHelp;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo javamemo;

	/* 생성자 has a */
	public JavaMemoEvt(JavaMemo javamemo) {
		this.javamemo = javamemo;
	}

	/* 종료 활성화 */
	@Override
	public void windowClosing(WindowEvent e) {
		javamemo.dispose();
	}

	/* 아이템에 대한 처리 메소드 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// 1.miNew, 2.miOpen, 3.miSave, 4.miNewSave, 5.miEnd, 6.miFormat, 7.miHelp //

		// 1. 메뉴아이템_"새글" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiNew()) {
			newMemo();
		}
		// 2. 메뉴아이템_"열기" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiOpen()) {
			openMemo();
		}
		// 3. 메뉴아이템_"저장" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiSave()) {
			saveMemo();
		}
		// 4. 메뉴아이템_"다른 이름으로 저장" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiNewSave()) {
			newSaveMemo();
		}
		// 5. 메뉴아이템_"종료" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiEnd()) {
			javamemo.dispose();
		}
		// 6. 메뉴아이템_"서식" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiFormat()) {
			formatDialog();
		}
		// 7. 메뉴아이템_"도움말" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiHelp()) {
			helpDialog();
		}
	}

	/* "새글"버튼을 눌렀을 때(ActionEvent) = 호출 : 텍스트에리아 초기화 */
	public void newMemo() {
		// 버그 : TA를 초기화 하기 위해서는 TA.getText()메소드를 한번 실행해야 합니다. //
		javamemo.getTaNote().getText();
		javamemo.getTaNote().setText("");

		//
		javamemo.setTitle("메모장-새글");
	}

	/* 파일 열기 */
	public void openMemo() {
		// 파일다이얼로그 객체 생성 : (파일다이얼로그가 열리는 객체, 다이얼로그의 이름(제목), 다이얼로그 형식) //
		FileDialog fdOpen = new FileDialog(javamemo, "문서열기", FileDialog.LOAD);
		fdOpen.setVisible(true); // 가시화

		// 다이얼로그의 메소드 //
		String filePath = fdOpen.getDirectory(); // 선택한 파일의 경로찾는 메소드
		String fileName = fdOpen.getFile(); // 선택한 파일의 이름

		if (filePath != null) {
			javamemo.setTitle("메모장-열기 " + filePath + fileName);
		} // end if
	}// openMemo 메소드 종료 //

	/* 작성한 메모를 저장 : 기존의 파일명을 그대로 저장하는 파일명에 반영. */
	public void saveMemo() {
		newSaveMemo();
	}

	/* 파일명을 입력받아 새이름으로 저장하는 일 */
	public void newSaveMemo() {
		// 파일다이얼로그 객체 생성 : (파일다이얼로그가 열리는 객체, 다이얼로그의 이름(제목), 다이얼로그 형식) //
		FileDialog fdSave = new FileDialog(javamemo, "문서저장", FileDialog.SAVE);
		fdSave.setVisible(true); // 가시화

		// 다이얼로그의 메소드 //
		String filePath = fdSave.getDirectory(); // 선택한 파일의 경로찾는 메소드
		String fileName = fdSave.getFile(); // 선택한 파일의 이름

		if (filePath != null) {
			javamemo.setTitle("메모장-저장 " + filePath + fileName);
		} // end if
	}// newSaveMemo 메소드 종료 //

	/* 글꼴을 설정하는 다이얼로그를 실행하는 일 */
	public void formatDialog() {
		new MemoFormat(javamemo);
	}

	/* 메모장 정보를 제공하는 다이얼로그 실행 */
	public void helpDialog() {
		new MemoHelp(javamemo);
	}

}
