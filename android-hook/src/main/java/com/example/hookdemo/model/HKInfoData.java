package com.example.hookdemo.model;

import android.util.Log;

import java.util.List;

public class HKInfoData {

    public String packageName;
    public String exclude;

    public List<HKInfoDetail> details;

    public void dump() {
        Log.e("========", "===============================");
        Log.e("========", "packageName\t\t" + packageName);
        Log.e("========", "details\t\t" + details.size() + "");
        for (HKInfoDetail detail : details) {
            detail.dump();
        }
        Log.e("========", "===============================");
    }

}
