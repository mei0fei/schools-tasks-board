package com.etc.punchyy.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.etc.punchyy.biz.CompBiz;
import com.etc.punchyy.biz.MissionBiz;
import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.CompBizImpl;
import com.etc.punchyy.bizimpl.MissionBizImpl;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.dao.MissionDao;
import com.etc.punchyy.dao.UserDao;
import com.etc.punchyy.daoimpl.MissionDaoImpl;
import com.etc.punchyy.daoimpl.UserDaoImpl;
import com.etc.punchyy.entity.Comp;
import com.etc.punchyy.entity.Mission;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.FrameUtil;
import com.etc.punchyy.util.NumberControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Complain extends JFrame {

	private JPanel contentPane;
	private JTextField Badid;  //��Ͷ���˵�ID
	private JTextField Misid;  //��Ͷ�ߵ���ID
	private JLabel Badidhit,Misidhit,Reasonhit;//��Ͷ����ID��Ͷ��ID���������ʾ��
	private JButton home,OjbK;//���������棬�ύ��ť,
	private UserBiz userbiz=new UserBizImpl();
	private MissionBiz mis=new MissionBizImpl();
	private CompBiz comp=new CompBizImpl();
	private JTextArea textArea;
	private int i,i2;
	private User user;


	/**
	 * Create the frame.
	 */
	
	public Complain(User user) {
		setFont(new Font("΢���ź�", Font.PLAIN, 15));
		this.user=user;
		setTitle("Ͷ��");
		FrameUtil.initFrame(this, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		Home home = new Home(Complain.this.user);
		home.setVisible(true);
		Complain.this.dispose();
		}
		});
		
		Badid = new JTextField();
		Badid.setBounds(296, 10, 115, 25);
		Badid.setDocument(new NumberControl(6));
		//������Ͷ���˵������
		Badid.addFocusListener(new FocusListener(){
			@Override//�����ж��û��Ƿ����
			public void focusGained(FocusEvent arg0) {
			}
			@Override
			public void focusLost(FocusEvent arg0) {
					if("".equals(Badid.getText())){
						Badidhit.setText("������ID");
					}//�ж���ʾ���Ƿ�����ʾ�Ĵ��� 
						else if("".equals(Misidhit.getText())){
							i=Integer.valueOf(Badid.getText());
							Mission m=mis.serchById(Integer.valueOf(Misid.getText()));
							if(m.getMission_emp().getUser_id()==i||m.getMission_emper().getUser_id()==i){
								if(m.getMission_emp().getUser_id()==Complain.this.user.getUser_id()||m.getMission_emper().getUser_id()==Complain.this.user.getUser_id()){
								Badidhit.setText("");
								}
								else{
									Badidhit.setText("��û����ö���");
								}
							}else{
								Badidhit.setText("��������ȷ��ID");
							}
						}
					
			}
			});
		contentPane.add(Badid);
		
		JLabel lblNewLabel = new JLabel("��Ͷ����");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel.setBounds(212, 12, 70, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6295\u8BC9\u7684\u5355\u53F7");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(22, 12, 82, 18);
		contentPane.add(lblNewLabel_1);
		
		Misid = new JTextField();
		Misid.setBounds(100, 10, 103, 25);
		Misid.setDocument(new NumberControl(5));

		Misid.addFocusListener(new FocusListener(){	
				@Override//�����ж������Ƿ����
				public void focusGained(FocusEvent arg0) {
				}
				@Override
				public void focusLost(FocusEvent arg0) {
					
					if("".equals(Complain.this.Misid.getText())){
						Misidhit.setText("����������ID");
					}else { 
							i2=Integer.valueOf(Misid.getText());
							Mission mn= mis.serchById(i2);
							if(mn==null){
							Misidhit.setText("������ID������");}
							else {
								if(mn.getMission_emp()==null){
									Misidhit.setText("�����񲻿ɱ�Ͷ��");
								}else{
							Misidhit.setText("");}
						}
							}}}
				);
		contentPane.add(Misid);
		
		JLabel lblNewLabel_2 = new JLabel("Ͷ������");
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(22, 52, 70, 24);
		contentPane.add(lblNewLabel_2);
		
		Reasonhit = new JLabel("");
		Reasonhit.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		Reasonhit.setForeground(Color.RED);
		Reasonhit.setBounds(162, 202, 103, 15);
		contentPane.add(Reasonhit);
		
		Badidhit = new JLabel("");
		Badidhit.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		Badidhit.setForeground(Color.RED);
		Badidhit.setBounds(296, 33, 115, 15);
		contentPane.add(Badidhit);
		
		Misidhit = new JLabel("");
		Misidhit.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		Misidhit.setForeground(Color.RED);
		Misidhit.setText("����������ID");
		Misidhit.setBounds(100, 33, 103, 15);
		contentPane.add(Misidhit);
		
		//�ύ��ť���ã�����ύ���ϴ��ı������ݵ����ݿ�
		OjbK = new JButton("�ύ");
		OjbK.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		OjbK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Badidhit.getText().equals("")&& Misidhit.getText().equals("")&& Reasonhit.getText().equals("")){			
					Comp comp1=new Comp();
					UserDao user=new UserDaoImpl();
					MissionDao mis=new MissionDaoImpl();
					comp1.setComp_bad(user.queryUserById(Integer.valueOf(Badid.getText())));
					comp1.setComp_mission(mis.serchById(Integer.valueOf(Misid.getText())));
					comp1.setComp_reason(textArea.getText());
					comp1.setComp_time(FrameUtil.getWebsiteDatetime());
					if(comp.addMission(comp1)){
						JOptionPane.showMessageDialog(Complain.this, "�ύ�ɹ�");
						Complain.this.dispose();
						Home home=new Home(Complain.this.user);
					}else{
					JOptionPane.showMessageDialog(Complain.this, "�ύʧ��");
				    return;
				}
			}else{
				JOptionPane.showMessageDialog(Complain.this, "�ύʧ�ܣ��������");
				return;
		}
				}		
		});
		OjbK.setBounds(74, 227, 95, 33);
		contentPane.add(OjbK);
		
	    home = new JButton("\u8FD4\u56DE");
	    home.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home home=new Home(Complain.this.user);
				home.setVisible(true);
				Complain.this.dispose();
			}
		});
		home.setBounds(258, 227, 95, 33);
		contentPane.add(home);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 86, 389, 110);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.addFocusListener(new FocusListener() {			
			@Override
			public void focusLost(FocusEvent arg0) {
				if(textArea.getText()==null){
					Reasonhit.setText("����дͶ������");
				}
			}
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		scrollPane.setViewportView(textArea);
		
	}
}