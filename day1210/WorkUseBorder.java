package day1210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class WorkUseBorder extends Frame {

	public WorkUseBorder() {
		super("�ڵ���ġ ���� �Դϴ�.");

		/* �Ϲݱ��� ���� */
		// ���� - �ǳ� //
		Label titleLabel = new Label("�л� ����");

		// ���� - ���� - �ǳ� //
		Label nameLabel = new Label("�̸�");
		TextField nameField = new TextField();
		Label ageLabel = new Label("����");
		TextField ageField = new TextField();
		Label telLabel = new Label("��ȭ��ȣ");
		TextField telField = new TextField();
		Label genderlabel = new Label("����");
		CheckboxGroup gender = new CheckboxGroup();
		Checkbox maleChbox = new Checkbox("����", true, gender);
		Checkbox femaleChbox = new Checkbox("����", true, gender);
		Panel genderBoxpanel = new Panel(); // ����üũ�ڽ� �ǳڿ� ���
		genderBoxpanel.add(maleChbox);
		genderBoxpanel.add(femaleChbox);

		// ���� - ������ - �ǳ� //
		TextArea textArea = new TextArea();

		// ���� - �ǳ� //
		Button button1 = new Button("�߰�");
		Button button2 = new Button("����");
		Button button3 = new Button("����");
		Button button4 = new Button("����");

		/* �����̳ʱ��� ���� �� ������Ʈ �߰� */
		// ������ //
		Panel northPanel = new Panel();
		northPanel.add(titleLabel);

		// ���� - ���� //
		Panel leftCenterPanel = new Panel();
		leftCenterPanel.setLayout(new GridLayout(4, 2));
		leftCenterPanel.add(nameLabel);
		leftCenterPanel.add(nameField);
		leftCenterPanel.add(ageLabel);
		leftCenterPanel.add(ageField);
		leftCenterPanel.add(telLabel);
		leftCenterPanel.add(telField);
		leftCenterPanel.add(genderlabel);
		leftCenterPanel.add(genderBoxpanel);

		// ���� - ������ //
//		Panel rightCenterPanel = new Panel();
//		rightCenterPanel.add(textArea);
//		rightCenterPanel.setLayout(new FlowLayout());

		Panel centerGridPanel = new Panel();
		centerGridPanel.setLayout(new GridLayout(1, 2));
		centerGridPanel.add(leftCenterPanel);
		centerGridPanel.add(textArea);

		// �Ʒ��� //
		Panel southPanel = new Panel();
		southPanel.add(button1);
		southPanel.add(button2);
		southPanel.add(button3);
		southPanel.add(button4);

		/* ��ġ�Ŵ��� ���� */
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, northPanel);
		add(BorderLayout.CENTER, centerGridPanel);
		add(BorderLayout.SOUTH, southPanel);

		/* ũ�� �� ��ġ ���� */
		setSize(250, 250);
//		setBounds(x, y, width, height);

		/* ����ȭ */
		setVisible(true);

		/* ���� Ȱ��ȭ */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new WorkUseBorder();
	}

}
