package kr.co.sist.memo.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.JavaMemo;

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

	/*  */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/* 새글에 대한 처리 */
	public void newMemo() {

	}

	/* .txt 파일 열기 */
	public void openMemo() {

	}

	/* 작성한 메모를 저장 : 기존의 파일명을 그대로 저장하는 파일명에 반영. */
	public void saveMemo() {

	}

	/* 파일명을 입력받아 새이름으로 저장하는 일 */
	public void newSaveMemo() {

	}

	/* 글꼴을 설정하는 다이얼로그를 실행하는 일 */
	public void formatDialog() {

	}

	/* 메모장 정보를 제공하는 다이얼로그 실행 */
	public void helpDialog() {

	}

}
