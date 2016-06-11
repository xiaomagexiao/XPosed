package com.xxAssistant.UI;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xx.XXPlugin;
import com.xxAssistant.UI.Configs.Config;
import com.xxAssistant.UI.Factory.DrawAboutIconView;
import com.xxAssistant.UI.Factory.DrawCloseIconView;
import com.xxAssistant.UI.Factory.ShapeBg;

public class xxAbout extends RelativeLayout {
    private RelativeLayout mAbout;
    private Context mContext;
    private float mDp;
    private LinearLayout mRealAbout;
    private TextView mTvContent;

    public xxAbout(Context context, ViewGroup parent, float dp) {
        super(context);
        this.mDp = dp;
        this.mContext = context;
        this.mAbout = ((RelativeLayout)this);
        this.initView();
    }

    private void initView() {
        this.mAbout.setGravity(17);
        this.mAbout.setBackgroundColor(-16777216);
        this.mAbout.getBackground().setAlpha(0);
        this.mAbout.setClickable(true);
        this.mRealAbout = new LinearLayout(this.mContext);
        this.mRealAbout.setOrientation(1);
        this.mRealAbout.setGravity(1);
        ShapeBg v0 = new ShapeBg(this.mDp);
        v0.setCornerRadius(8f);
        v0.setColor(-16777216);
        v0.setStroke(1, -1);
        this.mRealAbout.setBackgroundDrawable(((Drawable)v0));
        this.mRealAbout.getBackground().setAlpha(153);
        int v7 = ((int)(16f * this.mDp));
        this.mRealAbout.setPadding(v7, ((int)(10f * this.mDp)), v7, v7);
        RelativeLayout.LayoutParams v2 = new RelativeLayout.LayoutParams(((int)(300f * this.mDp)), -2);
        this.mRealAbout.setMinimumHeight(((int)(100f * this.mDp)));
        this.mAbout.addView(this.mRealAbout, ((ViewGroup.LayoutParams)v2));
        TextView v9 = new TextView(this.mContext);
        v9.setText(Config.xxTittle[Config.XXLANGUAGE_NOW]);
        v9.getPaint().setFakeBoldText(true);
        v9.setTextSize(((float)Config.xxTittleTextSize));
        v9.setTextColor(Config.xxTittleTextColor);
        v9.setGravity(1);
        RelativeLayout.LayoutParams v8 = new RelativeLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams v3 = new LinearLayout.LayoutParams(-1, -2);
        v8.addRule(13);
        RelativeLayout v6 = new RelativeLayout(this.mContext);
        v6.addView(((View)v9), ((ViewGroup.LayoutParams)v8));
        DrawCloseIconView v5 = new DrawCloseIconView(this.mContext, this.mDp, ((int)(30f * this.mDp)), ((int)(30f * this.mDp)));
        v5.setMinimumHeight(((int)(30f * this.mDp)));
        v5.setMinimumWidth(((int)(30f * this.mDp)));
        v5.setBackgroundColor(16777215);
        v8 = new RelativeLayout.LayoutParams(-2, -2);
        v8.addRule(15);
        v5.invalidate();
        v6.addView(((View)v5), ((ViewGroup.LayoutParams)v8));
        v5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                XXPlugin.getInstance().getViewController().backFromAboutView();
            }
        });
        DrawAboutIconView v4 = new DrawAboutIconView(this.mContext, this.mDp, ((int)(30f * this.mDp)), ((int)(30f * this.mDp)));
        v4.setMinimumHeight(((int)(30f * this.mDp)));
        v4.setMinimumWidth(((int)(30f * this.mDp)));
        v4.setBackgroundColor(16777215);
        v8 = new RelativeLayout.LayoutParams(-2, -2);
        v8.addRule(15);
        v8.addRule(11);
        v4.invalidate();
        v3.bottomMargin = ((int)(6f * this.mDp));
        this.mRealAbout.addView(((View)v6), ((ViewGroup.LayoutParams)v3));
        TextView v1 = new TextView(this.mContext);
        v1.setText(Config.xxDescription[Config.XXLANGUAGE_NOW]);
        v1.setTextSize(((float)Config.xxAboutContentTextSize));
        v1.setTextColor(Config.xxTittleTextColor);
        v1.setGravity(3);
        new RelativeLayout.LayoutParams(-1, -2).addRule(14);
        v3.bottomMargin = ((int)(12f * this.mDp));
        this.mRealAbout.addView(((View)v1), ((ViewGroup.LayoutParams)v3));
    }
}

