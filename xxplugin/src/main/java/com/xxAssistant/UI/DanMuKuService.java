package com.xxAssistant.UI;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.IBinder;

public class DanMuKuService extends Service {
	public static boolean a;
	public static DanMuKuService b;
	ActivityManager c;
	public static String d;
	public static String e;
	public static int f;
	public static boolean g;
	int h;
	long i;
	long j;
	boolean k;
	Thread l;
	Handler m;
	private int n;

	static {
		DanMuKuService.a = false;
		DanMuKuService.b = null;
		DanMuKuService.d = "";
		DanMuKuService.e = "";
		DanMuKuService.f = 0;
		DanMuKuService.g = false;
	}

	public DanMuKuService() {
		super();
		this.h = 500;
		this.i = 0;
		this.j = 0;
		this.k = false;
		this.n = -1;
	}

	public void a() {
	}

	public IBinder onBind(Intent arg2) {
		return null;
	}

	public void onConfigurationChanged(Configuration arg3) {
		super.onConfigurationChanged(arg3);
	}

	public void onCreate() {
		super.onCreate();
	}

	public void onDestroy() {
		super.onDestroy();
		DanMuKuService.a = false;
		DanMuKuService.b = null;
		DanMuKuService.f = 0;
		DanMuKuService.g = false;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		this.a();
		DanMuKuService.b = this;
		DanMuKuService.g = true;
		this.startForeground(0, null);
		DanMuKuService.a = true;
		this.l.start();
		return super.onStartCommand(intent, flags, startId);
	}
}
