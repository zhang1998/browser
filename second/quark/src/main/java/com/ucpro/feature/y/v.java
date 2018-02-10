package com.ucpro.feature.y;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ac;
import com.ucweb.common.util.p.b;

/* compiled from: ProGuard */
public final class v extends ViewGroup implements y {
    private c a;
    private e b;
    private View c;
    private RelativeLayout d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private View l;
    private ImageView m;
    private FrameLayout n;
    private m o = null;
    private boolean p = true;

    public v(Context context) {
        super(context);
        setId(R.id.view_homepage);
        this.e = a.c((int) R.dimen.homepage_searchbar_height);
        this.f = a.c((int) R.dimen.homepage_searchbar_marginx);
        this.j = a.c((int) R.dimen.homepage_searchbar_margin_baseline);
        this.g = a.c((int) R.dimen.homepage_logo_margin_bottom);
        this.h = a.c((int) R.dimen.homepage_navigation_margin_baseline);
        this.i = a.c((int) R.dimen.homepage_navigation_view_height);
        this.k = a.c((int) R.dimen.homepage_baseline_offset_y);
        setOnLongClickListener(new d(this));
        this.b = new e(getContext());
        addView(this.b);
        this.d = new RelativeLayout(getContext());
        this.d.setTag(R.id.ui_auto, b.f);
        addView(this.d);
        this.d.setOnClickListener(new h(this));
        this.m = new ImageView(getContext());
        this.m.setFocusable(false);
        this.n = new FrameLayout(getContext());
        this.n.setOnClickListener(new n(this));
        this.n.addView(this.m);
        int c = a.c((int) R.dimen.homepage_qrcode_view_margin_right);
        this.n.setPadding(c, 0, c, 0);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        this.d.addView(this.n, layoutParams);
        a();
        this.o = new m();
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        this.a = (c) bVar;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b != null) {
            this.b.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (this.d != null) {
            this.d.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth() - (this.f * 2), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.e, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.c != null && this.c.getParent() == this) {
            this.c.measure(i, MeasureSpec.makeMeasureSpec(this.i, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.l != null && this.l.getParent() == this) {
            this.l.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d != null) {
            int width = (getWidth() - this.d.getMeasuredWidth()) / 2;
            int baseLineY = getBaseLineY() + this.j;
            int measuredHeight = baseLineY - this.d.getMeasuredHeight();
            this.d.layout(width, measuredHeight, this.d.getMeasuredWidth() + width, baseLineY);
        }
        if (!(this.b == null || this.d == null)) {
            width = (getWidth() - this.b.getMeasuredWidth()) / 2;
            baseLineY = this.d.getTop() - this.g;
            measuredHeight = baseLineY - this.b.getMeasuredHeight();
            this.b.layout(width, measuredHeight, this.b.getMeasuredWidth() + width, baseLineY);
        }
        if (this.c != null && this.c.getParent() == this) {
            int baseLineY2 = getBaseLineY() + this.h;
            this.c.layout(0, baseLineY2, getWidth(), this.i + baseLineY2);
        }
        if (this.l != null && this.l.getParent() == this) {
            this.l.layout(0, 0, this.l.getMeasuredWidth(), this.l.getMeasuredHeight() + 0);
        }
    }

    public final void setEnableGesture(boolean z) {
        this.p = z;
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ac) {
                ((ac) parent).setEnableGesture(z);
                return;
            }
        }
    }

    private int getBaseLineY() {
        return (getHeight() / 2) + this.k;
    }

    public final void a(View view) {
        if (view.getParent() == null) {
            this.c = view;
            addView(this.c);
        }
    }

    public final void setTouchCallback(w wVar) {
        this.o.f = wVar;
    }

    public final View getLogo() {
        return this.b;
    }

    public final View getSearchBar() {
        return this.d;
    }

    public final View getNavigationView() {
        return this.c;
    }

    public final void a() {
        this.m.setImageDrawable(a.a("home_qrcode_scan.svg"));
        this.b.setImageDrawable(a.b("home_logo.svg"));
        if (!a.a()) {
            this.d.setBackgroundDrawable(a.a("searchpage_fake_input_frame_bg.xml"));
            this.m.setColorFilter(0);
            this.b.setColorFilter(0);
        } else if (a.d()) {
            this.d.setBackgroundDrawable(a.a("searchpage_fake_input_frame_bg_dark.xml"));
            this.m.setColorFilter(-11184811);
            this.b.setColorFilter(-11184811);
        } else {
            this.d.setBackgroundDrawable(a.a("searchpage_fake_input_frame_bg.xml"));
            this.m.setColorFilter(-1);
            this.b.setColorFilter(-1);
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.p) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        m mVar = this.o;
        switch (motionEvent.getAction()) {
            case 0:
                mVar.a = false;
                mVar.b = false;
                mVar.c = motionEvent.getX();
                mVar.d = motionEvent.getY();
                if (mVar.d < 200.0f) {
                    z = true;
                }
                mVar.e = z;
                break;
            case 1:
            case 3:
                mVar.a();
                break;
            case 2:
                mVar.a(motionEvent);
                break;
        }
        return mVar.a;
    }

    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            a(IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE);
            a(0.0f);
        }
    }

    public final void a(float f, float f2) {
        this.b.setAlpha(f);
        this.c.setAlpha(f);
        this.b.setScaleX(f2);
        this.b.setScaleY(f2);
        this.c.setScaleX(f2);
        this.c.setScaleY(f2);
    }

    public final void a(float f) {
        this.d.setTranslationY(f);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
    }

    public final void setLogoMarginBottom(int i) {
        if (i != -1) {
            this.g = i;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.p) {
            m mVar = this.o;
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    mVar.a();
                    break;
                case 2:
                case 4:
                    mVar.a(motionEvent);
                    break;
            }
            if (mVar.a) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
