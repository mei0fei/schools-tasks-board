package com.etc.punchyy.tset;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.etc.punchyy.biz.MissionBiz;
import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.MissionBizImpl;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.entity.Mission;
import com.etc.punchyy.util.FrameUtil;

public class Test1 {

	public static void main(String[] args) {
//		
//		UserBiz biz=new UserBizImpl();
//		
//		Scanner s=new Scanner(System.in);
//		
//		System.out.println("������id");
//		int id=s.nextInt();
//		System.out.println("����������");
//		String pwd=s.next();
//		
//		if(biz.login(id, pwd)!=null){
//			System.out.println("��½�ɹ�");
//		}else{
//			System.out.println("��¼ʧ��");
//		}
		
//		  System.out.println(Character.isDigit('c'));
//	        System.out.println(Character.isDigit('5'));
//	
//	        
//	        String tel="16541635464";
//	        char[] str=tel.toCharArray();
//			for (int i = 0; i < str.length; i++) {
//				System.out.println(Character.isDigit(tel.charAt(i)));
//			}
//	
	
	
//			Scanner s=new Scanner(System.in);
//			System.out.println("��������");
//			String year=s.next();
//			
//			System.out.println("��������");
//			String month=s.next();
//			
//			System.out.println("��������");
//			String day=s.next();
//			
//			String time=year+"-"+month+"-"+day+" ";
//			
//			//ͨ��dateformate���ַ���ת����date
//			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//			
//			try {
//				Date date=df.parse(time);
//				System.out.println(date);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//			
		
		
//		
//		
//			Date date=new Date();//ϵͳ��ǰʱ��
//			Date date2=new Date(10000);//����1970��1��1��8��ĺ�����ʱ��	
//			System.out.println(date);
//			System.out.println(date2);
//			
//			
			Mission mission=new Mission();
//			
			MissionBiz missionBiz = new MissionBizImpl();
//			long old=0;
//			long now=0;
//			
//			List<Mission> list=missionBiz.serchAll();
//			for (int i = 0; i < list.size(); i++) {
//				
//			
//			String oldtime=list.get(i).getMission_time();
//			String nowtime=FrameUtil.getWebsiteDatetime();
//			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			
//			try {
//				old=df.parse(oldtime).getTime();
//				now=df.parse(nowtime).getTime();
//				if(now-old>=0){
//					missionBiz.updateState("δ��ȡ", list.get(i).getMission_id());
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
			
			
			
//			 String date1 = "2001-03-15 15-37-05";  
//		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//24Сʱ��  
////		      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");//12Сʱ��  
//		        long time2 = 0;
//				try {
//					time2 = simpleDateFormat.parse(date1).getTime();
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}  
//		        System.out.println(time2);  
			
//		long old=0,now=0;;
//		List<Mission> list=missionBiz.serchAll();
//		for (int i = 0; i < list.size(); i++) {
//		String oldtime=list.get(i).getMission_time();
//		String nowtime=FrameUtil.getWebsiteDatetime();
//		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			old=df.parse(oldtime).getTime();
//			now=df.parse(nowtime).getTime();
//			if(!list.get(i).getMission_state().equals("�����")){
//				if(list.get(i).getMission_emp()==null){
//					if(now-old>=0){
//						missionBiz.updateState("δ��ȡ", list.get(i).getMission_id());
//					}
//				}else{
//					missionBiz.updateState("�����", list.get(i).getMission_id());
//				}
//				
//			}
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//			
//	}
			
//			String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//			StringBuilder sb=new StringBuilder(6);
//			for(int i=0;i<6;i++)
//			{
//			char ch=str.charAt(new Random().nextInt(str.length()));
//			sb.append(ch);
//			}
//			System.out.println(sb.toString());


			
	}	
	
}