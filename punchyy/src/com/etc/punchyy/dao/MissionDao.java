package com.etc.punchyy.dao;



import java.util.List;
import java.util.Vector;

import com.etc.punchyy.entity.Mission;
import com.etc.punchyy.entity.User;

public interface MissionDao {
	//�������񣨵����û��Ĺ��ܣ�
	public boolean addMission(Mission mission);
	//���ݱ�����id��������
	public List<Mission> serchGet(User user);
	//���ݹ���id��������
	public List<Mission> serchMy(User user);
	//ģ���ؼ��ʴʲ���δ��ɵ�����
	public List<Mission> serchLike(String key,User user);
	//�����������޸�����״̬�������û��Ĺ��ܣ�
	public boolean updateState(String state,int id);
	//�鿴���еĶ���
	public List<Mission> serchAll();
	//�鿴����δ��ȡ�Ķ��� ��������ѯ�û�����ȷ���û�ҳ����ʾ�Ķ���ͬһ�ص������
	public List<Mission> serchUn(User user);
	//�ö���id��ѯ����
	public Mission serchById(int id);
	//���ݶ���ID���ӱ�����
	public boolean updateEmp(User emp,int id);
	//���ݶ���IDɾ������
	public boolean deleteMission(int id);
	//���ݶ���id�޸�ʱ��
	public boolean updateFinishTimeById(int id,String time);
	
	
}