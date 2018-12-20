package kr.co.sist.memo.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Panel;
import java.awt.TextArea;

import kr.co.sist.memo.evt.MemoHelpEvt;

/*
 * CENTER에 TA 배치
 * 내용)
 * 메모장 정보
 * 이 메모장은 Java로 만들어졌으며 누구나 코드 수정 및 배포를 할 수 있습니다.
 * 단, 이 코드를 사용하여 개선했을 때에는 소스공개를  원칙으로한다. GNU
 * 작성자 : 정택성
 * Version : 1.0;
 */
@SuppressWarnings("serial")
/* Dialog클래스 상속 : Is A */
public class MemoHelp extends Dialog {

	/* JavaMemo클래스 선언 */
	JavaMemo javamemo;

	/* 일반컴포넌트 선언 */
	TextArea infoTextArea;
	Button okButton;

	public MemoHelp(JavaMemo javamemo) {
		/* JavaMemo클래스 생성 : Has a 관계 */
		super(javamemo, "이 메모장에 대하여", true);
		this.javamemo = javamemo;

		/* 일반컴포넌트 생성 */
		// TA컴포넌트 생성 & 수정불가 설정 //
		infoTextArea = new TextArea();
		String infoContents = "메모장 정보\n이 메모장은 Java로 만들어졌으며 누구나 코드 수정 및 배포를 할 수 있습니다.\n단, 이 코드를 사용하여 개선했을 때에는 소스공개를  원칙으로한다. GNU\n작성자 : 정택성\nVersion : 1.0\n";
		infoTextArea.setText(infoContents);
		// 수정불가 설정입니다. //
		infoTextArea.setEditable(false);

		// 버튼 컴포넌트 생성 //
		okButton = new Button("확인");

		/* 배치 */
		// TA : CENTER
		add(BorderLayout.CENTER, infoTextArea);
		// 버튼 : SOUTH
		Panel southPanel = new Panel();
		southPanel.add(okButton);
		add(BorderLayout.SOUTH, southPanel);

		/* 크기 설정 */
		setBounds(javamemo.getX() + 120, javamemo.getY() + 150, 600, 170);
		// 크기 변환불가 설정 //
		setResizable(false);

		/* 이벤트 객체 생성 및 등록 */
		MemoHelpEvt mhe = new MemoHelpEvt(this);
		okButton.addActionListener(mhe);
		addWindowListener(mhe);

		/* 가시화 */
		setVisible(true);
	}

}
