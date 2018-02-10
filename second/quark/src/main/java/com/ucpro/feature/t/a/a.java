package com.ucpro.feature.t.a;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.d.b;
import com.ucpro.feature.t.f;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class a extends c {
    private long K = 300;
    private int L;
    private int M;
    private int N;
    private int O;
    private d P = null;
    public View a;
    public float b = 0.0f;
    public float c = 0.0f;
    public float d = 0.0f;
    public float e = 0.0f;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i;
    public int j;
    public float k = 0.0f;
    public float l = IPictureView.DEFAULT_MIN_SCALE;

    public a(Context context) {
        super(context);
    }

    protected final void a() {
        super.a();
        this.L = com.ucpro.ui.c.a.c((int) R.dimen.mutil_window_toolbar_height);
        this.M = com.ucpro.ui.c.a.c((int) R.dimen.mutil_window_offset_x);
        this.i = com.ucpro.ui.c.a.c((int) R.dimen.mutil_window_sign_margin_left);
        this.j = com.ucpro.ui.c.a.c((int) R.dimen.mutil_window_sign_margin_bottom);
    }

    protected final void b() {
        super.b();
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.a = new View(getContext());
        addView(this.a);
    }

    public final void c() {
        super.c();
        this.a.setBackgroundDrawable(com.ucpro.ui.c.a.a("multiwindow_current_sign.svg"));
    }

    public final void setPresenter(b bVar) {
        c.b(bVar instanceof d);
        this.P = (d) bVar;
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
        d();
        if (this.a != null) {
            this.a.measure(MeasureSpec.makeMeasureSpec(com.ucpro.ui.c.a.c((int) R.dimen.mutil_window_sign_width), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(com.ucpro.ui.c.a.c((int) R.dimen.mutil_window_sign_width), UCCore.VERIFY_POLICY_QUICK));
        }
    }

    protected final void d() {
        if (this.p != null) {
            this.p.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.h, UCCore.VERIFY_POLICY_QUICK));
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        e();
        if (this.a != null && this.a.getVisibility() != 8 && this.N != 0 && this.O != 0) {
            int i5 = this.N;
            int measuredWidth = this.a.getMeasuredWidth() + i5;
            int i6 = this.O;
            this.a.layout(i5, i6, measuredWidth, this.a.getMeasuredHeight() + i6);
        }
    }

    protected final void e() {
        if (this.p != null && this.p.getVisibility() == 0) {
            this.p.layout(0, 0, this.p.getMeasuredWidth() + 0, this.p.getMeasuredHeight() + 0);
        }
    }

    public final void setAnimEndScale(float f) {
        this.c = f;
    }

    public final void setAnimStartScale(float f) {
        this.b = f;
    }

    public final void setAnimEndY(float f) {
        this.d = f;
    }

    public final void setAnimEndX(float f) {
        this.e = f;
    }

    public final void a(int i, int i2, f fVar, boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
        ofFloat.addUpdateListener(new f(this, z, i2, i));
        ofFloat.addListener(new g(this, fVar));
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(this.K);
        ofFloat.start();
    }

    public final void a(boolean z, int[] iArr) {
        if (z) {
            this.N = iArr[0];
            this.O = iArr[1];
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
        requestLayout();
    }
}
