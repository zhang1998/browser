package com.ucpro.feature.t;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.t.a.a;
import com.ucpro.feature.t.b.c;
import com.ucpro.feature.t.b.k;
import com.ucpro.feature.t.b.n;
import com.ucpro.feature.t.b.s;
import com.ucpro.feature.t.c.f;
import com.ucweb.common.util.m.b;

/* compiled from: ProGuard */
public final class l extends ViewGroup implements d, c {
    n a = null;
    f b = null;
    a c = null;
    View d = null;
    private HorizontalScrollView e = null;
    private boolean f = true;
    private f g = null;
    private boolean h = true;

    public l(Context context) {
        super(context);
        if (com.ucpro.ui.c.a.b()) {
            this.e = (HorizontalScrollView) LayoutInflater.from(getContext()).inflate(R.layout.multiwindow_scollerview_night, this, false);
        } else {
            this.e = (HorizontalScrollView) LayoutInflater.from(getContext()).inflate(R.layout.multiwindow_scollerview, this, false);
        }
        View view = this.e;
        Class cls = HorizontalScrollView.class;
        b.a(view, cls, "mEdgeGlowLeft");
        b.a(view, cls, "mEdgeGlowRight");
        addView(this.e);
        this.a = new n(getContext());
        this.a.setWheelViewCallback(this);
        this.d = new View(getContext());
        this.e.addView(new m(this, getContext(), this.a, this.d));
        this.c = new a(getContext());
        addView(this.c);
        this.b = new f(getContext());
        addView(this.b);
        c();
    }

    public final void c() {
        setBackgroundColor(com.ucpro.ui.c.a.c("default_background_dark"));
        this.d.setBackgroundDrawable(com.ucpro.ui.c.a.a("multiwindow_current_sign.svg"));
        this.c.c();
        n nVar = this.a;
        int childCount = nVar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = nVar.getChildAt(i);
            com.ucweb.common.util.c.b(childAt instanceof k);
            ((k) childAt).c();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.h) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.h) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b != null) {
            this.b.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (this.e != null) {
            this.e.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight() - this.b.getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.c != null) {
            this.c.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
            a aVar = this.c;
            int measuredHeight = this.a.getMeasuredHeight();
            if (aVar.f == 0) {
                aVar.f = aVar.getMeasuredHeight();
                aVar.g = a.a(com.ucpro.base.system.b.a.f(), measuredHeight, false)[1];
                aVar.h = aVar.f;
            }
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!(this.e == null || this.e.getVisibility() == 8)) {
            this.e.layout(0, 0, this.e.getMeasuredWidth() + 0, this.e.getMeasuredHeight() + 0);
        }
        if (!(this.b == null || this.b.getVisibility() == 8)) {
            int measuredWidth = this.b.getMeasuredWidth() + 0;
            int measuredHeight = getMeasuredHeight();
            this.b.layout(0, measuredHeight - this.b.getMeasuredHeight(), measuredWidth, measuredHeight);
        }
        if (!(this.c == null || this.c.getVisibility() == 8)) {
            this.c.layout(0, 0, this.c.getMeasuredWidth() + 0, this.c.getMeasuredHeight() + 0);
        }
        if (this.f) {
            n nVar = this.a;
            int childCount = nVar.getChildCount();
            for (measuredHeight = 0; measuredHeight < childCount; measuredHeight++) {
                k kVar = (k) nVar.getChildAt(measuredHeight);
                if (kVar.getWebShotBitmap() == null) {
                    nVar.a.add(kVar);
                }
            }
            nVar.a();
            if (this.a.getFirstCard() != null) {
                View webShotImageView = this.a.getFirstCard().getWebShotImageView();
                if (webShotImageView != null) {
                    this.c.setAnimEndScale(((float) webShotImageView.getMeasuredWidth()) / ((float) this.c.getMeasuredWidth()));
                    int[] iArr = new int[2];
                    webShotImageView.getLocationInWindow(iArr);
                    measuredWidth = iArr[0];
                    int i5 = iArr[1];
                    this.c.getLocationInWindow(iArr);
                    this.c.setAnimEndX((float) (measuredWidth - iArr[0]));
                    this.c.setAnimEndY((float) (i5 - iArr[1]));
                    a aVar = this.c;
                    f fVar = this.g;
                    aVar.J = aVar.getY();
                    aVar.I = aVar.getX();
                    aVar.b = IPictureView.DEFAULT_MIN_SCALE;
                    i5 = (int) (((float) aVar.g) / aVar.c);
                    aVar.k = 0.0f;
                    aVar.l = IPictureView.DEFAULT_MIN_SCALE;
                    aVar.a(true, new int[]{(int) (aVar.e + ((float) aVar.i)), (int) (((aVar.d + ((float) aVar.g)) - ((float) aVar.j)) - ((float) aVar.a.getMeasuredHeight()))});
                    aVar.a(aVar.f, i5, fVar, false);
                }
            }
            f fVar2 = this.b;
            fVar2.setAlpha(0.0f);
            fVar2.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(fVar2.a);
            this.f = false;
        }
    }

    public final s getWheelView() {
        return this.a;
    }

    public final f getToolbar() {
        return this.b;
    }

    public final void setCanTouch(boolean z) {
        this.h = z;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 1) {
            return true;
        }
        g.a().b(e.C, 2);
        return true;
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("8995241");
    }

    public final String getPageName() {
        return "Page_multiwindow";
    }

    public final com.ucpro.feature.t.a.c getAnimCard() {
        return this.c;
    }

    public final void setEnterAnimCallback(f fVar) {
        this.g = fVar;
    }

    public final void a() {
        getToolbar().b();
    }

    public final void a(float f) {
        if (this.d != null) {
            this.d.setTranslationY(f);
        }
    }

    public final void b() {
        if (this.d == null) {
            return;
        }
        if (this.a.getChildCount() > 0) {
            this.d.animate().translationY(0.0f).setDuration(300).start();
        } else {
            this.d.setVisibility(8);
        }
    }
}
