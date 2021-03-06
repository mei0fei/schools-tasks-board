package com.etc.punchyy.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.punchyy.dao.UserDao;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	JDBCUtil util = new JDBCUtil();
	@Override
	//用户登录验证
	public User login(int id, String pwd) {
		ResultSet rs = util.query("select * from t_user where user_id=? and user_pwd=?", id, pwd);
		User user = null;
		try {
			if (rs.next()) {
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_sex(rs.getString("user_sex"));
				user.setUser_tel(rs.getString("user_tel"));
				user.setUser_money(rs.getDouble("user_money"));
				user.setUser_credit(rs.getDouble("user_credit"));
				user.setUser_pwd(rs.getString("user_pwd"));
				user.setUser_addr(rs.getString("user_addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeAll();
		}
		return user;
	}

	@Override
	//注册功能
	public boolean register(User user) {
		int i = util.update("insert into t_user (user_name,user_sex,user_tel,user_money,user_credit,user_pwd,user_addr) values (?,?,?,?,?,?,?)",user.getUser_name(),user.getUser_sex(),user.getUser_tel(),user.getUser_money(),user.getUser_credit(), user.getUser_pwd(),user.getUser_addr());
		return i>0;
	}

	@Override
	//通过用户id修改信用度
	public boolean updateCreditById(int id, double credit) {
		int i=util.update("update t_user set user_credit=? where user_id=?", credit,id);
		return i>0;
	}
 
	@Override
	public User queryUserById(int id) {
		ResultSet rs = util.query("select * from t_user where user_id=?",id);
		User user = null;
		try {
			if (rs.next()) {
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_sex(rs.getString("user_sex"));
				user.setUser_tel(rs.getString("user_tel"));
				user.setUser_money(rs.getDouble("user_money"));
				user.setUser_credit(rs.getDouble("user_credit"));
				user.setUser_pwd(rs.getString("user_pwd"));
				user.setUser_addr(rs.getString("user_addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeAll();
		}
		return user;
	}

	@Override
	//充值
	public boolean rechargeMoneyById(User user, double money) {
		int i=util.update("update t_user set user_money=(user_money+?) where user_id=?",money ,user.getUser_id());
		return i>0;
	}

	@Override
	//提现
	public boolean withdrawMoneyById(User user, double money) {
		return util.update("update t_user set user_money=(user_money-?) where user_id=?", money,user.getUser_id()) >0;
	}

	@Override
	//通过用户名字查找该用户（系统用户名不会重复）
	public User queryUserByName(String name) {
		ResultSet rs = util.query("select * from t_user where user_name=?",name);
		User user = null;
		try {
			if (rs.next()) {
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_sex(rs.getString("user_sex"));
				user.setUser_tel(rs.getString("user_tel"));
				user.setUser_money(rs.getDouble("user_money"));
				user.setUser_credit(rs.getDouble("user_credit"));
				user.setUser_pwd(rs.getString("user_pwd"));
				user.setUser_addr(rs.getString("user_addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeAll();
		}
		return user;
	}

	@Override
	//修改密码
	public boolean updatePwdById(int id, String pwd) {
		int i=util.update("update t_user set user_pwd=? where user_id=?", pwd,id);
		return i>0;
	}

	@Override
	//修改电话
	public boolean updateTelById(int id, String tel) {
		int i=util.update("update t_user set user_tel=? where user_id=?", tel,id);
		return i>0;
	}

	@Override
	//查找电话是否重复(0电话没有注册，1电话已注册)
	public int check(String tel) {
		ResultSet rs=util.query("select user_name  from t_user where user_tel = ?", tel);
		String t = null;
		try {
			if(rs.next()){
				t=rs.getString("user_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		if(t==null){
			return 0;
		}
		return 1;
	}
	@Override
	//查找所有用户
	public List<User> queryAll() {
	ResultSet rs=util.query("select * from t_User");
	User user=null;
	List<User> list=new ArrayList<User>();
	try {
		while(rs.next()){
			user=new User();
			user.setUser_id(rs.getInt("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_sex(rs.getString("user_sex"));
			user.setUser_tel(rs.getString("user_tel"));
			user.setUser_money(rs.getDouble("user_money"));
			user.setUser_credit(rs.getDouble("user_credit"));
			user.setUser_pwd(rs.getString("user_pwd"));
			user.setUser_addr(rs.getString("user_addr"));
			list.add(user);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		util.closeAll();
	}
	return list;
	}

}
