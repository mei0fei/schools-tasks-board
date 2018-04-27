package com.etc.punchyy.bizimpl;

import java.util.List;

import com.etc.punchyy.biz.CompBiz;
import com.etc.punchyy.dao.CompDao;
import com.etc.punchyy.daoimpl.CompDaoImpl;
import com.etc.punchyy.entity.Comp;

public class CompBizImpl implements CompBiz{
	CompDao dao=new CompDaoImpl();

	@Override
	
	//添加投诉单
	public boolean addMission(Comp comp) {
	if("".equals(comp.getComp_reason())||comp.getComp_bad()==null && comp.getComp_mission()==null && comp.getComp_reason()==null){
		return false;}
	return dao.addMission(comp);
	}

	@Override
	//删除投诉单
	public boolean delete(int id) {
	if(id>0){
		return dao.delete(id);}
	return false;
	}

	@Override
	//修改信用度
	public boolean updateCredit(int id, int credit) {
	if(id>0&&(credit>=0||credit<=5)){
		return dao.updateCredit(id, credit);
	}return false;
	}
	//查看所有反馈的信息
	@Override
	public List<Comp> queryAll() {
		return dao.queryAll();
	}
	//返回该任务id的任务
	@Override
	public Comp queryCompByID(int id) {
		if(id>0){
			return dao.queryCompByID(id);
		}
		return null;
	}

}
