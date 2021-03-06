package com.etc.punchyy.dao;

import java.util.List;

import com.etc.punchyy.entity.User;

public interface UserDao {
	
	//登录
	public User login(int id,String pwd);
	
	//注册
	public boolean register(User user);
	
	//充值
	public boolean rechargeMoneyById(User user,double money);
	
	//提现
	public boolean withdrawMoneyById(User user,double money);
	
	//修改信用度
	public boolean updateCreditById(int id,double credit);
	
	//根据id查找用户信息
	public User queryUserById(int id);
	
	//根据用户名查询用户信息
	public User queryUserByName(String name);
	
	//根据id修改密码
	public boolean updatePwdById(int id,String pwd);
	
	//根据id修改电话
	public boolean updateTelById(int id,String tel);
	//检查是否重复
	public int check(String tel);
	
	//查找用户全部信息
	public List<User> queryAll();
}
