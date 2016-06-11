package com.xxAssistant.UI.Factory;


import android.graphics.drawable.GradientDrawable;

public class ShapeBg extends GradientDrawable {
    private float mdp;

    public ShapeBg(float dp) {
        super();
        this.mdp = dp;
        this.setShape(0);
    }

    public void setCornerRadii(float[] radii) {
        int v1 = radii.length;
        if(v1 >= 4) {
            float[] v2 = new float[8];
            int v0;
            for(v0 = 0; v0 < v1 << 1; ++v0) {
                v2[v0] = radii[v0 >> 1] * this.mdp;
            }

            super.setCornerRadii(v2);
        }
    }

    public void setCornerRadius(float radius) {
        super.setCornerRadius(this.mdp * radius);
    }

    public void setStroke(int width, int color) {
        super.setStroke(((int)((((float)width)) * this.mdp)), color);
    }
}

