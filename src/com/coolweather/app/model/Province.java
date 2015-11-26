/**
 * 
 */
package com.coolweather.app.model;

/**
 * 省
 * @author 大师兄
 * @ClassName Province
 * @Version v1.0
 * @ModifiedBy 大师兄
 * @Copyright 农村小卖部
 * @date 2015年11月24日 下午11:34:18
 */
public class Province {

	private int id; // 主键，自增长
	private String provinceName; // 省名
	private String provinceCode; // 省级代号
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProvinceName() {
		return provinceName;
	}
	
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	public String getProvinceCode() {
		return provinceCode;
	}
	
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
}
