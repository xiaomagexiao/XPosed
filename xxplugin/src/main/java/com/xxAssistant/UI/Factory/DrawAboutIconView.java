package com.xxAssistant.UI.Factory;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.LinearLayout;

public class DrawAboutIconView extends LinearLayout {
    private final Context context;
    private float mDp;
    private int mHeight;
    private int mWidght;
    private final Paint paint;

    public DrawAboutIconView(Context context, float mDp, int widght, int height) {
        super(context);
        this.context = context;
        this.mDp = mDp;
        this.mWidght = widght;
        this.mHeight = height;
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setColor(-16777216);
        int v8 = ((int)(13f * this.mDp));
        int v9 = ((int)(this.mDp * 2f));
        int v6 = this.mWidght / 2;
        int v7 = this.mHeight / 2;
        this.paint.setARGB(255, 11, 96, 254);
        canvas.drawCircle(((float)v6), ((float)v7), ((float)(v8 + 1 + v9 / 2)), this.paint);
        this.paint.setARGB(255, 0, 0, 0);
        this.paint.setStrokeWidth(this.mDp * 2f);
        canvas.drawLine(((float)v6), (((float)v7)) - 6f * this.mDp, ((float)v6), this.mDp * 2f + (((float)v7)), this.paint);
        canvas.drawCircle(((float)v6), (((float)v7)) + 5f * this.mDp, 1f * this.mDp, this.paint);
        super.onDraw(canvas);
    }
}

