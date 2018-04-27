package com.etc.punchyy.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.etc.punchyy.dao.MissionDao;
import com.etc.punchyy.dao.UserDao;
import com.etc.punchyy.entity.Mission;
import com.etc.punchyy.entity.User;
import com.etc.punchyy.util.JDBCUtil;

public class MissionDaoImpl implements MissionDao {
	JDBCUtil util = new JDBCUtil();
	UserDao dao = new UserDaoImpl();
	@Override
	public boolean addMission(Mission mission) {
		// 添加订单
		return util.update("insert into t_mission(mission_name,mission_detail,mission_emper,mission_reward,mission_time,mission_state) values(?,?,?,?,?,?)", mission.getMission_name(),mission.getMission_detail(),mission.getMission_emper().getUser_id(),mission.getMission_reward(),mission.getMission_time(),"未领取")>0;
	}

	@Override
	public List<Mission> serchGet(User user) {
		// 根据被雇者id查找任务
		ResultSet rs = util.query("select * from t_mission where mission_emp=?",user.getUser_id());
		List<Mission> list = new ArrayList<Mission>();
		try {
			while (rs.next()) {
				Mission m = new Mission();
				m.setMission_detail(rs.getString("mission_detail"));
				m.setMission_emp(dao.queryUserById(rs.getInt("mission_emp")));
				m.setMission_emper(dao.queryUserById(rs.getInt("mission_emper")));
				m.setMission_id(rs.getInt("mission_id"));
				if (!"".equals(rs.getString("mission_finish"))) {
					m.setMission_finish(rs.getString("mission_finish"));
				}
				m.setMission_name(rs.getString("mission_name"));
				m.setMission_reward(rs.getDouble("mission_reward"));
				m.setMission_state(rs.getString("mission_state"));
				m.setMission_time(rs.getString("mission_time"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeAll();
		}
		return list;
	}

	// 根据雇主id查找任务
	@Override
	public List<Mission> serchMy(User user) {

		ResultSet rs = util.query("select * from t_mission where mission_emper= ?",user.getUser_id());
		List<Mission> list = new ArrayList<Mission>();
		try {
			while (rs.next()) {
				Mission m = new Mission();
				m.setMission_detail(rs.getString("mission_detail"));
				if (!"".equals(rs.getInt("mission_emp"))) {
					m.setMission_emp(dao.queryUserById(rs.getInt("mission_emp")));
				}
				m.setMission_emper(dao.queryUserById(rs.getInt("mission_emper")));
				m.setMission_id(rs.getInt("mission_id"));
				if (!"".equals(rs.getString("mission_finish"))) {
					m.setMission_finish(rs.getString("mission_finish"));
				}
				m.setMission_name(rs.getString("mission_name"));
				m.setMission_reward(rs.getDouble("mission_reward"));
				m.setMission_state(rs.getString("mission_state"));
				m.setMission_time(rs.getString("mission_time"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeAll();
		}
		return list;

	}

	// 模糊关键词词查找未完成的任务
	@Override
	public List<Mission> serchLike(String key,User user) {
		ResultSet rs = util.query("select * from t_mission where mission_detail like ? and mission_state='未领取' and Mission_emper in(SELECT User_id from t_user where User_addr=? ) ","%" + key + "%",user.getUser_addr());
		List<Mission> list = new ArrayList<Mission>();
		try {
			while (rs.next()) {
				Mission m = new Mission();
				m.setMission_detail(rs.getString("mission_detail"));
				if (!"".equals(rs.getInt("mission_emp"))) {
					m.setMission_emp(dao.queryUserById(rs.getInt("mission_emp")));
				}
				m.setMission_emper(dao.queryUserById(rs.getInt("mission_emper")));
				m.setMission_id(rs.getInt("mission_id"));
				if (!"".equals(rs.getString("mission_finish"))) {
					m.setMission_finish(rs.getString("mission_finish"));
				}
				m.setMission_name(rs.getString("mission_name"));
				m.setMission_reward(rs.getDouble("mission_reward"));
				m.setMission_state(rs.getString("mission_state"));
				m.setMission_time(rs.getString("mission_time"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeAll();
		}
		return list;
	}

	// 根据任务编号修改任务状态（调用用户的功能）
	@Override
	public boolean updateState(String state, int id) {
		return util.update("update t_mission set mission_state=? where mission_id=?",state, id) > 0;}

	// 查看所有的订单
	@Override
	public List<Mission> serchAll() {
		ResultSet rs = util.query("select * from t_mission" );
		List<Mission> list = new ArrayList<Mission>();
		try {
			while (rs.next()) {
				Mission m = new Mission();
				m.setMission_detail(rs.getString("mission_detail"));
				if (!"".equals(rs.getInt("mission_emp"))) {
					m.setMission_emp(dao.queryUserById(rs.getInt("mission_emp")));
				}
				m.setMission_emper(dao.queryUserById(rs.getInt("mission_emper")));
				m.setMission_id(rs.getInt("mission_id"));
				if (!"".equals(rs.getString("mission_finish"))) {
					m.setMission_finish(rs.getString("mission_finish"));
				}
				m.setMission_name(rs.getString("mission_name"));
				m.setMission_reward(rs.getDouble("mission_reward"));
				m.setMission_state(rs.getString("mission_state"));
				m.setMission_time(rs.getString("mission_time"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeAll();
		}
		return list;
	}

	// 查看所有该地区未领取的订单
	@Override
	public List<Mission> serchUn(User user) {
		ResultSet rs = util.query("SELECT * from t_mission where mission_state='未领取' and Mission_emper in(SELECT User_id from t_user where User_addr=? )",user.getUser_addr());
		List<Mission> list = new ArrayList<Mission>();
		try {
			while (rs.next()) {
				Mission m = new Mission();
				m.setMission_detail(rs.getString("mission_detail"));
				if (!"".equals(rs.getInt("mission_emp"))) {
					m.setMission_emp(dao.queryUserById(rs.getInt("mission_emp")));
				}
				m.setMission_emper(dao.queryUserById(rs.getInt("mission_emper")));
				m.setMission_id(rs.getInt("mission_id"));
				if (!"".equals(rs.getString("mission_finish"))) {
					m.setMission_finish(rs.getString("mission_finish"));
				}
				m.setMission_name(rs.getString("mission_name"));
				m.setMission_reward(rs.getDouble("mission_reward"));
				m.setMission_state(rs.getString("mission_state"));
				m.setMission_time(rs.getString("mission_time"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeAll();
		}
		return list;
	}

	@Override
	public Mission serchById(int id) {
		// 通过任务id找到该任务
		ResultSet rs = util.query("select * from t_mission where mission_id=?",id);
		Mission m = null;
		try {
			if (rs.next()) {
				m = new Mission();
				m.setMission_detail(rs.getString("mission_detail"));
				if (!"".equals(rs.getInt("mission_emp"))) {
					m.setMission_emp(dao.queryUserById(rs.getInt("mission_emp")));
				}
				m.setMission_emper(dao.queryUserById(rs.getInt("mission_emper")));
				m.setMission_id(rs.getInt("mission_id"));
				if (!"".equals(rs.getString("mission_finish"))) {
					m.setMission_finish(rs.getString("mission_finish"));
				}
				m.setMission_name(rs.getString("mission_name"));
				m.setMission_reward(rs.getDouble("mission_reward"));
				m.setMission_state(rs.getString("mission_state"));
				m.setMission_time(rs.getString("mission_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeAll();
		}
		if (!(m == null)) {
			return m;
		}
		return null;
	}
	@Override
	//修改任务的被雇佣者
	public boolean updateEmp(User emp, int id) {
		return util.update("update t_mission set mission_emp=? where mission_id=?",emp.getUser_id(), id) > 0;
	}

	@Override
	//根据任务id删除任务
	public boolean deleteMission(int id) {
		return util.update("delete from t_mission  where mission_id=?",id) > 0;
	}

	@Override
	public boolean updateFinishTimeById(int id, String time) {
		//修改任务完成时间
		return util.update("update t_mission set mission_finish=? where mission_id=?", time,id)>0;
	}

}
