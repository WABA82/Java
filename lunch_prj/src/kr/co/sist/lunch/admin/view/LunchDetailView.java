package kr.co.sist.lunch.admin.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.controller.LunchDetailController;
import kr.co.sist.lunch.admin.controller.LunchMainController;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;

/**
 * ���ö� ���̺��� ���õ� �� ���� ����ϰ� ����, ������ �� �� �ִ� â
 */
@SuppressWarnings("serial")
public class LunchDetailView extends JDialog {

	private JLabel jlLunchImg;
	private JTextField jtfLunchCode, jtfLunchName, jtfLunchDate, jtfLunchPrice;
	private JTextArea jtaLunchSpec;
	private JButton jbImg, jbUpdate, jbDelete, jbEnd;

	public LunchDetailView(LunchMainView lmv, LunchDetailVO ld_vo, LunchMainController lmc) {
		super(lmv, "���ö� �� ����", true); // true - ���

		// DB���� ��ȸ�� ����� ������Ʈ���� ä���.
		ImageIcon iiLunch = new ImageIcon(
				"C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/" + ld_vo.getImg());
		jlLunchImg = new JLabel(iiLunch);

		jtfLunchCode = new JTextField();
		jtfLunchName = new JTextField();
		jtfLunchDate = new JTextField();
		jtfLunchPrice = new JTextField();
		jtaLunchSpec = new JTextArea();
		JScrollPane jspTaSpec = new JScrollPane(jtaLunchSpec);

		// DB���� ��ȸ�� �� ����
		jtfLunchCode.setText(ld_vo.getCode());
		jtfLunchName.setText(ld_vo.getLunch_name());
		jtfLunchDate.setText(ld_vo.getInput_date());
		jtfLunchPrice.setText(String.valueOf(ld_vo.getPrice()));
		jtaLunchSpec.setText(ld_vo.getSpec());

		jbImg = new JButton("�̹�������");
		jbUpdate = new JButton("����");
		jbDelete = new JButton("����");
		jbEnd = new JButton("�ݱ�");

		JLabel jlDetailTitle = new JLabel("���ö� ������");
		jlDetailTitle.setFont(new Font("Dialog", Font.BOLD, 22));

		JLabel jlLunchCode = new JLabel("�ڵ�");
		JLabel jlLunchName = new JLabel("�̸�");
		JLabel jlLunchPrice = new JLabel("����");
		JLabel jlLunchDate = new JLabel("�Է���");
		JLabel jlLunchSpec = new JLabel("Ư����");

		/* ��ġ */
		setLayout(null);
		jlDetailTitle.setBounds(10, 25, 250, 30);
		jlLunchImg.setBounds(10, 65, 244, 220);

		jlLunchCode.setBounds(270, 60, 80, 25);
		jlLunchName.setBounds(270, 90, 80, 25);
		jlLunchPrice.setBounds(270, 120, 80, 25);
		jlLunchDate.setBounds(270, 150, 80, 25);
		jlLunchSpec.setBounds(270, 180, 80, 25);

		jtfLunchCode.setBounds(330, 60, 185, 25);
		jtfLunchCode.setEditable(false);
		jtfLunchCode.setBackground(Color.WHITE);
		jtfLunchName.setBounds(330, 90, 185, 25);
		jtfLunchPrice.setBounds(330, 120, 185, 25);
		jtfLunchDate.setBounds(330, 150, 185, 25);
		jtfLunchDate.setEditable(false);
		jtfLunchDate.setBackground(Color.WHITE);
		jspTaSpec.setBounds(330, 180, 185, 108);

		jbImg.setBounds(40, 320, 100, 25);
		jbUpdate.setBounds(160, 320, 100, 25);
		jbDelete.setBounds(280, 320, 100, 25);
		jbEnd.setBounds(400, 320, 100, 25);

		add(jlDetailTitle);
		add(jlLunchImg);

		add(jbImg);
		add(jbUpdate);
		add(jbDelete);
		add(jbEnd);

		add(jlLunchCode);
		add(jtfLunchCode);
		add(jlLunchName);
		add(jtfLunchName);
		add(jlLunchPrice);
		add(jtfLunchPrice);
		add(jlLunchDate);
		add(jtfLunchDate);
		add(jlLunchSpec);
		add(jspTaSpec);

		/* �̺�Ʈ ��� */
		LunchDetailController ldc = new LunchDetailController(this, lmc, ld_vo.getImg());
		addWindowListener(ldc);
		jbImg.addActionListener(ldc);
		jbUpdate.addActionListener(ldc);
		jbDelete.addActionListener(ldc);
		jbEnd.addActionListener(ldc);

		setResizable(false);
		setBounds(lmv.getX() + 100, lmv.getY() + 50, 535, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ���̾�α׸� ������ ������ JFrame�� �ٸ��� DISPOSE_ON_CLOSE�� ����Ѵ�.
	}// ������

	public JLabel getJlLunchImg() {
		return jlLunchImg;
	}

	public JTextField getJtfLunchCode() {
		return jtfLunchCode;
	}

	public JTextField getJtfLunchName() {
		return jtfLunchName;
	}

	public JTextField getJtfLunchDate() {
		return jtfLunchDate;
	}

	public JTextField getJtfLunchPrice() {
		return jtfLunchPrice;
	}

	public JTextArea getJtaLunchSpec() {
		return jtaLunchSpec;
	}

	public JButton getJbImg() {
		return jbImg;
	}

	public JButton getJbUpdate() {
		return jbUpdate;
	}

	public JButton getJbDelete() {
		return jbDelete;
	}

	public JButton getJbEnd() {
		return jbEnd;
	}

}// class
