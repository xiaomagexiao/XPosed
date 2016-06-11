package com.example.target;

import android.util.Log;

public class HKInfoDetail {

    public String className;
    public String functionName;
    public String argsType;
    public String tag;
    public boolean enable;
    public boolean stack;

    public void dump() {
        Log.e("========", "===============================");
        Log.e("========", "className\t\t" + className);
        Log.e("========", "functionName\t\t" + functionName);
        Log.e("========", "argsType\t\t" + argsType);
        Log.e("========", "tag\t\t" + tag);
        Log.e("========", "enable\t\t" + enable);
        Log.e("========", "stack\t\t" + stack);
        Log.e("========", "===============================");
    }
}
