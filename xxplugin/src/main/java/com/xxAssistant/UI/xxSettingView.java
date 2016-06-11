package com.xxAssistant.UI;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.xx.XXPlugin;
import com.xx.ui.XXPluginBaseView;
import com.xx.ui.XXPluginParentView;
import com.xxAssistant.UI.Configs.CellConfig;
import com.xxAssistant.UI.Configs.Config;
import com.xxAssistant.UI.Factory.DrawAboutIconView;
import com.xxAssistant.UI.Factory.DrawCloseIconView;
import com.xxAssistant.UI.Factory.ShapeBg;
import com.xxAssistant.UI.Factory.ViewFactoty;
import com.xxAssistant.UI.Factory.ViewFactoty.ViewType;

public class xxSettingView extends XXPluginBaseView {
    private Context mContext;
    private float mDp;
    private LinearLayout mRealSettingView;
    private RelativeLayout mSettingView;
    private SparseArray mViews;

    public xxSettingView(Context context, float dp) {
        super(context);
        this.mViews = new SparseArray();
        this.mContext = context;
        this.mSettingView = ((RelativeLayout) this);
        this.mDp = dp;
        this.initView();
    }

    private void initView() {
        View v12;
        CellConfig config;
        this.mSettingView.setGravity(17);
        this.mSettingView.setBackgroundColor(-16777216);
        this.mSettingView.getBackground().setAlpha(80);
        this.mRealSettingView = new LinearLayout(this.mContext);
        this.mRealSettingView.setOrientation(1);
        this.mRealSettingView.setGravity(1);
        int v18 = ((int) (16f * this.mDp));
        this.mRealSettingView.setPadding(v18, 0, v18, v18);
        ShapeBg v9 = new ShapeBg(this.mDp);
        v9.setCornerRadius(8f);
        v9.setColor(-16777216);
        this.mRealSettingView.setBackgroundDrawable(((Drawable) v9));
        this.mRealSettingView.getBackground().setAlpha(153);
        this.mSettingView.addView(this.mRealSettingView, new RelativeLayout.LayoutParams(((int) (300f * this.mDp)), -2));
        RelativeLayout v17 = new RelativeLayout(this.mContext);
        v17.setBackgroundColor(16777215);
        LinearLayout.LayoutParams v13 = new LinearLayout.LayoutParams(-1, ((int) (45f * this.mDp)));
        TextView v22 = new TextView(this.mContext);
        v22.setText(Config.xxTittle[Config.XXLANGUAGE_NOW]);
        v22.getPaint().setFakeBoldText(true);
        v22.setTextSize(((float) Config.xxTittleTextSize));
        v22.setTextColor(Config.xxTittleTextColor);
        v22.setGravity(1);
        RelativeLayout.LayoutParams v19 = new RelativeLayout.LayoutParams(-1, -2);
        v19.addRule(13);
        v17.addView(v22, v19);
        DrawCloseIconView v16 = new DrawCloseIconView(this.mContext, this.mDp, ((int) (30f * this.mDp)), ((int) (30f * this.mDp)));
        v16.setMinimumHeight(((int) (30f * this.mDp)));
        v16.setMinimumWidth(((int) (30f * this.mDp)));
        v16.setBackgroundColor(16777215);
        v19 = new RelativeLayout.LayoutParams(-2, -2);
        v19.addRule(15);
        v16.invalidate();
        v17.addView(v16, v19);
        DrawAboutIconView v15 = new DrawAboutIconView(this.mContext, this.mDp, ((int) (30f * this.mDp)), ((int) (30f * this.mDp)));
        v15.setMinimumHeight(((int) (30f * this.mDp)));
        v15.setMinimumWidth(((int) (30f * this.mDp)));
        v15.setBackgroundColor(16777215);
        v19 = new RelativeLayout.LayoutParams(-2, -2);
        v19.addRule(15);
        v19.addRule(11);
        v15.invalidate();
        this.mRealSettingView.addView(v17, ((ViewGroup.LayoutParams) v13));
        ScrollView v20 = new ScrollView(this.mContext);
        v20.setScrollBarStyle(0);
        LinearLayout v14 = new LinearLayout(this.mContext);
        v14.setOrientation(1);
        v13 = new LinearLayout.LayoutParams(-1, -2);
        this.mRealSettingView.addView(v20, ((ViewGroup.LayoutParams) v13));
        v20.addView(((View) v14));
        if (Config.XXLANGUAGE_NOW == 0) {
            int v21;
            for (v21 = 0; v21 < Config.xxSections_CH.length; ++v21) {
                v14.addView(ViewFactoty.createView(this.mContext, this.mDp, ViewType.Section, Config.xxSections_CH[v21], -1, ""),
                        ((ViewGroup.LayoutParams) v13));
                int v11;
                for (v11 = 0; v11 < Config.xxCells_ID[v21].length; ++v11) {
                    config = (CellConfig) Config.mCellConfigMap.get(Config.xxCells_ID[v21][v11]);
                    v12 = ViewFactoty.createView(this.mContext, this.mDp, config.mViewType,
                            config.mChineseText, config.mViewId, config.mDefault);
                    v14.addView(v12, ((ViewGroup.LayoutParams) v13));
                    this.mViews.put(Config.xxCells_ID[v21][v11], v12);
                }
            }
        } else {
            for (int v21 = 0; v21 < Config.xxSections_EN.length; ++v21) {
                v14.addView(ViewFactoty.createView(this.mContext, this.mDp, ViewType.Section, Config.xxSections_EN[v21], -1, ""),
                        ((ViewGroup.LayoutParams) v13));
                for (int v11 = 0; v11 < Config.xxCells_ID[v21].length; ++v11) {
                    config = (CellConfig) Config.mCellConfigMap.get(Config.xxCells_ID[v21][v11]);
                    v12 = ViewFactoty.createView(this.mContext, this.mDp, config.mViewType,
                            config.mEnglishText, config.mViewId, config.mDefault);
                    v14.addView(v12, ((ViewGroup.LayoutParams) v13));
                    this.mViews.put(Config.xxCells_ID[v21][v11], v12);
                }
            }
        }

        v15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                XXPlugin.getInstance().getViewController().showAboutView();
            }
        });
        v16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                XXPluginParentView.closePluginBackToSmallFloatView();
            }
        });
        v17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            }
        });
        this.mSettingView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                float v4 = event.getX();
                float v5 = event.getY();
                float v2 = ((float) xxSettingView.this.mRealSettingView.getLeft());
                float v3 = ((float) xxSettingView.this.mRealSettingView.getTop());
                float v0 = ((float) xxSettingView.this.mRealSettingView.getBottom());
                float v1 = ((float) xxSettingView.this.mRealSettingView.getRight());
                switch (event.getAction()) {
                    case 0: {
                        if (v4 >= v2 && v4 <= v1 && v5 >= v3) {
                            if (v5 > v0) {
                            } else {
                                return false;
                            }
                        }

                        xxSettingView.this.setVisibility(View.GONE);
                        XXPluginParentView.closePluginBackToSmallFloatView();
                        break;
                    }
                }

                return false;
            }
        });
    }
}
