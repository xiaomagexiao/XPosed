package com.xxAssistant.UI.Factory;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xxAssistant.UI.Configs.Config;

public class ButtonCellView extends BaseCellView {
    TextView mButtonText;

    public ButtonCellView(Context context, float dp, String viewName, int viewId, String defaultValue) {
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
        this.mButtonText = new TextView(context);
        this.mButtonText.setText(((CharSequence)defaultValue));
        this.mButtonText.setPadding(5, 5, 5, 5);
        this.mButtonText.setTextColor(Config.xxAfterEditTextColor);
        this.mButtonText.setTextSize(((float)Config.xxCellTextSize));
        ShapeBg v0 = new ShapeBg(dp);
        v0.setCornerRadius(4f);
        v0.setColor(16777215);
        v0.setStroke(1, -1);
        this.mButtonText.setBackgroundDrawable(((Drawable)v0));
        v4 = new RelativeLayout.LayoutParams(-2, -2);
        v4.addRule(11);
        v4.addRule(15);
        v4.rightMargin = ((int)(ButtonCellView.mDp * 13f));
        v2.addView(this.mButtonText, ((ViewGroup.LayoutParams)v4));
        ImageView v1 = new ImageView(context);
        v1.setBackgroundColor(1728053247);
        v4 = new RelativeLayout.LayoutParams(-1, 2);
        v4.addRule(12);
        v2.addView(((View)v1), ((ViewGroup.LayoutParams)v4));
        this.addView(((View)v2), new RelativeLayout.LayoutParams(-1, ((int)((((float)Config.xxCellHeight)) * ButtonCellView.mDp))));
    }

    public ButtonCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonCellView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}

