package com.xx;

import android.app.Application;
import android.content.Context;

public class MainApplication  extends Application{

	private static Context mContext;
	public static Context getContext(){
		return mContext;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this;
	}
	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}
}
