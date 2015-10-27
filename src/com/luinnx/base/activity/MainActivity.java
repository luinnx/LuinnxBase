package com.luinnx.base.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.luinnx.R;
import com.luinnx.base.BaseActivity;
import com.luinnx.fragment.CategoryFragment;
import com.luinnx.fragment.CollectionFragment;
import com.luinnx.fragment.HomeFragment;
import com.luinnx.fragment.MyPageFragment;
import com.luinnx.fragment.PopularFragment;

public class MainActivity extends BaseActivity implements OnClickListener {
	private static final String TAG = MainActivity.class.getSimpleName();
	private FragmentManager fragmentManager;

	/**
	 * 首页fragment
	 */
	private HomeFragment homeFragment;

	/**
	 * 分类fragment
	 */
	private CategoryFragment categoryFragment;
	/**
	 * 热门fragment
	 */
	private PopularFragment popularFragment;
	/**
	 * 收藏fragment
	 */
	private CollectionFragment collectionFragment;

	/**
	 * 我的fragment
	 */
	private MyPageFragment myPageFragment;

	/**
	 * 首页tab布局
	 */
	private RelativeLayout home_layout;
	/**
	 * 分类tab布局
	 */
	private RelativeLayout category_layout;
	/**
	 * 热门tab布局
	 */
	private RelativeLayout popular_layout;
	/**
	 * 收藏tab布局
	 */
	private RelativeLayout collection_layout;
	/**
	 * 我的页面tab布局
	 */
	private RelativeLayout mypage_layout;

	private ImageView home_image;
	private ImageView category_image;
	private ImageView popular_image;
	private ImageView collection_image;
	private ImageView mypage_image;

	private TextView home_tv;
	private TextView category_tv;
	private TextView popular_tv;
	private TextView collection_tv;
	private TextView mypage_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fragmentManager = getFragmentManager();
		findViewById();
		initViews();
		setSelectTable(0);

	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub

		home_layout = (RelativeLayout) findViewById(R.id.home_layout);
		category_layout = (RelativeLayout) findViewById(R.id.category_layout);
		popular_layout = (RelativeLayout) findViewById(R.id.popular_layout);
		collection_layout = (RelativeLayout) findViewById(R.id.collection_layout);
		mypage_layout = (RelativeLayout) findViewById(R.id.mypage_layout);

		home_image = (ImageView) findViewById(R.id.home_image);
		category_image = (ImageView) findViewById(R.id.category_image);
		popular_image = (ImageView) findViewById(R.id.popular_image);
		collection_image = (ImageView) findViewById(R.id.collection_image);
		mypage_image = (ImageView) findViewById(R.id.mypage_image);

		home_tv = (TextView) findViewById(R.id.home_text);
		category_tv = (TextView) findViewById(R.id.category_text);
		popular_tv = (TextView) findViewById(R.id.popular_text);
		collection_tv = (TextView) findViewById(R.id.collection_text);
		mypage_tv = (TextView) findViewById(R.id.mypage_text);

	}

	@Override
	protected void initViews() {
		// TODO Auto-generated method stub
		home_layout.setOnClickListener(this);
		category_layout.setOnClickListener(this);
		popular_layout.setOnClickListener(this);
		collection_layout.setOnClickListener(this);
		mypage_layout.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.home_layout:
			setSelectTable(0);
			break;
		case R.id.category_layout:
			setSelectTable(1);
			break;
		case R.id.popular_layout:
			setSelectTable(2);
			break;
		case R.id.collection_layout:
			setSelectTable(3);
			break;
		case R.id.mypage_layout:
			setSelectTable(4);
			break;
		default:
			break;
		}

	}

	/**
	 * 
	 * setSelectTable:(传入要选择的tab序号). <br/>
	 * 
	 * @author luinnx
	 * @param index
	 *            每个tab分别对用每一项：0：首页 1：分类 2：热门 3：收藏 4：我的
	 * 
	 */
	private void setSelectTable(int index) {
		clearSelection();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		hideFragments(transaction);

		switch (index) {
		case 0:
			home_layout.setBackgroundColor(Color.parseColor("#3f515b"));
			home_tv.setTextColor(Color.WHITE);
			if (homeFragment == null) {
				homeFragment = new HomeFragment();
				transaction.add(R.id.content, homeFragment);

			} else {
				transaction.show(homeFragment);
			}

			break;
		case 1:
			category_layout.setBackgroundColor(Color.parseColor("#3f515b"));
			category_tv.setTextColor(Color.WHITE);
			if (categoryFragment == null) {
				categoryFragment = new CategoryFragment();
				transaction.add(R.id.content, categoryFragment);
			} else {
				transaction.show(categoryFragment);
			}

			break;
		case 2:
			popular_layout.setBackgroundColor(Color.parseColor("#3f515b"));
			popular_tv.setTextColor(Color.WHITE);
			if (popularFragment == null) {
				popularFragment = new PopularFragment();
				transaction.add(R.id.content, popularFragment);
			} else {
				transaction.show(popularFragment);
			}

			break;
		case 3:
			collection_layout.setBackgroundColor(Color.parseColor("#3f515b"));
			collection_tv.setTextColor(Color.WHITE);
			if (collectionFragment == null) {
				collectionFragment = new CollectionFragment();
				transaction.add(R.id.content, collectionFragment);
			} else {
				transaction.show(collectionFragment);
			}

			break;
		case 4:
			mypage_layout.setBackgroundColor(Color.parseColor("#3f515b"));
			mypage_tv.setTextColor(Color.WHITE);
			if (myPageFragment == null) {
				myPageFragment = new MyPageFragment();
				transaction.add(R.id.content, myPageFragment);
			} else {
				transaction.show(myPageFragment);
			}

			break;

		default:

			break;
		}
		transaction.commit();

	}

	/**
	 * 
	 * hideFragments:(隐藏所有fragment). <br/> 
	 * 
	 * @author luinnx 
	 * @param transaction 
	 *
	 */
	private void hideFragments(FragmentTransaction transaction) {
		// TODO Auto-generated method stub
		if (homeFragment != null) {
			transaction.hide(homeFragment);
		}
		if (categoryFragment != null) {
			transaction.hide(categoryFragment);
		}
		if (popularFragment != null) {
			transaction.hide(popularFragment);
		}
		if (collectionFragment != null) {
			transaction.hide(collectionFragment);
		}
		if (myPageFragment != null) {
			transaction.hide(myPageFragment);
		}
	}

	/**
	 * 
	 * clearSelection:(清除已选中的tab状态). <br/>
	 * 
	 * @author luinnx
	 * 
	 */
	private void clearSelection() {
		// TODO Auto-generated method stub
		home_layout.setBackgroundColor(Color.parseColor("#8bc34a"));
		category_layout.setBackgroundColor(Color.parseColor("#cddc39"));
		popular_layout.setBackgroundColor(Color.parseColor("#ffeb3b"));
		collection_layout.setBackgroundColor(Color.parseColor("#ffc107"));
		mypage_layout.setBackgroundColor(Color.parseColor("#ff9500"));

		home_tv.setTextColor(Color.parseColor("#363636"));
		category_tv.setTextColor(Color.parseColor("#363636"));
		popular_tv.setTextColor(Color.parseColor("#363636"));
		collection_tv.setTextColor(Color.parseColor("#363636"));
		mypage_tv.setTextColor(Color.parseColor("#363636"));

	}

}
