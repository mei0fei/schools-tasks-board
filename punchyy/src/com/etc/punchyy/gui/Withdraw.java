package com.etc.punchyy.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.FrameUtil;

import java.awt.Font;

public class Withdraw extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private User user;
	private JLabel lblNewLabel;
	private JButton Button;
	UserBiz biz=new UserBizImpl();
	private JButton btnNewButton;
	private double i;



	/**
	 * Create the frame.
	 */
	public Withdraw(User user) {
		this.user=user;
		setTitle("提现");
		FrameUtil.initFrame(this,300, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		Withdraw.this.dispose();
		}
		});
		
		lblNewLabel = new JLabel("提现金额：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 23, 75, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(86, 68, 166, 31);
		contentPane.add(textField);
		
		Button = new JButton("确认提现");
		Button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//先进行判断再进入biz层
				if("".equals(textField.getText())){
					JOptionPane.showMessageDialog(Withdraw.this, "请输入要提现的金额");
					return;
				}
				//判断是否可以转换为double类型
				try {
					i=Double.parseDouble((textField.getText()));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(Withdraw.this, "请输入正确的金额");
					return;
				} 
				if(i>Withdraw.this.user.getUser_money()){
					JOptionPane.showMessageDialog(Withdraw.this, "余额不足，请重新输入");
					return;
				}
				//输入框无误 进入查找
				if(biz.withdrawMoneyById(Withdraw.this.user,i)){
					JOptionPane.showMessageDialog(Withdraw.this, "提现成功！");
					Withdraw.this.user.setUser_money(Withdraw.this.user.getUser_money()-i);
					UserWindow home = new UserWindow(Withdraw.this.user);
					Withdraw.this.dispose();
				}else{
					JOptionPane.showMessageDialog(Withdraw.this, "提现失败！请重新输入！！！");
					return;
				}
			
			}
		});
		Button.setBounds(25, 139, 94, 44);
		contentPane.add(Button);
		
		btnNewButton = new JButton("返回");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserWindow home = new UserWindow(Withdraw.this.user);
				Withdraw.this.dispose();
			}
		});
		btnNewButton.setBounds(158, 140, 94, 44);
		contentPane.add(btnNewButton);
	}

}
