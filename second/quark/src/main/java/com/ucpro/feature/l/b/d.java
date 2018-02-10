package com.ucpro.feature.l.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class d extends FrameLayout {
    private ImageView a;
    private int b;
    private int c;

    public d(Context context) {
        super(context);
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.a = new ImageView(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.a, layoutParams);
        this.a.setImageDrawable(a.a("discover_plugin_add.svg"));
        this.b = a.c("discover_page_plugin_btn_close_color");
        this.a.setColorFilter(this.b);
    }

    public final void setPlusImage(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    public final void setState(int i) {
        if (this.c != i) {
            this.c = i;
            if (this.c == 0) {
                this.a.setRotation(0.0f);
                this.a.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
                return;
            }
            this.a.setRotation(135.0f);
            this.a.setAlpha(0.5f);
        }
    }

    public final void a(int i) {
        int i2 = 0;
        float f = IPictureView.DEFAULT_MIN_SCALE;
        if (this.c != i) {
            float f2;
            int i3;
            this.c = i;
            if (this.c == 0) {
                f2 = 0.5f;
                i3 = 135;
            } else {
                f2 = IPictureView.DEFAULT_MIN_SCALE;
                i3 = 0;
                i2 = 135;
                f = 0.5f;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
            ofFloat.addUpdateListener(new n(this, i2, i3, f, f2));
            ofFloat.setDuration(300);
            ofFloat.start();
        }
    }
}
