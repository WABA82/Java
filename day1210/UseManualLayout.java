package day1210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         ������Ʈ ������ġ : ������Ʈ Ŭ������ set�޼ҵ� ���.
 *
 */

@SuppressWarnings("serial")
public class UseManualLayout extends Frame {

	public UseManualLayout() {
		super("������ġ ����");

		// 1. ������Ʈ ����
		Label lbl = new Label();
		lbl.setText("��");
		TextField tf = new TextField();
		Button btn = new Button("Ŭ��");
		// 2. �⺻ ��ġ������ ����
		setLayout(null);
		// 3. ��ġ
		lbl.setLocation(10, 25);
		lbl.setSize(80, 50);
		tf.setBounds(50, 100, 120, 25);
		btn.setBounds(250, 200, 120, 23);
		add(lbl); // Frame�� ��ġ
		add(tf);
		add(btn);
		// 4. ������ ��ǥ ����
		setLocation(100, 200);
		// 5. ������ ũ�� ����
		setSize(500, 600);
		// (4+5).
		setBounds(200, 100, 400, 250);
		setResizable(false); // ������ ����.
		// 6. ����ȭ
		setVisible(true);
		// 7. �����ư Ȱ��ȭ
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new UseManualLayout();
	}

}
