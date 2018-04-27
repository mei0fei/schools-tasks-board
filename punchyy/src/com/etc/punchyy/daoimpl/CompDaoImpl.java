package com.etc.punchyy.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import com.etc.punchyy.biz.UserBiz;
import com.etc.punchyy.bizimpl.UserBizImpl;
import com.etc.punchyy.dao.CompDao;
import com.etc.punchyy.dao.MissionDao;
import com.etc.punchyy.dao.UserDao;
import com.etc.punchyy.entity.Comp;
import com.etc.punchyy.entity.User;



public class CompDaoImpl implements CompDao{
	@Override
	//添加投诉单
	public boolean addMission(Comp comp) {
	int i=util.update("insert into t_comp(comp_bad,comp_reason,comp_mission,comp_time) values(?,?,?,?) ",comp.getComp_bad().getUser_id(),comp.getComp_reason(),comp.getComp_mission().getMission_id(),comp.getComp_time());
		return i>0;
	}

	@Override
	//删除投诉单
	public boolean delete(int id) {
		return util.update("delete from t_Comp where Comp_id=?", id)>0;
	}

	@Override
	
	public boolean updateCredit(int id, int credit) {
		return util.update("update t_Comp set User_credit=? where User_id=?",credit,id)>0;
	}
	@Override
	public List<Comp> queryAll() {
	ResultSet rs=util.query("select * from t_comp");
	Comp comp=null;
	List<Comp> list=new ArrayList<Comp>();
	try {
		while(rs.next()){
			comp=new Comp();
			comp.setComp_id(rs.getInt("comp_id"));
			UserDao user=new UserDaoImpl();
			comp.setComp_bad(user.queryUserById(rs.getInt("comp_bad")));
			MissionDao mis=new MissionDaoImpl();
			comp.setComp_mission(mis.serchById(rs.getInt("comp_mission")));
			comp.setComp_reason(rs.getString("comp_reason"));
			if("".equals(rs.getString("comp_time"))){
				comp.setComp_time("");
			}else{
				comp.setComp_time(rs.getString("comp_time"));
			}
			list.add(comp);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		util.closeAll();
	}
		return list;
	}

	@Override
	public Comp queryCompByID(int id) {
	ResultSet rs=util.query("select * from t_comp where comp_id=?", id);
	Comp comp=null;
	try {
		if(rs.next()){
			comp=new Comp();
			UserDao user=new UserDaoImpl();
			comp.setComp_bad(user.queryUserById(rs.getInt("comp_bad")));
			MissionDao mis=new MissionDaoImpl();
			comp.setComp_mission(mis.serchById(rs.getInt("comp_mission")));
			comp.setComp_id(rs.getInt("comp_id"));
			comp.setComp_reason(rs.getString("comp_reason"));
			comp.setComp_time(rs.getString("comp_time"));
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		util.closeAll();
	}
		return comp;
	}
	}

