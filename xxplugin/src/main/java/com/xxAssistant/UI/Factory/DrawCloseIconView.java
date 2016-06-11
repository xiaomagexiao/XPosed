package com.xxAssistant.UI.Factory;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.LinearLayout;

public class DrawCloseIconView extends LinearLayout {
    private final Context context;
    private float mDp;
    private int mHeight;
    private int mWidght;
    private final Paint paint;

    public DrawCloseIconView(Context context, float mDp, int widght, int height) {
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
        int v8 = ((int)(12f * this.mDp));
        int v9 = ((int)(this.mDp * 2f));
        this.paint.setARGB(255, 200, 193, 200);
        this.paint.setStrokeWidth(2f);
        canvas.drawCircle(((float)v6), ((float)v7), ((float)v8), this.paint);
        this.paint.setARGB(255, 200, 193, 200);
        this.paint.setStrokeWidth(((float)v9));
        canvas.drawCircle(((float)v6), ((float)v7), ((float)(v8 + 1 + v9 / 2)), this.paint);
        this.paint.setARGB(255, 200, 193, 200);
        this.paint.setStrokeWidth(2f);
        canvas.drawCircle(((float)v6), ((float)v7), ((float)(v8 + v9)), this.paint);
        v5.setARGB(255, 200, 193, 200);
        v5.setStrokeWidth(this.mDp * 2f);
        canvas.drawLine((((float)v6)) - this.mDp * 4f, (((float)v7)) - this.mDp * 4f, this.mDp * 4f + (((float)v6)), this.mDp * 4f + (((float)v7)), v5);
        canvas.drawLine(this.mDp * 4f + (((float)v6)), (((float)v7)) - this.mDp * 4f, (((float)v6)) - this.mDp * 4f, this.mDp * 4f + (((float)v7)), v5);
        super.onDraw(canvas);
    }
}

