package com.xx.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.xxassitant.assist.R;
import com.xx.XXPlugin;
import com.xxAssistant.UI.Configs.Config;

public class XXPluginInputDialogView extends XXPluginBaseView {
    protected static final String TAG = "XXPluginInputDialogView";
    private int defaultNum;
    private String hintStr;
    private Context mContext;
    private LinearLayout mDialogView;
    private EditText mEditText;
    private IXXPluginDialogClickListener mListener;
    private Resources mRes;
    private int maxNum;
    private int minNum;
    private String title;

    public XXPluginInputDialogView(Context context, Resources res, String title, String hintStr, int defaultNum, int minNum, int maxNum, IXXPluginDialogClickListener listener) {
        super(context);
        this.mRes = res;
        this.mContext = context;
        this.title = title;
        this.hintStr = hintStr;
        this.defaultNum = defaultNum;
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.mListener = listener;
        LayoutInflater.from(context).inflate(res.getLayout(R.layout.xx_plugin_dialog_input), ((ViewGroup)this));
        this.initViews();
        this.setClickable(true);
    }

    private boolean closeInput(View anchor) {
    	InputMethodManager im = ((InputMethodManager)this.mContext.getSystemService("input_method"));
        return im.hideSoftInputFromWindow(anchor.getWindowToken(), 0);
    }

    private void initViews() {
        this.mDialogView = (LinearLayout) this.findViewWithTag("dialog_input_view");
        this.mDialogView.setBackgroundDrawable(this.mRes.getDrawable(R.drawable.bg_dialog));
        View v2 = this.findViewWithTag("dialog_title_textview");
        if(this.title != null) {
            ((TextView)v2).setText(this.title);
        }

        this.mEditText = (EditText) this.findViewWithTag("dialog_input");
        this.mEditText.setBackgroundDrawable(this.mRes.getDrawable(R.drawable.input_box));
        this.mEditText.setInputType(2);
        this.mEditText.setText("");
        if(this.hintStr != null) {
            this.mEditText.setHint(this.hintStr);
        }

        if(this.defaultNum != 0) {
            this.mEditText.setText("" + this.defaultNum);
        }

        this.setEditTextChangeListener();
        View v0 = this.findViewWithTag("dialog_left_button");
        ((Button)v0).setBackgroundDrawable(this.mRes.getDrawable(R.drawable.bg_left_button_selector));
        ((Button)v0).setText(Config.xxOk[Config.XXLANGUAGE_NOW]);
        ((Button)v0).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                XXPluginInputDialogView.this.closeInput(XXPluginInputDialogView.this.mEditText);
                if(XXPluginInputDialogView.this.mListener != null) {
                    XXPluginInputDialogView.this.mListener.onClickDialog(Integer.valueOf(XXPluginInputDialogView.this.mEditText.getText().toString()).intValue());
                }

                XXPlugin.getInstance().getViewController().closeInputDialog();
            }
        });
        View v1 = this.findViewWithTag("dialog_right_button");
        ((Button)v1).setBackgroundDrawable(this.mRes.getDrawable(R.drawable.bg_right_button_selector));
        ((Button)v1).setText(Config.xxCancel[Config.XXLANGUAGE_NOW]);
        ((Button)v1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                XXPluginInputDialogView.this.closeInput(XXPluginInputDialogView.this.mEditText);
                XXPlugin.getInstance().getViewController().closeInputDialog();
            }
        });
    }

    private void setEditTextChangeListener() {
        this.mEditText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if(s != null && s.toString() != null && s.toString().length() >= 1) {
                    int v0 = Integer.parseInt(s.toString());
                    if(v0 > XXPluginInputDialogView.this.maxNum) {
                        XXPluginInputDialogView.this.mEditText.setText(XXPluginInputDialogView.this.maxNum + "");
                    }

                    if(v0 >= XXPluginInputDialogView.this.minNum) {
                        return;
                    }

                    XXPluginInputDialogView.this.mEditText.setText(XXPluginInputDialogView.this.minNum + "");
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }
}

