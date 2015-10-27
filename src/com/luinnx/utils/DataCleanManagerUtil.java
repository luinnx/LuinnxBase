/** 
 * Project Name:LuinnxBase 
 * File Name:DataCleanManagerUtils.java 
 * Package Name:com.luinnx.utils 
 * Date:2015-10-26下午5:28:35 
 * Copyright (c) 2015, luinnx@gmail.com All Rights Reserved. 
 */  
  
package com.luinnx.utils;  

import java.io.File;
import java.math.BigDecimal;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

/** 
 * ClassName:DataCleanManagerUtils <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   主要功能有清除内/外缓存，清除数据库，清除sharedPreference，清除files和清除自定义目录 .. <br/> 
 * Date:     2015-10-26 下午5:28:35 <br/> 
 * @author   luinnx 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class DataCleanManagerUtil {


	/**
	 * 
	 * cleanInternalCache:(清除本应用内部缓存(/data/data/com.xxx.xxx/cache)). <br/>
	 * 
	 * @author luinnx
	 * @param context
	 * 
	 */
	public static void cleanInternalCache(Context context) {
		deleteFilesByDirectory(context.getCacheDir());

	}

	/**
	 * 
	 * cleanDatabases:(清除本应用所有数据库文件(/data/data/com.xxx.xxx/databases)). <br/>
	 * 
	 * @author luinnx
	 * @param context
	 * 
	 */
	public static void cleanDatabases(Context context) {
		deleteFilesByDirectory(new File("/data/data/"
				+ context.getPackageName() + "/databases"));
	}

	/**
	 * 
	 * cleanDatabaseByName:(按数据库名字清除). <br/>
	 * 
	 * @author luinnx
	 * @param context
	 * @param dbName
	 * 
	 */
	public static void cleanDatabaseByName(Context context, String dbName) {
		context.deleteDatabase(dbName);
	}

	/**
	 * 
	 * cleanFiles:(清除/data/data/com.xxx.xxx/files下的内容). <br/>
	 * 
	 * @author luinnx
	 * @param context
	 * 
	 */
	public static void cleanFiles(Context context) {
		deleteFilesByDirectory(context.getFilesDir());
	}

	/**
	 * cleanExternalCache:(清除外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/
	 * cache)). <br/>
	 * 
	 * @author luinnx
	 * @param context
	 * 
	 */
	public static void cleanExternalCache(Context context) {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			deleteFilesByDirectory(context.getExternalCacheDir());
		}
	}

	/**
	 * 
	 * cleanCustomCache:(清除自定义路径下的文件，使用需小心，请不要误删。而且只支持目录下的文件删除). <br/>
	 * 
	 * @author luinnx
	 * @param filePath
	 * 
	 */
	public static void cleanCustomCache(String filePath) {
		deleteFilesByDirectory(new File(filePath));
	}

	/**
	 * 
	 * cleanApplicationData:(清除本应用所有的数据). <br/>
	 * 
	 * @author luinnx
	 * @param context
	 * @param filepath
	 * 
	 */
	public static void cleanApplicationData(Context context, String... filepath) {
		cleanInternalCache(context);
		cleanExternalCache(context);
		cleanDatabases(context);
		cleanSharedPreference(context);
		cleanFiles(context);
		if (filepath == null) {
			return;
		}
		for (String filePath : filepath) {
			cleanCustomCache(filePath);
		}
	}

	/**
	 * deleteFilesByDirectory:( 删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理). <br/>
	 * 
	 * @param directory
	 * 
	 */
	private static void deleteFilesByDirectory(File directory) {
		if (directory != null && directory.exists() && directory.isDirectory()) {
			for (File item : directory.listFiles()) {
				item.delete();
			}
		}
	}

	/**
	 * 
	 * getFolderSize:( //Context.getExternalFilesDir() -->
	 * SDCard/Android/data/你的应用的包名/files/ 目录，一般放一些长时间保存的数据
	 * Context.getExternalCacheDir() -->
	 * SDCard/Android/data/你的应用包名/cache/目录，一般存放临时缓存数据 ). <br/>
	 * 
	 * @author luinnx
	 * @param file
	 * @return
	 * @throws Exception
	 * 
	 */
	public static long getFolderSize(File file) throws Exception {
		long size = 0;
		try {
			File[] fileList = file.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				// 如果下面还有文件
				if (fileList[i].isDirectory()) {
					size = size + getFolderSize(fileList[i]);
				} else {
					size = size + fileList[i].length();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	/**
	 * 
	 * deleteFolderFile:(删除指定目录下文件及目录). <br/>
	 * 
	 * @author luinnx
	 * @param filePath
	 * @param deleteThisPath
	 * 
	 */
	public static void deleteFolderFile(String filePath, boolean deleteThisPath) {
		if (!TextUtils.isEmpty(filePath)) {
			try {
				File file = new File(filePath);
				if (file.isDirectory()) {// 如果下面还有文件
					File files[] = file.listFiles();
					for (int i = 0; i < files.length; i++) {
						deleteFolderFile(files[i].getAbsolutePath(), true);
					}
				}
				if (deleteThisPath) {
					if (!file.isDirectory()) {// 如果是文件，删除
						file.delete();
					} else {// 目录
						if (file.listFiles().length == 0) {// 目录下没有文件或者目录，删除
							file.delete();
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * getFormatSize:(格式化单元). <br/>
	 * 
	 * @author luinnx
	 * @param size
	 * @return
	 * 
	 */
	public static String getFormatSize(double size) {
		double kiloByte = size / 1024;
		if (kiloByte < 1) {
			return size + "Byte";
		}

		double megaByte = kiloByte / 1024;
		if (megaByte < 1) {
			BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
			return result1.setScale(2, BigDecimal.ROUND_HALF_UP)
					.toPlainString() + "KB";
		}

		double gigaByte = megaByte / 1024;
		if (gigaByte < 1) {
			BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
			return result2.setScale(2, BigDecimal.ROUND_HALF_UP)
					.toPlainString() + "MB";
		}

		double teraBytes = gigaByte / 1024;
		if (teraBytes < 1) {
			BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
			return result3.setScale(2, BigDecimal.ROUND_HALF_UP)
					.toPlainString() + "GB";
		}
		BigDecimal result4 = new BigDecimal(teraBytes);
		return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
				+ "TB";
	}

	/**
	 * 
	 * cleanSharedPreference:(清除本应用SharedPreference(/data/data/com.xxx.xxx/
	 * shared_prefs)). <br/>
	 * 
	 * @author luinnx
	 * @param context
	 * 
	 */
	private static void cleanSharedPreference(Context context) {
		// TODO Auto-generated method stub
		deleteFilesByDirectory(new File("/data/data/"
				+ context.getPackageName() + "/shared_prefs"));

	}

	/**
	 * 
	 * getCacheSize:(获取缓存大小). <br/>
	 * 
	 * @author luinnx
	 * @param file
	 * @return
	 * @throws Exception
	 * 
	 */
	public static String getCacheSize(File file) throws Exception {
		return getFormatSize(getFolderSize(file));
	}


	

}
 