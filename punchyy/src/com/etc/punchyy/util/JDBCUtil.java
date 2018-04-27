package com.etc.punchyy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	//��������
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	//�������ݿ��ַ
//	public static final String PATH = "jdbc:mysql://127.0.0.1:3306/yyy";
	public static final String PATH = "jdbc:mysql://172.18.20.59:3306/yyy";
	
	//�û���
	public static final String NAME = "root";
	//����
	public static final String PWD = "123";
//	public static final String PWD = "123456";
	//���Ӷ���
	private Connection con ;
	//Ԥ����������
	private PreparedStatement ps;
	//�����
	private ResultSet rs;
	
	
	/**��ȡ���Ӷ���
	 * 
	 * @return ���Ӷ���
	 */
	public Connection getcon(){
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(PATH,NAME,PWD);
		} catch (Exception e) {
			System.out.println("���ݿ������쳣��ԭ��"+e.getMessage());
		}
		return con;
	}
	
	/**
	 * �ر����ݿ����ӵķ���
	 */
	public void closeAll(){
		try {
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(con != null){
				con.close();
			}
		} catch (Exception e) {
			System.out.println("�ر����ݿ��Ƿ����쳣��ԭ��"+e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param sql	��ɾ�ĵ�sql���
	 * @param obj	��ͬ�������Ҫ�Ķ�̬����
	 * @return		sql���ִ�к���Ӱ������
	 */
	public int update (String sql,Object...obj){
		int result = 0;
		try {
			con=getcon();
			ps= con.prepareStatement(sql);
			if(obj != null){
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("ִ��sql��䷢���쳣��ԭ��"+e.getMessage());
		} finally{
			closeAll();
		}
		return result;
	}
	
	/**
	 * 
	 * @param sql ���ҵ����
	 * @param obj ��ͬ�������Ҫ�Ķ�̬����
	 * @return �����
	 */
	public ResultSet query(String sql,Object...obj){
		try {
			con=getcon();
			ps=con.prepareStatement(sql);
			if(obj != null){
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			rs= ps.executeQuery();
		} catch (Exception e) {
			System.out.println("ִ��sql��䷢���쳣��ԭ��"+e.getMessage());
		}
		return rs;
	}
	
	
}