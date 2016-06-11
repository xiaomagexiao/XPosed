package com.game.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.acker.speedshow.R;
import com.game.logic.params.Constants;
import com.game.logic.window.MyWindowManager;
import com.game.ui.index.MainApplication;

public class MainWindowView extends WindowView implements View.OnClickListener {

    private RelativeLayout mRootView;
    private RelativeLayout rl_buttom;
    Button bt_hide;
    private Button bt_start;
    private Context mContext;

    public MainWindowView(Context context) {
        super(context);
        this.mContext = context;
        this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.float_window_main, this);
        this.bt_hide = (Button) mRootView.findViewById(R.id.bt_hide);
        this.rl_buttom = (RelativeLayout) mRootView.findViewById(R.id.rl_buttom);
        this.bt_hide.setOnClickListener(this);
        this.bt_start = (Button) mRootView.findViewById(R.id.bt_start);
        this.bt_start.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_hide:
                mRootView.setVisibility(View.GONE);
                break;
            case R.id.bt_start:
                Toast.makeText(mContext, "启动脚本", Toast.LENGTH_SHORT).show();
                MyWindowManager.getInstance().createWindow(MainApplication.getInstance(), Constants.SETTING_WINDOW_TYPE);
                break;
        }
    }
}
