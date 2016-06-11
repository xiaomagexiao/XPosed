package com.xxAssistant.UI.Factory;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xx.XXPluginData;
import com.xxAssistant.UI.Configs.Config;

public class SwitchCellView extends BaseCellView {
    public interface SwitchCallBack {
        void callBack(Boolean arg1);
    }

    SwitchCallBack mSwitchCallBack;
    TextView mSwitchText;

    public SwitchCellView(Context context, float dp, String viewName, int viewId, String defaultValue) {
        super(context, dp, viewName, viewId);
        RelativeLayout v2 = new RelativeLayout(context);
        TextView v3 = new TextView(context);
        v3.setText(this.xxViewName);
        v3.setTextSize(((float)Config.xxCellTextSize));
        v3.setTextColor(Config.xxCellTextColor);
        v3.getPaint().setFakeBoldText(true);
        v3.setShadowLayer(1f, 0f, -1f, -16777216);
        RelativeLayout.LayoutParams v4 = new RelativeLayout.LayoutParams(-2, -2);
        v4.addRule(9);
        v4.addRule(15);
        v2.addView(((View)v3), ((ViewGroup.LayoutParams)v4));
        int v0 = XXPluginData.getIntValue(viewId, Integer.valueOf(defaultValue).intValue());
        this.mSwitchText = new TextView(context);
        if(v0 == 1) {
            this.mSwitchText.setText(Config.xxOn[Config.XXLANGUAGE_NOW]);
            this.mSwitchText.setTextColor(Config.xxOnButtonColor);
            this.mSwitchText.setTextSize(((float)Config.xxCellTextSize));
        }
        else {
            this.mSwitchText.setText(Config.xxOff[Config.XXLANGUAGE_NOW]);
            this.mSwitchText.setTextColor(Config.xxOffButtonColor);
            this.mSwitchText.setTextSize(((float)Config.xxCellTextSize));
        }

        v4 = new RelativeLayout.LayoutParams(-2, -2);
        v4.addRule(11);
        v4.addRule(15);
        v4.rightMargin = ((int)(SwitchCellView.mDp * 13f));
        v2.addView(this.mSwitchText, ((ViewGroup.LayoutParams)v4));
        ImageView v1 = new ImageView(context);
        v1.setBackgroundColor(1728053247);
        v4 = new RelativeLayout.LayoutParams(-1, 2);
        v4.addRule(12);
        v2.addView(((View)v1), ((ViewGroup.LayoutParams)v4));
        this.addView(((View)v2), new RelativeLayout.LayoutParams(-1, ((int)((((float)Config.xxCellHeight)) * SwitchCellView.mDp))));
    }

    public SwitchCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwitchCellView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public boolean getSwitchValue() {
        boolean v0 = this.mSwitchText.getText().equals(Config.xxOff[Config.XXLANGUAGE_NOW]) ? false : true;
        return v0;
    }

    public void setSwitchCallBack(SwitchCallBack callback) {
        this.mSwitchCallBack = callback;
    }

    public void switchFunction() {
        if(this.mSwitchText.getText().equals(Config.xxOff[Config.XXLANGUAGE_NOW])) {
            this.mSwitchText.setText(Config.xxOn[Config.XXLANGUAGE_NOW]);
            this.mSwitchText.setTextColor(Config.xxOnButtonColor);
            if(this.mSwitchCallBack != null) {
                this.mSwitchCallBack.callBack(Boolean.valueOf(true));
            }

            XXPluginData.putIntValue(this.getId(), 1);
        }
        else {
            this.mSwitchText.setText(Config.xxOff[Config.XXLANGUAGE_NOW]);
            this.mSwitchText.setTextColor(Config.xxOffButtonColor);
            if(this.mSwitchCallBack != null) {
                this.mSwitchCallBack.callBack(Boolean.valueOf(false));
            }

            XXPluginData.putIntValue(this.getId(), 0);
        }
    }
}

