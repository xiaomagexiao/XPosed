package com.xxAssistant.UI.Factory;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.LinearLayout;

public class DrawArrowIconView extends LinearLayout {
    private final Context context;
    private float mDp;
    private int mHeight;
    private int mWidght;
    private final Paint paint;

    public DrawArrowIconView(Context context, float mDp, int widght, int height) {
        super(context);
        this.context = context;
        this.mDp = mDp;
        this.mWidght = widght;
        this.mHeight = height;
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint v5 = new Paint();
        v5.setColor(-16777216);
        int v6 = this.mWidght / 2;
        int v7 = this.mHeight / 2;
        v5.setARGB(255, 200, 193, 200);
        v5.setStrokeWidth(2f * this.mDp);
        canvas.drawLine((((float)v6)) - this.mDp * 6f, (((float)v7)) - this.mDp * 6f, ((float)(v6 + 1)), ((float)(v7 + 1)), v5);
        canvas.drawLine(((float)(v6 + 1)), ((float)(v7 - 1)), (((float)v6)) - this.mDp * 6f, this.mDp * 6f + (((float)v7)), v5);
        super.onDraw(canvas);
    }
}

