package day1211;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/* ������ ������Ʈ ��� */
public class Work1211 extends Frame implements ItemListener {

	/* ������Ʈ ���� */
	Choice colorChoice;
	Label choicedColorLabel;

	public Work1211() {
		/* ������Ʈ ���� */
		colorChoice = new Choice();
		colorChoice.add("������");
		colorChoice.add("�Ķ���");
		colorChoice.add("������");
		colorChoice.add("��   ��");
		colorChoice.add("��ȫ��");

		choicedColorLabel = new Label("������ ȭ���� �Դϴ�.");

		/* �г� ���� */
		Panel centerGridPanel = new Panel();
		centerGridPanel.setLayout(new GridLayout(1, 2));
		centerGridPanel.add(choicedColorLabel);
		centerGridPanel.add(colorChoice);

		/* ��ġ */
		add(centerGridPanel);

		/* �̺�Ʈ ��� */
		colorChoice.addItemListener(this);

		/* ũ�⼳�� */
		setBounds(100, 100, 300, 300);

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

	/* �̺�Ʈ ó�� */
	@Override
	public void itemStateChanged(ItemEvent e) {

		String pickedColor = colorChoice.getSelectedItem();

		Color color = Color.BLACK;

		switch (pickedColor) {
		case "������":
			color = Color.BLACK;
			break;
		case "�Ķ���":
			color = Color.BLUE;
			break;
		case "������":
			color = Color.RED;
			break;
		case "��   ��":
			color = Color.GREEN;
			break;
		case "��ȫ��":
			color = Color.MAGENTA;
			break;
		}

		choicedColorLabel.setForeground(color);
	}

	public static void main(String[] args) {
		new Work1211();
	}

}
