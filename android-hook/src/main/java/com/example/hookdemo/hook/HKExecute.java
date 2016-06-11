package com.example.hookdemo.hook;

import com.example.hookdemo.model.HKInfoDetail;

import java.util.Map;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class HKExecute extends MyHookCommon {

    public void hook(LoadPackageParam lpparam, HKInfoDetail data, String packageName) throws ClassNotFoundException {
        this.hookDetail = data;
        this.packageName = packageName;
        Object[] args = createArgs(data);
        XposedHelpers.findAndHookMethod(data.className, lpparam.classLoader, data.functionName, args
        );
    }

    public Object[] createArgs(HKInfoDetail data) throws ClassNotFoundException {
        Object[] args_obj = null;
        String args_type = data.argsType;
        int pos = 0;

        if (args_type != null && args_type.length() != 0) {

            String args_array[] = args_type.split(",");

            args_obj = new Object[args_array.length + 1];

            /*
            * method args string -> object
            * */

            for (String tmp : args_array) {
                if (string_to_class(tmp) != null) {
                    args_obj[pos] = string_to_class(tmp);
                } else {
                    args_obj[pos] = Class.forName(tmp);
                }
                pos++;
            }
        } else {
            args_obj = new Object[1];
        }

        /*
        * callback function
        * */
        args_obj[pos] = commonHook();
        return args_obj;
    }

}
