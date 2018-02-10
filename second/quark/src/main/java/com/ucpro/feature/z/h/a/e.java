package com.ucpro.feature.z.h.a;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.quark.browser.R;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.feature.i.f;
import com.ucpro.feature.y.b;
import com.ucpro.feature.z.a.c;
import com.ucpro.feature.z.b.a;
import com.ucpro.feature.z.c.d;
import com.ucpro.feature.z.d.g;
import com.ucpro.ui.widget.h;

/* compiled from: ProGuard */
public final class e extends ViewGroup {
    public c a;
    public a b;
    public g c;
    com.ucpro.feature.z.e.g d;
    d e;
    h f;
    h g;
    h h;
    LayoutAnimationController i;
    public boolean j;
    public boolean k;
    public i l;
    public h m;
    public l n;
    public int o;
    private h p;
    private View q;
    private h r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    public e(Context context) {
        super(context);
        this.a = null;
        this.p = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.q = null;
        this.e = null;
        this.r = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = null;
        this.w = 0;
        this.x = 0;
        this.o = -1;
        this.y = false;
        this.z = false;
        this.s = com.ucpro.ui.c.a.c((int) R.dimen.search_address_bar_height);
        this.t = 1;
        this.u = com.ucpro.ui.c.a.c((int) R.dimen.search_input_history_margin_left);
        this.v = com.ucpro.ui.c.a.c((int) R.dimen.search_copy_tip_height);
        this.a = new c(getContext());
        this.a.setVisibility(8);
        addView(this.a);
        this.q = new View(getContext());
        this.q.setVisibility(8);
        addView(this.q);
        this.p = new h(getContext(), this.a);
        this.p.setVisibility(8);
        addView(this.p);
        this.b = new a(getContext());
        this.b.setVisibility(8);
        addView(this.b);
        this.c = new g(getContext());
        this.c.setMaxLines(4);
        this.c.setVisibility(8);
        addView(this.c);
        this.d = new com.ucpro.feature.z.e.g(getContext());
        this.d.setVisibility(8);
        addView(this.d);
        Animation animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(0.0f, IPictureView.DEFAULT_MIN_SCALE);
        alphaAnimation.setDuration(100);
        animationSet.addAnimation(alphaAnimation);
        alphaAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.5f, 1, 0.0f);
        alphaAnimation.setDuration(100);
        animationSet.addAnimation(alphaAnimation);
        this.i = new LayoutAnimationController(animationSet, 0.1f);
        this.i.setOrder(1);
        this.d.setLayoutAnimation(this.i);
        this.e = new d(getContext());
        this.e.setVisibility(8);
        addView(this.e);
        a();
        d();
        e();
        f();
        this.o = com.ucweb.common.util.j.a.a("WindowHeightWithKeybord");
    }

    public final void a() {
        this.a.a();
        this.b.a();
        this.c.a();
        this.d.c();
        this.e.a();
        this.q.setBackgroundColor(com.ucpro.ui.c.a.c("default_cutting_line"));
    }

    public final void setState(i iVar) {
        this.l = iVar;
    }

    public final void setHomePage(b bVar) {
        if (this.r == null) {
            this.r = new h(getContext());
            addView(this.r, 0);
        }
        this.r.setSourceView(bVar.getLogo());
        this.r.setAlpha(this.r.getSourceView().getAlpha());
        if (this.f == null) {
            this.f = new h(getContext());
            addView(this.f, 0);
        }
        this.f.setSourceView(bVar.getNavigationView());
        this.f.setAlpha(this.f.getSourceView().getAlpha());
        if (this.h == null) {
            this.h = new h(getContext());
            addView(this.h, 0);
        }
        this.h.setSourceView(bVar.getSearchBar());
        this.h.setAlpha(this.h.getSourceView().getAlpha());
        int top = bVar.getSearchBar().getTop();
        this.w = ((int) bVar.getSearchBar().getTranslationY()) + top;
        this.x = top;
        g();
        h();
        this.m.b();
        this.n.b();
    }

    public final void setHomeToolBar(View view) {
        if (this.g == null) {
            this.g = new h(getContext());
            addView(this.g, 0);
        }
        this.g.setSourceView(view);
        this.g.setAlpha(this.g.getSourceView().getAlpha());
    }

    private void d() {
        this.a.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.s, UCCore.VERIFY_POLICY_QUICK));
    }

    private void e() {
        this.b.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.b.getInputEnhanceImproveHeight(), UCCore.VERIFY_POLICY_QUICK));
    }

    private void f() {
        this.c.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth() - (this.u * 2), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), SectionHeader.SHT_LOUSER));
    }

    private void g() {
        if (this.r != null) {
            this.r.measure(MeasureSpec.makeMeasureSpec(this.r.getSourceView().getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.r.getSourceView().getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.f != null) {
            this.f.measure(MeasureSpec.makeMeasureSpec(this.f.getSourceView().getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.f.getSourceView().getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.g != null) {
            this.g.measure(MeasureSpec.makeMeasureSpec(this.g.getSourceView().getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.g.getSourceView().getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.h != null) {
            this.h.measure(MeasureSpec.makeMeasureSpec(this.h.getSourceView().getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.h.getSourceView().getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        }
    }

    private void h() {
        if (this.r != null && this.r.getVisibility() == 0) {
            View sourceView = this.r.getSourceView();
            this.r.layout(sourceView.getLeft(), sourceView.getTop(), sourceView.getRight(), sourceView.getBottom());
        }
        if (this.f != null && this.f.getVisibility() == 0) {
            sourceView = this.f.getSourceView();
            this.f.layout(sourceView.getLeft(), sourceView.getTop(), sourceView.getRight(), sourceView.getBottom());
        }
        if (this.g != null && this.g.getVisibility() == 0) {
            sourceView = this.g.getSourceView();
            this.g.layout(sourceView.getLeft(), sourceView.getTop(), sourceView.getRight(), sourceView.getBottom());
        }
        if (this.h != null && this.h.getVisibility() == 0) {
            sourceView = this.h.getSourceView();
            this.h.layout(sourceView.getLeft(), sourceView.getTop(), sourceView.getRight(), sourceView.getBottom());
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.a != null) {
            int measuredWidth = this.a.getMeasuredWidth() + 0;
            int i5 = this.w;
            this.a.layout(0, i5, measuredWidth, this.a.getMeasuredHeight() + i5);
        }
        if (this.q != null) {
            measuredWidth = this.q.getMeasuredWidth() + 0;
            i5 = this.a.getTop();
            this.q.layout(0, i5 - this.q.getMeasuredHeight(), measuredWidth, i5);
        }
        if (this.p != null && this.p.getVisibility() == 0) {
            measuredWidth = this.p.getMeasuredWidth() + 0;
            i5 = this.w;
            this.p.layout(0, i5, measuredWidth, this.p.getMeasuredHeight() + i5);
        }
        if (this.b != null) {
            i5 = this.w + this.b.getMeasuredHeight();
            this.b.layout(0, i5, this.b.getMeasuredWidth() + 0, this.b.getMeasuredHeight() + i5);
        }
        if (this.c != null) {
            measuredWidth = this.u;
            i5 = this.c.getMeasuredWidth() + measuredWidth;
            int i6 = this.w;
            this.c.layout(measuredWidth, i6 - this.c.getMeasuredHeight(), i5, i6);
        }
        if (this.d != null && this.d.getVisibility() == 0) {
            this.d.layout(0, 0, this.d.getMeasuredWidth() + 0, this.d.getMeasuredHeight());
        }
        h();
        if (this.e != null) {
            measuredWidth = this.e.getMeasuredWidth() + 0;
            i5 = this.a.getTop();
            this.e.layout(0, i5 - this.e.getMeasuredHeight(), measuredWidth, i5);
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        d();
        this.p.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.s, UCCore.VERIFY_POLICY_QUICK));
        e();
        f();
        this.d.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight() - this.a.getMeasuredHeight(), UCCore.VERIFY_POLICY_QUICK));
        this.q.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.t, UCCore.VERIFY_POLICY_QUICK));
        g();
        this.e.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.v, UCCore.VERIFY_POLICY_QUICK));
    }

    public final void a(int i, boolean z) {
        this.l.a(i, z);
    }

    public final void b() {
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (f.a.a() && !this.z) {
                layoutParams2.setMargins(0, com.ucweb.common.util.f.b(getContext()), 0, 0);
                this.z = true;
            } else if (!f.a.a() && this.z) {
                layoutParams2.setMargins(0, 0, 0, 0);
                this.z = false;
            }
        }
    }

    public final int getSearchBarLocationBottom() {
        if (this.p.getVisibility() == 0) {
            return (int) (this.p.getY() + ((float) this.p.getMeasuredHeight()));
        }
        return (int) (this.a.getY() + ((float) this.a.getMeasuredHeight()));
    }

    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.as);
            if (this.y) {
                return true;
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 67) {
            super.dispatchKeyEvent(keyEvent);
            return true;
        } else if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        } else {
            if (keyEvent.getAction() != 1) {
                return true;
            }
            com.ucpro.base.a.g.a().b(com.ucpro.base.a.e.ar);
            return true;
        }
    }

    public final void c() {
        if (this.l != null) {
            this.l.f();
        }
    }

    public final c getSearchBar() {
        return this.a;
    }

    public final h getMirrorAddressBar() {
        return this.p;
    }

    public final h getMirrorInputView() {
        return this.h;
    }

    public final g getInputHistoryView() {
        return this.c;
    }

    public final a getInputEnhanceView() {
        return this.b;
    }

    public final com.ucpro.feature.z.e.g getAssociateView() {
        return this.d;
    }

    public final View getBarShadowView() {
        return this.q;
    }

    public final h getMirrorLogo() {
        return this.r;
    }

    public final int getSearchBarInitY() {
        return this.w;
    }

    public final int getSearchBarInitYWithoutTransY() {
        return this.x;
    }

    public final h getMirrorNavigationView() {
        return this.f;
    }

    public final h getMirrorToolBar() {
        return this.g;
    }

    public final d getCopyTipView() {
        return this.e;
    }

    public final void setNeedInterceptPreIme(boolean z) {
        this.y = z;
    }
}
