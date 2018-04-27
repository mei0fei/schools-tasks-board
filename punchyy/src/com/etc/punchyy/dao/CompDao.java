package com.etc.punchyy.dao;
import java.util.List;

import com.etc.punchyy.entity.Comp;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.JDBCUtil;

public interface CompDao {
	JDBCUtil util=new JDBCUtil();
	//添加反馈
public boolean addMission(Comp comp);
    //删除反馈
public boolean delete(int id);
    //扣除信誉度
public boolean updateCredit(int id,int credit);
  //查找所有反馈编号的内容
public List<Comp> queryAll();
 //通过反馈单ID查询反馈单
public Comp queryCompByID(int id);
}