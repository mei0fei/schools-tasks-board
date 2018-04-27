package com.etc.punchyy.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.etc.punchyy.biz.MissionBiz;
import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.MissionBizImpl;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.entity.Mission;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.FrameUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTable;
import java.awt.Font;

public class Home extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_3;
	private JTextField money;
	private JScrollPane scrollPane;
	private JButton btnNewButton_5;
	private JTextField textField;
	private JButton btnNewButton_7;
	private User user;
	private JTable table;
	private DefaultTableModel tableModel;
	private long old = 0, now = 0;
	private UserBiz userBiz = new UserBizImpl();
	private MissionBiz missionBiz = new MissionBizImpl();
	private String[] columName = { "任务单号", "委托人", "任务名", "任务报酬" };
	private String[] mymsiName = { "任务单号", "任务名", "任务报酬", "领取人", "状态" };
	private String[] mygetName = { "任务单号", "任务名", "任务报酬", "状态" };

	/**
	 * Create the frame.
	 */
	public Home(User user) {

		this.user = user;
		setTitle(user.getUser_addr() + "任务栏——" + user.getUser_name());
		FrameUtil.initFrame(this,818, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel_3 = new JLabel("余  额");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(651, 494, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		String double_str = String.format("%.2f", Home.this.user.getUser_money());
		money = new JTextField(double_str);
		
		money.setBounds(702, 491, 87, 25);
		money.setFocusable(false);
		contentPane.add(money);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 787, 422);
		contentPane.add(scrollPane);
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel) {
			// 表格不允许被编辑
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.getTableHeader().setReorderingAllowed(false); // 不可整列移动
		table.getTableHeader().setResizingAllowed(false); // 不可拉动表格
		table.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);// 表示只允许选中第一行
		List<Mission> list = missionBiz.serchUn(user);
		String[][] data = new String[list.size()][columName.length];
		// "任务单号","委托人","任务名","任务报酬" 未领取 完成中 已完成
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < columName.length; j++) {
				if (j == 0) {
					data[i][j] = list.get(i).getMission_id() + "";
				}
				if (j == 1) {
					data[i][j] = list.get(i).getMission_emper().getUser_name()
							+ "";
				}
				if (j == 2) {
					data[i][j] = list.get(i).getMission_name() + "";
				}
				if (j == 3) {
					data[i][j] = list.get(i).getMission_reward() + "";
				}
			}
		}
		// 获取table适配器
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setDataVector(data, columName);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int clickCount = arg0.getClickCount();
				if (clickCount == 2) {
					// 获取选中的行
					int rowid = table.getSelectedRow();
					// 获取选中的列
					int columid = table.getSelectedColumn();
					int id = Integer.valueOf((String) table
							.getValueAt(rowid, 0));
					Mission mission = missionBiz.serchById(id);
					MissionDetail missionDetail = new MissionDetail(mission,
							Home.this.user);
					Home.this.dispose();
					missionDetail.setVisible(true);
				}
			}
		});
		scrollPane.setViewportView(table);

		JButton btnNewButton_2 = new JButton("可领取的任务");
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new missionun());
		btnNewButton_2.setBounds(93, 30, 122, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("我发布的任务");
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_3.addActionListener(new mymission());
		btnNewButton_3.setBounds(257, 30, 122, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("我领取的任务");
		btnNewButton_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_4.addActionListener(new myGet());
		btnNewButton_4.setBounds(417, 30, 122, 23);
		contentPane.add(btnNewButton_4);

		btnNewButton_5 = new JButton("发布任务");
		btnNewButton_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_5.addActionListener(new newmis());
		btnNewButton_5.setBounds(70, 490, 104, 23);
		contentPane.add(btnNewButton_5);

		textField = new JTextField();
		textField.setBounds(605, 30, 87, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		btnNewButton_7 = new JButton("查找");
		btnNewButton_7.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_7.addActionListener(new seek());

		btnNewButton_7.setBounds(702, 30, 93, 23);
		contentPane.add(btnNewButton_7);
		JButton btnNewButton_8 = new JButton("举报投诉");
		btnNewButton_8.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Complain c = new Complain(Home.this.user);
				Home.this.dispose();
			}
		});
		btnNewButton_8.setBounds(205, 490, 104, 23);
		contentPane.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("个人中心");
		btnNewButton_9.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_9.addActionListener(new userWindow());
		btnNewButton_9.setBounds(524, 490, 104, 23);
		contentPane.add(btnNewButton_9);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 877, 553);
		lblNewLabel.setIcon(new ImageIcon("image/1.jpg"));
		contentPane.add(lblNewLabel);

		
	}

	public class seek implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Thread(new Runnable() {
				public void run() {
					String key = textField.getText();
					List<Mission> list = missionBiz.serchLike(key,user);
					if (list == null) {
						JOptionPane.showMessageDialog(Home.this, "抱歉，没有查到您需要的信息！");
					} else {
						// 获取适配器对象
						DefaultTableModel dtm = (DefaultTableModel) table.getModel();
						String[] columnNames = { "任务单号", "任务名", "赏金", "发布人", "任务状态" };
						String[][] rowData = new String[list.size()][5];
						for (int i = 0; i < list.size(); i++) {
							for (int j = 0; j < 5; j++) {
								if (j == 0) {
									rowData[i][0] = list.get(i).getMission_id() + "";
								} else if (j == 1) {
									rowData[i][1] = list.get(i).getMission_name() + "";
								} else if (j == 2) {
									rowData[i][2] = list.get(i).getMission_reward()
											+ "";
								} else if (j == 3) {
									rowData[i][3] = list.get(i).getMission_emper()
											.getUser_name()
											+ "";
								} else {
									rowData[i][4] = list.get(i).getMission_state() + "";
								}
							}
						}
						// 装配数据
						dtm.setDataVector(rowData, columnNames);
						scrollPane.setViewportView(table);
					}
				}
			}).start();
		}
	}

	public class newmis implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
					NewMission newMission = new NewMission(user);
					newMission.setVisible(true);
					Home.this.dispose();
		}
	}

	public class missionun implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
					List<Mission> list = missionBiz.serchUn(user);
					
					String[][] data = new String[list.size()][columName.length];
					// "任务单号","委托人","任务名","任务报酬" 未领取 完成中 已完成
					for (int i = 0; i < list.size(); i++) {
						for (int j = 0; j < columName.length; j++) {
							if (j == 0) {
								data[i][j] = list.get(i).getMission_id() + "";
							}
							if (j == 1) {
								data[i][j] = list.get(i).getMission_emper()
										.getUser_name()
										+ "";
							}
							if (j == 2) {
								data[i][j] = list.get(i).getMission_name() + "";
							}
							if (j == 3) {
								data[i][j] = list.get(i).getMission_reward() + "";
							}
						}
					}
					// 获取table适配器
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.setDataVector(data, columName);
		}
	}

	public class mymission implements ActionListener {
		// 我发布的任务按钮监听
		public void actionPerformed(ActionEvent arg0) {
					List<Mission> list = missionBiz.serchMy(user);
					String[][] data = new String[list.size()][mymsiName.length];
					// "任务单号","任务名","任务报酬","领取人","状态" 未领取 完成中 已完成
					for (int i = 0; i < list.size(); i++) {
						for (int j = 0; j < mymsiName.length; j++) {
							if (j == 0) {
								data[i][j] = list.get(i).getMission_id() + "";
							}
							if (j == 1) {
								data[i][j] = list.get(i).getMission_name() + "";
							}
							if (j == 2) {
								data[i][j] = list.get(i).getMission_reward()+ "";
							}
							if (j == 3) {
								if (list.get(i).getMission_emp() == null) {data[i][j] = "";
								} else {
									data[i][j] = list.get(i).getMission_emp().getUser_name()+ "";
								}
							}
							if (j == 4) {
								data[i][j] = list.get(i).getMission_state()+ "";
							}
						}
					}
					// 获取table适配器
					DefaultTableModel dtm = (DefaultTableModel) table
							.getModel();
					dtm.setDataVector(data, mymsiName);
		}
	}

	public class myGet implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
					List<Mission> list = missionBiz.serchGet(user);
					String[][] data = new String[list.size()][mygetName.length];
					// "任务单号","任务名","任务报酬","状态" 未领取 完成中 已完成
					for (int i = 0; i < list.size(); i++) {
						for (int j = 0; j < mygetName.length; j++) {
							if (j == 0) {
								data[i][j] = list.get(i).getMission_id() + "";
							}
							if (j == 1) {
								data[i][j] = list.get(i).getMission_name() + "";
							}
							if (j == 2) {
								data[i][j] = list.get(i).getMission_reward() + "";
							}
							if (j == 3) {
								data[i][j] = list.get(i).getMission_state() + "";
							}
						}
					}
					// 获取table适配器
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.setDataVector(data, mygetName);
		}
	}

	public class userWindow implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
					String double_str = String.format("%.2f", userBiz.queryUserById(Home.this.user.getUser_id()).getUser_money());
					money.setText(String.valueOf(double_str));
					UserWindow userWindow = new UserWindow(Home.this.user);
					Home.this.dispose();
			
		}
	}
}
