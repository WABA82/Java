package day1211;

import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class UseItemLIstener extends Frame implements ItemListener {
	List list;
	Label lblResult;

	public UseItemLIstener() {
		list = new List();
		list.add("정택성/26");
		list.add("이재현/26");
		list.add("김정운/27");
		list.add("김정윤/30");
		list.add("이재찬/27");
		list.add("김개똥이/120");
		list.add("최썬더/6");
		list.add("이봉현최종진화물/98876");
		list.add("졸려용/1");

		lblResult = new Label("이름 :                     나이 : ");

		add("Center", list);
		add("South", lblResult);

		/* 이벤트 등록 */
		list.addItemListener(this);

		setBounds(200, 200, 400, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 리스트의 아이템이 선택되면 선택한 아이템을 가져와서 라벨에 변경.

		String[] readItem = list.getSelectedItem().split("/");
		String name = readItem[0];
		String age = readItem[1];
		StringBuilder viewData = new StringBuilder();
		viewData.append("이름 : ").append(name).append("   나이 : ").append(age);
		lblResult.setText(viewData.toString());
	}

	public static void main(String[] args) {
		new UseItemLIstener();
	}

}
