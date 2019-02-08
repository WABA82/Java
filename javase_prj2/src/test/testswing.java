package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class testswing {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testswing window = new testswing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testswing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(256, 10, 116, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(256, 41, 116, 21);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(256, 72, 116, 21);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setBounds(12, 10, 160, 186);
		frame.getContentPane().add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uC774\uBBF8\uC9C0", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 10, 160, 186);
		frame.getContentPane().add(panel);
	}
}
