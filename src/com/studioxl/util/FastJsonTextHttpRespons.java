package com.studioxl.util;

import java.lang.reflect.Type;
import com.alibaba.fastjson.JSON;
import com.loopj.android.http.TextHttpResponseHandler;
public  class FastJsonTextHttpRespons<T> extends TextHttpResponseHandler  {
	private static final String TAG = "FastJsonTextHttpRespons";
	private Type type;

	public FastJsonTextHttpRespons() {
		super(DEFAULT_CHARSET);
	}

	public FastJsonTextHttpRespons(Type type) {
		this.type = type;
	}

	@Override
	public void onFailure(int arg0, org.apache.http.Header[] arg1, String arg2,
			Throwable arg3) {
		onFailure(arg0, arg3);
	}

	@Override
	public void onSuccess(int arg0, org.apache.http.Header[] arg1, String arg2) {
		try {

			T t = (T) JSON.parseObject(arg2, type);
			onSuccess(arg0, t);
		} catch (Throwable arg3) {
			// TODO: handle exception
			onFailure(arg0, arg3);
		}
	}
	/**
	 * 成功的回调，
	 * 
	 * @param responseCode
	 *            响应码
	 * @param t
	 *            实体类
	 */
	public void onSuccess(int responseCode, T t) {

	}

	/**
	 * 失败的回调
	 * 
	 * @param responseCode
	 *            响应码
	 * @param arg3
	 *            异常
	 */
	public void onFailure(int responseCode, Throwable arg3) {

	}
	

}

