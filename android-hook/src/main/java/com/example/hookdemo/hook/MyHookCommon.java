package com.example.hookdemo.hook;

import android.util.Log;

import com.example.hookdemo.model.HKInfoDetail;

import java.util.Map;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.XposedBridge;

public class MyHookCommon {
    protected static final String TAG = "HookUtil";
    protected String packageName;

    protected HKInfoDetail hookDetail;

    protected XC_MethodHook commonHook() {
        final String info = hookDetail.tag + "->>>>";
        return new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                printParams(param, info);
                printStack(info);
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param)
                    throws Throwable {
                if (hookDetail.result != null) {
                    try {
                        String[] arr = hookDetail.result.split("-");
                        Object obj = string_to_value(arr[0], arr[1]);
                        param.setResult(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                        //传入参数1
                        XposedBridge.log("修改返回值异常:" + e.getMessage());
                    }
                }
            }
        };
    }

    protected void printStack(String type) {
        if (hookDetail.stack) {
            Log.e(TAG, "[!] " + packageName + "-" + type + Log.getStackTraceString(new Throwable()));
        }
    }

    protected void printParams(MethodHookParam param, String type) {
        Log.e(TAG, "[!] " + packageName + "-" + type + " 参数数量 - " + param.args.length);
        for (int i = 0; i < param.args.length; i++) {
            Log.e(TAG, "[!] 参数 (" + (i + 1) + "/" + param.args.length + ") ：" + (param.args[i] == null ? "-null-" : param.args[i]));
        }
    }

    Class string_to_class(String type) {

        switch (type) {
            case "byte":
                return byte.class;
            case "short":
                return short.class;
            case "int":
                return int.class;
            case "long":
                return long.class;
            case "float":
                return float.class;
            case "double":
                return double.class;
            case "String":
                return String.class;
            case "Map":
                return Map.class;
            case "boolean":
                return boolean.class;
            case "char":
                return char.class;
            case "Object":
                return Object.class;

            default:
                return null;
        }
    }

    Object string_to_value(String type, String val) {
        switch (type) {
            case "short":
                return Short.valueOf(val);
            case "int":
                return Integer.valueOf(val);
            case "long":
                return Long.valueOf(val);
            case "float":
                return Float.valueOf(val);
            case "double":
                return Double.valueOf(val);
            case "boolean":
                return "true".equals(val.toLowerCase());
            default:
                return val;
        }
    }

}
