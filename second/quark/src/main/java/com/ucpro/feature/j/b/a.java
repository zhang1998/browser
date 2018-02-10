package com.ucpro.feature.j.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.a.f;
import com.ucpro.base.a.j;
import com.ucpro.c.d;
import com.ucpro.feature.p.b;
import com.ucpro.feature.p.c;
import com.ucpro.ui.g.r;
import com.ucpro.ui.widget.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class a extends ViewGroup implements OnClickListener {
    public float a = 0.0f;
    public ValueAnimator b;
    public long c = 300;
    private FrameLayout d = new FrameLayout(getContext());
    private View e;
    private LinearLayout f;
    private List<c> g = new ArrayList();
    private int h = com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_min_view_width);
    private int i = com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_min_view_height);
    private int j = com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_min_view_rect_width);
    private int k = com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_min_view_rect_height);
    private int l = com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_max_view_width);
    private int m;
    private int n = com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_max_view_margin_top);
    private int o = com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_max_view_rect_width);
    private int p;
    private int q = com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_max_view_rect_margin_top);
    private Interpolator r = new OvershootInterpolator(0.8f);
    private Interpolator s = new DecelerateInterpolator();
    private com.ucpro.feature.j.a t;

    public a(Context context) {
        super(context);
        addView(this.d);
        this.e = new View(getContext());
        addView(this.e);
        this.f = new LinearLayout(getContext());
        this.f.setOrientation(1);
        addView(this.f);
        a();
    }

    public final void a(List<com.ucpro.feature.j.a.a> list) {
        this.f.removeAllViews();
        this.g.clear();
        for (com.ucpro.feature.j.a.a aVar : list) {
            if (aVar != null) {
                View cVar = new c(getContext(), new b(aVar.a, aVar.f, "menu_icon_bg_1080p.png", aVar.d, null));
                cVar.setId(aVar.a);
                cVar.setOnClickListener(this);
                this.f.addView(cVar, new LayoutParams(com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_item_width), com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_item_height)));
                this.g.add(cVar);
            }
        }
        this.f.setTranslationX((float) this.l);
    }

    public final void a() {
        int c = com.ucpro.ui.c.a.c((int) R.dimen.shortcut_menu_full_view_radius);
        this.e.setBackgroundDrawable(new i(new float[]{(float) c, (float) c, 0.0f, 0.0f, 0.0f, 0.0f, (float) c, (float) c}, com.ucpro.ui.c.a.c("default_background_white")));
        this.d.setBackgroundDrawable(com.ucpro.ui.c.a.a("shortcut_menu_shadow.9.png"));
        for (c cVar : this.g) {
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        b();
        this.m = this.f.getMeasuredHeight() + (this.n * 2);
        this.p = this.f.getMeasuredHeight() + (this.q * 2);
        c();
        d();
    }

    private void b() {
        this.f.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
    }

    private void c() {
        int curContainerWidth = getCurContainerWidth();
        int curContainerHeight = getCurContainerHeight();
        this.d.measure(MeasureSpec.makeMeasureSpec(curContainerWidth, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(curContainerHeight, UCCore.VERIFY_POLICY_QUICK));
    }

    private void d() {
        int curWhiteRectWidth = getCurWhiteRectWidth();
        int curWhiteRectHeight = getCurWhiteRectHeight();
        this.e.measure(MeasureSpec.makeMeasureSpec(curWhiteRectWidth, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(curWhiteRectHeight, UCCore.VERIFY_POLICY_QUICK));
    }

    private int getCurContainerWidth() {
        return (int) ((this.r.getInterpolation(this.a) * ((float) (this.l - this.h))) + ((float) this.h));
    }

    private int getCurContainerHeight() {
        return (int) ((this.r.getInterpolation(this.a) * ((float) (this.m - this.i))) + ((float) this.i));
    }

    private int getCurWhiteRectWidth() {
        return (int) ((this.r.getInterpolation(this.a) * ((float) (this.o - this.j))) + ((float) this.j));
    }

    private int getCurWhiteRectHeight() {
        return (int) ((this.r.getInterpolation(this.a) * ((float) (this.p - this.k))) + ((float) this.k));
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        e();
        f();
        g();
    }

    private void e() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = (getMeasuredHeight() - this.d.getMeasuredHeight()) / 2;
        this.d.layout(measuredWidth - this.d.getMeasuredWidth(), measuredHeight, measuredWidth, this.d.getMeasuredHeight() + measuredHeight);
    }

    private void f() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = (getMeasuredHeight() - this.e.getMeasuredHeight()) / 2;
        this.e.layout(measuredWidth - this.e.getMeasuredWidth(), measuredHeight, measuredWidth, this.e.getMeasuredHeight() + measuredHeight);
    }

    private void g() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = (getMeasuredHeight() - this.f.getMeasuredHeight()) / 2;
        this.f.layout(measuredWidth - this.f.getMeasuredWidth(), measuredHeight, measuredWidth, this.f.getMeasuredHeight() + measuredHeight);
    }

    public final void setStretchProgress(float f) {
        this.a = f;
        if (this.f.getMeasuredWidth() > 0) {
            this.f.setTranslationX((IPictureView.DEFAULT_MIN_SCALE - this.s.getInterpolation(f)) * ((float) this.f.getMeasuredWidth()));
        } else {
            this.f.setTranslationX((float) this.l);
        }
        c();
        d();
        b();
        e();
        f();
        g();
    }

    public final void setPresenter(com.ucpro.feature.j.a aVar) {
        this.t = aVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        if (this.t != null) {
            com.ucpro.feature.j.a aVar = this.t;
            boolean a;
            com.ucpro.model.a.b a2;
            String str;
            switch (view.getId()) {
                case 1:
                    a = com.ucpro.model.a.a.a.a("setting_enable_smart_no_image", false);
                    a2 = com.ucpro.model.a.a.a;
                    str = "setting_enable_smart_no_image";
                    if (a) {
                        z = false;
                    }
                    a2.b(str, z);
                    f.a().a(j.s);
                    break;
                case 2:
                    a = com.ucpro.model.a.a.a.a("setting_smart_reader", false);
                    a2 = com.ucpro.model.a.a.a;
                    str = "setting_smart_reader";
                    if (a) {
                        a = false;
                    } else {
                        a = true;
                    }
                    a2.b(str, a);
                    f.a().a(j.t);
                    break;
                case 3:
                    a = com.ucpro.model.a.a.a.a("setting_webcore_network_proxy", false);
                    a2 = com.ucpro.model.a.a.a;
                    str = "setting_webcore_network_proxy";
                    if (a) {
                        z = false;
                    }
                    a2.b(str, z);
                    f.a().a(j.n);
                    break;
                case 4:
                    a = com.ucpro.model.a.a.a.a("setting_enable_adapt_screen", false);
                    a2 = com.ucpro.model.a.a.a;
                    str = "setting_enable_adapt_screen";
                    if (a) {
                        z = false;
                    }
                    a2.b(str, z);
                    f.a().a(j.u);
                    break;
                case 5:
                    r rVar;
                    com.ucpro.ui.g.c iVar = new com.ucpro.feature.j.i(aVar);
                    List a3 = com.ucpro.a.a.c.a();
                    com.ucpro.feature.h.b.a;
                    String a4 = com.ucpro.a.a.c.a(com.ucpro.feature.h.a.d());
                    int i = 0;
                    while (i < a3.size()) {
                        if (com.ucweb.common.util.n.a.c((String) a3.get(i), a4)) {
                            if (d.b()) {
                                z = false;
                            }
                            rVar = new r(aVar.b().getContext(), z);
                            rVar.a(com.ucpro.ui.c.a.d((int) R.string.common_setting_ua_dialog_title));
                            rVar.a(a3, i);
                            rVar.a = iVar;
                            rVar.show();
                            break;
                        }
                        i++;
                    }
                    i = 0;
                    if (d.b()) {
                        z = false;
                    }
                    rVar = new r(aVar.b().getContext(), z);
                    rVar.a(com.ucpro.ui.c.a.d((int) R.string.common_setting_ua_dialog_title));
                    rVar.a(a3, i);
                    rVar.a = iVar;
                    rVar.show();
                case 6:
                    if (!(aVar.b() == null || aVar.b().G())) {
                        aVar.b().o();
                        break;
                    }
            }
            aVar.a();
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 1 || this.t == null) {
            return true;
        }
        this.t.a();
        return true;
    }
}
