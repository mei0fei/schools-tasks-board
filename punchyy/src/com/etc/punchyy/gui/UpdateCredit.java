package com.etc.punchyy.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.FrameUtil;

import javax.swing.JButton;
import java.awt.Font;

public class UpdateCredit extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private String[] AllUser={"用户ID","用户名字","用户信誉"};
	private JButton gai,back;
	private int row;
	private String val;
	private User user;

	/**
	 * Create the frame.
	 */
	public UpdateCredit(User user1,User user2,User user){
		this.user=user;
		FrameUtil.initFrame(this,608,350);
		setTitle("信用度修改");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		UpdateCredit.this.dispose();
		}
		});
		
		List<User> list=new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 572, 244);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		tableModel = new DefaultTableModel(); 
		table = new JTable(tableModel);
		table.getTableHeader().setReorderingAllowed(false);   //不可整列移动   
		table.getTableHeader().setResizingAllowed(false);   //不可拉动表格	
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//表示只允许选中第一行
		String[][] data=new String [list.size()][AllUser.length];
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < AllUser.length; j++) {
				if(j==0){
					data[i][j] = list.get(i).getUser_id()+"";
				}else if(j==1){
					data[i][j] = list.get(i).getUser_name();
				}else if(j==2){
					data[i][j] = list.get(i).getUser_credit()+"";
				}
		}}
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setDataVector(data, AllUser);
		scrollPane.setViewportView(table);
		
	    table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				row = table.getSelectedRow();//获取选中的行号
				DefaultTableModel model = (DefaultTableModel) table.getModel();//获取defaulttablemodel
				val = (String) model.getValueAt(row, 2).toString();//根据行号和列号，获取某个单元格的值
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		gai = new JButton("修改");
		gai.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		gai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				if("".equals(val)){
					JOptionPane.showMessageDialog(UpdateCredit.this,"信用度不能为空");
					return;
				}else{
					if (Double.valueOf(val) >5||Double.valueOf(val)<0) {
						JOptionPane.showMessageDialog(UpdateCredit.this,"修改信用度违规");
						return;
					}else{
						int rowid = table.getSelectedRow();
						int id = Integer.valueOf((String) table
									.getValueAt(rowid, 0));
						UserBiz user=new UserBizImpl();
						user.updateCreditById(id,Double.valueOf(val));
						JOptionPane.showMessageDialog(UpdateCredit.this,"修改信用度成功");
					}
				}
			
		}
		});
		gai.setBounds(54, 279, 93, 23);
		contentPane.add(gai);
		
		back = new JButton("返回");
		back.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateCredit.this.dispose();
				Admin admin = new Admin(UpdateCredit.this.user);
			}
		});
		back.setBounds(409, 279, 93, 23);
		contentPane.add(back);
		

	}
}
