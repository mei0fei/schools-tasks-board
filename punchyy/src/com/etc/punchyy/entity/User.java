package com.etc.punchyy.entity;

public class User {
	private int user_id;  //用户ID
	private String user_name;  //用户姓名
	private String user_sex;   //用户性别
	private String user_tel;	//用户电话
	private double user_money;	//用户余额
	private double user_credit;	//用户信用度 0~5    0为黑名单
	private String user_pwd;	//用户密码
	private String user_addr;	//用户地址
	
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public double getUser_money() {
		return user_money;
	}
	public void setUser_money(double user_money) {
		this.user_money = user_money;
	}
	public double getUser_credit() {
		return user_credit;
	}
	public void setUser_credit(double user_credit) {
		this.user_credit = user_credit;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	
}
