package com.studioxl.util;

import android.content.Context;

import com.loopj.android.http.RequestParams;

public class MyRequestUtil implements IRequestUtil {

	private Context context;
	public void initCommenParams(RequestParams requestParams) {
		requestParams.put("key", "huayins");
		requestParams.put("filetype", "json");
		requestParams.put("version", "410");
	}
	@Override
	public void getCityData(
			Context context,
			com.studioxl.util.FastJsonTextHttpRespons<com.studioxl.entity.CityInfoList> respons) {
		this.context = context;
		StringBuilder signBuilder = new StringBuilder();
		signBuilder.append("huayins").append("0779257096");
		RequestParams requestParams=new RequestParams();
		requestParams.put("sign", MD5Util.getMd5(signBuilder.toString()));
		initCommenParams(requestParams);
		String url="http://film.spider.com.cn/huayins/"+InterfaceNameUtil.API_CITY;
		MyHttpClient.get(context, url, requestParams, respons);
		
	}
	
}
