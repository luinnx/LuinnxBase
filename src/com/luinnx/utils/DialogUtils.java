/** 
 * Project Name:LuinnxBase 
 * File Name:DialogUtils.java 
 * Package Name:com.luinnx.utils 
 * Date:2015-10-26下午5:30:47 
 * Copyright (c) 2015, luinnx@gmail.com All Rights Reserved. 
 */  
  
package com.luinnx.utils;  

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

/** 
 * ClassName:DialogUtils <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015-10-26 下午5:30:47 <br/> 
 * @author   luinnx 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class DialogUtils {

	/**
	 * 
	 * setDialogWindowAttr:(自定义Dialo style、position). <br/>
	 * 
	 * @author luinnx
	 * @param dialog
	 * @param context
	 * @param width
	 *            width:1 MATCH_PARENT width:0 WRAP_CONTENT width:Custom double
	 *            width
	 * @param height
	 *            height:1 MATCH_PARENT height:0 WRAP_CONTENT height:Custom
	 *            double height 在dialog.show()之后调用
	 */
	public static void setDialogWindowAttr(Dialog dialog, Context context,double width, double height) {
		Window window = dialog.getWindow();
		WindowManager manager = ((Activity) context).getWindowManager();
		Display display = manager.getDefaultDisplay();
		WindowManager.LayoutParams params = window.getAttributes();
		params.gravity = Gravity.CENTER;
		if (width == 1) {
			params.width = LayoutParams.MATCH_PARENT;
		} else if (width == 0) {
			params.width = LayoutParams.WRAP_CONTENT;
		} else {
			params.width = (int) (display.getWidth() * width);
		}

		if (height == 1) {
			params.height = LayoutParams.MATCH_PARENT;
		} else if (height == 0) {
			params.height = LayoutParams.WRAP_CONTENT;
		} else {
			params.height = (int) (display.getHeight() * height);
		}

		dialog.getWindow().setAttributes(params);
	}


	
}
 