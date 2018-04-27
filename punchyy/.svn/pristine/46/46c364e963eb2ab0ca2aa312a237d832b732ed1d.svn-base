package com.etc.punchyy.bizimpl;

import java.util.List;

import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.dao.UserDao;
import com.etc.punchyy.daoimpl.UserDaoImpl;
import com.etc.punchyy.entity.User;

public class UserBizImpl implements UserBiz {

	UserDao dao = new UserDaoImpl();
//用户登录
	@Override
	public User login(int id, String pwd) {
		if (pwd==null||"".equals(pwd)||pwd.indexOf(" ")!=-1) {
			return null;
		} 
			return dao.login(id, pwd);
	}
	//添加新用户
	@Override
	public boolean register(User user) {
		if(user==null){
			return false;
		}
		if ("".equals(user.getUser_addr())||"".equals(user.getUser_name())||"".equals(user.getUser_pwd())||"".equals(user.getUser_tel())) {
			return false;
		}
		if (user.getUser_name().indexOf(" ")!=-1||user.getUser_pwd().indexOf(" ")!=-1) {
			return false;
		}
		return dao.register(user);
	}

	@Override
	//修改信用度
	public boolean updateCreditById(int id, double credit) {
		if (credit < 0 || credit > 5) {
			return false;
		}
		return dao.updateCreditById(id, credit);
	}

	@Override
	//id找用户
	public User queryUserById(int id) {
		if (id < 10001) {
			return null;
		}
		return dao.queryUserById(id);
	}

	@Override
	//充值
	public boolean rechargeMoneyById(User user, double money) {
		if (money <= 0||user==null) {
			return false;
		}
		return dao.rechargeMoneyById(user, money);
	}

	@Override
	//提现
	public boolean withdrawMoneyById(User user, double money) {
		if (money <= 0||user==null||money > user.getUser_money()) {
			return false;
		}
		return dao.withdrawMoneyById(user, money);
	}

	@Override
	//通过名字查找用户
	public User queryUserByName(String name) {
		if ("".equals(name)||name.indexOf(" ")!=-1) {
			return null;
		}
		return dao.queryUserByName(name);
	}

	@Override
	//修改密码
	public boolean updatePwdById(int id, String pwd) {
		if ("".equals(pwd)||id<=0) {
			return false;
		}
		return dao.updatePwdById(id, pwd);
	}

	@Override
	//修改电话
	public boolean updateTelById(int id, String tel) {
		char[] str=tel.toCharArray();
		for (int i = 0; i < str.length; i++) {
			if (!Character.isDigit(tel.charAt(i))) {
				return false;
			}
		}
		return dao.updateTelById(id, tel);
	}

	@Override
	//查找电话是否重复
	public int check(String tel) {
		// TODO Auto-generated method stub
		if("".equals(tel)){
			return 2;
		}
		return dao.check(tel);
	}
	@Override
	//全部用户
	public List<User> queryAll() {
	
		return dao.queryAll();
	}


}
