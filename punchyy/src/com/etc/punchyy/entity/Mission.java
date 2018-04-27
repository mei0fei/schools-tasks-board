package com.etc.punchyy.entity;

public class Mission {
	private int mission_id;			//任务编号
	private String mission_name;	//任务名称
	private String mission_detail;	//任务详情
	private User mission_emper;		//发布任务的人（雇主）  在mysql显示雇主ID
	private User mission_emp;		//接任务的人（雇员）      在mysql显示雇员ID
	private double mission_reward;	//任务报酬
	private String mission_time;	//任务发布时间
	private String mission_state;  //任务状态  未领取  完成中  已完成
	private String mission_finish; //任务完成的时间 
	public int getMission_id() {
		return mission_id;
	}
	public void setMission_id(int mission_id) {
		this.mission_id = mission_id;
	}
	public String getMission_name() {
		return mission_name;
	}
	public void setMission_name(String mission_name) {
		this.mission_name = mission_name;
	}
	public String getMission_detail() {
		return mission_detail;
	}
	public void setMission_detail(String mission_detail) {
		this.mission_detail = mission_detail;
	}
	public User getMission_emper() {
		return mission_emper;
	}
	public void setMission_emper(User mission_emper) {
		this.mission_emper = mission_emper;
	}
	public User getMission_emp() {
		return mission_emp;
	}
	public void setMission_emp(User mission_emp) {
		this.mission_emp = mission_emp;
	}
	public double getMission_reward() {
		return mission_reward;
	}
	public void setMission_reward(double mission_reward) {
		this.mission_reward = mission_reward;
	}
	public String getMission_time() {
		return mission_time;
	}
	public void setMission_time(String mission_time) {
		this.mission_time = mission_time;
	}
	public String getMission_state() {
		return mission_state;
	}
	public void setMission_state(String mission_state) {
		this.mission_state = mission_state;
	}
	public String getMission_finish() {
		return mission_finish;
	}
	public void setMission_finish(String mission_finish) {
		this.mission_finish = mission_finish;
	}
	
	
}
