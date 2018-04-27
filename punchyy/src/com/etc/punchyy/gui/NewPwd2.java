package com.etc.punchyy.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.FrameUtil;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPasswordField;
import java.awt.Font;

public class NewPwd2 extends JFrame {

	private JPanel contentPane;
	private User user;
	private JLabel lblNewLabel_2,lblNewLabel_3 ,lblNewLabel_5;
	private boolean flag1=false,flag2=false;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private String pwd1,pwd2;
	private UserBiz userBiz = new UserBizImpl();
	/**
	 * Create the frame.
	 */
	public NewPwd2(User user) {
		this.user=user;
		setTitle("����������");
		FrameUtil.initFrame(this, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u65B0  \u5BC6  \u7801");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel.setBounds(105, 49, 66, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ȷ������");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(105, 107, 66, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ȷ  ��");
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(flag1&&flag2){
				userBiz.updatePwdById(NewPwd2.this.user.getUser_id(), pwd1);
				JOptionPane.showMessageDialog(NewPwd2.this, "���Ҫ�úü�ס����Ŷ");
				Login login = new Login();
				NewPwd2.this.dispose();
			}
			
			}
		});
		btnNewButton.setBounds(108, 163, 91, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("��  ��");
		btnNewButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Login login = new Login();
			NewPwd2.this.dispose();
			}
		});
		btnNewButton_1.setBounds(229, 163, 91, 43);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(323, 49, 101, 25);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(323, 103, 101, 25);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 45, 139, 25);
		passwordField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				pwd1=new String(passwordField.getPassword());
				if(pwd1.length()<8){
					lblNewLabel_2.setText("��������ڼ�");
					lblNewLabel_2.setForeground(Color.red);
					flag1=false;
				}else if("".equals(pwd1)){
					lblNewLabel_2.setText("�����벻��Ϊ��");
					lblNewLabel_2.setForeground(Color.RED);
				}else if(pwd1.indexOf(" ")!=-1){
					lblNewLabel_2.setText("�����벻�ܴ��ո�");
					lblNewLabel_2.setForeground(Color.RED);
					}else {
					lblNewLabel_2.setText("���������");
					lblNewLabel_2.setForeground(Color.green);
					flag1=true;
				}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(181, 103, 139, 25);
		passwordField_1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				pwd2 = new String(passwordField_1.getPassword());
				if(pwd1.equals(pwd2)){
					lblNewLabel_3.setText("��");
					lblNewLabel_3.setForeground(Color.green);
					flag2=true;
				}else {
					lblNewLabel_3.setText("���������벻��ͬ");
					lblNewLabel_3.setForeground(Color.red);
					flag2=false;
				}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		contentPane.add(passwordField_1);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, 0, 451, 262);
		lblNewLabel_5.setIcon(new ImageIcon("image/qiang.png"));
		contentPane.add(lblNewLabel_5);
	}
}