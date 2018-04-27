package com.etc.punchyy.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.etc.punchyy.biz.CompBiz;
import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.CompBizImpl;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.entity.Comp;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.FrameUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CompDetail extends JFrame {

	private JPanel contentPane;
	private JTextField reportname;
	private JTextField badname;
	private JTextField reporttel;
	private JTextField badtel;
	private JTextField compid;
	private JTextField compname;
	private JButton update1,back;//信用修改，返回按钮
	private UserBiz user=new UserBizImpl();
	private boolean flag=false;
	private JScrollPane scrollPane_1;
	private JTextArea txtrDd;
	private CompBiz CB=new CompBizImpl();
	private JButton re;
	private User user2;
	private JButton btnNewButton;
	

	/**
	 * Create the frame.
	 * @param user2 
	 * @param comp2 
	 */
	public CompDetail(Comp comp,JButton refresh,User user) {
		user2=user;
		re=refresh;
		setTitle("投诉详情");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		CompDetail.this.dispose();
		}
		});
		FrameUtil.initFrame(this, 470, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			CompDetail.this.dispose();
			Admin admin = new Admin(user2);
			}
			});
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("    \u6295\u8BC9\u4EBA");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 72, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("    \u88AB\u6295\u8BC9\u4EBA");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(216, 10, 82, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("投诉人电话");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 49, 82, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("被投诉人电话");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(216, 49, 93, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("  \u6295\u8BC9\u5355\u53F7");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 88, 72, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("    \u6295\u8BC9\u4EFB\u52A1");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(216, 88, 82, 15);
		contentPane.add(lblNewLabel_5);
		
		reportname = new JTextField();
		//判定投诉人是雇主还是被雇人
		if(comp.getComp_mission().getMission_emp().getUser_name().equals(comp.getComp_bad().getUser_name())){
			//被雇人为被投诉人的情况
			reportname.setText(comp.getComp_mission().getMission_emper().getUser_name());
			flag=false;
			
		}else{
			//雇主为被投诉人的情况
			reportname.setText(comp.getComp_mission().getMission_emp().getUser_name());
			flag=true;
			
		}
		reportname.setBounds(94, 7, 114, 25);
		reportname.setFocusable(false);
		contentPane.add(reportname);
		
		badname = new JTextField(comp.getComp_bad().getUser_name());
		badname.setBounds(308, 7, 124, 25);
		badname.setFocusable(false);
		contentPane.add(badname);
		
		reporttel = new JTextField();
		reporttel.setBounds(94, 46, 114, 25);
		reporttel.setFocusable(false);
		contentPane.add(reporttel);
		
		badtel = new JTextField();
		badtel.setBounds(308, 46, 124, 25);
		badtel.setFocusable(false);
		contentPane.add(badtel);
		
		compid = new JTextField();
		compid.setBounds(96, 85, 112, 25);
		compid.setText(comp.getComp_id()+"");
		compid.setFocusable(false);
		contentPane.add(compid);
		compid.setColumns(10);
		
		compname = new JTextField();
		compname.setBounds(308, 85, 124, 25);
		compname.setText(comp.getComp_mission().getMission_name());
		compname.setFocusable(false);
		contentPane.add(compname);
		
		
		if(flag){
			reporttel.setText(comp.getComp_mission().getMission_emp().getUser_tel());
			badtel.setText(comp.getComp_mission().getMission_emper().getUser_tel());
		}else{
			reporttel.setText(comp.getComp_mission().getMission_emper().getUser_tel());
			badtel.setText(comp.getComp_mission().getMission_emp().getUser_tel());
		}
		update1 = new JButton("信用修改");
		update1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		update1.addActionListener(new update());
		update1.setBounds(51, 304, 93, 23);
		contentPane.add(update1);
		
		back = new JButton("\u5220\u9664\u6295\u8BC9");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int option= JOptionPane.showConfirmDialog(CompDetail.this, "是否要删除该任务？ ", "提示 ",JOptionPane.YES_NO_CANCEL_OPTION);
				if(option==JOptionPane.YES_OPTION){
					CB.delete(Integer.valueOf(compid.getText()));
					re.doClick();
					CompDetail.this.dispose();
					Admin admin = new Admin(user2);
				}	
				
			}
		});
		back.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		
		back.setBounds(169, 304, 93, 23);
		contentPane.add(back);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 132, 402, 162);
		contentPane.add(scrollPane_1);
		
		txtrDd = new JTextArea(comp.getComp_reason());
		scrollPane_1.setViewportView(txtrDd);
		
		btnNewButton = new JButton("\u8FD4    \u56DE");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		txtrDd.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Admin admin = new Admin(user2);
			CompDetail.this.dispose();		
			}
		});
		btnNewButton.setBounds(289, 305, 93, 23);
		contentPane.add(btnNewButton);
	}
    
	public class update implements ActionListener{
		 

			@Override
			public void actionPerformed(ActionEvent arg0) {
			User user1=new User();
            user1=user.queryUserByName(reportname.getText());
            User user2=new User();
            user2=user.queryUserByName(badname.getText());
			UpdateCredit UC=new UpdateCredit(user1,user2,CompDetail.this.user2);
			CompDetail.this.dispose();
			UC.setVisible(true);

				
			}

     }
}
