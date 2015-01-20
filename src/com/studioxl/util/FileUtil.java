package com.studioxl.util;

import java.io.File;

import android.content.Context;
import android.os.Environment;


public class FileUtil {
	
	
	/**
	 * 判断是否有sd卡 
	 * @return true表示有sd卡
	 */
	public static boolean isHaveStorage() {
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED); 
		return sdCardExist;

	}
	
	/**
	 * 得到sd卡路径
	 * @return
	 */
	public static String getStoragePath() {
		String path = null;
		if (isHaveStorage()) {
			path = Environment.getExternalStorageDirectory().getPath();
		}
		return path;
	}
	
	/**
	 * 得到系统缓存目录
	 * @param context
	 * @return
	 */
	public static File getSystemCacheFile(Context context) {
		return context.getCacheDir();
	}

	/**
	 * 得到程序缓存目录的路径
	 * @param context
	 * @return
	 */
	public static String getCachePath(Context context) {
		String cachePath = null;
		if (isHaveStorage()) {
			cachePath = getStoragePath();
		} else {
			cachePath = getSystemCacheFile(context).getPath();
		}
		cachePath = cachePath + ConfigUtil.CACHEPATH;
		return cachePath;
	}
}
