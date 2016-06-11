package com.example.hookdemo.util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import de.robv.android.xposed.XposedBridge;

public class FileUtil {

    private static final String DEFAULT_FILE_NAME = "/sdcard/hook.json";

    public static void writeStrToFile(String str, String fileName) {
        FileWriter writer;
        try {
            writer = new FileWriter(fileName);
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        String result = "";
        BufferedReader reader = null;
        try {
            File file = new File(fileName);
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            result = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 从assert里读取内容
     *
     * @param filename
     * @param context
     * @return
     */
    public static String strFromAssert(String filename, Context context) {
        String strResponse = "";
        InputStream ims = null;
        try {
            AssetManager assetManager = context.getAssets();
            ims = assetManager.open(filename);
            strResponse = getStringFromInputStream(ims);
        } catch (Exception e) {
            XposedBridge.log("从asset读取文件失败:" + e.getMessage());
            try {
                File file = new File(DEFAULT_FILE_NAME);
                ims = new FileInputStream(file);
                strResponse = getStringFromInputStream(ims);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }finally {
            if(ims!=null){
                try {
                    ims.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return strResponse;
    }

    private static String getStringFromInputStream(InputStream a_is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(a_is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return sb.toString();
    }

}
