package com.etc.punchyy.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.etc.punchyy.dao.CityDao;
import com.etc.punchyy.util.JDBCUtil;

public class CityDaoImpl implements CityDao{
	JDBCUtil util = new JDBCUtil();
	@Override
	public Vector<String> serch(int key) {
		// TODO Auto-generated method stub
		ResultSet rs=util.query("SELECT city_name from city where  city_keys=?", key);
		Vector<String> v=new Vector<String>();
		try {
			while(rs.next()){
				v.add(rs.getString("city_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return v;
	}

	@Override
	public Vector<String> serchBy(String key,String province) {
		// TODO Auto-generated method stub
		
		ResultSet rs=util.query("SELECT city_name from city where  city_keys in (select city_id from city where city_name=? and city_keys= (select city_id from city where city_name=?)) ", key,province);
		
		Vector<String> v=new Vector<String>();
		try {
			while(rs.next()){
				v.add(rs.getString("city_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		
		return v;
	}

	@Override
	public Vector<String> serchByKey(String key) {
		// TODO Auto-generated method stub
ResultSet rs=util.query("SELECT city_name from city where  city_keys in (select city_id from city where city_name=? ) ", key);
		
		Vector<String> v=new Vector<String>();
		try {
			while(rs.next()){
				v.add(rs.getString("city_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return v;
	}

}
