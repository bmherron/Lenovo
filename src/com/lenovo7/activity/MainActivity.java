package com.lenovo7.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.lenovo7.R;
import com.lenovo7.fragment.CarFragment;
import com.lenovo7.fragment.HistoryFragment;
import com.lenovo7.fragment.HomeFragment;
import com.lenovo7.fragment.SettingsFragment;

public class MainActivity extends Activity implements OnClickListener {
	private TextView w1View, w2View, w3View, w4View;
	private Fragment homeFragment, carFragment, historyFragment,
			settingsFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initEvent();
		selectFragment(0);
	}

	private void hideFragment(FragmentTransaction tr) {
		if (homeFragment != null)
			tr.hide(homeFragment);
		if (carFragment != null)
			tr.hide(carFragment);
		if (historyFragment != null)
			tr.hide(historyFragment);
		if (settingsFragment != null)
			tr.hide(settingsFragment);
	}

	private void selectFragment(int i) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction tr = fm.beginTransaction();
		hideFragment(tr);
		selectView(i);
		switch (i) {
		case 0:
			if (homeFragment == null) {
				homeFragment = new HomeFragment();
				tr.add(R.id.activity_main_content, homeFragment);
			} else {
				tr.show(homeFragment);
			}
			break;
		case 1:
			if (carFragment == null) {
				carFragment = new CarFragment();
				tr.add(R.id.activity_main_content, carFragment);
			} else {
				tr.show(carFragment);
			}
			break;
		case 2:
			if (historyFragment == null) {
				historyFragment = new HistoryFragment();
				tr.add(R.id.activity_main_content, historyFragment);
			} else {
				tr.show(historyFragment);
			}
			break;
		case 3:
			if (settingsFragment == null) {
				settingsFragment = new SettingsFragment();
				tr.add(R.id.activity_main_content, settingsFragment);
			} else {
				tr.show(settingsFragment);
			}
			break;

		default:
			break;
		}
		tr.commit();
	}

	private void selectView(int i) {
		w1View.setTextColor(getResources().getColor(R.color.red));
		w2View.setTextColor(getResources().getColor(R.color.red));
		w3View.setTextColor(getResources().getColor(R.color.red));
		w4View.setTextColor(getResources().getColor(R.color.red));
		w4View.setTextColor(getResources().getColor(R.color.red));
		w4View.setTextColor(getResources().getColor(R.color.red));
		w1View.setBackgroundColor(getResources().getColor(R.color.white));
		w2View.setBackgroundColor(getResources().getColor(R.color.white));
		w3View.setBackgroundColor(getResources().getColor(R.color.white));
		w4View.setBackgroundColor(getResources().getColor(R.color.white));
		switch (i) {
		case 0:
			w1View.setTextColor(getResources().getColor(R.color.white));
			w1View.setBackgroundColor(getResources().getColor(R.color.w));
			break;
		case 1:
			w2View.setTextColor(getResources().getColor(R.color.white));
			w2View.setBackgroundColor(getResources().getColor(R.color.w));
			break;
		case 2:
			w3View.setTextColor(getResources().getColor(R.color.white));
			w3View.setBackgroundColor(getResources().getColor(R.color.w));
			break;
		case 3:
			w4View.setTextColor(getResources().getColor(R.color.white));
			w4View.setBackgroundColor(getResources().getColor(R.color.w));
			break;

		default:
			break;
		}
	}

	private void initEvent() {
		w1View.setOnClickListener(this);
		w2View.setOnClickListener(this);
		w3View.setOnClickListener(this);
		w4View.setOnClickListener(this);
	}

	private void initView() {
		w1View = (TextView) findViewById(R.id.activity_main_w1);
		w2View = (TextView) findViewById(R.id.activity_main_w2);
		w3View = (TextView) findViewById(R.id.activity_main_w3);
		w4View = (TextView) findViewById(R.id.activity_main_w4);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.activity_main_w1:
			selectFragment(0);
			break;
		case R.id.activity_main_w2:
			selectFragment(1);
			break;
		case R.id.activity_main_w3:
			selectFragment(2);
			break;
		case R.id.activity_main_w4:
			selectFragment(3);
			break;

		default:
			break;
		}
	}
}
