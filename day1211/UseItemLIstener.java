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
		list.add("���ü�/26");
		list.add("������/26");
		list.add("������/27");
		list.add("������/30");
		list.add("������/27");
		list.add("�谳����/120");
		list.add("�ֽ��/6");
		list.add("�̺���������ȭ��/98876");
		list.add("������/1");

		lblResult = new Label("�̸� :                     ���� : ");

		add("Center", list);
		add("South", lblResult);

		/* �̺�Ʈ ��� */
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
		// ����Ʈ�� �������� ���õǸ� ������ �������� �����ͼ� �󺧿� ����.

		String[] readItem = list.getSelectedItem().split("/");
		String name = readItem[0];
		String age = readItem[1];
		StringBuilder viewData = new StringBuilder();
		viewData.append("�̸� : ").append(name).append("   ���� : ").append(age);
		lblResult.setText(viewData.toString());
	}

	public static void main(String[] args) {
		new UseItemLIstener();
	}

}