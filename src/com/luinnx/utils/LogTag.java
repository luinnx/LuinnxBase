/** 
 * Project Name:LuinnxBase 
 * File Name:LogTag.java 
 * Package Name:com.luinnx.utils 
 * Date:2015-10-26下午3:16:07 
 * Copyright (c) 2015, luinnx@gmail.com All Rights Reserved. 
 */  
  
package com.luinnx.utils;  

import java.io.File;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;

import com.luinnx.constants.Constants;

import de.mindpipe.android.logging.log4j.LogConfigurator;

/** 
 * ClassName:LogTag <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   日志工具类. <br/> 
 * Date:     2015-10-26 下午3:16:07 <br/> 
 * @author   luinnx 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class LogTag {


	public static final String TAG = "com.luinnx";
	
	public static void tag(String message){
		if(Constants.DEVELOP_MODE){
			Log.i("other", message);	
		}
	}
	
	public static void e(String methodName, Object msg){
		if(Constants.DEVELOP_MODE){
			Log.e(methodName, "========" + msg + "=============");	
		}
	}
	public static void e(String methodName, Object msg, Exception e){
		if(Constants.DEVELOP_MODE){
			Log.e(methodName, "========" + msg + "=============", e);	
		}
	}
	
	public static void i(String methodName, String msg){
		if(Constants.DEVELOP_MODE){
			Log.i(methodName, "========" + msg + "=============");	
		}
	}
	public static void e(String msg){
		if(Constants.DEVELOP_MODE){
			Log.e(TAG,msg);	
		}
	}
	
	public static void i(String msg){
		if(Constants.DEVELOP_MODE){
			Log.i(TAG,msg);	
		}
	}
	
	public static void w(String methodName, String msg){
		if(Constants.DEVELOP_MODE){
			Log.w(methodName, "========" + msg + "=============");	
		}
	}
	public static void d(String methodName, String msg){
		if(Constants.DEVELOP_MODE){
			Log.d(methodName, "========" + msg + "=============");	
		}
	}
	
	public static void sysout(Throwable e){
		if(Constants.DEVELOP_MODE){
			if(e!=null){
				e.printStackTrace();
			}	
		}
	}

	public static void log(Object msg){
		if(Constants.DEVELOP_MODE){
			System.out.println(msg);	
		}
	}
	
	public static void debugMotionEvent(String tag,MotionEvent ev){
		switch (ev.getAction()&MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			i(tag, "ACTION_DOWN");
			break;
		case MotionEvent.ACTION_MOVE:
			i(tag, "ACTION_MOVE");
			break;
		case MotionEvent.ACTION_CANCEL:
			i(tag, "ACTION_CANCEL");
			break;
		case MotionEvent.ACTION_UP:
			i(tag, "ACTION_UP");
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			//已经有一个点被触摸，第二个点之后的触摸，会是这个action
//			int index = (action& MotionEvent.ACTION_POINTER_INDEX_MASK)>>MotionEvent.ACTION_POINTER_INDEX_SHIFT;
			int index = ev.getActionIndex();
			i(tag, "ACTION_POINTER_DOWN  index=="+index);
			
			break;
		case MotionEvent.ACTION_POINTER_UP:
			//当一个点up，依然还有一个点在触摸屏幕，则会触发这个事件。否则，触发UP
			int upIndex = ev.getActionIndex();
			i(tag, "ACTION_POINTER_DOWN  index=="+upIndex);
			break;
		default:
			break;
		}
	}
	private static Logger gLogger;
	    
	private static void configLog()
	{
		final LogConfigurator logConfigurator = new LogConfigurator();
		
		logConfigurator.setFileName(Environment.getExternalStorageDirectory() + File.separator + "luinnx_log4j.log");
		// Set the root log level
		logConfigurator.setRootLevel(Level.DEBUG);
		// Set log level of a specific logger
		logConfigurator.setLevel("org.apache", Level.ERROR);
		logConfigurator.configure();

		//gLogger = Logger.getLogger(this.getClass());
		gLogger = Logger.getLogger("CrifanLiLog4jTest");
	}
	public static void debugTOSD(String msg){
		configLog();
		gLogger.debug(msg);
	}
	


}
 