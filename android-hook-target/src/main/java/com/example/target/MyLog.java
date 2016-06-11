package com.example.target;

import android.util.Log;

public class MyLog {

    private static boolean is_debug = true;

    /**
     * 静态方法
     *
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (is_debug) {
            Log.e(tag, msg);
        }
    }

    /**
     * 普通方法
     *
     * @param tag
     * @param msg
     */
    public void ee(String tag, String msg) {
        if (is_debug) {
            Log.e(tag, msg);
        }
    }

    /**
     * 测试修改返回值-boolean类型
     */
    public static boolean isOk() {
        return true;
    }

    /**
     * 测试修改返回值-String 类型
     */
    public static String getKey() {
        return "getKey";
    }

}
