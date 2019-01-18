package kr.co.sist.lunch.user.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.user.controller.LunchOrderDetailController;
import kr.co.sist.lunch.user.vo.LunchDetailVO;

@SuppressWarnings("serial")
public class LunchOrderDetailView extends JDialog {

	private JLabel jlLunchImg;
	private JTextField jtfLunchName, jtfLunchPrice, jtfOrderName, jtfPhone, jtfTotalPrice;
	private JTextArea jtaLunchSpec;
	private JButton jbOrder, jbEnd;
	private JComboBox<Integer> jbQuan;

	public LunchOrderDetailView(LunchClientVIew lcv, LunchDetailVO ld_vo) {
		super(lcv, ld_vo.getLunchName() + " ���ö� ������", true);
		// DB���� ��ȸ�� ����� ������Ʈ���� ä���.
		ImageIcon iiLunch = new ImageIcon("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/" + ld_vo.getImg());
		jlLunchImg = new JLabel(iiLunch);

		jtfLunchName = new JTextField(ld_vo.getLunchName());
		jtfLunchPrice = new JTextField(String.valueOf(ld_vo.getPrice()));
		jtfLunchPrice.setEditable(false);
		jtfLunchPrice.setBackground(Color.WHITE);
		jtfOrderName = new JTextField();
		jtfPhone = new JTextField();
		jtfTotalPrice = new JTextField(String.valueOf(ld_vo.getPrice()));
		jtaLunchSpec = new JTextArea(ld_vo.getSpec());
		jtaLunchSpec.setEditable(false);
		jtaLunchSpec.setBackground(Color.WHITE);
		JScrollPane jspTaSpec = new JScrollPane(jtaLunchSpec);

		// DB���� ��ȸ�� �� ����
		jbOrder = new JButton("�ֹ�");
		jbEnd = new JButton("�ݱ�");

		JLabel jlDetailTitle = new JLabel("���ö� ������");
		jlDetailTitle.setFont(new Font("Dialog", Font.BOLD, 22));

		JLabel jlLunchName = new JLabel("�̸�");
		JLabel jlLunchPrice = new JLabel("����");
		JLabel jlLunchQuan = new JLabel("����");
		JLabel jlLunchTotalPrice = new JLabel("�Ѱ���");
		JLabel jlOrderName = new JLabel("�ֹ��ڸ�");
		JLabel jlOrderTel = new JLabel("��ȭ��ȣ");
		JLabel jlLunchSpec = new JLabel("Ư����");

		DefaultComboBoxModel<Integer> dlmQuan = new DefaultComboBoxModel<Integer>();
		for (int i = 1; i < 11; i++) {
			dlmQuan.addElement(i);
		} // end for

		jbQuan = new JComboBox<Integer>(dlmQuan);

		/* ��ġ */
		setLayout(null);
		jlDetailTitle.setBounds(10, 25, 250, 30);
		jlLunchImg.setBounds(10, 65, 244, 220);
		jlLunchName.setBounds(270, 60, 80, 25);
		jlLunchPrice.setBounds(270, 90, 80, 25);
		jlLunchQuan.setBounds(270, 120, 80, 25);
		jlLunchTotalPrice.setBounds(270, 150, 80, 25);
		jlOrderName.setBounds(270, 180, 80, 25);
		jlOrderTel.setBounds(270, 210, 80, 25);
		jlLunchSpec.setBounds(270, 240, 80, 25);

		/* ������Ʈ ũ�� ���� */
		jtfLunchName.setBounds(340, 60, 185, 25);
		jtfLunchName.setEditable(false);
		jtfLunchName.setBackground(Color.white);
		jtfLunchPrice.setBounds(340, 90, 185, 25);
		jbQuan.setBounds(340, 120, 185, 25);
		jtfTotalPrice.setBounds(340, 150, 185, 25);
		jtfTotalPrice.setEditable(false);
		jtfTotalPrice.setBackground(Color.white);
		jtfOrderName.setBounds(340, 180, 185, 25);
		jtfPhone.setBounds(340, 210, 185, 25);
		jspTaSpec.setBounds(340, 240, 185, 100);
		jbOrder.setBounds(280, 360, 100, 25);
		jbEnd.setBounds(400, 360, 100, 25);

		/* ������Ʈ ���̱� */
		add(jlDetailTitle);
		add(jlLunchImg);
		add(jbOrder);
		add(jbEnd);
		add(jlDetailTitle);
		add(jlLunchImg);
		add(jlLunchName);
		add(jtfLunchName);
		add(jlLunchPrice);
		add(jtfLunchPrice);
		add(jlLunchQuan);
		add(jbQuan);
		add(jlLunchTotalPrice);
		add(jtfTotalPrice);
		add(jlOrderName);
		add(jtfOrderName);
		add(jlOrderTel);
		add(jtfPhone);
		add(jlLunchSpec);
		add(jspTaSpec);

		/* �̺�Ʈ ��� */
		LunchOrderDetailController lodc = new LunchOrderDetailController(this, ld_vo.getLunchCode());
		addWindowListener(lodc);

		jbQuan.addActionListener(lodc);
		jbOrder.addActionListener(lodc);
		jbEnd.addActionListener(lodc);

		setBounds(lcv.getX() + 100, lcv.getY() + 50, 550, 450);
		setVisible(true);

	}// �Ű�������

	/************ ���� getter�޼ҵ� ************/

	public JLabel getJlLunchImg() {
		return jlLunchImg;
	}

	public JTextField getJtfLunchName() {
		return jtfLunchName;
	}

	public JTextField getJtfLunchPrice() {
		return jtfLunchPrice;
	}

	public JTextField getJtfOrderName() {
		return jtfOrderName;
	}

	public JTextField getJtfPhone() {
		return jtfPhone;
	}

	public JTextField getJtfTotalPrice() {
		return jtfTotalPrice;
	}

	public JTextArea getJtaLunchSpec() {
		return jtaLunchSpec;
	}

	public JButton getJbOrder() {
		return jbOrder;
	}

	public JButton getJbEnd() {
		return jbEnd;
	}

	public JComboBox<Integer> getJbQuan() {
		return jbQuan;
	}

}// class
