package com.etc.punchyy.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.print.attribute.AttributeSet;
import javax.swing.JFrame;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class FrameUtil {

	/**
	 * @param args
	 */
	public static void initFrame(JFrame frame,int width,int height ) {
		// TODO Auto-generated method stub
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension =toolkit.getScreenSize();
		int x =(int)dimension.getWidth();
		int y =(int)dimension.getHeight();
		frame.setBounds((x-width)/2, (y-height)/2, width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	
	
	public static String getWebsiteDatetime(){
	        try {
	        	String webUrl = "http://www.baidu.com";//��ðٶȵı���ʱ��
	            URL url = new URL(webUrl);// ȡ����Դ����
	            URLConnection uc = url.openConnection();// �������Ӷ���
	            uc.connect();// ��������
	            long ld = uc.getDate();// ��ȡ��վ����ʱ��
	            Date date = new Date(ld);// ת��Ϊ��׼ʱ�����
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);// �������ʱ��
	            sdf.format(date);
	            return sdf.format(date);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	
}
	