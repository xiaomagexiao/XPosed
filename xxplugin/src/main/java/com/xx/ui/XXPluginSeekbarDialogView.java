package com.xx.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.com.xxassitant.assist.R;
import com.xx.XXPlugin;
import com.xxAssistant.UI.Configs.Config;

public class XXPluginSeekbarDialogView extends RelativeLayout {
    protected static final String TAG = "XXPluginSeekbarDialogView";
    private Context mContext;
    private int mDefaultNum;
    private LinearLayout mDialogView;
    private Button mLeftBtn;
    private IXXPluginDialogClickListener mListener;
    private int mMaxValue;
    private int mMinValue;
    private Resources mRes;
    private Button mRightBtn;
    private SeekBar mSeekBar;
    private TextView mSeekBarTextView;
    private String mTitle;

    public XXPluginSeekbarDialogView(Context context, Resources res, String title, int defaultNum, int minValue, int maxValue, IXXPluginDialogClickListener listener) {
        super(context);
        this.mRes = res;
        this.mContext = context;
        this.mListener = listener;
        this.mTitle = title;
        this.mDefaultNum = defaultNum;
        this.mMaxValue = maxValue;
        this.mMinValue = minValue;
        LayoutInflater.from(context).inflate(res.getLayout(R.layout.xx_plugin_dialog_seekbar), ((ViewGroup)this));
        this.initViews();
        this.setClickable(true);
    }

    private void initViews() {
        View v0 = this.findViewWithTag("dialog_title_textview");
        if(this.mTitle != null) {
            ((TextView)v0).setText(this.mTitle);
        }

        this.mDialogView = (LinearLayout) this.findViewWithTag("dialog_seekbar_view");
        this.mDialogView.setBackgroundDrawable(this.mRes.getDrawable(R.drawable.bg_dialog));
        this.mSeekBarTextView = (TextView) this.findViewWithTag("dialog_seekbar_text");
        this.mSeekBarTextView.setText("" + this.mDefaultNum);
        this.mSeekBar = (SeekBar) this.findViewWithTag("dialog_seekbar");
        this.mSeekBar.setThumb(this.mRes.getDrawable(R.drawable.seek_thumb));
        this.mSeekBar.setProgressDrawable(this.mRes.getDrawable(R.drawable.bg_seekbar));
        this.mSeekBar = (SeekBar) this.findViewWithTag("dialog_seekbar");
        this.mSeekBar.setMax(this.mMaxValue - this.mMinValue);
        this.mSeekBar.setProgress(this.mDefaultNum - this.mMinValue);
        this.mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                XXPluginSeekbarDialogView.this.mSeekBarTextView.setText(XXPluginSeekbarDialogView.this.mMinValue + progress + "");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.mLeftBtn = (Button) this.findViewWithTag("dialog_left_button");
        this.mLeftBtn.setBackgroundDrawable(this.mRes.getDrawable(R.drawable.bg_left_button_selector));
        this.mRightBtn = (Button) this.findViewWithTag("dialog_right_button");
        this.mRightBtn.setBackgroundDrawable(this.mRes.getDrawable(R.drawable.bg_right_button_selector));
        this.mLeftBtn.setText(Config.xxOk[Config.XXLANGUAGE_NOW]);
        this.mRightBtn.setText(Config.xxCancel[Config.XXLANGUAGE_NOW]);
        this.mLeftBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(XXPluginSeekbarDialogView.this.mListener != null) {
                    XXPluginSeekbarDialogView.this.mListener.onClickDialog(Integer.valueOf(XXPluginSeekbarDialogView.this.mSeekBarTextView.getText().toString()).intValue());
                }

                XXPlugin.getInstance().getViewController().closeSeekbarDialog();
            }
        });
        this.mRightBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                XXPlugin.getInstance().getViewController().closeSeekbarDialog();
            }
        });
    }
}

