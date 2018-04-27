package com.etc.punchyy.dao;
import java.util.List;

import com.etc.punchyy.entity.Comp;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.JDBCUtil;

public interface CompDao {
	JDBCUtil util=new JDBCUtil();
	//��ӷ���
public boolean addMission(Comp comp);
    //ɾ������
public boolean delete(int id);
    //�۳�������
public boolean updateCredit(int id,int credit);
  //�������з�����ŵ�����
public List<Comp> queryAll();
 //ͨ��������ID��ѯ������
public Comp queryCompByID(int id);
}