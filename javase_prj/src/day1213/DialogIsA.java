package day1213;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
/* ���̾�α� ������Ʈ ��� �ޱ� Is A */
public class DialogIsA extends Dialog implements ActionListener {

	/* �Ϲ� ������Ʈ ���� */
	private Button button;

	/* ������ */
	public DialogIsA(UseDialogIsA uda) {
		super(uda, "���̾�α�", true);

		/* ������Ʈ ���� */
		Label label = new Label("������ ����� �Դϴ�.");
		button = new Button("�ݱ�");

		/* ��ġ�ϱ� */
		// label ������Ʈ ��ġ //
		Panel panel = new Panel();
		panel.add(label);
		add(BorderLayout.CENTER, panel);
		// button ������Ʈ ��ġ
		add(BorderLayout.SOUTH, button);

		/* �̺�Ʈ ��� */
		button.addActionListener(this);

		/* ���� �̺�Ʈ ó�� : ���̾�α�������Ʈ */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		/* ũ�� ���� �� ����ȭ */
		// ������������ �������� ���̾�α� ���� //
		System.out.println("�θ� x��ǥ : " + uda.getX() + "�θ� y��ǥ : " + uda.getY());
		setBounds((uda.getX() + 50), (uda.getY() + 50), 200, 200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
