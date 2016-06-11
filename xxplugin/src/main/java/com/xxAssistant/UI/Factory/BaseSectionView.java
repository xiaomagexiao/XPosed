package com.xxAssistant.UI.Factory;


import android.content.Context;
import android.util.AttributeSet;

public class BaseSectionView extends BaseView {
    public BaseSectionView(Context context, float dp, String viewName, int viewId) {
        super(context, dp, viewName, viewId);
    }

    public BaseSectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseSectionView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}

