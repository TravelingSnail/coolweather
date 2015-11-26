/**
 * 
 */
package com.coolweather.app.model;

/**
 * 市
 * @author 大师兄
 * @ClassName City
 * @Version v1.0
 * @ModifiedBy 大师兄
 * @Copyright 农村小卖部
 * @date 2015年11月24日 下午11:38:04
 */
public class City {

	private int id; // 主键，自增长
	private String cityName; // 市名
	private String cityCode; // 市级代号
	private int provinceId; // 省id，外键

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

}
