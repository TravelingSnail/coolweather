/**
 * 
 */
package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 基础帮助类SQLiteOpenHelper，用于管理数据库（创建和升级）
 * @author 大师兄
 * @ClassName CoolWeatherOpenHelper
 * @Version v1.0
 * @ModifiedBy 大师兄
 * @Copyright 农村小卖部
 * @date 2015年11月24日 下午11:23:38
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
	
	// 省：Province表-建表语句
	public static final String CREATE_PROVINCE = "create table Province ("
			+ "id integer primary key autoincrement,"
			+ "province_name text,"
			+ "province_code text)";
	// 市：City表-建表语句
	public static final String CREATE_CITY = "create table City ("
			+ "id integer primary key autoincrement,"
			+ "city_name text,"
			+ "city_code text,"
			+ "province_id integer)";
	// 县：County表-建表语句
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
	 * @author 大师兄
	 * @date 2015年11月24日 下午11:23:39
	 * @param db
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE); // 创建Province表
		db.execSQL(CREATE_CITY); // 创建City表
		db.execSQL(CREATE_COUNTY); // 创建County表
	}

	/**
	 * @author 大师兄
	 * @date 2015年11月24日 下午11:23:39
	 * @param db
	 * @param oldVersion
	 * @param newVersion
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
