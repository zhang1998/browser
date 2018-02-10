package com.ucpro.feature.setting.b.d.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.ucpro.base.c.b.g;
import com.ucpro.feature.setting.view.c.a;
import com.ucpro.feature.video.player.h;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.af;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.w;

/* compiled from: ProGuard */
public final class b extends g implements a, com.ucpro.feature.video.player.a.g, af {
    public h e;
    private f f;
    private FrameLayout g;
    private LinearLayout h;
    private c i;

    public b(Context context, c cVar) {
        super(context);
        if (this.f == null) {
            this.f = new f(getContext());
        }
        this.f = this.f;
        this.f.f = this;
        this.f.a("开发模式视频播放器");
        this.f.a(com.ucpro.ui.c.a.a("back.svg"));
        String titleBarRightImageName = getTitleBarRightImageName();
        if (TextUtils.isEmpty(titleBarRightImageName)) {
            this.f.a(false);
        } else {
            this.f.a(true);
            this.f.b(com.ucpro.ui.c.a.a(titleBarRightImageName));
        }
        getBaseLayer().addView(this.f.a, new LayoutParams(-1, -2));
        setBackgroundColor(com.ucpro.ui.c.a.c("setting_window_background_color"));
        this.i = cVar;
        setWindowCallBacks(this.i);
        this.e = new h(getContext(), this);
        getContentLayer().addView(this.e.e(), new ViewGroup.LayoutParams(-1, -1));
    }

    public final String getTitleBarRightImageName() {
        return null;
    }

    private LinearLayout getBaseLayer() {
        if (this.h == null) {
            this.h = new LinearLayout(getContext());
            this.h.setOrientation(1);
            b(this.h);
        }
        return this.h;
    }

    public final FrameLayout getContentLayer() {
        if (this.g == null) {
            this.g = new FrameLayout(getContext());
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
            getBaseLayer().addView(this.g, layoutParams);
        }
        return this.g;
    }

    public final void l() {
    }

    public final int getTitleBarHeight() {
        return com.ucpro.ui.c.a.c((int) R.dimen.setting_window_title_bar_height);
    }

    public final boolean a(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        new StringBuilder("handleMessage;").append(i).append(",params=").append(bVar).append(",result=").append(bVar2);
        if (i == UCMPackageInfo.getLibFilter && this.e != null) {
            h hVar = this.e;
            if (hVar.c != null) {
                hVar.c.l();
                hVar.c = null;
            }
            hVar.j();
        }
        return false;
    }

    public final void a(com.ucpro.feature.setting.view.item.h hVar, int i, Object obj) {
    }

    public final void a(f fVar, View view, ad adVar) {
        getUICallbacks().a(true);
    }

    public final void a(f fVar, View view, w wVar) {
    }
}
