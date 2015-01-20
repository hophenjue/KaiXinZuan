package com.studioxl.util;

import com.studioxl.entity.CityInfoList;

import android.content.Context;

public interface IRequestUtil {

	public void getCityData(Context context,FastJsonTextHttpRespons<CityInfoList> respons);
}
