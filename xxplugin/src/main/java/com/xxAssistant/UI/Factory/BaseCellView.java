package com.xxAssistant.UI.Factory;


import android.content.Context;
import android.util.AttributeSet;

public class BaseCellView extends BaseView {
    public BaseCellView(Context context, float dp, String viewName, int viewId) {
        super(context, dp, viewName, viewId);
    }

    public BaseCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseCellView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}

