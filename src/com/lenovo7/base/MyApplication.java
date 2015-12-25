package com.lenovo7.base;

import android.app.Application;
import android.os.Handler;

import com.lenovo7.bean.Sensor;
import com.lenovo7.bean.Share;
import com.lenovo7.util.PlayMusic;

public class MyApplication extends Application {
	
	public static String url ;
	public static Share share;
	public static Handler handler1 , handler2;
	public static PlayMusic play;
	public static MyApplication context;
	public static Sensor sensor;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		share = new Share(getApplicationContext());
		url = "http://" + share.getIP() + ":" + share.getPORT() + 
				"/transportservice/type/jason/action/";
		context = this;
		play = new PlayMusic(MyApplication.context);
	}
}
