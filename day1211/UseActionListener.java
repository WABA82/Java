package day1211;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         �׼Ǹ����ʸ� ����� �̺�Ʈ ó�� - is a ����� �̺�Ʈ ó��
 *
 */
@SuppressWarnings("serial")
public class UseActionListener extends Frame implements ActionListener {

	/* �ν��Ͻ� ����(Ŭ���� ���� ��𼭳� ���� ����.) ���� */
	TextField tfName;
	TextArea taDisplay;

	public UseActionListener() {
		super("�׼� �̺�Ʈ�� ���");

		// 1. ������Ʈ ����
		Label lblName = new Label("�̸�");
		tfName = new TextField(20);
		Button btnAdd = new Button("�߰�");
		Button btnClose = new Button("����");
		taDisplay = new TextArea();

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
		add("Center", taDisplay);

		/* �̺�Ʈ ��� */
		btnAdd.addActionListener(this); // ��ư���� �̺�Ʈ�� ��ϵ�
		tfName.addActionListener(this);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		/* TextField�� ���� �ޱ�. */
		String name = tfName.getText();

		if (!name.isEmpty()) { // �Է¹��ڿ��� ������� �ʴٸ� �߰�.
			/* TextArea�� �߰� */
			taDisplay.append(name + "\n");
			/* TextField�� ���� �ʱ�ȭ */
			tfName.setText("");
		}

		/* Ŀ���� �ؽ�Ʈ �ʵ忡 �缳�� */
		tfName.requestFocus();
	}

	public static void main(String[] args) {
		new UseActionListener();
	}

}
