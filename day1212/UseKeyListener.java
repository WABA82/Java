package day1212;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         Ű���� �̺�Ʈ ó��
 */

// 1. ������ ������Ʈ ��� // 
@SuppressWarnings("serial")
public class UseKeyListener extends Frame implements KeyListener {

	public static final int ENTER = 10;

	// 2. �Ϲ� ������������Ʈ ���� //
	private TextField tf;
	private Label lbl;

	/* ������ */
	public UseKeyListener() {

		super("Ű���� �̺�Ʈ ����");
		// 3. ������Ʈ ���� //
		tf = new TextField();
		lbl = new Label("���â", Label.CENTER);

		// 4. ��ġ //
		add(BorderLayout.NORTH, tf);
		add(BorderLayout.CENTER, lbl);

		// 5. ������Ʈ�� �̺�Ʈ�� ���
		tf.addKeyListener(this);

		// 6. ������ ũ�� �� ��ġ ���� //
		setBounds(100, 100, 400, 150);

		// 7. ����ȭ //
		setVisible(true);

		// 8. ���� Ȱ��ȭ //
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	@Override // Ű�� ������ ���� ��Ȳ �Դϴ�. ���� ���ڸ� �˼� �ְ� Ű�ڵ�� �� �� ����.
	public void keyTyped(KeyEvent ke) {
		System.out.println("Ű Ÿ�Ե�");

	}

	@Override // Ű�� ��Ȯ�� ������ �˼� ����, ���� Ű�� ������ �ִ����� �˼� �ֽ��ϴ�.
	public void keyPressed(KeyEvent ke) {
		System.out.println("Ű ��������");

	}

	@Override
	public void keyReleased(KeyEvent ke) {
		System.out.println("Ű �������");
		// ���� Ű�� ���ڿ� �ڵ尪�� ���
		char inputKey = ke.getKeyChar();
		int inputCode = ke.getKeyCode(); // Ű���� �ڵ�� Ű���� Ű�� ������ ���ڰ� : �����ڵ�� �ټ� �ٸ��ϴ�.
		System.out.println(inputKey + " " + inputCode);
		// ��� �󺧿� �Ѹ���.
		StringBuilder output = new StringBuilder();
		output.append("����Ű ���� : ").append(inputKey).append(", ����Ű�� Ű�ڵ� : ").append(inputCode);
		lbl.setText(output.toString());

		switch (inputCode) {
		case ENTER:
			// JDK 1.7���� �߻��� ���� : TextField, TextArea�� setText("")�� �ٷ� ����ϸ� �ʱ�ȭ ���� �ʴ´�.
			// ���� �ѹ� �� ��
			tf.getText();
			tf.setText("");
			break;
		case KeyEvent.VK_ESCAPE:
			dispose();
		}

	}

	/* ���θ޼ҵ� �Դϴ�. */
	public static void main(String[] args) {
		new UseKeyListener();
	}

}
