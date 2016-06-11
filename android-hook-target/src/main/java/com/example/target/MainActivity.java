package com.example.target;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private TextView tv_hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    MyLog.e("MainActivity", "[!] MainActivity show msg e!!!");
                    new MyLog().ee("MainActivity", "[!] MainActivity show msg  eeee!!!");
                    MyLog.e("MainActivity", "[!] boolean - " +MyLog.isOk());
                    MyLog.e("MainActivity", "[!] String - " +MyLog.getKey());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        String str = strFromAssert("hook.json", this);
        Log.e("11111", str);

        List<HKInfoData> list = null;
        try {
            Gson gson = new Gson();
            list = gson.fromJson(str,
                    new TypeToken<List<HKInfoData>>() {
                    }.getType());
        } catch (Exception e) {
        }

        if (list == null) {
            list = new ArrayList<>();
        }
        for (HKInfoData info : list) {
            info.dump();
        }
        Log.e("11111", list.size() + "");
        tv_hello = (TextView) this.findViewById(R.id.tv_hello);
        tv_hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("11111", "setOnClickListener");
            }
        });
        try {
            Class cl = Class.forName("android.view.View$OnClickListener");
            Log.e("11111", cl.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private static final String DEFAULT_FILE_NAME = "/sdcard/hook.json";

    /**
     * 从assert里读取内容
     *
     * @param filename
     * @param context
     * @return
     */
    public static String strFromAssert(String filename, Context context) {
        AssetManager assetManager = context.getAssets();
        String strResponse = "";
        InputStream ims = null;
        try {
            ims = assetManager.open(filename);
            if (ims == null) {
                File file = new File(DEFAULT_FILE_NAME);
                ims = new FileInputStream(file);
            }
            strResponse = getStringFromInputStream(ims);
        } catch (Exception e) {
            try {
                File file = new File(DEFAULT_FILE_NAME);
                ims = new FileInputStream(file);
                strResponse = getStringFromInputStream(ims);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
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
