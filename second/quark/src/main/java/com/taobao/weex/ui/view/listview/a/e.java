package com.taobao.weex.ui.view.listview.a;

import android.graphics.Canvas;
import android.mini.support.v7.widget.RecyclerView;
import android.mini.support.v7.widget.RecyclerView.State;
import android.mini.support.v7.widget.at;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class e extends at {
    boolean a = true;
    float b = -1.0f;
    int c = 0;
    int d = 0;
    int e = 0;
    float f = 0.0f;
    float g = 0.0f;

    public e(boolean z, float f, int i, int i2, int i3, float f2, float f3) {
        this.a = z;
        this.b = f;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = f2;
        this.g = f3;
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, State state) {
        super.a(canvas, recyclerView, state);
        int width = recyclerView.getWidth();
        int height = recyclerView.getHeight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            int height2;
            int i2;
            int i3;
            View childAt = recyclerView.getChildAt(i);
            if (this.a) {
                height2 = childAt.getHeight();
                i2 = height2;
                height2 = childAt.getTop() + (height2 / 2);
                i3 = height;
            } else {
                height2 = childAt.getWidth();
                i2 = height2;
                height2 = childAt.getLeft() + (height2 / 2);
                i3 = width;
            }
            float min = Math.min(IPictureView.DEFAULT_MIN_SCALE, Math.max(-1.0f, ((float) (height2 - (i3 / 2))) * (IPictureView.DEFAULT_MIN_SCALE / ((float) ((i2 + i3) / 2)))));
            if (this.b > 0.0f) {
                childAt.setAlpha(IPictureView.DEFAULT_MIN_SCALE - (this.b * Math.abs(min)));
            }
            if (this.f > 0.0f || this.g > 0.0f) {
                childAt.setScaleX(IPictureView.DEFAULT_MIN_SCALE - (this.f * Math.abs(min)));
                childAt.setScaleY(IPictureView.DEFAULT_MIN_SCALE - (this.g * Math.abs(min)));
            }
            if (this.e != 0) {
                childAt.setRotation(((float) this.e) * min);
            }
            if (this.c != 0) {
                childAt.setTranslationX(((float) this.c) * Math.abs(min));
            }
            if (this.d != 0) {
                childAt.setTranslationY(Math.abs(min) * ((float) this.d));
            }
        }
    }
}
