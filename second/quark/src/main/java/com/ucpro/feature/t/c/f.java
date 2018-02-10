package com.ucpro.feature.t.c;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.d.b;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class f extends ViewGroup implements l {
    public long a;
    private g b;
    private h c;
    private j d;

    static /* synthetic */ void c(f fVar) {
        h hVar = fVar.c;
        if (hVar.a == null) {
            return;
        }
        if (hVar.a.b.a) {
            hVar.a.c();
            return;
        }
        d dVar = hVar.a.b;
        if (dVar.e != null) {
            dVar.e.cancel();
        }
        dVar.e = ValueAnimator.ofInt(new int[]{dVar.d, dVar.c});
        dVar.e.addUpdateListener(new c(dVar));
        dVar.e.setDuration(300);
        dVar.e.start();
        dVar.a = true;
    }

    public f(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.a = 300;
        this.d = new i(this);
        this.c = new h(getContext());
        this.c.setListener(this.d);
        addView(this.c);
        this.c.setBackgroundColor(a.c("default_background_dark"));
        this.c.a();
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.c != null) {
            this.c.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.mutil_window_toolbar_height), UCCore.VERIFY_POLICY_QUICK));
        }
        setMeasuredDimension(getMeasuredWidth(), this.c.getMeasuredHeight());
    }

    public final void setPresenter(b bVar) {
        c.b(bVar instanceof g);
        this.b = (g) bVar;
    }

    public final void a() {
        setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        animate().alpha(0.0f).setDuration(this.a);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final void b() {
        h hVar = this.c;
        if (hVar.a != null && hVar.a.b.a) {
            hVar.a.c();
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.c != null && this.c.getVisibility() != 8) {
            int measuredWidth = this.c.getMeasuredWidth() + 0;
            int measuredHeight = getMeasuredHeight();
            this.c.layout(0, measuredHeight - this.c.getMeasuredHeight(), measuredWidth, measuredHeight);
        }
    }
}
