package kr.co.sist.memo.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

import kr.co.sist.memo.evt.JavaMemoEvt;

/**
 * @author owner<br>
 *         사용자가 간단한 메모를 작성, 파일로 저장, 파일에서 로딩하는 기능이 구현된 메모장.
 */
@SuppressWarnings("serial")
/* 윈도우컴포넌트 상속 받기 */
public class JavaMemo extends Frame {

	/* 일반 컴포넌트 선언 */
	private Menu menuFile, menuEdit, MenuHelp;
	private MenuItem miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp;
	private TextArea taNote;

	/** 생서자 **/
	public JavaMemo(Font font) {
		super("메모장");
		/* 일반 컴포넌트 생성 */
		// 메뉴 생성 //
		menuFile = new Menu("파일");
		menuEdit = new Menu("서식");
		MenuHelp = new Menu("도움말");

		// 메뉴 아이템 생성 //
		miNew = new MenuItem("새글");
		miOpen = new MenuItem("열기");
		miSave = new MenuItem("저장");
		miNewSave = new MenuItem("다른 이름으로 저장");
		miEnd = new MenuItem("종료");
		miFormat = new MenuItem("글꼴");
		miHelp = new MenuItem("도움말");

		// 텍스트에리아 생성 //
		taNote = new TextArea();
		// 매개변수로 들어오는 Font를 적용하여 TextArea에 Font를 설정한다. //
		if (font != null) {
			taNote.setFont(font);
		}
		/* 배치 : 메뉴아이템 -> 메뉴 */
		// menuFile
		menuFile.add(miNew);
		menuFile.addSeparator();
		menuFile.add(miOpen);
		menuFile.add(miSave);
		menuFile.add(miNewSave);
		menuFile.addSeparator();
		menuFile.add(miEnd);
		// menuEdit
		menuEdit.add(miFormat);
		// MenuHelp
		MenuHelp.add(miHelp);

		/* 종료활성화 */
		JavaMemoEvt jme = new JavaMemoEvt(this);
		addWindowListener(jme);
		// 메뉴아이템이벤트 등록 //
		miNew.addActionListener(jme);
		miOpen.addActionListener(jme);
		miSave.addActionListener(jme);
		miNewSave.addActionListener(jme);
		miEnd.addActionListener(jme);
		miFormat.addActionListener(jme);
		miHelp.addActionListener(jme);

		/* 메뉴바 선언 및 생성 */
		MenuBar menubar = new MenuBar();
		menubar.add(menuFile);
		menubar.add(menuEdit);
		menubar.add(MenuHelp);

		/* 메뉴바, 텍스트에리아 배치 */
		setMenuBar(menubar);
		add(BorderLayout.CENTER, taNote);

		/* 크기 설정 */
		setBounds(10, 10, 900, 600);
		setVisible(true);

	}

	/* 메뉴는 사용하지 않고, 메뉴아이템에 대해서만 사용. */
//	public Menu getMenuFile() {
//		return menuFile;
//	}
//	public Menu getMenuEdit() {
//		return menuEdit;
//	}
//	public Menu getMenuHelp() {
//		return MenuHelp;
//	}

	public MenuItem getMiNew() {
		return miNew;
	}

	public MenuItem getMiOpen() {
		return miOpen;
	}

	public MenuItem getMiSave() {
		return miSave;
	}

	public MenuItem getMiNewSave() {
		return miNewSave;
	}

	public MenuItem getMiEnd() {
		return miEnd;
	}

	public MenuItem getMiFormat() {
		return miFormat;
	}

	public MenuItem getMiHelp() {
		return miHelp;
	}

	public TextArea getTaNote() {
		return taNote;
	}

}
