package com.etc.punchyy.gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.gui.Home.userWindow;
import com.etc.punchyy.util.FrameUtil;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserWindow extends JFrame {

	private JPanel contentPane;
	private User user;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_6;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private UserBiz userBiz = new UserBizImpl();
	
	


	/**
	 * Create the frame.
	 */
	public UserWindow(User user) {
		this.user=user;
		setTitle("��������");
		FrameUtil.initFrame(this, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		Home home = new Home(UserWindow.this.user);
		home.setVisible(true);
		UserWindow.this.dispose();
		}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		UserWindow.this.dispose();		
		}
		});
		
		JLabel lblNewLabel = new JLabel("��  ��");
		lblNewLabel.setBounds(46, 27, 54, 18);
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(98, 24, 87, 25);
		textField.setFocusable(false);
		textField.setText(user.getUser_id()+"");
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("�û���");
		lblNewLabel_1.setBounds(225, 27, 54, 15);
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(278, 24, 127, 25);
		textField_1.setFocusable(false);
		textField_1.setText(user.getUser_name());
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("��  ��");
		lblNewLabel_2.setBounds(46, 72, 54, 15);
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 68, 87, 25);
		textField_2.setFocusable(false);
		textField_2.setText(user.getUser_sex());
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("��  ��");
		lblNewLabel_3.setBounds(225, 71, 54, 15);
		lblNewLabel_3.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(278, 68, 127, 25);
		textField_3.setFocusable(false);
		textField_3.setText(user.getUser_tel()+"");
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("���ö�");
		lblNewLabel_4.setBounds(46, 119, 54, 15);
		lblNewLabel_4.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(98, 115, 87, 25);
		textField_4.setFocusable(false);
								
		String double_cre = String.format("%.0f", user.getUser_credit());
		textField_4.setText(double_cre+"");
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("���ڵ�");
		lblNewLabel_5.setBounds(225, 119, 54, 14);
		lblNewLabel_5.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(278, 115, 127, 25);
		textField_5.setFocusable(false);
		textField_5.setText(user.getUser_addr());
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_6 = new JLabel("��  ��");
		lblNewLabel_6.setBounds(46, 155, 54, 18);
		lblNewLabel_6.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_6);
		
		String double_str = String.format("%.2f", userBiz.queryUserById(UserWindow.this.user.getUser_id()).getUser_money());
		textField_6 = new JTextField(double_str);
		textField_6.setBounds(98, 153, 87, 25);
		



//		new Thread(new Runnable() {			
//			@Override
//			public void run() {
//				while (true) {
////					try {
////						Thread.sleep(100);
////					} catch (InterruptedException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}								
//					String double_str = String.format("%.2f", userBiz.queryUserById(UserWindow.this.user.getUser_id()).getUser_money());
//					textField_6.setText(double_str);
//				}				
//			}
//		}).start();

		textField_6.setFocusable(false);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		btnNewButton = new JButton("��ֵ");
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recharge recharge=new Recharge(UserWindow.this.user);
				UserWindow.this.dispose();
			}
		});
		btnNewButton.setBounds(195, 153, 66, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("����");
		btnNewButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdraw withdraw=new Withdraw(UserWindow.this.user);
				withdraw.setVisible(true);
				UserWindow.this.dispose();
			}
		});
		btnNewButton_1.setBounds(278, 153, 66, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("�޸�����");
		btnNewButton_2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new rePwd());
		btnNewButton_2.setBounds(92, 201, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("��  ��");
		btnNewButton_3.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home home = new Home(UserWindow.this.user);
				UserWindow.this.dispose();
			}
		});
		btnNewButton_3.setBounds(244, 202, 93, 23);
		contentPane.add(btnNewButton_3);
	}
	
	public class rePwd implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			UserWindow.this.dispose();
			NewPwd newPwd = new NewPwd(user);
		}		
	}
}
