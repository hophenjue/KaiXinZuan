package com.studioxl.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class DeviceInfo {

	/**
	 * 判断手机的网络是否可用 
	 * @param context 上下文
	 * @return true 可用
	 */
	public static boolean isNetAvailable(Context context) {
		NetworkInfo networkInfo = getNetWorkInfo(context);

		if (networkInfo != null) {

			return networkInfo.isAvailable();
		}
		return false;
	}
	
	/**
	 * 主要获取网络信息类NetworkInfo
	 * @param context
	 * @return
	 */
	public static NetworkInfo getNetWorkInfo(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();

		return activeNetInfo;
	}
}
