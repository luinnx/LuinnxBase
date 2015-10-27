/** 
 * Project Name:LuinnxBase 
 * File Name:BaseApplication.java 
 * Package Name:com.luinnx.application 
 * Date:2015-10-26下午2:42:22 
 * Copyright (c) 2015, luinnx@gmail.com All Rights Reserved. 
 */

package com.luinnx.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

/**
 * ClassName:BaseApplication <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: BaseApplication. <br/>
 * Date: 2015-10-26 下午2:42:22 <br/>
 * 
 * @author luinnx
 * @version
 * @since JDK 1.6
 * @see
 */
public class BaseApplication extends Application {
	private final static String TAG = BaseApplication.class.getSimpleName();
	private volatile static BaseApplication uniqueInstance;
	private Context mContext;

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mContext = getApplicationContext();
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}

	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
		super.onTrimMemory(level);
	}

	/**
	 * 
	 * getInstance:(获取单一application). <br/>
	 * 
	 * @author luinnx
	 * @return
	 * 
	 */
	public static BaseApplication getInstance() {
		if (uniqueInstance == null) {
			synchronized (BaseApplication.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new BaseApplication();
				}
			}
		}
		return uniqueInstance;
	}

	public Context getmContext() {
		return mContext;
	}

}
