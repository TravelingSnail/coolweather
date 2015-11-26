/**
 * 
 */
package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * ����������SQLiteOpenHelper�����ڹ������ݿ⣨������������
 * @author ��ʦ��
 * @ClassName CoolWeatherOpenHelper
 * @Version v1.0
 * @ModifiedBy ��ʦ��
 * @Copyright ũ��С����
 * @date 2015��11��24�� ����11:23:38
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
	
	// ʡ��Province��-�������
	public static final String CREATE_PROVINCE = "create table Province ("
			+ "id integer primary key autoincrement,"
			+ "province_name text,"
			+ "province_code text)";
	// �У�City��-�������
	public static final String CREATE_CITY = "create table City ("
			+ "id integer primary key autoincrement,"
			+ "city_name text,"
			+ "city_code text,"
			+ "province_id integer)";
	// �أ�County��-�������
	public static final String CREATE_COUNTY = "create table County ("
			+ "id integer primary key autoincrement,"
			+ "county_name text,"
			+ "county_code text,"
			+ "city_id integer)";
	
	/**
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public CoolWeatherOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	/**
	 * @author ��ʦ��
	 * @date 2015��11��24�� ����11:23:39
	 * @param db
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE); // ����Province��
		db.execSQL(CREATE_CITY); // ����City��
		db.execSQL(CREATE_COUNTY); // ����County��
	}

	/**
	 * @author ��ʦ��
	 * @date 2015��11��24�� ����11:23:39
	 * @param db
	 * @param oldVersion
	 * @param newVersion
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
