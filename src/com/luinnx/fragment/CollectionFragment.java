/** 
 * Project Name:LuinnxBase 
 * File Name:HomeFragment.java 
 * Package Name:com.luinnx.fragment 
 * Date:2015-10-27上午10:44:39 
 * Copyright (c) 2015, luinnx@gmail.com All Rights Reserved. 
 */

package com.luinnx.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luinnx.R;

/**
 * ClassName:HomeFragment <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: 收藏页面. <br/>
 * Date: 2015-10-27 上午10:44:39 <br/>
 * 
 * @author luinnx
 * @version
 * @since JDK 1.6
 * @see
 */
public class CollectionFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View collecationlayout = inflater.inflate(R.layout.collection_layout,
				container, false);
		return collecationlayout;
	}

}
