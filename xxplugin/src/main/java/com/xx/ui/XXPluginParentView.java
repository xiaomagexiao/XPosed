package com.xx.ui;


import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import com.xx.XXPlugin;

public class XXPluginParentView extends FrameLayout {
    protected static final String TAG = "XXPluginParentView";

    public XXPluginParentView(Context context, Resources res) {
        super(context);
    }

    public static void closePluginBackToSmallFloatView() {
        XXPlugin.getInstance().onReturnToSmallFloatView();
    }
}

