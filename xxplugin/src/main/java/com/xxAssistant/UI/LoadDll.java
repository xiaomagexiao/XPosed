package com.xxAssistant.UI;

import java.io.File;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.xxAssistant.Utils.Utility;

public class LoadDll {
	public static void load(final Context content, int id, String gameName) {
		File file = new File(content.getCacheDir(), "");
		if (!file.exists()) {
			file.mkdir();
		}
		if (Utility.getInstance().doSymlinkAndChmode(
				new File("/data/data/com.xxAssistant/app_plugin/" + id + "/" + gameName + ".xxplist").getAbsolutePath(),
				content.getCacheDir() + "/plist.xx")) {

			new Handler(content.getMainLooper()).postDelayed(new Thread() {
				public void run() {
					super.run();
					// 移除文件
					Utility.getInstance().doRemoveFile(String.valueOf(content.getCacheDir().toString()) + "/plist.xx");
				}
			}, 3000);
			Toast.makeText(content, "插件部署成功", 0).show();
		} else {
			Toast.makeText(content, "插件部署失败", 0).show();
		}
	}

}
