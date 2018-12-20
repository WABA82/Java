package day1210;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         �޴� : �޴���, �޴�, �޴����������� �����˴ϴ�.
 */
//1. ������ ������Ʈ ���
@SuppressWarnings("serial")
public class UseMenubar extends Frame {

	public UseMenubar() {
		super("�޴��� ����ϱ�");

		// 1. �޴��� ����
		MenuBar menubar = new MenuBar();

		// 2. �޴�����
		Menu menu1 = new Menu("1��");
		Menu menu2 = new Menu("2��");
		Menu menu3 = new Menu("3��");
		Menu menu3_1 = new Menu("3�� �׷�");
		Menu menu4 = new Menu("4��");

		// 3. �޴������� ����.
		MenuItem menuitem1_1 = new MenuItem("������");
		MenuItem menuitem1_2 = new MenuItem("�̺���");
		MenuItem menuitem1_3 = new MenuItem("������");

		MenuItem menuitem2_1 = new MenuItem("�ڿ���");
		MenuItem menuitem2_2 = new MenuItem("������");

		MenuItem menuitem3_1 = new MenuItem("������");
		MenuItem menuitem3_2 = new MenuItem("������");
		MenuItem menuitem3_3 = new MenuItem("���ü�");
		MenuItem menuitem3_4 = new MenuItem("������");

		MenuItem menuitem4_1 = new MenuItem("������");
		MenuItem menuitem4_2 = new MenuItem("������");
		MenuItem menuitem4_3 = new MenuItem("�����");
		MenuItem menuitem4_4 = new MenuItem("������");
		MenuItem menuitem4_5 = new MenuItem("������");

		// �޴��������� �޴��� ��ġ
		menu1.add(menuitem1_1);
		menu1.add(menuitem1_2);
		menu1.addSeparator();
		menu1.add(menuitem1_3);

		menu2.add(menuitem2_1);
		menu2.add(menuitem2_2);

		// menu3_1�� ���� �޴���ġ
		menu3_1.add(menuitem3_2);
		menu3_1.add(menuitem3_3);
		menu3_1.add(menuitem3_4);

		menu3.add(menuitem3_1);
		menu3.add(menu3_1);

		menu4.add(menuitem4_1);
		menu4.add(menuitem4_2);
		menu4.add(menuitem4_3);
		menu4.addSeparator();
		menu4.add(menuitem4_4);
		menu4.add(menuitem4_5);

		// �޴��� �޴��ٿ� �ø���(��ġ)

		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.add(menu4);

		// �����ӿ� �ø���
		setMenuBar(menubar);

		setBounds(200, 100, 800, 600);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();

			}
		});
	}

	public static void main(String[] args) {
		new UseMenubar();
	}

}
