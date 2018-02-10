package com.ucpro.feature.webwindow;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.a.b;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class w extends ViewGroup {
    f a = new f(getContext());
    private boolean b = true;
    private int c = a.c((int) R.dimen.home_indicator_iconsize);
    private int d;
    private int e = a.c((int) R.dimen.home_indicator_max_drag_dist);

    public w(Context context) {
        super(context);
        addView(this.a);
        a();
    }

    public final void a() {
        f fVar = this.a;
        fVar.a.setBackgroundDrawable(a.a("back_home_bg_ready.svg"));
        fVar = this.a;
        fVar.b.setBackgroundDrawable(a.a("back_home_bg.svg"));
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.b) {
            int width = (getWidth() - this.a.getMeasuredWidth()) / 2;
            int height = this.d == 0 ? getHeight() : this.d;
            this.a.layout(width, height, this.a.getMeasuredWidth() + width, this.a.getMeasuredHeight() + height);
            this.b = false;
            if (this.d == 0) {
                setBottomClipY(getHeight());
            }
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.a.measure(MeasureSpec.makeMeasureSpec(this.c, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.c, UCCore.VERIFY_POLICY_QUICK));
    }

    public final void setDragDist(int i) {
        this.a.setTranslationY((float) Math.min(0, Math.max(-this.e, i)));
        f fVar;
        int i2;
        if (b()) {
            fVar = this.a;
            if (fVar.a.getAlpha() != IPictureView.DEFAULT_MIN_SCALE) {
                if (fVar.c == null || !fVar.c.isRunning()) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (i2 == 0) {
                    if (fVar.d != null && fVar.d.isRunning()) {
                        fVar.d.cancel();
                    }
                    if (fVar.c == null) {
                        fVar.c = ObjectAnimator.ofFloat(fVar.a, "alpha", new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
                        fVar.c.setInterpolator(new b());
                    }
                    fVar.c.setFloatValues(new float[]{fVar.a.getAlpha(), IPictureView.DEFAULT_MIN_SCALE});
                    fVar.c.setDuration(350);
                    fVar.c.start();
                    return;
                }
                return;
            }
            return;
        }
        fVar = this.a;
        if (fVar.a.getAlpha() != 0.0f) {
            if (fVar.d == null || !fVar.d.isRunning()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 == 0) {
                if (fVar.c != null && fVar.c.isRunning()) {
                    fVar.c.cancel();
                }
                if (fVar.d == null) {
                    fVar.d = ObjectAnimator.ofFloat(fVar.a, "alpha", new float[]{IPictureView.DEFAULT_MIN_SCALE, 0.0f});
                    fVar.d.setInterpolator(new b());
                }
                fVar.d.setFloatValues(new float[]{fVar.a.getAlpha(), 0.0f});
                fVar.d.setDuration(350);
                fVar.d.start();
            }
        }
    }

    public final boolean b() {
        return this.a.getTranslationY() == ((float) (-this.e));
    }

    protected final void dispatchDraw(Canvas canvas) {
        canvas.save();
        if (this.d != 0) {
            canvas.clipRect(0, 0, getWidth(), this.d);
        }
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public final void setBottomClipY(int i) {
        this.d = i;
        this.a.offsetTopAndBottom(this.d - this.a.getTop());
        invalidate();
    }
}
