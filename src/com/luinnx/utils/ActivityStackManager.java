/** 
 * Project Name:LuinnxBase 
 * File Name:ActivityStackManager.java 
 * Package Name:com.luinnx.utils 
 * Date:2015-10-26下午4:51:44 
 * Copyright (c) 2015, luinnx@gmail.com All Rights Reserved. 
 */

package com.luinnx.utils;

import java.util.Stack;

import android.app.Activity;

/**
 * ClassName:ActivityStackManager <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: Activity stack manager. <br/>
 * Date: 2015-10-26 下午4:51:44 <br/>
 * 
 * @author luinnx
 * @version
 * @since JDK 1.6
 * @see
 */
public class ActivityStackManager {
	private static final String TAG = ActivityStackManager.class.getSimpleName();
	private static Stack<Activity> activityStack;
	private volatile static ActivityStackManager mActivityStackManager;

	public static ActivityStackManager getInstence() {

		if (mActivityStackManager == null) {

			synchronized (ActivityStackManager.class) {
				if (mActivityStackManager == null) {
					mActivityStackManager = new ActivityStackManager();
				}
			}
		}
		return mActivityStackManager;

	}
	
	/**
	 * 
	 * getCurrentActivity:(取得当前Activity). <br/>
	 * 
	 * @author luinnx
	 * @return
	 * 
	 */
	public Activity getCurrentActivity() {
		Activity activity = null;
		if (activityStack!=null) {
			activity = activityStack.lastElement();
		}
		return activity;

	}

	/**
	 * 
	 * addActivity:(添加Activity到栈中). <br/>
	 * 
	 * @author luinnx
	 * @param activity
	 * 
	 */
	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	/**
	 * 
	 * removeActivity:(从堆栈中移除Activity). <br/>
	 * 
	 * @author luinnx
	 * @param activity
	 * 
	 */
	public void removeActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
			return;
		}
		activityStack.remove(activity);
	}

	/**
	 * 
	 * finishActivity:(结束当前Activity). <br/>
	 * 
	 * @author luinnx
	 * 
	 */
	public void finishActivity() {
		if (activityStack.isEmpty() || activityStack == null) {
			return;
		}
		Activity activity = activityStack.lastElement();

		finishActivity(activity);

	}

	public void finishActivity(Activity activity) {
		if (activity != null && !activityStack.isEmpty()
				&& activityStack != null) {
			activityStack.remove(activity);
			activity.finish();
		}
	}

	/**
	 * 
	 * finishActivity:(结束指定Activity). <br/>
	 * 
	 * @author luinnx
	 * @param clazz
	 * 
	 */
	public void finishActivity(Class<?> clazz) {
		if (activityStack.isEmpty() || activityStack == null) {
			return;
		}
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(clazz)) {
				finishActivity(activity);
			}
		}
	}
	
	/**
	 * 
	 * findActivity:(从堆栈中获取指定Activity). <br/> 
	 * @author luinnx 
	 * @param clazz
	 * @return Activity
	 *
	 */
	public Activity findActivity(Class<?> clazz){
		
		if (activityStack.isEmpty() || activityStack == null) {
			return null;
		}
		
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(clazz)) {
				return activity;
			}
		}
		
		return null;
		
	}

	/**
	 * 
	 * finishAllActivity:(结束所有Activity). <br/>
	 * 
	 * @author luinnx
	 * 
	 */
	public void finishAllActivity() {
		if (activityStack.isEmpty() || activityStack == null) {
			return;
		}
		while (!activityStack.isEmpty()) {
			Activity activity = activityStack.lastElement();
			activityStack.remove(activity);
			activity.finish();
		}
		activityStack.clear();
	}

	/**
	 * 
	 * exitApplication:(退出程序，是否在后台运行true:在后台运行  false:完全退出). <br/>
	 * 
	 * @author luinnx
	 * @param isbackground
	 * 
	 */
	public void exitApplication(boolean isbackground) {
		try {
			finishAllActivity();
			if (!isbackground) {
				android.os.Process.killProcess(android.os.Process.myPid());
				System.exit(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	

}
