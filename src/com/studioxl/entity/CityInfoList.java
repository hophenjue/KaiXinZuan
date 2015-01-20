package com.studioxl.entity;

import java.util.List;
import java.util.Map;

public class CityInfoList extends BaseEntity {
	private String flag;
	private List<Map<String, List<CityInfo>>> cityInfo;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<Map<String, List<CityInfo>>> getCityInfo() {
		return cityInfo;
	}

	public void setCityInfo(List<Map<String, List<CityInfo>>> cityInfo) {
		this.cityInfo = cityInfo;
	}

}
