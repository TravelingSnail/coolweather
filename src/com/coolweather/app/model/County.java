/**
 * 
 */
package com.coolweather.app.model;

/**
 * ��
 * @author ��ʦ��
 * @ClassName County
 * @Version v1.0
 * @ModifiedBy ��ʦ��
 * @Copyright ũ��С����
 * @date 2015��11��24�� ����11:39:58
 */
public class County {

	private int id; // ������������
	private String countyName; // ����
	private String countyCode; // �ؼ�����
	private int cityId; // ��id�����

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