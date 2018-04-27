package com.etc.punchyy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.etc.punchyy.biz.MissionBiz;
import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.MissionBizImpl;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.entity.Mission;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.gui.Home.userWindow;
import com.etc.punchyy.util.FrameUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

public class MissionDetail extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_6;
	private Mission mission;
	private User user;
	private JTextArea textArea;
	private JButton btnNewButton ;
	private MissionBiz missionBiz = new MissionBizImpl();
	private UserBiz userBiz = new UserBizImpl();

	/**
	 * Create the frame.
	 */
	public MissionDetail(Mission mission,User user) {
		this.mission=mission;
		this.user=user;
		setTitle("任务详情");
		FrameUtil.initFrame(this,450, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		Home home = new Home(MissionDetail.this.user);
		home.setVisible(true);
		MissionDetail.this.dispose();
		}
		});
		
		if(mission.getMission_state().equals("未领取")&&mission.getMission_emper().getUser_id()!=user.getUser_id()){
			btnNewButton = new JButton("领取任务");
			btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			btnNewButton.addActionListener(new getMis());
			btnNewButton.setBounds(92, 316, 110, 23);
			contentPane.add(btnNewButton);
		}else if(mission.getMission_state().equals("完成中")&&mission.getMission_emper().getUser_id()==user.getUser_id()){
			btnNewButton = new JButton("完成任务");
			btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			btnNewButton.addActionListener(new getMis());
			btnNewButton.setBounds(92, 316, 110, 23);
			contentPane.add(btnNewButton);
		}else if(mission.getMission_state().equals("未领取")  || mission.getMission_state().equals("已过期") &&mission.getMission_emper().getUser_id()==user.getUser_id()){
			btnNewButton = new JButton("删除任务");
			btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			btnNewButton.addActionListener(new getMis());
			btnNewButton.setBounds(92, 316, 110, 23);
			contentPane.add(btnNewButton);
		}
		if(mission.getMission_state().equals("已完成")&&mission.getMission_emper().getUser_id()==user.getUser_id()){

		}
			
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		MissionDetail.this.dispose();
		}
		});
		
		JLabel lblNewLabel = new JLabel("任务单号");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(37, 38, 67, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(114, 35, 96, 25);
		textField.setText(mission.getMission_id()+"");
		textField.setFocusable(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("任务名称");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(220, 38, 65, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(295, 35, 96, 25);
		textField_1.setText(mission.getMission_name());
		textField_1.setFocusable(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u53D1  \u5E03  \u4EBA");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(37, 75, 67, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 72, 96, 25);
		textField_2.setText(mission.getMission_emper().getUser_id()+"");
		textField_2.setFocusable(false);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("联系方式");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(220, 75, 65, 15);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(295, 72, 96, 25);
		textField_3.setText(mission.getMission_emper().getUser_tel());
		textField_3.setFocusable(false);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u4FE1  \u7528  \u5EA6");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(37, 116, 67, 15);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(114, 113, 96, 25);
		textField_4.setText(mission.getMission_emper().getUser_credit()+"");
		textField_4.setFocusable(false);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("  \u8D4F    \u91D1");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(220, 116, 65, 15);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(295, 113, 96, 25);
		String double_str = String.format("%.2f", mission.getMission_reward());
		textField_5.setText(double_str);
		textField_5.setFocusable(false);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_6 = new JLabel("任务描述(任务发布时间:"+mission.getMission_time()+")");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(50, 156, 341, 15);
		contentPane.add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 181, 343, 114);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setText(mission.getMission_detail());
		textArea.setFocusable(false);
		scrollPane.setViewportView(textArea);
		
		
		
		JButton btnNewButton_1 = new JButton("\u8FD4  \u56DE");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			MissionDetail.this.dispose();	
			Home home = new Home(MissionDetail.this.user);
			}
		});
		btnNewButton_1.setBounds(257, 316, 110, 23);
		contentPane.add(btnNewButton_1);
	}
	
	public class getMis implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(btnNewButton.getText().equals("领取任务")){
				if((MissionDetail.this.user.getUser_id())==(mission.getMission_emper().getUser_id())){
					JOptionPane.showMessageDialog(MissionDetail.this, "您无法领取自己的任务！");
				}else {
				if(user.getUser_credit()>0){
					if(mission.getMission_state().equals("未领取")){
						if(missionBiz.updateEmp(user, mission.getMission_id())){
							if(missionBiz.updateState("完成中", mission.getMission_id())){
								JOptionPane.showMessageDialog(MissionDetail.this, "领取成功!");
								MissionDetail.this.dispose();
								Home home = new Home(user);
							}else {
								JOptionPane.showMessageDialog(MissionDetail.this, "领取失败!");						
							}
						}else {
							JOptionPane.showMessageDialog(MissionDetail.this, "领取失败!");
						}					
					}else {
						JOptionPane.showMessageDialog(MissionDetail.this, "该任务被被人抢先领走了!");
					}	
				}else {
					JOptionPane.showMessageDialog(MissionDetail.this, "您的信用度过低!");
				}
				}
			}else if(btnNewButton.getText().equals("完成任务")){
				int option= JOptionPane.showConfirmDialog(MissionDetail.this, "确定该任务是否完成？ ", "提示 ",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if(option==JOptionPane.YES_OPTION){
					String double_cre = String.format("%.0f", 
							MissionDetail.this.mission.getMission_emp().getUser_credit());  //去除真实信用度的小数
					int credit = Integer.valueOf(double_cre);						//去除后小数的信用度变为int型
					userBiz.rechargeMoneyById(mission.getMission_emp(), 
							mission.getMission_reward()*(0.94+credit*0.01));
					//写入任务完成时间
					missionBiz.updateFinishTimeById(Integer.valueOf(textField.getText()), FrameUtil.getWebsiteDatetime());	
					userBiz.updateCreditById(MissionDetail.this.mission.getMission_emper().getUser_id(), 
							MissionDetail.this.mission.getMission_emper().getUser_credit()+0.01);
					userBiz.updateCreditById(MissionDetail.this.mission.getMission_emp().getUser_id(), 
							MissionDetail.this.mission.getMission_emp().getUser_credit()+0.01);
					JOptionPane.showMessageDialog(MissionDetail.this, "该任务已完成!");
					missionBiz.updateState("已完成", mission.getMission_id());
					MissionDetail.this.dispose();
					Home home = new Home(user);
				}
			}else {
				int option= JOptionPane.showConfirmDialog(MissionDetail.this, "是否要删除该任务？ ", "提示 ",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if(option==JOptionPane.YES_OPTION){
					missionBiz.deleteMission(mission.getMission_id());
					userBiz.rechargeMoneyById(mission.getMission_emper(), mission.getMission_reward());
					double d = MissionDetail.this.mission.getMission_emper().getUser_credit();
					mission.getMission_emper().setUser_credit(d-(0.01));
					userBiz.updateCreditById(MissionDetail.this.mission.getMission_emper().getUser_id(), 
							d-(0.01));
					JOptionPane.showMessageDialog(MissionDetail.this, "已经删除该任务");
					MissionDetail.this.dispose();
					Home home = new Home(user);
			}
			}
		}
	}
}
	
