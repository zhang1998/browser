package com.ucpro.feature.s.b;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.d.b;
import com.ucpro.feature.s.a;
import com.ucpro.feature.s.b.a.d;
import com.ucpro.feature.s.b.a.e;
import com.ucpro.feature.s.f;
import com.ucpro.model.keepproguard.discnavi.DiscoveryNavigationData;
import com.ucpro.ui.widget.i;

/* compiled from: ProGuard */
public final class h extends FrameLayout implements d, c, j, f {
    private a a;
    private b b;
    private View c;
    private e d;
    private ImageView e;
    private View f = new View(getContext());

    public h(Context context) {
        int b;
        super(context);
        this.f.setAlpha(0.0f);
        addView(this.f);
        this.b = new b(getContext());
        this.b.setListener(this);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOnClickListener(new k(this));
        int c = com.ucpro.ui.c.a.c((int) R.dimen.discovery_navi_view_close_button_hit_expand_x);
        linearLayout.setPadding(c, 0, c, 0);
        c = com.ucpro.ui.c.a.c((int) R.dimen.discovery_navi_view_bottombar_height);
        this.e = new ImageView(getContext());
        this.e.setScaleX(0.0f);
        this.e.setScaleY(0.0f);
        int c2 = com.ucpro.ui.c.a.c((int) R.dimen.discovery_navi_view_close_button_size);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(c2, c2);
        layoutParams.gravity = 17;
        linearLayout.addView(this.e, layoutParams);
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, c);
        layoutParams2.gravity = 17;
        View frameLayout = new FrameLayout(getContext());
        frameLayout.addView(linearLayout, layoutParams2);
        this.c = frameLayout;
        this.d = new e(getContext(), this.b, this.c);
        this.d.setListener(this);
        c = com.ucpro.ui.c.a.c((int) R.dimen.discovery_navi_view_padding);
        if (com.ucpro.feature.i.f.a.a()) {
            b = com.ucweb.common.util.f.b(getContext()) + c;
        } else {
            b = c;
        }
        this.d.setPadding(c, b, c, c);
        addView(this.d);
        this.f.setBackgroundColor(com.ucpro.ui.c.a.c("all_in_one_navi_bg_mask_color"));
        this.d.setExpansibleBackground(new i(com.ucpro.ui.c.a.c((int) R.dimen.discovery_navi_view_content_bg_corner_radius), com.ucpro.ui.c.a.c("all_in_one_navi_content_bg_color")));
        this.e.setImageDrawable(com.ucpro.ui.c.a.a("discovery_navigation_close.svg"));
        this.c.setBackgroundDrawable(com.ucpro.ui.c.a.a("all_in_one_navi_bottom_bar_bg.xml"));
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 1 || this.a == null) {
            return true;
        }
        this.a.e();
        return true;
    }

    public final void setPresenter(b bVar) {
        this.a = (a) bVar;
    }

    public final void setupData(DiscoveryNavigationData discoveryNavigationData) {
        this.b.setAdapter(new g(getContext(), discoveryNavigationData, this));
    }

    public final void g() {
        this.d.b(0);
    }

    public final void a() {
        this.f.animate().cancel();
        this.f.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(300).start();
        this.e.animate().setDuration(300).setStartDelay(380).scaleX(IPictureView.DEFAULT_MIN_SCALE).scaleY(IPictureView.DEFAULT_MIN_SCALE).setInterpolator(new DecelerateInterpolator()).start();
    }

    public final void b() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void d() {
        if (this.a != null) {
            this.a.c();
        }
    }

    public final void e() {
        if (this.a != null) {
            this.a.d();
        }
    }

    public final void f() {
        if (this.a != null) {
            this.a.f();
        }
    }

    public final void onClick(View view) {
        if ((view instanceof e) && this.a != null) {
            e eVar = (e) view;
            this.a.a(this.b.getCurrentTabName(), eVar.getTitle(), eVar.getUrl());
        }
    }

    public final void a(String str) {
        if (this.a != null) {
            this.a.a(str);
        }
    }

    public final void c() {
        this.f.animate().cancel();
        this.f.animate().alpha(0.0f).setDuration(300).start();
    }
}
