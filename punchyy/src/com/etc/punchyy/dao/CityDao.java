package com.etc.punchyy.dao;

import java.util.Vector;

public interface CityDao {

	//根据key值找
	public Vector<String> serch (int key);
	//根据城市和市区找
	public Vector<String> serchBy (String key,String province);
	//根据市区找
	public Vector<String> serchByKey(String key);
}
