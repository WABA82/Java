package day1210;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         메뉴 : 메뉴바, 메뉴, 메뉴아이템으로 구성됩니다.
 */
//1. 윈도우 컴포넌트 상속
@SuppressWarnings("serial")
public class UseMenubar extends Frame {

	public UseMenubar() {
		super("메뉴바 사용하기");

		// 1. 메뉴바 생성
		MenuBar menubar = new MenuBar();

		// 2. 메뉴생성
		Menu menu1 = new Menu("1조");
		Menu menu2 = new Menu("2조");
		Menu menu3 = new Menu("3조");
		Menu menu3_1 = new Menu("3조 그룹");
		Menu menu4 = new Menu("4조");

		// 3. 메뉴아이템 생성.
		MenuItem menuitem1_1 = new MenuItem("이재찬");
		MenuItem menuitem1_2 = new MenuItem("이봉현");
		MenuItem menuitem1_3 = new MenuItem("박은영");

		MenuItem menuitem2_1 = new MenuItem("박영민");
		MenuItem menuitem2_2 = new MenuItem("김정윤");

		MenuItem menuitem3_1 = new MenuItem("김정운");
		MenuItem menuitem3_2 = new MenuItem("노진경");
		MenuItem menuitem3_3 = new MenuItem("정택성");
		MenuItem menuitem3_4 = new MenuItem("이재현");

		MenuItem menuitem4_1 = new MenuItem("공선의");
		MenuItem menuitem4_2 = new MenuItem("오영근");
		MenuItem menuitem4_3 = new MenuItem("김건하");
		MenuItem menuitem4_4 = new MenuItem("박정미");
		MenuItem menuitem4_5 = new MenuItem("최혜원");

		// 메뉴아이템을 메뉴에 배치
		menu1.add(menuitem1_1);
		menu1.add(menuitem1_2);
		menu1.addSeparator();
		menu1.add(menuitem1_3);

		menu2.add(menuitem2_1);
		menu2.add(menuitem2_2);

		// menu3_1의 하위 메뉴배치
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

		// 메뉴를 메뉴바에 올리기(배치)

		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.add(menu4);

		// 프레임에 올리기
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
