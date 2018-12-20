package day1217;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJTab extends JFrame {

	UseJTab thisObject;
	JTabbedPane jtab;

	public UseJTab() {
		super("Tab");
		thisObject = this;
		ImageIcon imageicon;
		/* 1.탭을 추가할 수 있는 객체 생성 */
		jtab = new JTabbedPane();
		/* 2. 각 탭에 들어갈 컴포넌트를 생성 */
		// 1번 탭 //
		imageicon = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img1.png");
		JLabel jlabel = new JLabel(imageicon);
		JLabel jlabel2 = new JLabel();

		// 2번 탭 //
		JPanel panel = new JPanel();
		panel.add(new JLabel("이름"));
		panel.add(new JTextField(30));
		panel.add(new JButton("입력"));

		JPanel tab2 = new JPanel();
		tab2.setLayout(new BorderLayout());

		panel.setBorder(new TitledBorder("입력데이터"));

		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("결과창"));

		tab2.add("North", panel);
		tab2.add("Center", jsp);

		jtab.add("1번 탭", jlabel);
		jtab.add("2번 탭", tab2);
		jtab.add("3번 탭", new JButton());
		jtab.add("4번 탭", jlabel2);

		UseJTab.jtabEvt jtEvt = this.new jtabEvt();
		jtab.addMouseListener(jtEvt);

		/* 배치 */
		add("Center", jtab);

		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/* inner class */
	public class jtabEvt extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (jtab.getSelectedIndex() == 3) {

				String password = JOptionPane.showInputDialog("비밀번호를 입력해 주세요.");
				if (password.trim().equals("123")) {
					JOptionPane.showMessageDialog(thisObject, "비밀번호가 잘 입력되었습니다.");
					jtab.setSelectedIndex(0);
				} else {
					JOptionPane.showMessageDialog(thisObject, "잘못된 비밀번호를 입력했습니다.");
				}

			}
		}
	}

	/* inner class */
	public static void main(String[] args) {
		new UseJTab();
	}

}
