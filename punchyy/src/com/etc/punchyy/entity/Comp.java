package com.etc.punchyy.entity;

public class Comp {
	private int comp_id;			//�ٱ�����
	private User comp_bad;			//���ٱ���	��mysql����ʾ���ٱ���ID
	private Mission comp_mission;	//���ٱ�������  ��mysql����ʾ����
	private String comp_reason;		//�ٱ�����
	private String comp_time;		//�ٱ�ʱ��
	public int getComp_id() {
		return comp_id;
	}
	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}
	public User getComp_bad() {
		return comp_bad;
	}
	public void setComp_bad(User comp_bad) {
		this.comp_bad = comp_bad;
	}
	public Mission getComp_mission() {
		return comp_mission;
	}
	public void setComp_mission(Mission comp_mission) {
		this.comp_mission = comp_mission;
	}
	public String getComp_reason() {
		return comp_reason;
	}
	public void setComp_reason(String comp_reason) {
		this.comp_reason = comp_reason;
	}
	public String getComp_time() {
		return comp_time;
	}
	public void setComp_time(String comp_time) {
		this.comp_time = comp_time;
	}
	
	
}