package dao;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import dbutil.dbUtil;
import entity.lvyou;

public class dao {

	dbUtil dbu = new dbUtil();
	public String name() {
		
		String sql ="select name,景区简介,经度,纬度,市  from jingqu";
		Object[] param = {
				
		};
		List<lvyou> name = dbu.getName(sql, param);
//		System.out.println(name);
		String str = JSON.toJSONString(name);
		System.out.println(str);

		return str;
		
	}

}
