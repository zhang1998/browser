package com.ucpro.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class RollingDots extends LinearLayout {
    private Context a;
    private List<ImageView> b;
    private int[] c;
    private List<Drawable> d;
    private Runnable e;
    private int f = 200;
    private int g = 0;
    private int h = 0;
    private long i = 0;
    private boolean j = false;

    static /* synthetic */ void a(RollingDots rollingDots) {
        if (rollingDots.j) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (rollingDots.h <= 0 || currentAnimationTimeMillis - rollingDots.i <= ((long) rollingDots.h)) {
                int size = rollingDots.b.size();
                for (int i = 0; i < size; i++) {
                    if (rollingDots.c[i] > 0) {
                        int[] iArr = rollingDots.c;
                        iArr[i] = iArr[i] - 1;
                    }
                }
                rollingDots.g = (rollingDots.g + 1) % size;
                rollingDots.c[rollingDots.g] = rollingDots.d.size() - 1;
                for (int i2 = 0; i2 < size; i2++) {
                    ((ImageView) rollingDots.b.get(i2)).setImageDrawable((Drawable) rollingDots.d.get(rollingDots.c[i2]));
                }
                rollingDots.postDelayed(rollingDots.e, (long) rollingDots.f);
            }
        }
    }

    public RollingDots(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        setGravity(17);
        setOrientation(0);
        this.b = new ArrayList();
        this.d = new ArrayList();
        this.e = new b(this);
        a(6);
    }

    private void a(int i) {
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        for (int i2 = 0; i2 < i; i2++) {
            View imageView = new ImageView(this.a);
            addView(imageView, layoutParams);
            this.b.add(imageView);
        }
    }

    public void setDotCout(int i) {
        if (i >= 2) {
            int size = this.b.size();
            if (i == size) {
                return;
            }
            if (i > size) {
                a(i - size);
                return;
            }
            for (size -= i; size > 0; size--) {
                this.b.remove(0);
                removeViewAt(0);
            }
        }
    }

    public void setFrameDuration(int i) {
        if (i > 0) {
            this.f = i;
        }
    }
}
