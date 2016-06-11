package com.xx;

import android.app.Application;
import android.content.Context;

public class XXPluginBase extends Application{

	public Context mContext;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		mContext = this;
		super.onCreate();
	}
}
