package day1211;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class UseItemLIstener2 extends Frame implements ItemListener {

	/* ������Ʈ ���� */
	List dataList;
	Label nameLabel;
	Label ageLabel;

	public UseItemLIstener2() {

		super("�����۸����� �� ���������� ����");

		/* ������Ʈ ���� */
		// ����Ʈ
		dataList = new List();
		dataList.add("���ü�/26");
		dataList.add("������/26");
		dataList.add("������/27");
		dataList.add("������/30");
		dataList.add("������/27");
		dataList.add("�谳����/120");
		dataList.add("�ֽ��/6");
		dataList.add("�̺���������ȭ��/98876");
		dataList.add("������/1");
		// ��
		nameLabel = new Label("�̸� :		");
		ageLabel = new Label("���� :		");

		/* �г� ���� �� ���� */
		Panel southPanel = new Panel();
		southPanel.add(nameLabel);
		southPanel.add(ageLabel);

		/* ��ġ */
		add(BorderLayout.CENTER, dataList);
		add(BorderLayout.SOUTH, southPanel);
		setBounds(200, 200, 400, 300);

		/* ����ȭ */
		setVisible(true);

		/* ���� Ȱ��ȭ */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}

	/* �̺�Ʈ ���� : �����۸����� */
	@Override
	public void itemStateChanged(ItemEvent e) {
	}

	public static void main(String[] args) {
		new UseItemLIstener2();
	}// main

}// class
