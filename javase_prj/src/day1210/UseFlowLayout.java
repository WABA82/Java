package day1210;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author owner<br>
 *         �÷ο� ���̾ƿ��� ������Ʈ�� ���.
 *
 */
//1.������ ������Ʈ ���. 

@SuppressWarnings("serial")
public class UseFlowLayout extends Frame {

	public UseFlowLayout() {

		super("FlowLayout ����");
		// 2.�Ϲ�������Ʈ�� ����.
		Label lblName = new Label("�̸�");
		TextField tfName = new TextField(10);
		Button btn = new Button("�Է�");
		List list = new List();
		list.add("���ü�");
		list.add("������");
		list.add("������");
		list.add("������");
		list.add("������");

		Checkbox checkbox1 = new Checkbox("���", false);
		Checkbox checkbox2 = new Checkbox("��", false);
		Checkbox checkbox3 = new Checkbox("����", false);

		// ���� ��ư
		CheckboxGroup cg = new CheckboxGroup();
		Checkbox rb1 = new Checkbox("����", true, cg);
		Checkbox rb2 = new Checkbox("����", false, cg);

		// 3. ���̾ƿ�����;
		setLayout(new FlowLayout());

		// 4. �Ϲ�������Ʈ ��ġ
		add(lblName);
		add(tfName);
		add(btn);
		add(list);
		add(checkbox1);
		add(checkbox2);
		add(checkbox3);
		add(rb1);
		add(rb2);

		// 5. �������� ũ�� ����
		setSize(400, 300);

		// 6. ����ȭ
		setVisible(true);

		// 7. ���� Ȱ��ȭ
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new UseFlowLayout();
	}

}
