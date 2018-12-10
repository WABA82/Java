package day1210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         �����̳� : �����̳� ������Ʈ�� �Ϲ� ������Ʈ �����Ҽ� �ִ� ������Ʈ�� ���.
 *
 */
@SuppressWarnings("serial")
public class UsePanel extends Frame {

	public UsePanel() {
		super("�����̳� ������Ʈ�� ���");
		// 1. ������Ʈ ����
		Label lblName = new Label("�̸�");
		lblName.setBackground(Color.PINK);
		lblName.setForeground(Color.MAGENTA);

		TextField tfName = new TextField(20);
		Color backBlack = new Color(0x000000);
		Color foreWhite = new Color(0xFFFFFF);
		tfName.setBackground(backBlack);
		tfName.setForeground(foreWhite);

		Button btnAdd = new Button("�߰�");
		Button btnClose = new Button("����");

		TextArea taDisplay = new TextArea();
		taDisplay.setFont(new Font("Dialog", Font.BOLD, 20));

		// �����̳� ������Ʈ ���� : �Ϲ�������Ʈ�� ����.
		Panel panelNorth = new Panel();
		panelNorth.add(lblName);
		panelNorth.add(tfName);
		panelNorth.add(btnAdd);
		panelNorth.add(btnClose);

		// 2. ��ġ������ ����
		setLayout(new BorderLayout());

		// 3. �������̾ƿ��� Ư¡ : �ϳ��� ������ �ϳ��� ������Ʈ�� ���� ����.
		add("North", panelNorth);
//		add("North", tfName);
//		add("North", btnAdd);
//		add("North", btnClose);
		add("Center", taDisplay);

		// 4. ������ ũ�⼳��
		setBounds(200, 100, 400, 250);

		// 5. ����ȭ
		setVisible(true);

		// 6. ������ ���� �̺�Ʈó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new UsePanel();
	}

}
