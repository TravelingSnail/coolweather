/**
 * 
 */
package com.coolweather.app.model;

/**
 * ��
 * @author ��ʦ��
 * @ClassName City
 * @Version v1.0
 * @ModifiedBy ��ʦ��
 * @Copyright ũ��С����
 * @date 2015��11��24�� ����11:38:04
 */
public class City {

	private int id; // ������������
	private String cityName; // ����
	private String cityCode; // �м�����
	private int provinceId; // ʡid�����

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
