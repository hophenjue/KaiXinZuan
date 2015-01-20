package com.studioxl.util;

import android.content.Context;
import android.widget.Toast;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
public class MyHttpClient {
	private static AsyncHttpClient httpClient = new AsyncHttpClient();

	private MyHttpClient() {

	}
	public static void get(Context context, String url, RequestParams params,
			ResponseHandlerInterface responseHandler) {
		if (DeviceInfo.isNetAvailable(context)) {
			httpClient.get(url, params, responseHandler);
		} else {
			Toast.makeText(context,"无网络", 2000).show();
		}

	}

	public static void post(Context context, String url, RequestParams params,
			ResponseHandlerInterface responseHandler) {
		if (DeviceInfo.isNetAvailable(context)) {
			httpClient.post(url, params, responseHandler);
		} else {
			Toast.makeText(context,"无网络", 2000).show();
		}

	}

}
