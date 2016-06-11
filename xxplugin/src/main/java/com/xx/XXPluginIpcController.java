package com.xx;


import java.io.IOException;
import java.util.Scanner;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

public class XXPluginIpcController extends XXIpcController {
    private static final String TAG = "XXIpcAssistController";
    public static final int XXIPCKEY_Set_DoPlayMusic = 112;


    public XXPluginIpcController(int pid) {
        super(pid);
    }

    public String getSocketBaseName() {
        return "xxp_gjqt";
    }

    public void onReceive(String line) {
        Log.e("XXIpcAssistController", "onReceive line is :" + line);
        Scanner v5 = new Scanner(line);
        int v4 = v5.nextInt();
        Log.e("XXIpcAssistController", "onReceive rid " + v4);
        if(v4 > 0) {
            v5.close();
        }
        else {
            int v0 = v5.nextInt();
            Log.e("XXIpcAssistController", "onReceive value " + v0);
            switch(v0) {
                case 112: {
                    this.playMusic(XXPlugin.getInstance().getContext(), "file:///data/data/" + XXPlugin.getInstance().getContext().getPackageName() + "/app_plugin/" + XXPlugin.getInstance().getGameUid() + "/winwinwin.wav");
                    this.send(v4 + " " + v0);
                    break;
                }
            }

            v5.close();
        }
    }

	public void playMusic(Context context, String musicFilepath) {
        try {
			Log.e("XXIpcAssistController", "playMusic " + musicFilepath);
			MediaPlayer v1 = MediaPlayer.create(context, Uri.parse(musicFilepath));
			if(v1 != null) {
			    v1.stop();
			    v1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			        public void onCompletion(MediaPlayer mp) {
			            if(mp != null) {
			                mp.release();
			            }
			        }
			    });
			    v1.prepare();
			    v1.start();
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void send(int cmd, String value) {
        String v0 = this.mRid + " " + cmd + " " + value;
        ++this.mRid;
        Log.i("XXIpcAssistController", "send " + v0);
        this.send(v0);
    }
}

