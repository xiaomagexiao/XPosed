package com.xxAssistant.Utils;

import java.io.IOException;
import java.io.PrintWriter;

public class Utility {
	public static String TAG;
	private static Utility instance;
	static {
		Utility.TAG = "Utility";
		System.loadLibrary("utility");
	}

	public static Utility getInstance() {
		if (instance == null) {
			instance = new Utility();
		}
		return instance;
	}

	public boolean a() {
		try {
			Runtime.getRuntime().exec("su -c id");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean b(String cmd) {
		boolean v0 = true;
		Process v2 = null;
		try {
			v2 = Runtime.getRuntime().exec("su");
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter v1 = new PrintWriter(v2.getOutputStream());
		v1.print(cmd);
		v1.flush();
		v1.close();
		if (v2 != null) {
			v2.destroy();
		} else {
			v0 = false;
		}

		return v0;
	}

	public void c(String cmd) {
		try {
			Runtime.getRuntime().exec("chmod 777 " + cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public native int compatibilityCheck();

	public void d(String cmd) {
		try {
			Runtime.getRuntime().exec("rm -r " + cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public native String doGetAndroidLoaderVersion();

	public native boolean doMkdir(String arg1);

	public native boolean doMkfile(String arg1);

	public native boolean doRemoveFile(String arg1);

	public native boolean doSymlinkAndChmode(String arg1, String arg2);// doSymlinkAndChmode
																		// doSymlinkAndChmode

	public native boolean doUpdateAssistantJSON(int arg1, int[] arg2);

	public native boolean doUpdateSpeedMJSON(String[] arg1);

	public native int getppid();

	public native boolean isInjectFrameChanged(String arg1);

	public native boolean isInjected();

	public native void softRestart();
}
