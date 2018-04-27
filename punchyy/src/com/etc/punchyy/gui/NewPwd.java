package com.etc.punchyy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.FrameUtil;
import java.awt.Font;

public class NewPwd extends JFrame {

	private JPanel contentPane;
	private boolean flag1,flag2,flag3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private User user;
	private JLabel lblNewLabel_3,lblNewLabel_4,lblNewLabel_5 ,lblNewLabel_6;
	private String oldpwd,newpwd,once;
	private JButton btnNewButton,btnNewButton_1 ;


	/**
	 * Create the frame.
	 */
	public NewPwd(User user) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		NewPwd.this.dispose();
		}
		});
		this.user=user;
		setTitle("�޸�����");
		FrameUtil.initFrame(this, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		UserWindow userWindow = new UserWindow(NewPwd.this.user);
		NewPwd.this.dispose();
		}
		});
		
		JLabel lblNewLabel = new JLabel("�� �� �룺");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel.setBounds(99, 50, 73, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("�� �� �룺");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(99, 100, 73, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ȷ�����룺");
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(99, 150, 79, 15);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(317, 50, 107, 25);
		lblNewLabel_3.addFocusListener(new OldPwd());
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(317, 100, 107, 25);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(317, 150, 107, 25);
		contentPane.add(lblNewLabel_5);
		
		btnNewButton = new JButton("ȷ��");
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton.setBounds(99, 197, 93, 23);
		btnNewButton.addActionListener(new yes());
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("����");
		btnNewButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton_1.setBounds(221, 197, 93, 23);
		btnNewButton_1.addActionListener(new back());
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(182, 46, 132, 25);
		passwordField.addFocusListener(new OldPwd());
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(182, 96, 132, 25);
		passwordField_1.addFocusListener(new RePwd());
		contentPane.add(passwordField_1);
		
		
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(182, 146, 132, 25);
		passwordField_2.addFocusListener(new FocusListener() {		
			@Override
			public void focusLost(FocusEvent arg0) {
				once = new String(passwordField_2.getPassword());
				newpwd = new String(passwordField_1.getPassword());
				lblNewLabel_5.setText("");
				if(newpwd.equals(once)){
					flag3=true;
				}else {
					lblNewLabel_5.setText("��ȷ������");
					lblNewLabel_5.setForeground(Color.red);
					flag3=false;
				}
			}			
			@Override
			public void focusGained(FocusEvent arg0) {	
			}
		});
		contentPane.add(passwordField_2);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 451, 262);
		lblNewLabel_6.setIcon(new ImageIcon("image/qiang.png"));
		contentPane.add(lblNewLabel_6);
		
	}
	
	public class OldPwd implements FocusListener{
		@Override
		public void focusGained(FocusEvent arg0) {		
		}
		@Override
		public void focusLost(FocusEvent arg0) {
			oldpwd = new String(passwordField.getPassword());
			lblNewLabel_3.setText("");
			if(oldpwd==null||"".equals(oldpwd)){
				lblNewLabel_3.setText("����������Ŷ~");
				lblNewLabel_3.setForeground(Color.red);
				flag1=false;
			}else if(user.getUser_pwd().equals(oldpwd)){
				lblNewLabel_3.setText("��");
				lblNewLabel_3.setForeground(Color.green);
				flag1=true;
			}else {
				lblNewLabel_3.setText("");
				lblNewLabel_3.setForeground(Color.red);
				flag1=false;
			}
		}
	}
	
	public class RePwd implements FocusListener{
		@Override
		public void focusGained(FocusEvent arg0) {
		}
		@Override
		public void focusLost(FocusEvent arg0) {
			lblNewLabel_4.setText("");
			oldpwd = new String(passwordField.getPassword());
			newpwd = new String(passwordField_1.getPassword());
			if(newpwd==null||newpwd.equals("")){
				lblNewLabel_4.setText("�������벻��Ϊ�գ�");
				lblNewLabel_4.setForeground(Color.red);
				flag2=false;
			}else if(newpwd.equals(oldpwd)){
				lblNewLabel_4.setText("���¾����벻����ͬ��");
				lblNewLabel_4.setForeground(Color.red);
				flag2=false;
			}else if(newpwd.length()<8){
				lblNewLabel_4.setText("��������ڼ򵥣�");
				lblNewLabel_4.setForeground(Color.red);
				flag2=false;
			}else {
				lblNewLabel_4.setText("�����������~");
				lblNewLabel_4.setForeground(Color.green);
				flag2 = true;				
			}
		}
	}
	
	public class back implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			UserWindow userWindow = new UserWindow(user);
			NewPwd.this.dispose();
		}
	}
	
	public class yes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			once = new String(passwordField_2.getPassword());
			newpwd = new String(passwordField_1.getPassword());
			if(newpwd.equals(once)){
				flag3=true;
			}
			if(flag1&&flag2&&flag3){
				newpwd = new String(passwordField_1.getPassword());
				UserBiz biz = new UserBizImpl();
				if(biz.updatePwdById(user.getUser_id(), newpwd)){
				JOptionPane.showMessageDialog(NewPwd.this, "�޸ĳɹ��������µ�¼��");
				Login login = new Login();
				NewPwd.this.dispose();
				}else {
					JOptionPane.showMessageDialog(NewPwd.this, "�޸�ʧ�ܣ�");
				}
			}else {
				JOptionPane.showMessageDialog(NewPwd.this, "�޸�ʧ�ܣ�");
			}
			
		}
		
		
	}

}
