package com.studioxl.application;


import java.io.File;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.studioxl.util.FileUtil;
import com.studioxl.util.IRequestUtil;
import com.studioxl.util.MyRequestUtil;

import android.app.Application;
import android.content.Context;

/**
 * application类
 * @author hopehe test 团队开发同步很重要
 */
public class MyApplication extends Application {

	public static IRequestUtil requestUtil;
	public static Context gContext;
	private static MyApplication myApplication = null;
	
	@Override
	public void onCreate() {
		super.onCreate();
		gContext = this;
		initImageLoader(getApplicationContext());
	}
	
	public synchronized static MyApplication getInstance() {

		if (null == myApplication) {
			myApplication = new MyApplication();
		}
		return myApplication;
	}
	
	/**
	 * 初始化imageloader
	 * @param context
	 */
	public static void initImageLoader(Context context) {
		File cacheFile = new File(FileUtil.getCachePath(context));

		@SuppressWarnings("deprecation")
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.discCache(new UnlimitedDiscCache(cacheFile))
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO).build();

		ImageLoader.getInstance().init(config);

	}
	
	/**
	 * 初始化服务器请求类
	 * 
	 * @param isTest
	 *            是否是测试
	 */
	public static void initRequestUtil(boolean isTest) {
		synchronized (MyApplication.class) {
			if (null == requestUtil) {
					requestUtil = new MyRequestUtil();
				}
			}
		}
	
	/**
	 * 获取请求类实例
	 * 
	 * @return
	 */
	public static IRequestUtil getRequestUtil() {
		if (requestUtil == null) {
			requestUtil = new MyRequestUtil();
		}
		return requestUtil;
	}


}
