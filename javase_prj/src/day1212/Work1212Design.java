package day1212;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         1. �߰��� ������ �̸�, ����, �ּҸ� List�� �߰��ϰ� �ؽ�Ʈ�ʵ带 �ʱ�ȭ�Ѵ�.<br>
 *         2. ����Ʈ�� �������� Ŭ���ϸ� ������ ���� �ؽ�Ʈ�ʵ忡 �ԷµǾ�� �Ѵ�.<br>
 *         3. ������ ������<br>
 *         ����Ʈ�� �������� �ؽ�Ʈ �ʵ忡 ���� ��Ÿ����(Ȯ�εǰ�)<br>
 *         �ؽ�Ʈ �ʵ��� ������ �ش� ���� �����Ѵ�.<br>
 *         4. ������ ������<br>
 *         ����Ʈ�� �������� �ؽ�Ʈ �ʵ忡 ���� ��Ÿ����(Ȯ�εǰ�)<br>
 *         �ؽ�Ʈ �ʵ��� ���� ��ġ�ϴ� �������� �����Ѵ�.<br>
 *         5. �ݱ⸦ ������<br>
 *         ���α׷� ����.<br>
 */

@SuppressWarnings("serial")
/* ������ ������Ʈ ��ӹޱ� */
public class Work1212Design extends Frame {

	/* �Ϲ� ������Ʈ ���� */
	Label nameLabel, ageLabel, addressLabel;
	TextField nameTextField, ageTextField, addressTextField;
	Button addButton, deleteButton, changeButton, closeButton;
	List dataList;

	/** ������ �Դϴ� **/
	public Work1212Design() {

		super("1212���� �Դϴ�.");

		/* ������Ʈ ���� */
		// �� + �ؽ�Ʈ �ʵ�
		nameLabel = new Label("�̸�", Label.CENTER);
		nameTextField = new TextField("�̸��ؽ�Ʈ�ʵ�");
		ageLabel = new Label("����", Label.CENTER);
		ageTextField = new TextField("�����ؽ�Ʈ�ʵ�");
		addressLabel = new Label("�ּ�", Label.CENTER);
		addressTextField = new TextField("�ּ��ؽ�Ʈ�ʵ�");

		// ��ư
		addButton = new Button("�߰�");
		deleteButton = new Button("����");
		changeButton = new Button("����");
		closeButton = new Button("�ݱ�");

		// ����Ʈ
		dataList = new List();

		/* �г� ���� �� ���� */

		// ����_����_�׸��巹�̾ƿ� �г� : �� + �ؽ�Ʈ�ʵ� //
		Panel cenLeftPanel = new Panel();
		cenLeftPanel.setLayout(new GridLayout(3, 2));
		// �̸� ������Ʈ //
		cenLeftPanel.add(nameLabel);
		cenLeftPanel.add(nameTextField);
		// ���� ������Ʈ //
		cenLeftPanel.add(ageLabel);
		cenLeftPanel.add(ageTextField);
		// �ּ� ������Ʈ //
		cenLeftPanel.add(addressLabel);
		cenLeftPanel.add(addressTextField);

		// ���͸� �̵���ϴ� �׸��巹�̾ƿ��� �г� //
		Panel cenGridPanel = new Panel();
		cenGridPanel.setLayout(new GridLayout(1, 2));
		cenGridPanel.add(cenLeftPanel);
		cenGridPanel.add(dataList);

		// �Ʒ�_�Ϲ� �г� : ��ư //
		Panel southPanel = new Panel();
		southPanel.add(addButton);
		southPanel.add(deleteButton);
		southPanel.add(changeButton);
		southPanel.add(closeButton);

		/* ��ġ */
		add(BorderLayout.CENTER, cenGridPanel);
		add(BorderLayout.SOUTH, southPanel);

		/* ũ�� ���� */
		setBounds(100, 100, 300, 150);

		/* ����ȭ */
		setVisible(true);

		/* ���� Ȱ��ȭ */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new Work1212Design();
	}

}
