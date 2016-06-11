package com.example.hookdemo.util;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.text.TextUtils;

import com.example.hookdemo.MainApplication;
import com.example.hookdemo.model.HKInfoData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import de.robv.android.xposed.XposedBridge;

public class HKDataUtil {

    public static List<HKInfoData> parseJsonData(Context context) {
        //  String jsonString = FileUtil.readFromFile(filename);
        String jsonString = FileUtil.strFromAssert("hook.json", context);
        List<HKInfoData> list = null;
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString,
                    new TypeToken<List<HKInfoData>>() {
                    }.getType());
        } catch (Exception e) {
            XposedBridge.log("获取配置信息失败:" + e.getMessage());
        }
        if(list==null){
            list = new ArrayList<>();
        }
        for (HKInfoData info : list) {
            info.dump();
        }
        return list;
    }

}
