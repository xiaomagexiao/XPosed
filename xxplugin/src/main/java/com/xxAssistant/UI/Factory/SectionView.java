package com.xxAssistant.UI.Factory;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xxAssistant.UI.Configs.Config;

public class SectionView extends BaseSectionView {
    public SectionView(Context context, float dp, String viewName, int viewId) {
        super(context, dp, viewName, viewId);
        RelativeLayout v1 = new RelativeLayout(context);
        TextView v2 = new TextView(context);
        v2.setText(this.xxViewName);
        v2.setTextSize(((float)Config.xxSectionTextSize));
        v2.getPaint().setFakeBoldText(true);
        v2.setTextColor(Config.xxSectionTextColor);
        RelativeLayout.LayoutParams v3 = new RelativeLayout.LayoutParams(-2, -2);
        v3.addRule(9);
        v3.addRule(15);
        v1.addView(((View)v2), ((ViewGroup.LayoutParams)v3));
        ImageView v0 = new ImageView(context);
        v0.setBackgroundColor(1728053247);
        v3 = new RelativeLayout.LayoutParams(-1, 2);
        v3.addRule(12);
        v1.addView(((View)v0), ((ViewGroup.LayoutParams)v3));
        this.addView(((View)v1), new RelativeLayout.LayoutParams(-1, ((int)((((float)Config.xxSectionHeight)) * SectionView.mDp))));
    }

    public SectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SectionView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}

