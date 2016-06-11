package com.game.logic.window;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.net.TrafficStats;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;

import com.acker.speedshow.R;
import com.game.logic.params.Constants;
import com.game.ui.view.MainWindowView;
import com.game.ui.view.SmallWindowView;
import com.game.ui.view.WindowView;
import com.game.util.StartPlugin;
import com.xx.MainApplication;

import java.text.DecimalFormat;

public class MyWindowManager implements Constants {

    private WindowManager mWindowManager;
    private WindowView mSmallWindowView;
    private WindowView mMainWindowView;
    private View mSettingWindow;
    private LayoutParams windowParams;
    private static MyWindowManager instance;
    private long exitTime = 0;

    public static MyWindowManager getInstance() {
        if (instance == null) {
            instance = new MyWindowManager();
        }
        return instance;
    }

    public void createWindow(final Context context) {
        createWindow(context, SMALL_WINDOW_TYPE);
    }

    public void createWindow(final Context context, int type) {
        final WindowManager windowManager = getWindowManager(context);
        if (windowParams == null) {
            windowParams = getWindowParams(context);
        }
        switch (type) {
            case SMALL_WINDOW_TYPE:
                if (mSmallWindowView == null) {
                    mSmallWindowView = new SmallWindowView(context);
                    setOnTouchListener(windowManager, mSmallWindowView);
                    windowManager.addView(mSmallWindowView, windowParams);
                    mSmallWindowView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showMainContent(context);
                        }
                    });
                }
                break;
            case SETTING_WINDOW_TYPE:
                if (mSettingWindow == null) {
                    mSettingWindow = StartPlugin.getView();
                    setOnTouchListener(windowManager, mSettingWindow);
                    windowManager.addView(mSettingWindow, getSettingParams(MainApplication.getContext()));
                }
                break;
            default:
                break;
        }
    }

    private void showMainContent(Context context) {
        final WindowManager windowManager = getWindowManager(context);
        if (windowParams == null) {
            windowParams = getWindowParams(context);
        }
        mMainWindowView = new MainWindowView(context);
        windowManager.addView(mMainWindowView, windowParams);
    }

    private LayoutParams getWindowParams(Context context) {
        final WindowManager windowManager = getWindowManager(context);
        Point sizePoint = new Point();
        windowManager.getDefaultDisplay().getSize(sizePoint);
        int screenWidth = sizePoint.x;
        int screenHeight = sizePoint.y;
        LayoutParams windowParams = new WindowManager.LayoutParams();
        windowParams.type = LayoutParams.TYPE_PHONE;
        windowParams.format = PixelFormat.RGBA_8888;
        windowParams.flags = LayoutParams.FLAG_NOT_TOUCH_MODAL
                | LayoutParams.FLAG_NOT_FOCUSABLE;
        windowParams.gravity = Gravity.START | Gravity.TOP;
        windowParams.width = LayoutParams.WRAP_CONTENT;
        windowParams.height = LayoutParams.WRAP_CONTENT;
        windowParams.x = screenWidth;
        windowParams.y = screenHeight / 2;
        return windowParams;
    }

    private LayoutParams getSettingParams(Context context) {
        LayoutParams windowParams = new WindowManager.LayoutParams();
        windowParams.type = LayoutParams.TYPE_PHONE;
        windowParams.format = PixelFormat.RGBA_8888;
        windowParams.gravity = Gravity.CENTER;
        windowParams.width = LayoutParams.WRAP_CONTENT;
        windowParams.height = LayoutParams.WRAP_CONTENT;
        return windowParams;
    }

    private void setOnTouchListener(final WindowManager windowManager, final View windowView) {
        windowView.setOnTouchListener(new OnTouchListener() {
            int lastX, lastY;
            int paramX, paramY;
            boolean isDrag = false;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                        paramX = windowParams.x;
                        paramY = windowParams.y;
                        isDrag = false;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int dx = (int) event.getRawX() - lastX;
                        int dy = (int) event.getRawY() - lastY;
                        windowParams.x = paramX + dx;
                        windowParams.y = paramY + dy;
                        // 更新悬浮窗位置
                        windowManager.updateViewLayout(windowView, windowParams);
                        isDrag = true;
                        return true;
                    case MotionEvent.ACTION_UP:
                        if ((System.currentTimeMillis() - exitTime) < CHANGE_DELAY) {

                            return true;
                        } else {
                            exitTime = System.currentTimeMillis();
                            if (isDrag) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    default:
                        break;
                }
                return false;
            }
        });
    }

    private void removeWindow(Context context, WindowView windowView) {
        if (windowView != null) {
            WindowManager windowManager = getWindowManager(context);
            windowManager.removeView(windowView);
        }
    }

    public void removeAllWindow(Context context) {
        removeWindow(context, mSmallWindowView);
        mSmallWindowView = null;
    }

    public boolean isWindowShowing() {
        return mSmallWindowView != null;
    }

    private WindowManager getWindowManager(Context context) {
        if (mWindowManager == null) {
            mWindowManager = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
        }
        return mWindowManager;
    }
}
