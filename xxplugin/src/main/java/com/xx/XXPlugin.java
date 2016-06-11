package com.xx;


import android.content.Context;
import android.content.res.Resources;
import android.view.View;

public class XXPlugin extends XXPluginBase {
    private static final String TAG = "XXPlugin";
    private boolean mIsHook;
    private static XXPlugin mSelf;
    protected XXPluginViewController mViewController;
	private int gameUid;
	private String gamePkgName;

    public XXPlugin(Context context) {
        this.mIsHook = false;
        XXPlugin.mSelf = this;
    }

    protected XXIpcController createIpcController(int pid) {
        return new XXPluginIpcController(pid);
    }

    public void destroy() {
        XXPlugin.mSelf = null;
    }

    public int getGameUid() {
        return this.gameUid;
    }

    public static XXPlugin getInstance() {
        if(mSelf==null){
            mSelf = new XXPlugin(MainApplication.getContext());
        }
        return XXPlugin.mSelf;
    }

    public String getToastStr() {
        return "";
    }

    public View getView(Context context, float dp, IXXClickBlankListener listener) {
     //   this.mBlankListener = listener;
        if(this.mViewController == null) {
            this.mViewController = new XXPluginViewController(context, this.createResources(this.createAssetManager(this.getApkPath())), dp);
        }

        return this.mViewController.getPluginParentView();
    }

    private Resources createResources(Object createAssetManager) {
		return null;
	}

	private Object createAssetManager(String apkPath) {
		return null;
	}

	private String getApkPath() {
		return "";
	}

	public XXPluginViewController getViewController() {
        return this.mViewController;
    }

    public int getViewType() {
        return 0;
    }

//    public void init(int gameUid, int gamePid, String gamePkgName, XXPluginInitObsv obsv) {
//        super.init(gameUid, gamePid, gamePkgName, obsv);
//    }

    protected void onInitResult(boolean isSucc) {
//        if((isSucc) && !this.mIsHook) {
//            this.mIsHook = true;
//            Config.autoSetLanguage(this.mContext);
//            Config.loadCellConfig();
//            String v7 = this.mContext.getPackageManager().getPackageInfo(this.gamePkgName, 16384).versionName;
//            Log.i("XXPlugin", "versionName " + v7);
//            XXIpcController v4 = XXPlugin.getInstance().getIpcController();
//            ((XXPluginIpcController)v4).send(Config.XXIPCKey_Set_dohook, this.gamePkgName + " " + v7);
//            int v3;
//            for(v3 = 0; v3 < Config.xxCells_ID.length; ++v3) {
//                int v5;
//                for(v5 = 0; v5 < Config.xxCells_ID[v3].length; ++v5) {
//                    ((XXPluginIpcController)v4).send(Config.mCellConfigMap.get(Config.xxCells_ID[v3][v5]).mCmd, XXPluginData.getIntValue(Config.xxCells_ID[v3][v5], 0));
//                }
//            }
//        }
    }

	public Context getContext() {
		return mContext;
	}

	public void onReturnToSmallFloatView() {
		// TODO Auto-generated method stub
		
	}
}

