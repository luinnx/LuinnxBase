/** 
 * Project Name:LuinnxBase 
 * File Name:BaseActivity.java 
 * Package Name:com.luinnx.base 
 * Date:2015-10-26下午1:58:36 
 * Copyright (c) 2015, luinnx@gmail.com All Rights Reserved. 
 */  
  
package com.luinnx.base;  

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/** 
 * ClassName:BaseActivity <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   BaseActivity. <br/> 
 * Date:     2015-10-26 下午1:58:36 <br/> 
 * @author   luinnx 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public abstract class BaseActivity extends Activity {
	private static final String TAG=BaseActivity.class.getSimpleName();
	protected Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mContext=this;
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	/**
	 * 
	 * findViewById:(绑定ID). <br/> 
	 * 
	 * @author luinnx  
	 *
	 */
	protected abstract void findViewById();
	
	/**
	 * 
	 * initViews:(初始化Views). <br/> 
	 * 
	 * @author luinnx  
	 *
	 */
	protected abstract void initViews();
	
	/**
	 * 
	 * openActivity:(启动Activity). <br/> 
	 * 
	 * @author luinnx 
	 * @param pClass 
	 *
	 */
	protected void  openActivity(Class<?> clazz){
		openActivity(clazz, null);
	}
	/**
	 * 
	 * openActivity:(启动Activity). <br/> 
	 * 
	 * @author luinnx 
	 * @param pClass
	 * @param bundle 
	 *
	 */
	protected void openActivity(Class<?> clazz,Bundle bundle){
		Intent  intent=new Intent(this, clazz);
		if (bundle!=null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}
	

}
 