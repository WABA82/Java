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
 *         ����ڰ� ������ �޸� �ۼ�, ���Ϸ� ����, ���Ͽ��� �ε��ϴ� ����� ������ �޸���.
 */
@SuppressWarnings("serial")
/* ������������Ʈ ��� �ޱ� */
public class JavaMemo extends Frame {

	/* �Ϲ� ������Ʈ ���� */
	private Menu menuFile, menuEdit, MenuHelp;
	private MenuItem miNew, miOpen, miSave, miNewSave, miEnd, miFormat, miHelp;
	private TextArea taNote;

	/** ������ **/
	public JavaMemo(Font font) {
		super("�޸���");
		/* �Ϲ� ������Ʈ ���� */
		// �޴� ���� //
		menuFile = new Menu("����");
		menuEdit = new Menu("����");
		MenuHelp = new Menu("����");

		// �޴� ������ ���� //
		miNew = new MenuItem("����");
		miOpen = new MenuItem("����");
		miSave = new MenuItem("����");
		miNewSave = new MenuItem("�ٸ� �̸����� ����");
		miEnd = new MenuItem("����");
		miFormat = new MenuItem("�۲�");
		miHelp = new MenuItem("����");

		// �ؽ�Ʈ������ ���� //
		taNote = new TextArea();
		// �Ű������� ������ Font�� �����Ͽ� TextArea�� Font�� �����Ѵ�. //
		if (font != null) {
			taNote.setFont(font);
		}
		/* ��ġ : �޴������� -> �޴� */
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

		/* ����Ȱ��ȭ */
		JavaMemoEvt jme = new JavaMemoEvt(this);
		addWindowListener(jme);
		// �޴��������̺�Ʈ ��� //
		miNew.addActionListener(jme);
		miOpen.addActionListener(jme);
		miSave.addActionListener(jme);
		miNewSave.addActionListener(jme);
		miEnd.addActionListener(jme);
		miFormat.addActionListener(jme);
		miHelp.addActionListener(jme);

		/* �޴��� ���� �� ���� */
		MenuBar menubar = new MenuBar();
		menubar.add(menuFile);
		menubar.add(menuEdit);
		menubar.add(MenuHelp);

		/* �޴���, �ؽ�Ʈ������ ��ġ */
		setMenuBar(menubar);
		add(BorderLayout.CENTER, taNote);

		/* ũ�� ���� */
		setBounds(10, 10, 900, 600);
		setVisible(true);

	}

	/* �޴��� ������� �ʰ�, �޴������ۿ� ���ؼ��� ���. */
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
