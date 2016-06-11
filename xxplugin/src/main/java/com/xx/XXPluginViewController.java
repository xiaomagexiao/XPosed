package com.xx;


import java.util.Stack;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.xx.ui.IXXPluginDialogClickListener;
import com.xx.ui.XXPluginInputDialogView;
import com.xx.ui.XXPluginParentView;
import com.xx.ui.XXPluginSeekbarDialogView;
import com.xxAssistant.UI.xxAbout;
import com.xxAssistant.UI.xxSettingView;

public class XXPluginViewController {
    private static final String TAG = "XXPluginViewController";
    private xxAbout mAboutView;
    private Context mContext;
    private float mDp;
    private XXPluginInputDialogView mInputDialog;
    private XXPluginParentView mParentView;
    private Resources mRes;
    private XXPluginSeekbarDialogView mSeekbarDialog;
    private xxSettingView mSettingView;
    private Stack mViewStack;

    public XXPluginViewController(Context context, Resources res, float dp) {
        super();
        this.mViewStack = null;
        this.mContext = context;
        this.mDp = dp;
        this.mRes = res;
    }

    public void backFromAboutView() {
        if(this.mParentView != null && this.mAboutView != null) {
            this.mParentView.removeView(this.mAboutView);
        }

        this.mSettingView.setVisibility(View.VISIBLE);
    }

    public void backToLastView() {
    }

    public void closeInputDialog() {
        if(this.mInputDialog != null && this.mParentView != null) {
            this.mParentView.removeView(this.mInputDialog);
        }
    }

    public void closeSeekbarDialog() {
        if(this.mSeekbarDialog != null && this.mParentView != null) {
            this.mParentView.removeView(this.mSeekbarDialog);
        }
    }

    public XXPluginParentView getPluginParentView() {
        this.mSettingView = new xxSettingView(this.mContext, this.mDp);
        this.mParentView = new XXPluginParentView(this.mContext, this.mRes);
        this.mParentView.addView(this.mSettingView);
        return this.mParentView;
    }

    public xxSettingView getSettingView() {
        return this.mSettingView;
    }

    public void showAboutView() {
        this.mAboutView = new xxAbout(this.mContext, null, this.mDp);
        this.mParentView.addView(this.mAboutView);
        this.mSettingView.setVisibility(View.GONE);
    }

    public void showInputDialog(String title, String hintStr, int defaultNum, int minNum, int maxNum, IXXPluginDialogClickListener listener) {
        if(this.mParentView != null) {
            this.mInputDialog = new XXPluginInputDialogView(this.mContext, this.mRes, title, hintStr, defaultNum, minNum, maxNum, listener);
            FrameLayout.LayoutParams v9 = new FrameLayout.LayoutParams(-1, this.mSettingView.getHeight());
            v9.gravity = 17;
            this.mParentView.addView(this.mInputDialog, ((ViewGroup.LayoutParams)v9));
        }
    }

    public void showSeekbarDialog(String title, int defaultNum, int minNum, int maxNum, IXXPluginDialogClickListener listener) {
        if(this.mParentView != null) {
            this.mSeekbarDialog = new XXPluginSeekbarDialogView(this.mContext, this.mRes, title, defaultNum, minNum, maxNum, listener);
            this.mParentView.addView(this.mSeekbarDialog);
        }
    }
}

