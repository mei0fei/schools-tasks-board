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
	private JTextField Badid;  //被投诉人的ID
	private JTextField Misid;  //被投诉单的ID
	private JLabel Badidhit,Misidhit,Reasonhit;//被投诉人ID，投诉ID，详情的提示框
	private JButton home,OjbK;//返回主界面，提交按钮,
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
		setFont(new Font("微软雅黑", Font.PLAIN, 15));
		this.user=user;
		setTitle("投诉");
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
		//监听被投诉人的输入框
		Badid.addFocusListener(new FocusListener(){
			@Override//监听判断用户是否存在
			public void focusGained(FocusEvent arg0) {
			}
			@Override
			public void focusLost(FocusEvent arg0) {
					if("".equals(Badid.getText())){
						Badidhit.setText("请输入ID");
					}//判断提示框是否有提示的存在 
						else if("".equals(Misidhit.getText())){
							i=Integer.valueOf(Badid.getText());
							Mission m=mis.serchById(Integer.valueOf(Misid.getText()));
							if(m.getMission_emp().getUser_id()==i||m.getMission_emper().getUser_id()==i){
								if(m.getMission_emp().getUser_id()==Complain.this.user.getUser_id()||m.getMission_emper().getUser_id()==Complain.this.user.getUser_id()){
								Badidhit.setText("");
								}
								else{
									Badidhit.setText("您没参与该订单");
								}
							}else{
								Badidhit.setText("请输入正确的ID");
							}
						}
					
			}
			});
		contentPane.add(Badid);
		
		JLabel lblNewLabel = new JLabel("被投诉人");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(212, 12, 70, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6295\u8BC9\u7684\u5355\u53F7");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(22, 12, 82, 18);
		contentPane.add(lblNewLabel_1);
		
		Misid = new JTextField();
		Misid.setBounds(100, 10, 103, 25);
		Misid.setDocument(new NumberControl(5));

		Misid.addFocusListener(new FocusListener(){	
				@Override//监听判断任务是否存在
				public void focusGained(FocusEvent arg0) {
				}
				@Override
				public void focusLost(FocusEvent arg0) {
					
					if("".equals(Complain.this.Misid.getText())){
						Misidhit.setText("请输入任务ID");
					}else { 
							i2=Integer.valueOf(Misid.getText());
							Mission mn= mis.serchById(i2);
							if(mn==null){
							Misidhit.setText("此任务ID不存在");}
							else {
								if(mn.getMission_emp()==null){
									Misidhit.setText("该任务不可被投诉");
								}else{
							Misidhit.setText("");}
						}
							}}}
				);
		contentPane.add(Misid);
		
		JLabel lblNewLabel_2 = new JLabel("投诉详情");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(22, 52, 70, 24);
		contentPane.add(lblNewLabel_2);
		
		Reasonhit = new JLabel("");
		Reasonhit.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		Reasonhit.setForeground(Color.RED);
		Reasonhit.setBounds(162, 202, 103, 15);
		contentPane.add(Reasonhit);
		
		Badidhit = new JLabel("");
		Badidhit.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		Badidhit.setForeground(Color.RED);
		Badidhit.setBounds(296, 33, 115, 15);
		contentPane.add(Badidhit);
		
		Misidhit = new JLabel("");
		Misidhit.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		Misidhit.setForeground(Color.RED);
		Misidhit.setText("请输入任务ID");
		Misidhit.setBounds(100, 33, 103, 15);
		contentPane.add(Misidhit);
		
		//提交按钮设置，点击提交后上传文本框数据到数据库
		OjbK = new JButton("提交");
		OjbK.setFont(new Font("微软雅黑", Font.PLAIN, 15));
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
						JOptionPane.showMessageDialog(Complain.this, "提交成功");
						Complain.this.dispose();
						Home home=new Home(Complain.this.user);
					}else{
					JOptionPane.showMessageDialog(Complain.this, "提交失败");
				    return;
				}
			}else{
				JOptionPane.showMessageDialog(Complain.this, "提交失败，请检查错误");
				return;
		}
				}		
		});
		OjbK.setBounds(74, 227, 95, 33);
		contentPane.add(OjbK);
		
	    home = new JButton("\u8FD4\u56DE");
	    home.setFont(new Font("微软雅黑", Font.PLAIN, 15));
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
					Reasonhit.setText("请填写投诉详情");
				}
			}
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		scrollPane.setViewportView(textArea);
		
	}
}
