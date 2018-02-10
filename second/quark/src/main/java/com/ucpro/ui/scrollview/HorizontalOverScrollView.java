package com.ucpro.ui.scrollview;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.HorizontalScrollView;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public class HorizontalOverScrollView extends HorizontalScrollView {
    private TimeInterpolator a;
    private int b;
    private int c;
    private long d;

    public HorizontalOverScrollView(Context context) {
        super(context);
        a();
    }

    public HorizontalOverScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public HorizontalOverScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.b = getContext().getResources().getDisplayMetrics().widthPixels / 3;
        this.c = getContext().getResources().getInteger(17694721);
        this.a = new DecelerateInterpolator();
    }

    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        int i9 = this.b;
        if (z) {
            this.d = AnimationUtils.currentAnimationTimeMillis();
        } else {
            float interpolation = this.a.getInterpolation(((float) (AnimationUtils.currentAnimationTimeMillis() - this.d)) / ((float) this.c));
            if (interpolation > IPictureView.DEFAULT_MIN_SCALE) {
                interpolation = IPictureView.DEFAULT_MIN_SCALE;
            }
            int i10 = (int) (((float) i9) - (interpolation * ((float) i9)));
            if (i10 < 0) {
                i10 = 0;
            }
            i9 = i10;
        }
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i9, i8, z);
    }
}
