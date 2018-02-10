package com.ucpro.feature.z.h.a;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.z.a.c;
import com.ucpro.feature.z.b.a;
import com.ucpro.feature.z.c.d;
import com.ucpro.feature.z.d.g;
import com.ucpro.ui.widget.h;
import com.ucweb.common.util.f;

/* compiled from: ProGuard */
public abstract class i {
    protected View a = null;
    protected c b = null;
    protected h c = null;
    protected h d = null;
    protected a e = null;
    protected g f = null;
    protected com.ucpro.feature.z.e.g g = null;
    protected View h = null;
    protected d i = null;
    protected h j = null;
    protected h k = null;
    protected h l = null;
    protected int m = 0;
    protected int n = 0;
    protected int o = 0;
    protected int p = 0;
    protected int q = 0;
    int r = 3;
    int s = 0;
    long t = 100;
    public boolean u = false;
    Handler v = new b(this, Looper.getMainLooper());
    protected k w = null;
    protected Context x = null;
    protected j y = null;
    private ValueAnimator z = null;

    public abstract void a();

    public abstract void a(int i);

    public abstract void a(k kVar);

    public abstract void b(k kVar);

    public i(e eVar) {
        this.x = eVar.getContext();
        this.y = (j) eVar.getParent();
        b();
    }

    protected final void b() {
        this.a = this.y.getBgView();
        this.b = this.y.getSearchBar();
        this.c = this.y.getMirrorAddressBar();
        this.d = this.y.getMirrorInputView();
        this.e = this.y.getInputEnhanceView();
        this.f = this.y.getInputHistoryView();
        this.g = this.y.getAssociateView();
        this.h = this.y.getBarShadowView();
        this.j = this.y.getMirrorLogo();
        this.k = this.y.getMirrorNavigationView();
        this.l = this.y.getMirrorToolBar();
        this.i = this.y.getCopyTipView();
    }

    protected final void c() {
        this.u = false;
        this.s = 0;
        this.v.sendEmptyMessage(1);
    }

    protected final void d() {
        this.b.getUrlEditText().requestFocus();
        this.b.getUrlEditText().dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0));
        this.b.getUrlEditText().dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0));
        f.c(this.x);
        e();
    }

    protected void e() {
    }

    protected final void f() {
        f.a(this.x, this.y);
        this.b.getUrlEditText().clearFocus();
    }

    protected final void a(int i, boolean z) {
        float y = this.c.getVisibility() == 0 ? this.c.getY() : this.b.getY();
        float f = (float) i;
        if (this.z != null) {
            this.z.cancel();
        }
        this.z = ValueAnimator.ofFloat(new float[]{IPictureView.DEFAULT_MIN_SCALE, 0.0f});
        this.z.addUpdateListener(new f(this, f, y));
        this.z.addListener(new d(this, z, i));
        this.z.setDuration(250).start();
    }
}
