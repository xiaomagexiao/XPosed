package com.example.hookdemo.hook;

import android.util.Log;

public class HKLog {

    private static boolean is_debug = true;

    public static void e(String tag, String msg) {
        if (is_debug) {
            Log.e(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (is_debug) {
            Log.w(tag, msg);
        }
    }

}
