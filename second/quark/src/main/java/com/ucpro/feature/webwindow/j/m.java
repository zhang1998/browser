package com.ucpro.feature.webwindow.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.c.b.g;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.af;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.w;

/* compiled from: ProGuard */
public abstract class m extends g implements af {
    private f e;
    private FrameLayout f;
    private LinearLayout g;
    private String h;

    public abstract String getTitleText();

    public m(Context context) {
        super(context);
        if (this.e == null) {
            this.e = new f(getContext());
        }
        this.e = this.e;
        this.e.f = this;
        this.e.a(getTitleText());
        this.e.a(a.a("back.svg"));
        String titleBarRightImageName = getTitleBarRightImageName();
        if (TextUtils.isEmpty(titleBarRightImageName)) {
            this.e.a(false);
        } else {
            this.e.a(true);
            this.e.b(a.a(titleBarRightImageName));
        }
        getBaseLayer().addView(this.e.a, new LayoutParams(-1, -2));
        a();
    }

    public final void setTitleText(String str) {
        this.h = str;
        if (this.e != null) {
            this.e.a(str);
        }
    }

    public String getTitleBarRightImageName() {
        return null;
    }

    private void a() {
        setBackgroundColor(a.c("setting_window_background_color"));
    }

    public final void l() {
        super.l();
        a();
        if (this.e != null) {
            this.e.b();
        }
    }

    public final FrameLayout getContentLayer() {
        if (this.f == null) {
            this.f = new FrameLayout(getContext());
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
            getBaseLayer().addView(this.f, layoutParams);
        }
        return this.f;
    }

    private LinearLayout getBaseLayer() {
        if (this.g == null) {
            this.g = new LinearLayout(getContext());
            this.g.setOrientation(1);
            b(this.g);
        }
        return this.g;
    }

    public final void a(f fVar, View view, ad adVar) {
        getUICallbacks().a(true);
    }

    public final void a(f fVar, View view, w wVar) {
    }
}
