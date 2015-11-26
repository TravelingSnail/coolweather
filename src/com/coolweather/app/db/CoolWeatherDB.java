/**
 * 
 */
package com.coolweather.app.db;

import java.util.ArrayList;
import java.util.List;

import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 常用的数据库操作封装类--单例类
 * @author 大师兄
 * @ClassName CoolWeatherDB
 * @Version v1.0
 * @ModifiedBy 大师兄
 * @Copyright 农村小卖部
 * @date 2015年11月25日 下午8:25:48
 */
public class CoolWeatherDB {

	// 数据库名
	public static final String DB_NAME = "cool_weather";
	// 数据库版本号
	public static final int DB_VERSION = 1;
	// 数据库操作封装类
	public static CoolWeatherDB coolWeatherDB;
	// 数据库操作类
	public SQLiteDatabase db;
	
	/**
	 * 将构造方法私有化
	 * @author 大师兄
	 * @date 2015年11月25日 下午8:43:10
	 * @param context
	 */
	private CoolWeatherDB(Context context) {
		CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, DB_VERSION);
		db = dbHelper.getWritableDatabase();
	}
	
	/**
	 * 获取CoolWeatherDB的实例
	 * @author 大师兄
	 * @date 2015年11月25日 下午8:43:20
	 * @param context
	 * @return
	 */
	public synchronized static CoolWeatherDB getInstance(Context context) {
		if(coolWeatherDB == null) {
			coolWeatherDB = new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}
	
	/**
	 * 将Province实例存储到数据库
	 * @author 大师兄
	 * @date 2015年11月25日 下午8:43:25
	 * @param province
	 */
	public void saveProvince(Province province) {
		if(province != null) {
			ContentValues values = new ContentValues();
			values.put("province_name", province.getProvinceName()); // 省名
			values.put("province_code", province.getProvinceCode()); // 省级代号
			db.insert("Province", null, values); // 插入
		}
	}
	
	/**
	 * 从数据库读取全国所有的省份信息
	 * @author 大师兄
	 * @date 2015年11月25日 下午8:44:04
	 * @return
	 */
	public List<Province> loadProvinces() {
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null);
		if(cursor.moveToFirst()) { //光标移到第一个
			do {
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id"))); // 省ID
				province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name"))); // 省名
				province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code"))); // 省级代号
			} while (cursor.moveToNext()); // 移到下一条记录
		}
		
		return list;
	}
	
	/**
	 * 将City实例存储到数据库
	 * @author 大师兄
	 * @date 2015年11月26日 上午9:49:16
	 * @param city
	 */
	public void saveCity(City city) {
		if(city != null) {
			ContentValues values = new ContentValues();
			values.put("city_name", city.getCityName()); // 市名
			values.put("city_code", city.getCityCode()); // 市级代号
			values.put("provinceId", city.getProvinceId()); // 省id，外键
			
			db.insert("City", null, values); // 插入到数据库
		}
	}
	
	/**
	 * 根据省ID读取所有城市信息
	 * @author 大师兄
	 * @date 2015年11月26日 下午7:19:04
	 * @param provinceId
	 * @return
	 */
	public List<City> loadCities(int provinceId) {
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query("City", null, "province_id = ?", new String[]{String.valueOf(provinceId)}, null, null, null);
		if(cursor.moveToFirst()) {
			do {
				City city = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id"))); // 市ID
				city.setCityName(cursor.getString(cursor.getColumnIndex("city_name"))); // 市名
				city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code"))); // 市级代号
				city.setProvinceId(provinceId); // 省ID，外键
				
				list.add(city);
			} while (cursor.moveToNext());
		}
		return list;
	}
	
	/**
	 * 将County实例存储到数据库
	 * @author 大师兄
	 * @date 2015年11月26日 下午7:20:00
	 * @param county
	 */
	public void saveCounty(County county) {
		if(county != null) {
			ContentValues values = new ContentValues();
			values.put("county_name", county.getCountyName()); // 县名
			values.put("county_code", county.getCountyCode()); // 县级代号
			values.put("city_id", county.getCityId()); // 市级ID，外键
			
			db.insert("County", null, values); // 插入到数据库
		}
	}
	
	/**
	 * 根据市id读取所有县信息
	 * @author 大师兄
	 * @date 2015年11月26日 下午7:29:23
	 * @param cityId
	 * @return
	 */
	public List<County> loadCounties(int cityId) {
		List<County> list = new ArrayList<County>();
		Cursor cursor = db.query("County", null, "city_id = ?", new String[]{String.valueOf(cityId)}, null, null, null);
		if(cursor.moveToFirst()) {
			do {
				County county = new County();
				county.setId(cursor.getInt(cursor.getColumnIndex("id"))); // 县id
				county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name"))); // 县名
				county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code"))); // 县级代号
				county.setCityId(cityId); // 市级id，外键
			} while (cursor.moveToNext());
		}
		return list;
	}
	
}
