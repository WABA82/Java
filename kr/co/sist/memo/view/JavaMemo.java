package kr.co.sist.memo.view;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

/**
 * @author owner<br>
 *         ����ڰ� ������ �޸� �ۼ�, ���Ϸ� ����, ���Ͽ��� �ε��ϴ� ����� ������ �޸���.
 */
@SuppressWarnings("serial")
/* ������������Ʈ ��� �ޱ� */
public class JavaMemo extends Frame {

	/* �Ϲ� ������Ʈ ���� */
	private MenuBar menubar;
	private Menu menu, menuFile, menuEdit, MenuHelp;
	private MenuItem miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp;

	public JavaMemo() {
		/* �Ϲ� ������Ʈ ���� */
		Menu menu = new Menu();
		menuFile = new Menu("����");
		menuEdit = new Menu("����");
		MenuHelp = new Menu("����");

		miNew = new MenuItem("����");
		miOpen = new MenuItem("����");
		miSave = new MenuItem("����");
		miNewSave = new MenuItem("���ο� �̸����� ����");
		miEnd = new MenuItem("�ݱ�");
		miFormat = new MenuItem("�۲� �ٲٱ�");
		miHelp = new MenuItem("����ǥ��");

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
