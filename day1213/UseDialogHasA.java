package day1213;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         ������ Ŭ�������� ���̾�α�Ŭ������ has a ����� ���
 */
@SuppressWarnings("serial")
/* ��ӹޱ� */
public class UseDialogHasA extends Frame implements ActionListener {

	private Button btn1;// Frame�� ��ġ
	private Button btn2;// ���̾�α׿뿡 ��ġ
	/* ���̾�α� ���� : �ν��Ͻ����� �����ؾ� �׼�������޼ҵ带 ����� �� �ִ�. */
	Dialog dialog;

	/* ������ */
	public UseDialogHasA() {
		super("���̾�α� ����� ����ϱ�");

		/* �Ϲ� ������Ʈ ���� */
		btn1 = new Button("���̾�α� ��� ");

		/* ��ġ */
		Panel panel = new Panel();
		panel.add(btn1);
		add(panel);

		/* �̺�Ʈ��� : btn1�� Ŭ���ϸ� ���̾�α� â�� �������. */
		btn1.addActionListener(this);

		/* ũ�� ���� */
		setBounds(100, 100, 300, 400);

		/* ���� �̺�Ʈ */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		/* ����ȭ */
		setVisible(true);

	}

	@Override
	/* ActionListener�� �޼ҵ� : */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			creatDialog();
		}
		if (e.getSource() == btn2) {
			dialog.dispose();
		}
	}

	public void creatDialog() {
		/* ���� */
		dialog = new Dialog(this, "���̾�α�", true);

		/* Dialog�� ��ġ�� ������Ʈ ���� */
		Label lbl = new Label("������ ������ ����� �Դϴ�.");
		btn2 = new Button("�ݱ�");

		dialog.add(BorderLayout.CENTER, lbl);
		dialog.add(BorderLayout.SOUTH, btn2);

		/* �̺�Ʈ ��� */
		btn2.addActionListener(this);

		/* ũ�� ���� */
		dialog.setBounds(200, 200, 300, 300);

		/* ���� �̺�Ʈ : �ݵ�� ����ȭ ���� ��ġ��� �Ѵ�. */
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.dispose(); // ���̾�α׸� ���� �ǵ��� ��ü�� ����� �ش�.
			}
		});

		/* ����ȭ */
		dialog.setVisible(true);

	}

	public static void main(String[] args) {
		new UseDialogHasA();
	}

}
