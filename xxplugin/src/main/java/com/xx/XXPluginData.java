package com.xx;


import android.content.SharedPreferences;

public class XXPluginData {
    public static final String SP_NAME = "xxp_gjqt_settings";
    protected static SharedPreferences mSp;

    public XXPluginData() {
        super();
    }

    public static int getIntValue(int viewId, int defValue) {
        SharedPreferences v1 = XXPluginData.getSp();
        if(v1 != null) {
            defValue = v1.getInt("" + viewId, defValue);
        }

        return defValue;
    }

    public static SharedPreferences getSp() {
        if(XXPluginData.mSp == null && XXPlugin.getInstance() != null && XXPlugin.getInstance().getContext() != null) {
            XXPluginData.mSp = XXPlugin.getInstance().getContext().getSharedPreferences("xxp_gjqt_settings", 0);
        }

        return XXPluginData.mSp;
    }

    public static void putIntValue(int viewId, int val) {
        SharedPreferences v0 = XXPluginData.getSp();
        if(v0 != null) {
            v0.edit().putInt("" + viewId, val).commit();
        }
    }
}

