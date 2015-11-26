/**
 * 
 */
package com.coolweather.app.model;

/**
 * 县
 * @author 大师兄
 * @ClassName County
 * @Version v1.0
 * @ModifiedBy 大师兄
 * @Copyright 农村小卖部
 * @date 2015年11月24日 下午11:39:58
 */
public class County {

	private int id; // 主键，自增长
	private String countyName; // 县名
	private String countyCode; // 县级代号
	private int cityId; // 市id，外键

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

}
