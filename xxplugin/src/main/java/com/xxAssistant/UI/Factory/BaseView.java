package com.xxAssistant.UI.Factory;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class BaseView extends RelativeLayout {
    protected static ShapeBg mBg;
    protected static float mDp;
    protected static int mPad;
    protected String xxViewName;

    public BaseView(Context context, float dp, String viewName, int viewId) {
        super(context);
        this.setTag(viewName);
        if(BaseView.mBg == null) {
            BaseView.mDp = dp;
            BaseView.mBg = new ShapeBg(BaseView.mDp);
            BaseView.mBg.setCornerRadius(8f);
            BaseView.mBg.setColor(-16777216);
            BaseView.mBg.setStroke(1, -1);
            BaseView.mPad = ((int)(6f * BaseView.mDp));
        }

        this.xxViewName = viewName;
        this.setId(viewId);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}

