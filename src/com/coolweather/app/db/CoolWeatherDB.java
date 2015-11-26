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
 * ���õ����ݿ������װ��--������
 * @author ��ʦ��
 * @ClassName CoolWeatherDB
 * @Version v1.0
 * @ModifiedBy ��ʦ��
 * @Copyright ũ��С����
 * @date 2015��11��25�� ����8:25:48
 */
public class CoolWeatherDB {

	// ���ݿ���
	public static final String DB_NAME = "cool_weather";
	// ���ݿ�汾��
	public static final int DB_VERSION = 1;
	// ���ݿ������װ��
	public static CoolWeatherDB coolWeatherDB;
	// ���ݿ������
	public SQLiteDatabase db;
	
	/**
	 * �����췽��˽�л�
	 * @author ��ʦ��
	 * @date 2015��11��25�� ����8:43:10
	 * @param context
	 */
	private CoolWeatherDB(Context context) {
		CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, DB_VERSION);
		db = dbHelper.getWritableDatabase();
	}
	
	/**
	 * ��ȡCoolWeatherDB��ʵ��
	 * @author ��ʦ��
	 * @date 2015��11��25�� ����8:43:20
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
	 * ��Provinceʵ���洢�����ݿ�
	 * @author ��ʦ��
	 * @date 2015��11��25�� ����8:43:25
	 * @param province
	 */
	public void saveProvince(Province province) {
		if(province != null) {
			ContentValues values = new ContentValues();
			values.put("province_name", province.getProvinceName()); // ʡ��
			values.put("province_code", province.getProvinceCode()); // ʡ������
			db.insert("Province", null, values); // ����
		}
	}
	
	/**
	 * �����ݿ��ȡȫ�����е�ʡ����Ϣ
	 * @author ��ʦ��
	 * @date 2015��11��25�� ����8:44:04
	 * @return
	 */
	public List<Province> loadProvinces() {
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null);
		if(cursor.moveToFirst()) { //����Ƶ���һ��
			do {
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id"))); // ʡID
				province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name"))); // ʡ��
				province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code"))); // ʡ������
			} while (cursor.moveToNext()); // �Ƶ���һ����¼
		}
		
		return list;
	}
	
	/**
	 * ��Cityʵ���洢�����ݿ�
	 * @author ��ʦ��
	 * @date 2015��11��26�� ����9:49:16
	 * @param city
	 */
	public void saveCity(City city) {
		if(city != null) {
			ContentValues values = new ContentValues();
			values.put("city_name", city.getCityName()); // ����
			values.put("city_code", city.getCityCode()); // �м�����
			values.put("provinceId", city.getProvinceId()); // ʡid�����
			
			db.insert("City", null, values); // ���뵽���ݿ�
		}
	}
	
	/**
	 * ����ʡID��ȡ���г�����Ϣ
	 * @author ��ʦ��
	 * @date 2015��11��26�� ����7:19:04
	 * @param provinceId
	 * @return
	 */
	public List<City> loadCities(int provinceId) {
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query("City", null, "province_id = ?", new String[]{String.valueOf(provinceId)}, null, null, null);
		if(cursor.moveToFirst()) {
			do {
				City city = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id"))); // ��ID
				city.setCityName(cursor.getString(cursor.getColumnIndex("city_name"))); // ����
				city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code"))); // �м�����
				city.setProvinceId(provinceId); // ʡID�����
				
				list.add(city);
			} while (cursor.moveToNext());
		}
		return list;
	}
	
	/**
	 * ��Countyʵ���洢�����ݿ�
	 * @author ��ʦ��
	 * @date 2015��11��26�� ����7:20:00
	 * @param county
	 */
	public void saveCounty(County county) {
		if(county != null) {
			ContentValues values = new ContentValues();
			values.put("county_name", county.getCountyName()); // ����
			values.put("county_code", county.getCountyCode()); // �ؼ�����
			values.put("city_id", county.getCityId()); // �м�ID�����
			
			db.insert("County", null, values); // ���뵽���ݿ�
		}
	}
	
	/**
	 * ������id��ȡ��������Ϣ
	 * @author ��ʦ��
	 * @date 2015��11��26�� ����7:29:23
	 * @param cityId
	 * @return
	 */
	public List<County> loadCounties(int cityId) {
		List<County> list = new ArrayList<County>();
		Cursor cursor = db.query("County", null, "city_id = ?", new String[]{String.valueOf(cityId)}, null, null, null);
		if(cursor.moveToFirst()) {
			do {
				County county = new County();
				county.setId(cursor.getInt(cursor.getColumnIndex("id"))); // ��id
				county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name"))); // ����
				county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code"))); // �ؼ�����
				county.setCityId(cityId); // �м�id�����
			} while (cursor.moveToNext());
		}
		return list;
	}
	
}
