package day1213;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         ������ Ŭ�������� ���̾�α�Ŭ������ Is a ����� ���
 */
@SuppressWarnings("serial")
/* ��ӹޱ� */
public class UseDialogIsA extends Frame implements ActionListener {

	private Button btn1;// Frame�� ��ġ

	/* ������ */
	public UseDialogIsA() {
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
		creatDialog();
	}

	public void creatDialog() {
		new DialogIsA(this);
	}

	public static void main(String[] args) {
		new UseDialogIsA();
	}

}
