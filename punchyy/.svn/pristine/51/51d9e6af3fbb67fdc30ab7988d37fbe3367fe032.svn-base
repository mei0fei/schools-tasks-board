package com.etc.punchyy.gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.FrameUtil;
import com.etc.punchyy.util.NumberControl;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.awt.Font;

public class ForgetPwd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3, lblNewLabel_4;
	private UserBiz userBiz = new UserBizImpl();
	private StringBuilder sb = new StringBuilder(6);
	private char ch;
	private JLabel lblNewLabel_5;

	/**
	 * Create the frame.
	 */
	public ForgetPwd() {
		setTitle("Õ¸º«√‹¬Î");
		FrameUtil.initFrame(this, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5E10       \u53F7");
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		lblNewLabel.setBounds(89, 29, 67, 24);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(166, 29, 169, 27);
		textField.setDocument(new NumberControl(8));
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u6CE8\u518C\u7535\u8BDD");
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(89, 80, 67, 24);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(166, 80, 169, 27);
		
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setDocument(new NumberControl(11));
		JButton btnNewButton = new JButton("ªÒ»°—È÷§¬Î");
		btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						sb.delete(0, 6);
						lblNewLabel_3.setText("");
								String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789qwertyuiopasdfghjklzxcvbnms";
								for (int i = 0; i < 6; i++) {
									ch = str.charAt(new Random().nextInt(str
											.length()));
									sb.append(ch);
								}
								lblNewLabel_3.setText(sb.toString());
					}
				}).start();
			}
		});
		btnNewButton.setBounds(210, 114, 112, 34);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("\u9A8C  \u8BC1  \u7801");
		lblNewLabel_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(89, 161, 67, 24);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(166, 161, 169, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_1 = new JButton("œ¬“ª≤Ω");
		btnNewButton_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_2.getText().equals("")) {
					lblNewLabel_4.setText("«Î ‰»Î—È÷§¬Î£°");
					lblNewLabel_4.setForeground(Color.red);
				} else {
					if (textField_2.getText().equals(sb.toString())) {
						lblNewLabel_4.setText("°Ã");
						lblNewLabel_4.setForeground(Color.green);
						if (textField.getText() != null
								&& !textField.getText().equals("")
								&& textField_1.getText() != null
								&& !textField_1.equals("")) {
							int id = Integer.valueOf(textField.getText());
							User user = userBiz.queryUserById(id);
							String tel = textField_1.getText();
							if (user != null) {
								if ((user.getUser_tel()).equals(tel)) {
									NewPwd2 newPwd2 = new NewPwd2(user);
									newPwd2.setVisible(true);
									ForgetPwd.this.dispose();
								}
							}
						}
					} else {
						lblNewLabel_4.setText("—È÷§¬Î≤ª’˝»∑£°");
						lblNewLabel_4.setForeground(Color.red);
					}
				}
			}
		});
		btnNewButton_1.setBounds(79, 201, 104, 40);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("∑µ  ªÿ");
		btnNewButton_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login login = new Login();
				login.setVisible(true);
				ForgetPwd.this.dispose();
			}
		});
		btnNewButton_2.setBounds(218, 201, 104, 40);
		contentPane.add(btnNewButton_2);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			Login login = new Login();
			login.setVisible(true);
			ForgetPwd.this.dispose();
		}
		});

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(89, 114, 112, 34);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(337, 160, 87, 25);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, 0, 451, 262);
		lblNewLabel_5.setIcon(new ImageIcon("image/qiang.png"));
		contentPane.add(lblNewLabel_5);
	}
}
