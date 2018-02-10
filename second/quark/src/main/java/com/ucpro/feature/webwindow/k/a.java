package com.ucpro.feature.webwindow.k;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class a extends FrameLayout {
    public static final int a = com.ucpro.ui.c.a.c((int) R.dimen.webpage_pull_refresh_max_height);
    public ValueAnimator b = null;
    public ValueAnimator c = null;
    public Interpolator d = new LinearInterpolator();
    private ImageView e = null;
    private d f = null;
    private float g = 0.0f;

    public a(Context context) {
        super(context);
        int c = com.ucpro.ui.c.a.c((int) R.dimen.webpage_pull_refresh_loading_padding);
        setPadding(c, c, c, c);
        this.e = new ImageView(getContext());
        addView(this.e, new LayoutParams(-1, -1));
        this.f = new d(this, getContext());
        addView(this.f, new LayoutParams(-1, -1));
        a();
    }

    public final void a() {
        setBackgroundDrawable(com.ucpro.ui.c.a.a("pull_refresh_loading_bg.png"));
        this.e.setImageDrawable(com.ucpro.ui.c.a.a("pull_refresh_loading.png"));
        this.f.a.setColor(com.ucpro.ui.c.a.c("pull_refresh_loading_color"));
    }

    public final void a(float f, boolean z) {
        float f2 = IPictureView.DEFAULT_MIN_SCALE;
        float f3 = f / ((float) a);
        if (f3 > IPictureView.DEFAULT_MIN_SCALE) {
            f3 = IPictureView.DEFAULT_MIN_SCALE;
        }
        float f4 = ((float) a) * f3;
        float f5 = 360.0f * f3;
        f3 = (f3 * 1.5f) + 0.5f;
        if (f3 <= IPictureView.DEFAULT_MIN_SCALE) {
            f2 = f3;
        }
        setTranslationY(f4);
        setAlpha(f2);
        if (z) {
            this.e.setRotation(f5);
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            this.b.cancel();
        }
        if (this.c != null) {
            this.c.cancel();
        }
    }
}
