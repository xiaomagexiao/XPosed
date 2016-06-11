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

public class EditCellView extends BaseCellView {
    TextView mNumText;

    public EditCellView(Context context, float dp, String viewName, int viewId, String defaultValue) {
        super(context, dp, viewName, viewId);
        RelativeLayout v3 = new RelativeLayout(context);
        TextView v4 = new TextView(context);
        v4.setText(this.xxViewName);
        v4.setTextSize(((float)Config.xxCellTextSize));
        v4.getPaint().setFakeBoldText(true);
        v4.setShadowLayer(1f, 0f, -1f, -16777216);
        v4.setTextColor(Config.xxCellTextColor);
        RelativeLayout.LayoutParams v6 = new RelativeLayout.LayoutParams(-2, -2);
        v6.addRule(9);
        v6.addRule(15);
        v3.addView(((View)v4), ((ViewGroup.LayoutParams)v6));
        this.mNumText = new TextView(context);
        int v5 = XXPluginData.getIntValue(viewId, Integer.valueOf(defaultValue).intValue());
        if(v5 == 0) {
            this.mNumText.setText(v5 + "");
            this.mNumText.setTextColor(Config.xxBeforeEditTextColor);
            this.mNumText.setTextSize(((float)Config.xxCellTextSize));
        }
        else {
            this.mNumText.setText(v5 + "");
            this.mNumText.setTextColor(Config.xxAfterEditTextColor);
            this.mNumText.setTextSize(((float)Config.xxCellTextSize));
        }

        v6 = new RelativeLayout.LayoutParams(-2, -2);
        v6.addRule(11);
        v6.addRule(15);
        v6.rightMargin = ((int)(15f * EditCellView.mDp));
        v3.addView(this.mNumText, ((ViewGroup.LayoutParams)v6));
        DrawArrowIconView v0 = new DrawArrowIconView(context, EditCellView.mDp, ((int)(30f * EditCellView.mDp)), ((int)(30f * EditCellView.mDp)));
        v0.setBackgroundColor(16777215);
        v6 = new RelativeLayout.LayoutParams(((int)(30f * EditCellView.mDp)), ((int)(30f * EditCellView.mDp)));
        v6.addRule(11);
        v6.addRule(15);
        v0.invalidate();
        v6.rightMargin = ((int)(-12f * EditCellView.mDp));
        v3.addView(((View)v0), ((ViewGroup.LayoutParams)v6));
        ImageView v2 = new ImageView(context);
        v2.setBackgroundColor(1728053247);
        v6 = new RelativeLayout.LayoutParams(-1, 2);
        v6.addRule(12);
        v3.addView(((View)v2), ((ViewGroup.LayoutParams)v6));
        this.addView(((View)v3), new RelativeLayout.LayoutParams(-1, ((int)((((float)Config.xxCellHeight)) * EditCellView.mDp))));
    }

    public EditCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditCellView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void editNumText(int num) {
        if(num == 0) {
            this.mNumText.setTextColor(Config.xxBeforeEditTextColor);
            this.mNumText.setText(num + "");
        }
        else {
            this.mNumText.setTextColor(Config.xxAfterEditTextColor);
            this.mNumText.setText(num + "");
        }

        XXPluginData.putIntValue(this.getId(), num);
    }

    public int getNumText() {
        return Integer.parseInt(this.mNumText.getText().toString());
    }
}

