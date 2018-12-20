package day1212;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         ������Ʈ�� �ּҸ� ���ϴ� �޼ҵ� : getSource(); ������Ʈ�� ���� ������ ���ϴ� �޼ҵ� :
 *         getActionCommand(); - action�����ʿ����� ����� �� �ִ�.
 */
@SuppressWarnings("serial")
/* ���� ������Ʈ ���, �׼Ǹ����� �����ϱ� */
public class EventCompare extends Frame implements ActionListener {

	/* ������Ʈ ���� */
	private Button btnOpen;
	private Button btnSave;
	private Label lblOutput;

	public EventCompare() {

		super("���ϴ��̾�α� ���");

		/* ���� */
		btnOpen = new Button("������");
		btnSave = new Button("������");
		lblOutput = new Label("���â : ");

		/* ��ġ */
		Panel panel = new Panel(); // �����̳�������Ʈ ���� : ������Ʈ�� ���� �� �ִ�.
		panel.add(btnOpen);
		panel.add(btnSave);

		add(BorderLayout.CENTER, panel);
		add(BorderLayout.SOUTH, lblOutput);

		/* �̺�Ʈ ��� */
		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);

		/* ũ�⼳�� */
		setBounds(100, 100, 500, 100);

		/* ����ȭ */
		setVisible(true);

		/* �����ư Ȱ��ȭ */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* �ּҷ� ���ϴ� ����Դϴ�. */
		System.out.println("������Ʈ�� �ּ�" + e);
		// ����ġ ���̽��� ��ü�� ���� ���մϴ�. //
		if (e.getSource() == btnOpen) {
			System.out.println("����" + e);
		}

		if (e.getSource() == btnSave) {
			System.out.println("����" + e);
		}

		/* �󺧷� ���ϱ� */
		System.out.println("�̺�Ʈ �߻� ��ü�� Label : " + e.getActionCommand());
		String label = e.getActionCommand();

		if (label.equals("������")) {
			System.out.println("�����带 Ŭ���߽��ϴ�.");

			/* ���ϴ��̾�α� ���� �� ���� */
			FileDialog fdOpen = new FileDialog(this, "����", FileDialog.LOAD);
			/* ���ϴ��̾�α� ����ȭ */
			fdOpen.setVisible(true);

			/* ���ϰ�� �� Ÿ��Ʋ ������������ */
			String path = fdOpen.getDirectory();
			String name = fdOpen.getFile();

			/* ������ ������ ���� ���� �Ʒ��� �ڵ� ����(�ּҿ� Ÿ��Ʋ ���) */
			if (name != null) {
				lblOutput.setText("�������� : " + path + name);
				// Ÿ�̺���� ���� ����.
				setTitle("���ϴ��̾�α� ��� - ���� : " + name);
				lblOutput.setText("�������� : ");
			}
		}

		if (label.equals("������")) {
			System.out.println("�����带 Ŭ���߽��ϴ�.");
			/* ���ϴ��̾�α� ���� �� ���� */
			FileDialog fdSave = new FileDialog(this, "����", FileDialog.SAVE);
			/* ���ϴ��̾�α� ����ȭ */
			fdSave.setVisible(true);

			/* ���ϰ�� �� Ÿ��Ʋ ������������ */
			String path = fdSave.getDirectory();
			String name = fdSave.getFile();

			/* ������ ������ ���� ���� �Ʒ��� �ڵ� ����(�ּҿ� Ÿ��Ʋ ���) */
			if (name != null) {
				lblOutput.setText("�������� : " + path + name);
				// Ÿ�̺���� ���� ����.
				setTitle("���ϴ��̾�α� ��� - ���� : " + name);
			}
		}
	}

	public static void main(String[] args) {
		new EventCompare();
	}

}
