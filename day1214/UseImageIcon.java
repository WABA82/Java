package day1214;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author owner<br>
 *         �ڹ�x.���� : �̹���������Ŭ���� ����Դϴ�.<br>
 *
 */
@SuppressWarnings("serial")
/* ����������Ʈ ��� �ޱ� : Is a */
public class UseImageIcon extends JFrame {

	/* �����Ϲ�������Ʈ ���� */
	ImageIcon imgicon1, imgicon2, imgicon3;
	JButton button1, button2, button3;

	public UseImageIcon() {
		super("������Ű���� �̹���������Ŭ���� ���");

		/* �����Ϲ�������Ʈ ���� */
		// �̹��������� ���� //
		imgicon1 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img1.png");
		imgicon2 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img2.png");
		imgicon3 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img3.png");

		button1 = new JButton("��ư1", imgicon1);
		button2 = new JButton("��ư2", imgicon2);
		button3 = new JButton("��ư3", imgicon3);

		/* �����ؽ�Ʈ ���� */
		button1.setToolTipText("��ư1");
		button2.setToolTipText("��ư2�� Ŭ���ϼ���.");
		button3.setToolTipText("��ư3 ������ �ݿ��� �Դϴ�.");

		/* �ѿ��������� */
		button3.setRolloverIcon(imgicon2);

		/* ��ư �� ��ġ���� */
		// ���� ��ġ //
		button1.setHorizontalTextPosition(JButton.LEFT);
		button2.setHorizontalTextPosition(JButton.CENTER);
		button3.setHorizontalTextPosition(JButton.CENTER);

		// ���� ��ġ //
		button1.setVerticalTextPosition(JButton.TOP);
		button2.setVerticalTextPosition(JButton.CENTER);
		button3.setVerticalTextPosition(JButton.BOTTOM);

		button1.
				
		/* ��ġ */
		setLayout(new GridLayout(1, 3));
		add(button1);
		add(button2);
		add(button3);

		/* ������ũ�⼳�� */
		setBounds(100, 100, 900, 400);

		/* ����Ȱ��ȭ */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* ����ȭ */
		setVisible(true);

	}

	public static void main(String[] args) {
		new UseImageIcon();
	}// ���� �޼ҵ�
}// Ŭ����
