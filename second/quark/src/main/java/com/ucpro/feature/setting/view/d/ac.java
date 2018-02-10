package com.ucpro.feature.setting.view.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.c.b.g;
import com.ucpro.feature.setting.view.c.a;
import com.ucpro.feature.setting.view.item.h;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.af;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.w;

/* compiled from: ProGuard */
public abstract class ac extends g implements a, af {
    protected h e;
    private f f = n();
    private FrameLayout g;
    private LinearLayout h;
    private String i;
    private i j;

    public abstract String getTitleText();

    public ac(Context context, i iVar) {
        super(context);
        this.j = iVar;
        setWindowCallBacks(this.j);
        this.f.a(getTitleText());
        this.f.a(com.ucpro.ui.c.a.a("back.svg"));
        String titleBarRightImageName = getTitleBarRightImageName();
        if (TextUtils.isEmpty(titleBarRightImageName)) {
            this.f.a(false);
        } else {
            this.f.a(true);
            this.f.b(com.ucpro.ui.c.a.a(titleBarRightImageName));
        }
        getBaseLayer().addView(this.f.a, new LayoutParams(-1, -2));
        m();
    }

    public void setTitleText(String str) {
        this.i = str;
        if (this.f != null) {
            this.f.a(str);
        }
    }

    public void a() {
    }

    public String getTitleBarRightImageName() {
        return null;
    }

    public void m() {
        setBackgroundColor(com.ucpro.ui.c.a.c("setting_window_background_color"));
    }

    public void l() {
        super.l();
        m();
        if (this.f != null) {
            this.f.b();
        }
    }

    public FrameLayout getContentLayer() {
        if (this.g == null) {
            this.g = new FrameLayout(getContext());
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
            getBaseLayer().addView(this.g, layoutParams);
        }
        return this.g;
    }

    private LinearLayout getBaseLayer() {
        if (this.h == null) {
            this.h = new LinearLayout(getContext());
            this.h.setOrientation(1);
            b(this.h);
        }
        return this.h;
    }

    public int getTitleBarHeight() {
        return com.ucpro.ui.c.a.c((int) R.dimen.setting_window_title_bar_height);
    }

    public i getSettingWindowCallback() {
        return this.j;
    }

    public final void a(f fVar, View view, ad adVar) {
        getUICallbacks().a(true);
    }

    public void a(f fVar, View view, w wVar) {
    }

    public f getTitleBar() {
        return this.f;
    }

    public final f n() {
        if (this.f == null) {
            this.f = new f(getContext());
        }
        return this.f;
    }
}
