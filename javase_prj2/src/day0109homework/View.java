package day0109homework;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class View extends JFrame {

	private JTextField jtf_Table, jtf_Column, jft_DataSize, jtf_KeyName;
	private JComboBox<String> jcb_DataTypes, jcb_Keys;
	private JButton btn_InsertTab, btn_InsertCol, btn_CreateTab, btn_Reset;
	private JTextArea jta_QueryView;

	public View() {
		JLabel tableName, columnName, dataType, dataSize, keyList, keyName;

		tableName = new JLabel("���̺��");
		jtf_Table = new JTextField(10);
		btn_InsertTab = new JButton("���̺��߰���ư");

		columnName = new JLabel("�÷���");
		jtf_Column = new JTextField(10);
		dataType = new JLabel("��������");
		jcb_DataTypes = new JComboBox<>();
		jcb_DataTypes.addItem("varchar2");
		jcb_DataTypes.addItem("char");
		jcb_DataTypes.addItem("number");
		jcb_DataTypes.addItem("date");
		dataSize = new JLabel("������ũ��");
		jft_DataSize = new JTextField(10);

		keyList = new JLabel("�������");
		jcb_Keys = new JComboBox<>();
		jcb_Keys.addItem("null");
		jcb_Keys.addItem("primary key");
		jcb_Keys.addItem("unique");
		jcb_Keys.addItem("not null");
		keyName = new JLabel("������׸�");
		jtf_KeyName = new JTextField(10);
		btn_InsertCol = new JButton("�÷��߰���ư");

		jta_QueryView = new JTextArea();
		jta_QueryView.setBorder(new TitledBorder("������"));
		jta_QueryView.setEditable(false);
		btn_CreateTab = new JButton("���̺������ư");
		btn_Reset = new JButton("�ʱ�ȭ");

		/* ��ġ */
		JPanel panelTab = new JPanel();
		panelTab.add(tableName);
		panelTab.add(jtf_Table);
		panelTab.add(btn_InsertTab);

		JPanel panelData = new JPanel();
		panelData.add(columnName);
		panelData.add(jtf_Column);
		panelData.add(dataType);
		panelData.add(jcb_DataTypes);
		panelData.add(dataSize);
		panelData.add(jft_DataSize);

		JPanel panelKey = new JPanel();
		panelKey.add(keyList);
		panelKey.add(jcb_Keys);
		panelKey.add(keyName);
		panelKey.add(jtf_KeyName);
		panelKey.add(btn_InsertCol);

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(3, 1));
		northPanel.add(panelTab);
		northPanel.add(panelData);
		northPanel.add(panelKey);
		add(BorderLayout.NORTH, northPanel);

		add(BorderLayout.CENTER, jta_QueryView);

		JPanel southPanel = new JPanel();
		southPanel.add(btn_CreateTab);
		southPanel.add(btn_Reset);
		add(BorderLayout.SOUTH, southPanel);

		/* �̺�Ʈ */
		Evt evt = new Evt(this);
		addWindowListener(evt); // ����ó��

		btn_InsertTab.addActionListener(evt);
		btn_InsertCol.addActionListener(evt);
		btn_CreateTab.addActionListener(evt);
		btn_Reset.addActionListener(evt);

		/* ũ�⼳�� �� ����ȭ */
		setBounds(200, 200, 700, 500);
		setVisible(true);

	}// �⺻������

	public JTextField getJtf_Table() {
		return jtf_Table;
	}

	public JTextField getJtf_Column() {
		return jtf_Column;
	}

	public JTextField getJft_DataSize() {
		return jft_DataSize;
	}

	public JTextField getJtf_KeyName() {
		return jtf_KeyName;
	}

	public JComboBox<String> getJcb_DataTypes() {
		return jcb_DataTypes;
	}

	public JComboBox<String> getJcb_Keys() {
		return jcb_Keys;
	}

	public JButton getBtn_InsertTab() {
		return btn_InsertTab;
	}

	public JButton getBtn_InsertCol() {
		return btn_InsertCol;
	}

	public JButton getBtn_CreateTab() {
		return btn_CreateTab;
	}

	public JButton getBtn_Reset() {
		return btn_Reset;
	}

	public JTextArea getJta_QueryView() {
		return jta_QueryView;
	}

	/* ���� ���� */

	public static void main(String[] args) {
		new View();
	}// main

}// class
