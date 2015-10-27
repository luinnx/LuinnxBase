/** 
 * Project Name:LuinnxBase 
 * File Name:Dip2px.java 
 * Package Name:com.luinnx.utils 
 * Date:2015-10-26下午5:34:58 
 * Copyright (c) 2015, luinnx@gmail.com All Rights Reserved. 
 */  
  
package com.luinnx.utils;  

import android.content.Context;

/** 
 * ClassName:Dip2px <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2015-10-26 下午5:34:58 <br/> 
 * @author   luinnx 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class Px2Dip {
    /** 
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
     */  
    public static int px2dip(Context context, float pxValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    } 

}
 