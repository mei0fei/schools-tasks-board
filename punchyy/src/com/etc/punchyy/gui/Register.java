package com.etc.punchyy.gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.dao.CityDao;
import com.etc.punchyy.daoimpl.CityDaoImpl;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.FrameUtil;
import com.etc.punchyy.util.NumberControl;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class Register extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField name;
	private JPasswordField pwd;
	private JPasswordField pwd1;
	private JTextField tel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton newone;
	private JLabel checkname,checkpwd,checkpwd1,checktel;
	private JRadioButton boy,girl;
	private String sex="��";
	private UserBiz ubi=new UserBizImpl();
	private CityDao cd=new CityDaoImpl();
	private JComboBox comboBox1,comboBox2,comboBox;
	private  String province="������",city="��Ͻ��",county="������";
	private ComboBoxModel  cbm2,cbm,cbm3;
	private JLabel lblNewLabel_5;
	
	//ע��ķ���
	public Register() {
		
		setTitle("ע���˺�");
		FrameUtil.initFrame(this,450,560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		Login login = new Login();
		Register.this.dispose();
		}
		});
		
		JLabel lblNewLabel = new JLabel("��    ��");
		lblNewLabel.setBounds(89, 39, 72, 18);
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("��    ��");
		lblNewLabel_1.setBounds(89, 79, 62, 18);
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ȷ������");
		lblNewLabel_2.setBounds(89, 119, 72, 18);
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setBounds(177, 38, 114, 24);
		contentPane.add(name);
		name.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						//���߳�ȥ���ݿ��ж������Ƿ��ظ�
						String name=Register.this.name.getText();
						if("".equals(name)){
							checkname.setText("���ֲ���Ϊ��");
							checkname.setForeground(Color.RED);
						}else if(name.indexOf(" ")!=-1){
							checkname.setText("���ֲ��ܴ��ո�");
							checkname.setForeground(Color.RED);
						}else if(ubi.queryUserByName(name)!=null){
							checkname.setText( "������ע��");
							checkname.setForeground(Color.RED);
						}else{
							checkname.setText("��");
							Register.this.checkname.setForeground(Color.green);
						}
					}
				}).start();
				
			}
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
		pwd = new JPasswordField();
		pwd.setBounds(177, 78, 114, 24);
		contentPane.add(pwd);
		pwd.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				//�ж�����
				String pwd=new String(Register.this.pwd.getPassword());
				if("".equals(pwd)){
					checkpwd.setText("���벻��Ϊ��");
					checkpwd.setForeground(Color.RED);
				}else if(pwd.indexOf(" ")!=-1){
					checkpwd.setText("���벻�ܴ��ո�");
					checkpwd.setForeground(Color.RED);
					}else if(pwd.length()<8){
					checkpwd.setText("������ڼ�");
					checkpwd.setForeground(Color.RED);
					}
				else{
					Register.this.checkpwd.setText("��");
					checkpwd.setForeground(Color.green);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});
		pwd1 = new JPasswordField();
		pwd1.setBounds(177, 118, 114, 24);
		contentPane.add(pwd1);
		pwd1.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// �ж϶�������������Ƿ���Ϲ���
				String pwd=new String(Register.this.pwd.getPassword());
				String pwd1=new String(Register.this.pwd1.getPassword());
				if(!pwd.equals(pwd1) ){
					Register.this.checkpwd1.setText("�������벻ͬ");
					Register.this.checkpwd1.setForeground(Color.RED);
				}else if(!"".equals(pwd1)){
					Register.this.checkpwd1.setText("��");
					checkpwd1.setForeground(Color.green);}
			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("\u6027    \u522B");
		lblNewLabel_3.setBounds(89, 159, 72, 18);
		lblNewLabel_3.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7535    \u8BDD");
		lblNewLabel_4.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(89, 199, 72, 18);
		contentPane.add(lblNewLabel_4);

		tel = new JTextField();
		tel.setDocument(new NumberControl(11));
		tel.setBounds(177, 198, 114, 24);
		contentPane.add(tel);
		tel.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// ���߳�ȥ���ݿ��жϵ绰�Ƿ��ظ�
				new Thread(new  Runnable() {
					public void run() {
						if("".equals(tel.getText())){
							checktel.setText("�绰����Ϊ��");
							checktel.setForeground(Color.RED);
						}else if(tel.getText().length()<11){
							checktel.setText("����д��ȷ�ĵ绰");
							checktel.setForeground(Color.RED);
						}
						//1Ϊ�绰��ע�� 2Ϊ�����˿յĵ绰��ǰ���Ѿ���ֹ�˿յĵ绰����
						else if(1==ubi.check(tel.getText())){
							checktel.setText("�绰��ע��");
							checktel.setForeground(Color.RED);}
						else{
							checktel.setText("��");
							checktel.setForeground(Color.green);
						}
					}
				}).start();
			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 305, 221, 143);
		contentPane.add(scrollPane);
		textArea = new JTextArea("ע����֪��\nע������ڷ�������ͽ�������\n���ܽ���Υ��Υ�ͻ\n����ʵ������ʵ����Ϣ\n�绰Ϊ������Ŀ���Ա���и��õĹ�ͨ\n���н���Ȩ�鱾��˾����\nδ�����");
		scrollPane.setViewportView(textArea);
		textArea.setFocusable(false);
		
		newone = new JButton("\u6CE8    \u518C");
		newone.setBounds(148, 471, 120, 41);
		newone.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		newone.addActionListener(this);
		contentPane.add(newone);
		
		checkname = new JLabel("");
		checkname.setBounds(305, 41, 91, 18);
		contentPane.add(checkname);
		
		checkpwd = new JLabel("");
		checkpwd.setBounds(305, 81, 91, 18);
		contentPane.add(checkpwd);
		
		checkpwd1 = new JLabel("");
		checkpwd1.setBounds(305, 121, 91, 18);
		contentPane.add(checkpwd1);
		
		checktel = new JLabel("");
		checktel.setBounds(305, 201, 107, 18);
		contentPane.add(checktel);
		
		boy = new JRadioButton("\u7537");
		boy.setBounds(177, 157, 60, 27);
		boy.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(boy);
		boy.addActionListener(this);
		boy.setSelected(true);
		
		girl = new JRadioButton("\u5973");
		girl.setBounds(253, 157, 60, 27);
		girl.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		girl.addActionListener(this);
		contentPane.add(girl);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(boy);
		bg.add(girl);
		
		JLabel label = new JLabel("\u5730    \u5740");
		label.setBounds(89, 239, 72, 18);
		label.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(label);
		//ʡ�ĵ�������
		comboBox = new JComboBox();
		comboBox.setBounds(89, 268, 91, 24);
		comboBox.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		contentPane.add(comboBox);
		//������д�½����ʡ��ѡ��
		cbm=new DefaultComboBoxModel(cd.serch(0));
		comboBox.setModel(cbm);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���������װ���к��ص�����
				Object object= comboBox.getSelectedItem();
				province=(String) object;
				Vector ve=new Vector(cd.serchByKey(province));
				Vector ve1=new Vector(cd.serchBy((String) ve.get(0),province));
				cbm2=new DefaultComboBoxModel(ve);
				//�������
				comboBox1.setModel(cbm2);
				cbm3=new DefaultComboBoxModel(ve1);
				comboBox2.setModel(cbm3);
				//��ȡĬ��ֵ 
				city=(String) ve.get(0);
				county=(String) ve1.get(0);
			}
		});
		//�еĵ�������
		comboBox1 = new JComboBox();
		comboBox1.setBounds(177, 268, 91, 24);
		comboBox1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		cbm2=new DefaultComboBoxModel(cd.serch(1));
		comboBox1.setModel(cbm2);
		
		comboBox1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȡѡ�е���
				Object object= comboBox1.getSelectedItem();
				city=(String) object;
				Vector ve=new Vector(cd.serchBy(city,province));
				cbm3=new DefaultComboBoxModel(ve);
				comboBox2.setModel(cbm3);
				//��ȡĬ���� ��Ĭ��ֵ
				county=(String) ve.get(0);
			}
		});
		contentPane.add(comboBox1);
		//���ĵ�������
		comboBox2 = new JComboBox();
		comboBox2.setBounds(268, 268, 91, 24);
		comboBox2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		cbm3=new DefaultComboBoxModel(cd.serch(35));
		comboBox2.setModel(cbm3);
		comboBox2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȡѡ�е���
				Object object= comboBox2.getSelectedItem();
				county=(String) object;
			}
		});
		contentPane.add(comboBox2);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, 0, 449, 522);
		lblNewLabel_5.setIcon(new ImageIcon("image/register.png"));
		contentPane.add(lblNewLabel_5);
//		if("".equals(checkage.getText())&&"".equals(checkname.getText())&&"".equals(checkpwd.getText())&&"".equals(checkpwd1.getText())&&"".equals(checkdept.getText())){
//			newone.setVisible(true);
//		}
//		&&!"".equals(this.role.getText())&&!"".equals(new String(this.pwd.getPassword()))&&!"".equals(new String(this.pwd1.getPassword()))&&!"".equals(this.dept.getText())&&!"".equals(this.age.getText())
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JButton){
			if("".equals(this.name.getText())||"".equals(new String(this.pwd.getPassword()))||"".equals(new String(this.pwd1.getPassword()))||"".equals(this.tel.getText()))
			{
					JOptionPane.showMessageDialog(Register.this, "������δ�������Ϣ");
					return;
			}else if(!"��".equals(checktel.getText())||!"��".equals(checkname.getText())||!"��".equals(checkpwd.getText())||!"��".equals(checkpwd1.getText())){
				JOptionPane.showMessageDialog(Register.this, "���������Ϣ");
				return;
				}
			else{// �����еĶ�����user ���÷���
					User u=new User();
					u.setUser_credit(1);
					u.setUser_money(10);
					u.setUser_name(this.name.getText());
					u.setUser_sex(sex);
					u.setUser_pwd(new String(this.pwd1.getPassword()));
					u.setUser_tel(this.tel.getText());
					u.setUser_addr(province+city+county);
					int i=ubi.check(u.getUser_tel());
					
					if(ubi.register(u)){
						//�ɹ������ע���id
						JOptionPane.showMessageDialog(this, "ע��ɹ�,����idΪ"+ubi.queryUserByName(u.getUser_name()).getUser_id());
						Login l=new Login();
						this.dispose();
					}else{
						JOptionPane.showMessageDialog(this, "ע��ʧ��");
					}
				}
			}
			if(e.getSource()instanceof JRadioButton){
			JRadioButton jrb=(JRadioButton) e.getSource();
			if(jrb.isSelected()){
				//��ȡѡ����Ա�
				Register.this.sex=jrb.getText();
			}
		}
	}
}