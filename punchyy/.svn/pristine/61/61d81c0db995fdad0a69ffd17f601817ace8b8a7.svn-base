package com.etc.punchyy.bizimpl;

import java.util.List;

import com.etc.punchyy.biz.MissionBiz;
import com.etc.punchyy.dao.MissionDao;
import com.etc.punchyy.daoimpl.MissionDaoImpl;
import com.etc.punchyy.entity.Mission;
import com.etc.punchyy.entity.User;

public class MissionBizImpl implements MissionBiz{
private MissionDao dao=new  MissionDaoImpl();
	@Override
	//添加任务
	public boolean addMission(Mission mission) {
		if(mission==null||"".equals(mission.getMission_detail())||"".equals(mission.getMission_name())||mission.getMission_reward()<=0.0){
			return false;
		}
		return dao.addMission(mission);
	}
	@Override
	//查找被雇者的任务
	public List<Mission> serchGet(User user) {
		return dao.serchGet(user);
	}

	@Override
	//根据雇主查找任务
	public List<Mission> serchMy(User user) {
		return dao.serchMy(user);
	}

	@Override
	//根据关键字查找任务详情符合的任务（不包括空格）
	public List<Mission> serchLike(String key,User user) {
		if("".equals(key)||key.indexOf(" ")!=-1||user==null){
			return null;
		}
		return dao.serchLike(key,user);
	}

	@Override
	//修改三种任务状态
	public boolean updateState(String state, int id) {
		if(state.equals("完成中")||state.equals("已完成")||state.equals("已过期")||state.equals("未领取")&&id>0){
		return dao.updateState(state, id);
		}
		return false;
	}

	@Override
	//查找全部的任务
	public List<Mission> serchAll() {
		return dao.serchAll();
	}

	@Override
	//查找没有完成的任务
	public List<Mission> serchUn(User user) {
		return dao.serchUn(user);
	}
	@Override
	//根据id查找任务
	public Mission serchById(int id) {
		if(id<0){
			return null;
		}
		return dao.serchById(id);
	}
	@Override
	//修改被雇佣者
	public boolean updateEmp(User emp, int id) {
		if(emp==null||id<0){
			return false;
		}
		return dao.updateEmp(emp, id);
	}
	@Override
	//根据订单删除订单
	public boolean deleteMission(int id) {
		if(id<0){
			return false;
		}
		return dao.deleteMission(id);
	}
	@Override
	//修改完成时间
	public boolean updateFinishTimeById(int id, String time) {
		if(id<0||"".equals(time)){
			return false;
		}
		return dao.updateFinishTimeById(id, time);
	}

}
