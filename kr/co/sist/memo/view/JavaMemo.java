package kr.co.sist.memo.view;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

/**
 * @author owner<br>
 *         사용자가 간단한 메모를 작성, 파일로 저장, 파일에서 로딩하는 기능이 구현된 메모장.
 */
@SuppressWarnings("serial")
/* 윈도우컴포넌트 상속 받기 */
public class JavaMemo extends Frame {

	/* 일반 컴포넌트 선언 */
	private MenuBar menubar;
	private Menu menu, menuFile, menuEdit, MenuHelp;
	private MenuItem miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp;

	public JavaMemo() {
		/* 일반 컴포넌트 생성 */
		Menu menu = new Menu();
		menuFile = new Menu("파일");
		menuEdit = new Menu("편집");
		MenuHelp = new Menu("도움말");

		miNew = new MenuItem("새글");
		miOpen = new MenuItem("열기");
		miSave = new MenuItem("저장");
		miNewSave = new MenuItem("새로운 이름으로 저장");
		miEnd = new MenuItem("닫기");
		miFormat = new MenuItem("글꼴 바꾸기");
		miHelp = new MenuItem("상태표시");

	}

	public MenuBar getMenubar() {
		return menubar;
	}

	public Menu getMenu() {
		return menu;
	}

	public Menu getMenuFile() {
		return menuFile;
	}

	public Menu getMenuEdit() {
		return menuEdit;
	}

	public Menu getMenuHelp() {
		return MenuHelp;
	}

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

}
