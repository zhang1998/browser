package com.ucpro.feature.webwindow;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.j.b.e;
import com.ucpro.feature.webwindow.e.f;
import com.ucpro.feature.webwindow.h.h;
import com.ucpro.feature.webwindow.k.a;
import com.ucpro.feature.webwindow.k.c;
import com.ucpro.feature.webwindow.k.g;
import com.ucpro.ui.widget.b.b;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class ab extends ViewGroup implements d, n, b {
    private int A;
    private boolean B;
    private boolean C;
    private boolean D = true;
    private boolean E = true;
    private boolean F = false;
    h a;
    View b = null;
    ValueAnimator c;
    ValueAnimator d;
    int e;
    int f = 0;
    int g;
    int h;
    boolean i;
    boolean j = true;
    a k;
    bg l;
    com.ucpro.ui.a.a m;
    e n;
    private af o;
    private f p;
    private ValueAnimator q;
    private ValueAnimator r;
    private ArrayList<View> s;
    private int t;
    private int u;
    private int v = 0;
    private int w = 1;
    private int x = -1;
    private int y;
    private int z;

    public ab(Context context) {
        super(context);
        this.A = ViewConfiguration.get(context).getScaledTouchSlop();
        this.l = new bg(getContext(), this);
        this.l.i = this;
    }

    public final void setGestureManager(af afVar) {
        this.o = afVar;
    }

    public final void setWebView(f fVar) {
        this.p = fVar;
        addView(this.p, 0);
        this.k = new a(getContext());
        addView(this.k);
    }

    public final f getWebView() {
        return this.p;
    }

    public final View getAddressBar() {
        return this.a;
    }

    public final View getBarShadowView() {
        return this.b;
    }

    public final void a(View view) {
        getLayerViews().add(view);
        addView(view);
    }

    private ArrayList<View> getLayerViews() {
        if (this.s == null) {
            this.s = new ArrayList();
        }
        return this.s;
    }

    private int getAddressBarMinHeight() {
        return this.e;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        a(i);
        if (this.a != null) {
            this.a.measure(i, MeasureSpec.makeMeasureSpec(getAddressBarHeight(), UCCore.VERIFY_POLICY_QUICK));
            this.a.setParentHeight(getMeasuredHeight());
        }
        if (this.s != null) {
            Iterator it = this.s.iterator();
            while (it.hasNext()) {
                ((View) it.next()).measure(i, i2);
            }
        }
        if (this.b != null) {
            this.b.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.g, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.k != null) {
            int c = com.ucpro.ui.c.a.c((int) R.dimen.webpage_pull_refresh_loading_width);
            this.k.measure(MeasureSpec.makeMeasureSpec(c, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(c, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.m != null) {
            this.m.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.n != null) {
            this.n.measure(i, i2);
        }
    }

    private void a(int i) {
        if (this.p != null) {
            int measuredHeight;
            if (this.B) {
                measuredHeight = getMeasuredHeight();
            } else if (getWebViewState() == 0) {
                measuredHeight = getMeasuredHeight() - getAddressBarMinHeight();
            } else {
                measuredHeight = getMeasuredHeight() - getAddressBarHeight();
            }
            this.p.measure(i, MeasureSpec.makeMeasureSpec(measuredHeight, UCCore.VERIFY_POLICY_QUICK));
        }
    }

    private int getAddressBarHeight() {
        if (this.a == null || this.a.getLayoutParams() == null) {
            return 0;
        }
        return this.a.getLayoutParams().height;
    }

    public final void setEnableScroll(boolean z) {
        this.j = z;
    }

    public final void setEnableSourceDelegateDispatchTouchEvent(boolean z) {
        this.D = z;
    }

    private void setAddressBarOffsetY(int i) {
        int i2 = this.u;
        this.u = i;
        if (this.u != i2 && getHeight() > 0 && this.a != null) {
            i2 = ((getHeight() - getAddressBarHeight()) + this.u) - this.a.getTop();
            float addressBarHeight = ((float) this.u) / ((float) (getAddressBarHeight() - getAddressBarMinHeight()));
            this.a.offsetTopAndBottom(i2);
            this.a.setShrinkProgress(addressBarHeight);
            if (this.b != null) {
                this.b.offsetTopAndBottom(i2);
            }
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.a != null) {
            int height = getHeight() - getAddressBarHeight();
            this.a.layout(0, height, getWidth(), getHeight());
            this.a.offsetTopAndBottom(((getHeight() - getAddressBarHeight()) + this.u) - this.a.getTop());
        }
        g();
        if (this.s != null) {
            Iterator it = this.s.iterator();
            while (it.hasNext()) {
                ((View) it.next()).layout(0, 0, getWidth(), getHeight());
            }
        }
        if (this.b != null && this.b.getVisibility() == 0) {
            int measuredWidth = this.b.getMeasuredWidth() + 0;
            height = this.a.getTop();
            this.b.layout(0, height - this.b.getMeasuredHeight(), measuredWidth, height);
        }
        if (this.k != null && this.k.getVisibility() == 0) {
            measuredWidth = (getMeasuredWidth() - this.k.getMeasuredWidth()) / 2;
            int i5 = -this.k.getMeasuredHeight();
            this.k.layout(measuredWidth, i5, this.k.getMeasuredWidth() + measuredWidth, this.k.getMeasuredHeight() + i5);
        }
        if (this.m != null) {
            this.m.layout(0, 0, this.m.getMeasuredWidth(), this.m.getMeasuredHeight());
        }
        if (this.n != null) {
            measuredWidth = getMeasuredWidth();
            i5 = (getMeasuredHeight() - this.n.getMeasuredHeight()) / 2;
            this.n.layout(measuredWidth - this.n.getMeasuredWidth(), i5, measuredWidth, this.n.getMeasuredHeight() + i5);
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (this.F || this.l == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        bg bgVar = this.l;
        switch (motionEvent.getAction()) {
            case 0:
                bgVar.d = false;
                bgVar.b = false;
                if (bgVar.h.getWebView().getPageScrollY() != 0) {
                    z = false;
                }
                bgVar.a = z;
                bgVar.c = -1;
                bgVar.e = Math.round(motionEvent.getX());
                bgVar.f = Math.round(motionEvent.getY());
                break;
            case 1:
            case 3:
            case 4:
                bgVar.a = false;
                bgVar.b = false;
                bgVar.c = -1;
                bgVar.d = false;
                break;
            case 2:
                if (bgVar.d) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    x -= (float) bgVar.e;
                    float f = y - ((float) bgVar.f);
                    if (bgVar.a && f > 0.0f && !bgVar.b && Math.abs(f) > ((float) bgVar.g) && Math.abs(f) > Math.abs(x) * 2.0f) {
                        bgVar.c = Math.round(y);
                        bgVar.b = true;
                        break;
                    }
                }
                break;
        }
        return bgVar.b;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.F || this.l == null) {
            return super.onTouchEvent(motionEvent);
        }
        bg bgVar = this.l;
        motionEvent.getX();
        float y = motionEvent.getY();
        float f = y - ((float) bgVar.f);
        switch (motionEvent.getAction()) {
            case 0:
                boolean z2 = bgVar.h.getAddressBar() == null || motionEvent.getY() <= ((float) bgVar.h.getAddressBar().getTop());
                bgVar.d = z2;
                bgVar.b = false;
                if (bgVar.h.getWebView().getPageScrollY() == 0) {
                    z = true;
                }
                bgVar.a = z;
                bgVar.c = -1;
                bgVar.e = Math.round(motionEvent.getX());
                bgVar.f = Math.round(motionEvent.getY());
                return true;
            case 1:
            case 3:
            case 4:
                if (bgVar.i != null && bgVar.b && bgVar.d) {
                    bgVar.i.b(y - ((float) bgVar.c));
                }
                bgVar.a = false;
                bgVar.b = false;
                bgVar.c = -1;
                bgVar.d = false;
                return true;
            case 2:
                if (!bgVar.d || f <= 0.0f || !bgVar.a || !bgVar.b || bgVar.i == null) {
                    return true;
                }
                bgVar.i.a(y - ((float) bgVar.c));
                return true;
            default:
                return true;
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        switch (motionEvent.getAction()) {
            case 0:
                if (getAddressBar() != null && motionEvent.getY() > ((float) getAddressBar().getTop())) {
                    z = false;
                }
                this.i = z;
                this.h = -1;
                this.t = -1;
                this.y = Math.round(motionEvent.getX());
                this.z = Math.round(motionEvent.getY());
                this.C = false;
                break;
            case 1:
            case 3:
            case 4:
                this.t = -1;
                this.C = false;
                this.i = false;
                break;
            case 2:
                if (this.i) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    x -= (float) this.y;
                    float f = y - ((float) this.z);
                    if (!this.C && Math.abs(f) > ((float) this.A) && Math.abs(f) > Math.abs(x) * 2.0f) {
                        this.t = Math.round(y);
                        this.C = true;
                    }
                    if (this.C) {
                        int round = Math.round(y);
                        if (this.t != -1 && this.j && this.E) {
                            int i = round - this.t;
                            if (i >= (-getScrollThresholdForChangeAddressBar())) {
                                if (i > getScrollThresholdForChangeAddressBar() && this.f != 0) {
                                    d();
                                    this.t = round;
                                    break;
                                }
                            }
                            e();
                            this.t = round;
                            break;
                        }
                    }
                }
                break;
        }
        z = super.dispatchTouchEvent(motionEvent);
        if (this.D) {
            this.o.a(motionEvent);
        }
        return z;
    }

    public final void b() {
        this.t = -1;
        this.h = -1;
        a();
    }

    private void g() {
        if (this.p != null) {
            int height;
            int width = getWidth();
            if (this.B) {
                height = getHeight();
            } else if (getWebViewState() == 0) {
                height = getHeight() - getAddressBarMinHeight();
            } else {
                height = getHeight() - getAddressBarHeight();
            }
            this.p.layout(0, 0, width, height);
        }
    }

    public final void setWebViewFillParent(boolean z) {
        this.B = z;
        if (this.p != null) {
            this.p.requestLayout();
        }
        if (this.a == null) {
            return;
        }
        if (z) {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
            return;
        }
        this.a.setVisibility(0);
        this.b.setVisibility(0);
    }

    private void setAddressState(int i) {
        this.v = i;
    }

    public final void d() {
        if (getAddressBarState() == 0) {
            return;
        }
        if (this.l == null || !this.l.b) {
            setAddressState(0);
            if (this.q != null && this.q.isRunning()) {
                this.q.cancel();
            }
            if (this.r == null) {
                this.r = ValueAnimator.ofInt(new int[]{0, 1});
                this.r.setDuration(300);
                this.r.addUpdateListener(new bh(this));
                this.r.addListener(new bm(this));
            }
            int i = this.u;
            this.r.setIntValues(new int[]{i, 0});
            this.r.start();
        }
    }

    public final void e() {
        if (getAddressBarState() == 1) {
            return;
        }
        if (this.l == null || !this.l.b) {
            setAddressState(1);
            setWebViewState(0);
            h();
            if (this.r != null && this.r.isRunning()) {
                this.r.cancel();
            }
            if (this.q == null) {
                this.q = ValueAnimator.ofInt(new int[]{0, 1});
                this.q.setDuration(300);
                this.q.addUpdateListener(new bc(this));
            }
            int i = this.u;
            int addressBarHeight = getAddressBarHeight() - getAddressBarMinHeight();
            this.q.setIntValues(new int[]{i, addressBarHeight});
            this.q.start();
        }
    }

    private void setWebViewState(int i) {
        this.w = i;
    }

    private int getWebViewState() {
        return this.w;
    }

    public final int getAddressBarState() {
        return this.v;
    }

    private void h() {
        this.p.forceLayout();
        a(MeasureSpec.makeMeasureSpec(getWidth(), UCCore.VERIFY_POLICY_QUICK));
        g();
    }

    final int getScrollThresholdForChangeAddressBar() {
        if (this.x == -1) {
            this.x = com.ucpro.ui.c.a.c((int) R.dimen.scroll_threshold_for_switch_search_bar);
        }
        return this.x;
    }

    public final void a(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
    }

    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            a();
        }
    }

    public final void a(float f) {
        this.k.a((f / IPictureView.DEFAULT_MAX_SCALE) * 2.0f, true);
    }

    public final void b(float f) {
        float f2 = (f / IPictureView.DEFAULT_MAX_SCALE) * 2.0f;
        a aVar = this.k;
        ValueCallback bfVar = new bf(this);
        if (aVar.b != null) {
            aVar.b.cancel();
        }
        if (f2 < ((float) ((a.a / 3) * 2))) {
            aVar.b = ValueAnimator.ofFloat(new float[]{f2, 0.0f});
            aVar.b.addUpdateListener(new com.ucpro.feature.webwindow.k.b(aVar));
            aVar.b.setDuration(300);
            aVar.b.start();
            bfVar.onReceiveValue(Boolean.valueOf(false));
            return;
        }
        aVar.b = ValueAnimator.ofFloat(new float[]{f2, (float) ((a.a / 3) * 2)});
        aVar.b.addUpdateListener(new g(aVar));
        aVar.b.setDuration(300);
        aVar.b.start();
        if (aVar.c != null) {
            aVar.c.cancel();
        }
        aVar.c = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        aVar.c.addUpdateListener(new com.ucpro.feature.webwindow.k.f(aVar));
        aVar.c.addListener(new c(aVar));
        aVar.c.setInterpolator(aVar.d);
        aVar.c.setRepeatCount(100);
        aVar.c.setDuration(2000);
        aVar.c.start();
        bfVar.onReceiveValue(Boolean.valueOf(true));
    }

    public final void a() {
        if (this.k != null && this.l != null && !this.l.b) {
            a aVar = this.k;
            ValueCallback anVar = new an(this);
            if (aVar.c != null) {
                aVar.c.cancel();
            }
            aVar.animate().scaleX(0.0f).scaleY(0.0f).setDuration(300).setListener(new com.ucpro.feature.webwindow.k.e(aVar, anVar)).start();
        }
    }

    public final View f() {
        if (this.m != null || this.p == null) {
            return null;
        }
        this.m = new com.ucpro.ui.a.a(getContext());
        this.m.a("lottie/404/data.json", "lottie/404/images", "lottie/404/images_night");
        this.m.setText(com.ucpro.ui.c.a.d((int) R.string.empty_error_anim_page_404));
        addView(this.m, 1);
        return this.m;
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9132271");
    }

    public final String getPageName() {
        return "Page_external_web";
    }

    public final void setEnableShrinkAddressBarByTouchEvent(boolean z) {
        this.E = z;
    }

    final void c() {
        if (this.c != null && this.c.isRunning()) {
            this.c.cancel();
        }
        if (this.d != null && this.d.isRunning()) {
            this.d.cancel();
        }
    }
}
