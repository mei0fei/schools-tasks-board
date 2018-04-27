package com.etc.punchyy.gui;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.etc.punchyy.biz.CompBiz;
import com.etc.punchyy.biz.MissionBiz;
import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.CompBizImpl;
import com.etc.punchyy.bizimpl.MissionBizImpl;
import com.etc.punchyy.bizimpl.UserBizImpl;

import com.etc.punchyy.entity.Comp;
import com.etc.punchyy.entity.Mission;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.FrameUtil;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Admin extends JFrame {

	private JPanel contentPane;
	private User user;
	private JTable table;
	private JScrollPane allinfo;
	private JButton report, allmis, info, back;// ȫ��������ȫ��������Ϣ�������������û���Ϣ
	private String[] columName = { "Ͷ�ߵ����", "Ͷ�߶�����", "��Ͷ��������", "Ͷ��ԭ��", "Ͷ��ʱ��" };
	private String[] AllMis = { "���񵥺�", "��������", "����", "�ܹ���", "���񷢲�ʱ��", "�����Ƿ���ȡ" };
	private String[] AllUser = { "�û�ID", "�û�����", "�Ա�", "��ϵ��ʽ", "���", "���ö�",
			"����", "�û���ַ" };
	private CompBiz compbiz = new CompBizImpl();
	private DefaultTableModel tableModel;
	private MissionBiz missionbiz = new MissionBizImpl();
	private UserBiz userb = new UserBizImpl();
	private int i = 1;
	private long old = 0, now = 0;
	private JButton refresh;
	private UserBiz userBiz = new UserBizImpl();
	private MissionBiz missionBiz = new MissionBizImpl();

	/**
	 * Create the frame.
	 */
	public Admin(User user) {
		this.user = user;
		setTitle("����");
		FrameUtil.initFrame(this, 1050, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		allinfo = new JScrollPane();
		allinfo.setBounds(21, 43, 1003, 600);
		contentPane.add(allinfo);

		allmis = new JButton("��������");
		allmis.addActionListener(new getmission());
		allmis.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		allmis.setBounds(346, 10, 116, 23);
		contentPane.add(allmis);

		info = new JButton("�û���Ϣ");
		info.addActionListener(new getuser());
		info.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		info.setBounds(638, 10, 106, 23);
		contentPane.add(info);

		back = new JButton("�˳�");
		back.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin.this.dispose();
			}
		});
		back.setBounds(903, 10, 106, 23);
		contentPane.add(back);

		allinfo.setViewportView(table);

		report = new JButton("�յ���Ͷ��");
		report.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		report.addActionListener(new getreport());
		report.setBounds(66, 10, 116, 23);
		contentPane.add(report);

		// Ĭ�Ͻ���
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.getTableHeader().setReorderingAllowed(false); // ���������ƶ�
		table.getTableHeader().setResizingAllowed(false); // ������������
		table.getSelectionModel().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);// ��ʾֻ����ѡ�е�һ��

		List<Comp> list = compbiz.queryAll();
		String[][] data = new String[list.size()][columName.length];
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < columName.length; j++) {
				if (j == 0) {
					data[i][j] = list.get(i).getComp_id() + "";
				} else if (j == 1) {
					data[i][j] = list.get(i).getComp_mission().getMission_id()
							+ "";
				} else if (j == 2) {
					data[i][j] = list.get(i).getComp_bad().getUser_name() + "";
				} else if (j == 3) {
					data[i][j] = list.get(i).getComp_reason() + "";
				} else if (j == 4) {
					data[i][j] = list.get(i).getComp_time() + "";
				}

			}
		}
		// ��ȡtable������
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setDataVector(data, columName);
		allinfo.setViewportView(table);

		
		
		// а�����
		refresh = new JButton("ˢ�ºٺ�");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (i == 1) {
					List<Comp> list = compbiz.queryAll();
					String[][] data = new String[list.size()][columName.length];
					for (int i = 0; i < list.size(); i++) {
						for (int j = 0; j < columName.length; j++) {
							if (j == 0) {
								data[i][j] = list.get(i).getComp_id() + "";
							} else if (j == 1) {
								data[i][j] = list.get(i).getComp_mission()
										.getMission_id()
										+ "";
							} else if (j == 2) {
								data[i][j] = list.get(i).getComp_bad()
										.getUser_name();
							} else if (j == 3) {
								data[i][j] = list.get(i).getComp_reason();
							} else if (j == 4) {
								data[i][j] = list.get(i).getComp_time();
							}

						}
					}// ��ȡtable������
					DefaultTableModel dtm = (DefaultTableModel) table
							.getModel();
					dtm.setDataVector(data, columName);

				}
				if (i == 2) {
					List<Mission> list = missionbiz.serchAll();
					String[][] data = new String[list.size()][AllMis.length];
					for (int i = 0; i < list.size(); i++) {
						for (int j = 0; j < AllMis.length; j++) {
							if (j == 0) {
								data[i][j] = list.get(i).getMission_id() + "";
							} else if (j == 1) {
								data[i][j] = list.get(i).getMission_name();
							} else if (j == 2) {
								if (list.get(i).getMission_emper() == null) {
									data[i][j] = "";
								} else {
									data[i][j] = list.get(i).getMission_emper()
											.getUser_name();
								}
							} else if (j == 3) {
								if (list.get(i).getMission_emp() == null) {
									data[i][j] = "";
								} else {
									data[i][j] = list.get(i).getMission_emp()
											.getUser_name();
								}
							} else if (j == 4) {
								data[i][j] = list.get(i).getMission_time();
							} else if (j == 5) {
								data[i][j] = list.get(i).getMission_state();
							}

						}
					}// ��ȡtable������
					DefaultTableModel dtm = (DefaultTableModel) table
							.getModel();
					dtm.setDataVector(data, AllMis);

				}
			}
		});
		
		refresh.setVisible(false);
		refresh.setBounds(369, 680, 93, 20);
		contentPane.add(refresh);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int clickCount = arg0.getClickCount();
				if (clickCount == 2) {
					// ��ȡѡ�е���
					int rowid = table.getSelectedRow();
					int id = Integer.valueOf((String) table
							.getValueAt(rowid, 0));
					if (i == 1) {
						// ��ȡѡ�е���

						Comp comp = compbiz.queryCompByID(id);
						CompDetail cp = new CompDetail(comp, refresh,Admin.this.user);
						Admin.this.dispose();
					}
					if (i == 2) {
						Mission AM = missionbiz.serchById(id);
						AdMission mm = new AdMission(AM, refresh,Admin.this.user);
						Admin.this.dispose();
					}
				}
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1045, 770);
		lblNewLabel.setIcon(new ImageIcon("image/admin.jpg"));
		contentPane.add(lblNewLabel);
		
				
		ThreadTime threadTime = new ThreadTime();
		Thread threadMain=Thread.currentThread();
		threadTime.setDaemon(true);
		threadTime.start();
		
	}
	
	
	public class ThreadTime extends Thread{
		@Override
		public void run() {
			while (true) {
			try {
				Thread.sleep(3600000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			List<Mission> list = missionBiz.serchAll();
			for (int i = 0; i < list.size(); i++) {
				String oldtime = list.get(i).getMission_time();
				String nowtime = FrameUtil.getWebsiteDatetime();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					old = df.parse(oldtime).getTime();
					now = df.parse(nowtime).getTime();
					if (!list.get(i).getMission_state().equals("�����")
							&& !list.get(i).getMission_state().equals("�ѹ���")) {
						if (now - old >= 259200000) { // 3����δ����ȡ������������״̬
							missionBiz.updateState("�ѹ���", list.get(i).getMission_id());
						} else if (now - old > 864000000
								&& list.get(i).getMission_state().equals("�ѹ���")) {
							missionBiz.deleteMission(list.get(i)
									.getMission_emper().getUser_id()); // ����������7��ɾ��
							userBiz.rechargeMoneyById(list.get(i)		//��Ǯ�˻�������
									.getMission_emper(), list.get(i).getMission_reward());
						}
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		}
	}

	// ����������
	public class getreport implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			i = 1;
			List<Comp> list = compbiz.queryAll();
			String[][] data = new String[list.size()][columName.length];
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < columName.length; j++) {
					if (j == 0) {
						data[i][j] = list.get(i).getComp_id() + "";
					} else if (j == 1) {
						data[i][j] = list.get(i).getComp_mission()
								.getMission_id()
								+ "";
					} else if (j == 2) {
						data[i][j] = list.get(i).getComp_bad().getUser_name();
					} else if (j == 3) {
						data[i][j] = list.get(i).getComp_reason();
					} else if (j == 4) {
						data[i][j] = list.get(i).getComp_time();
					}

				}
			}// ��ȡtable������
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setDataVector(data, columName);

		}
	}

	// �������񵥽���
	public class getmission implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			i = 2;
			List<Mission> list = missionbiz.serchAll();
			String[][] data = new String[list.size()][AllMis.length];
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < AllMis.length; j++) {
					if (j == 0) {
						data[i][j] = list.get(i).getMission_id() + "";
					} else if (j == 1) {
						data[i][j] = list.get(i).getMission_name();
					} else if (j == 2) {
						if (list.get(i).getMission_emper() == null) {
							data[i][j] = "";
						} else {
							data[i][j] = list.get(i).getMission_emper()
									.getUser_name();
						}
					} else if (j == 3) {
						if (list.get(i).getMission_emp() == null) {
							data[i][j] = "";
						} else {
							data[i][j] = list.get(i).getMission_emp()
									.getUser_name();
						}
					} else if (j == 4) {
						data[i][j] = list.get(i).getMission_time();
					} else if (j == 5) {
						data[i][j] = list.get(i).getMission_state();
					}

				}
			}// ��ȡtable������
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setDataVector(data, AllMis);

		}
	}

	public class getuser implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			i = 3;
			List<User> list = userb.queryAll();
			String[][] data = new String[list.size()][AllUser.length];
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < AllUser.length; j++) {
					if (j == 0) {
						data[i][j] = list.get(i).getUser_id() + "";
					} else if (j == 1) {
						data[i][j] = list.get(i).getUser_name();
					} else if (j == 2) {
						data[i][j] = list.get(i).getUser_sex();
					} else if (j == 3) {
						data[i][j] = list.get(i).getUser_tel();
					} else if (j == 4) {
						data[i][j] = list.get(i).getUser_money() + "";
					} else if (j == 5) {
						data[i][j] = list.get(i).getUser_credit() + "";
					} else if (j == 6) {
						data[i][j] = list.get(i).getUser_pwd();
					} else if (j == 7) {
						data[i][j] = list.get(i).getUser_addr();
					}
				}
			}// ��ȡtable������
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			dtm.setDataVector(data, AllUser);
			dtm.fireTableStructureChanged();
			dtm.fireTableDataChanged();

		}
	}
}