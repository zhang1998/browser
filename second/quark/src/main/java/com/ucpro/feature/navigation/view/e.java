package com.ucpro.feature.navigation.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class e extends u {
    private View r;
    private Animator s;
    private Animator t;
    private boolean u;

    public e(Context context, al alVar, ax axVar) {
        super(context, alVar, axVar);
        a();
    }

    public final void a() {
        Drawable a;
        super.a();
        if (a.a() && a.d()) {
            a = a.a("home_nav_add_dark.svg");
        } else {
            a = a.a("home_nav_add.svg");
        }
        setIcon(a);
        k();
    }

    private void k() {
        if (this.r != null) {
            this.r.setBackgroundDrawable(a.a("home_nav_edit_add.svg"));
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getEditIconView() != null) {
            View iconView = getIconView();
            if (iconView != null) {
                getEditIconView().layout(iconView.getLeft(), iconView.getTop(), iconView.getRight(), iconView.getBottom());
            }
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getEditIconView() != null) {
            View iconView = getIconView();
            if (iconView != null) {
                getEditIconView().measure(MeasureSpec.makeMeasureSpec(iconView.getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(iconView.getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
            }
        }
    }

    private View getEditIconView() {
        return this.r;
    }

    public final void a(long j) {
        View iconView = getIconView();
        if (iconView != null && iconView.getAlpha() != 0.0f) {
            Object obj;
            if (this.s == null || !this.s.isRunning()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                l();
                c();
                Animator ofFloat = ObjectAnimator.ofFloat(iconView, "alpha", new float[]{IPictureView.DEFAULT_MIN_SCALE, 0.0f});
                ofFloat.setDuration(j);
                ofFloat.start();
                this.s = ofFloat;
            }
        }
    }

    public final void b() {
        View iconView = getIconView();
        if (iconView != null && iconView.getAlpha() == 0.0f) {
            Object obj;
            if (this.t == null || !this.t.isRunning()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                l();
                c();
                Animator ofFloat = ObjectAnimator.ofFloat(iconView, "alpha", new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
                ofFloat.setDuration(300);
                ofFloat.start();
                this.t = ofFloat;
            }
        }
    }

    private void l() {
        if (this.s != null && this.s.isRunning()) {
            this.s.cancel();
        }
    }

    public final void c() {
        if (this.t != null && this.t.isRunning()) {
            this.t.cancel();
        }
    }

    public final void d() {
        if (!this.u) {
            this.u = true;
            if (this.r == null) {
                this.r = new View(getContext());
                k();
                addView(this.r);
            }
            setTitle(a.d((int) R.string.navigation_plus_wiget_text));
            if (getTitleView() != null) {
                getTitleView().setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            }
            if (getIconView() != null) {
                getIconView().setAlpha(0.0f);
            }
            getEditIconView().setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        }
    }

    public final void e() {
        if (this.u) {
            this.u = false;
            if (getTitleView() != null) {
                getTitleView().setAlpha(0.0f);
            }
            if (getIconView() != null) {
                getIconView().setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            }
            if (getEditIconView() != null) {
                getEditIconView().setAlpha(0.0f);
            }
        }
    }
}
