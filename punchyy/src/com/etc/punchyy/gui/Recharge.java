package com.etc.punchyy.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.FrameUtil;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Recharge extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private User user;
	private JLabel lblNewLabel;
	private JButton Button;
	UserBiz biz=new UserBizImpl();
	private double i;

	/**
	 * ��ֵ�ķ���
	 */
	public Recharge(User user) {
		this.user=user;
		setTitle("��ֵ");
		FrameUtil.initFrame(this,300, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		Recharge.this.dispose();
		}
		});
		
		lblNewLabel = new JLabel("��ֵ��");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 18, 94, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		textField.setBounds(92, 62, 164, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Button = new JButton("ȷ�ϳ�ֵ");
		Button.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("".equals(textField.getText())){
					JOptionPane.showMessageDialog(Recharge.this, "�������ֵ�Ľ��");
					return;
				}
				//�ж��Ƿ����ת��Ϊdouble����
				try {
					i=Double.parseDouble((textField.getText()));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(Recharge.this, "��������ȷ�Ľ��");
					return;
				}
				//��������� �������
				if(biz.rechargeMoneyById(Recharge.this.user,i)){
					JOptionPane.showMessageDialog(Recharge.this, "��ֵ�ɹ���");
					Recharge.this.user.setUser_money(Recharge.this.user.getUser_money()+i);
					UserWindow home = new UserWindow(Recharge.this.user);
					Recharge.this.dispose();
				}else{
					JOptionPane.showMessageDialog(Recharge.this, "��ֵʧ�ܣ����������룡����");
					return;
				}
				
			}
		});
		Button.setBounds(25, 140, 94, 44);
		contentPane.add(Button);
		
		JButton btnNewButton = new JButton("����");
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserWindow home = new UserWindow(Recharge.this.user);
				Recharge.this.dispose();
			}
		});
		btnNewButton.setBounds(162, 140, 94, 44);
		contentPane.add(btnNewButton);
	}
}