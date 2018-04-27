package com.etc.punchyy.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.etc.punchyy.biz.MissionBiz;
import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.MissionBizImpl;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.entity.Mission;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.FrameUtil;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class NewMission extends JFrame {

	private JPanel contentPane;
	private JTextField textname,textMoney;
	private JButton Button,back;
	private User user;
	private JLabel Label,Label1,lblNewLabel_6;
	private JTextArea textArea;
	UserBiz userBiz=new UserBizImpl();
	MissionBiz biz=new MissionBizImpl();
	Mission mission=new Mission();
	private int credit ;



	/**
	 * Create the frame.
	 */
	public NewMission(User user) {
		setFont(new Font("΢���ź�", Font.PLAIN, 15));
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
		Home home = new Home(NewMission.this.user);
		home.setVisible(true);
		NewMission.this.dispose();
		}
		});
		
		Label = new JLabel("������");
		Label.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		Label.setBounds(14, 13, 54, 15);
		contentPane.add(Label);
		
		textname = new JTextField();
		textname.setBounds(58, 35, 252, 25);
		contentPane.add(textname);
		textname.setColumns(10);
		
		Label1 = new JLabel("�������飨д������ص�ʱ���Լ�Ҫ��Ŷ��");
		Label1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		Label1.setBounds(14, 61, 319, 21);
		contentPane.add(Label1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 88, 406, 106);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea("ʱ�䣺\n�ص㣺\n���ݣ�\n��ע��");
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("��  ��");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(312, 13, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		textMoney = new JTextField();
		textMoney.setBounds(351, 35, 69, 25);
		contentPane.add(textMoney);
		textMoney.setColumns(10);
		
		Button = new JButton("����");
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�жϸ�������״̬���Ƿ���ϲ�����biz�������
				if(NewMission.this.user.getUser_credit()==0){
					JOptionPane.showMessageDialog(NewMission.this, "�����öȹ��ͣ��޷�����������");
					return;
				}
				if("".equals(textname.getText())){
					JOptionPane.showMessageDialog(NewMission.this, "������������");
					return;
				}
				if("".equals(textArea.getText())){
					JOptionPane.showMessageDialog(NewMission.this, "��������������");
					return;
				}else if(textArea.getText().length()<20){
					JOptionPane.showMessageDialog(NewMission.this, "����ϸ��д��������");
					return;
				}
				if("".equals(textMoney.getText())){
					JOptionPane.showMessageDialog(NewMission.this, "������������");
					return;
				}
				try {
					mission.setMission_reward(Double.valueOf(textMoney.getText()));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(NewMission.this, "�벻Ҫ���������������");
					return;
				}
				if(NewMission.this.user.getUser_money() <=Double.valueOf(textMoney.getText())){
					JOptionPane.showMessageDialog(NewMission.this,"�������㣬���ȳ�ֵ");
					return;
				}
				//����biz��
				mission.setMission_emper(NewMission.this.user);
				mission.setMission_name(textname.getText());
				mission.setMission_detail(textArea.getText());
				mission.setMission_time(FrameUtil.getWebsiteDatetime());
				if(biz.addMission(NewMission.this.mission)){
					String double_cre = String.format("%.0f", NewMission.this.user.getUser_credit());  //ȥ����ʵ���öȵ�С��
					credit = Integer.valueOf(double_cre);						//ȥ����С�������öȱ�Ϊint��
					new Thread(new  Runnable() {
						public void run() {
							userBiz.withdrawMoneyById(NewMission.this.user, 
									Double.valueOf(textMoney.getText())*(1.06-credit*0.01)); //�����ַ�����Ǯ �����������ö������������ѣ�	
						}
					}).start();
					String double_str = String.format("%.2f", Double.valueOf(textMoney.getText())*(0.06-credit*0.01));
					JOptionPane.showMessageDialog(NewMission.this, "��������ɹ���֧�������ѣ�"+double_str);
					Home home=new Home(NewMission.this.user);
					NewMission.this.dispose();
				}else{
					JOptionPane.showMessageDialog(NewMission.this, "��������ʧ�ܣ�");
				}
			}
		});
		Button.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		Button.setBounds(14, 207, 81, 35);
		contentPane.add(Button);
		
		back = new JButton("����");
		back.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home=new Home(NewMission.this.user);
				NewMission.this.dispose();
			}
		});
		back.setBounds(337, 207, 81, 35);
		contentPane.add(back);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 451, 262);
		lblNewLabel_6.setIcon(new ImageIcon("image/qiang.png"));
		contentPane.add(lblNewLabel_6);
	}
}