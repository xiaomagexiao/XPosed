package com.example.hookdemo.util;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.hookdemo.hook.HKCommon;
import com.example.hookdemo.hook.HKExecute;
import com.example.hookdemo.model.HKInfoData;
import com.example.hookdemo.model.HKInfoDetail;

import java.lang.reflect.Field;
import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class HookUtil implements IXposedHookLoadPackage {
    protected static final String TAG = HKCommon.TAG_CODE_INIT;
    private Context mContext;
    private String packageName;

    @Override
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        packageName = lpparam.packageName;
        Log.e(TAG, "[!]packagename =========== " + lpparam.packageName);
        // hookAndGetContext("android.app.Activity", lpparam, "onCreate");
        doAfterGetContext(lpparam);
    }

    private void hookAndGetContext(String className, final LoadPackageParam lpparam, String methodName) {
        XposedHelpers.findAndHookMethod(className, lpparam.classLoader, methodName, Bundle.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                // Hook函数之前执行的代码
                if (mContext == null) {
                    mContext = (Context) param.thisObject;
                    doAfterGetContext(lpparam);
                }
                Log.e(TAG, "[!] 获取到了Context");
            }

            @Override
            protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
                Log.e(TAG, "[!] afterHookedMethod");
            }
        });
    }

    public static Context getSystemContext() throws Exception {
        Object currentActivityThread = ReflectUtils.invokeStaticMethod("android.app.ActivityThread", "currentActivityThread",
                new Class[]{}, new Object[]{});
        Class<?> ActivityThread_class = Class.forName("android.app.ActivityThread");
        Field sSystemContext_field = ActivityThread_class.getDeclaredField("mSystemContext");
        sSystemContext_field.setAccessible(true);
        return (Context) sSystemContext_field.get(currentActivityThread);
    }

    /**
     * 获取context后执行
     *
     * @param lpparam
     */
    private void doAfterGetContext(LoadPackageParam lpparam) {
        if (mContext == null) {
            try {
                mContext = getSystemContext();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<HKInfoData> list = HKDataUtil.parseJsonData(mContext);
        for (HKInfoData data : list) {
            String exclude = data.exclude == null ? "" : data.exclude;
            if (("all".equals(data.packageName) && !exclude.contains(packageName)) || packageName.equals(data.packageName)) {
                data.packageName = packageName;
                hookData(lpparam, data);
                // break;
            }
        }
    }

    private void hookData(LoadPackageParam lpparam, HKInfoData data) {
        try {
            for (HKInfoDetail detail : data.details) {
                if (detail.enable) {
                    new HKExecute().hook(lpparam, detail, data.packageName);
                    XposedBridge.log("hook: " + data.packageName + " - " + detail.className + " - " + detail.functionName);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
