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
import com.ucpro.base.c.b.g;
import com.ucpro.feature.setting.b.b.a.d;
import com.ucpro.feature.setting.b.d.b.b;
import com.ucpro.feature.setting.b.d.b.h;
import com.ucpro.feature.setting.b.d.b.j;
import com.ucpro.ui.widget.ad;
import com.ucpro.ui.widget.af;
import com.ucpro.ui.widget.f;
import com.ucpro.ui.widget.w;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class a extends g implements com.ucpro.feature.setting.view.c.a, af {
    private d e;
    private com.ucpro.feature.setting.b.d.c.a f;
    private f g;
    private FrameLayout h;
    private LinearLayout i;
    private String j;
    private c k;
    private com.ucpro.feature.setting.b.b.a l;

    public a(Context context, com.ucpro.feature.setting.b.b.a aVar, c cVar) {
        super(context);
        this.l = aVar;
        if (this.g == null) {
            this.g = new f(getContext());
        }
        this.g = this.g;
        this.g.f = this;
        this.g.a(getTitleText());
        this.g.a(com.ucpro.ui.c.a.a("back.svg"));
        String titleBarRightImageName = getTitleBarRightImageName();
        if (TextUtils.isEmpty(titleBarRightImageName)) {
            this.g.a(false);
        } else {
            this.g.a(true);
            this.g.b(com.ucpro.ui.c.a.a(titleBarRightImageName));
        }
        getBaseLayer().addView(this.g.a, new LayoutParams(-1, -2));
        b();
        this.k = cVar;
        setWindowCallBacks(this.k);
        this.e = new d(getContext());
        this.e.setSettingViewCallback(this);
        a();
        getContentLayer().addView(this.e.getSettingView(), new ViewGroup.LayoutParams(-1, -1));
    }

    private void b() {
        setBackgroundColor(com.ucpro.ui.c.a.c("setting_window_background_color"));
        this.g.a(com.ucpro.ui.c.a.a("back.svg"));
    }

    public final String getTitleText() {
        return this.l.a;
    }

    public final void setTitleText(String str) {
        this.j = str;
        if (this.g != null) {
            this.g.a(str);
        }
    }

    public final String getTitleBarRightImageName() {
        return null;
    }

    private LinearLayout getBaseLayer() {
        if (this.i == null) {
            this.i = new LinearLayout(getContext());
            this.i.setOrientation(1);
            b(this.i);
        }
        return this.i;
    }

    public final void a() {
        if (this.e != null) {
            if (this.f == null) {
                Object obj;
                List<d> list = this.l.c;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((d) it.next()).b == com.ucpro.feature.setting.b.a.a.b) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        it.remove();
                    }
                }
                this.f = new com.ucpro.feature.setting.b.d.c.a(getContext());
                com.ucpro.feature.setting.b.d.c.a aVar = this.f;
                if (aVar.b == null) {
                    aVar.b = new ArrayList();
                }
                aVar.b.clear();
                for (d dVar : list) {
                    Context context = aVar.a;
                    switch (dVar.a()) {
                        case 0:
                            c.b(dVar instanceof com.ucpro.feature.setting.b.b.a);
                            b bVar = new b(context, (com.ucpro.feature.setting.b.b.a) dVar);
                            break;
                        case 1:
                            c.b(dVar instanceof com.ucpro.feature.setting.b.b.b);
                            com.ucpro.feature.setting.b.d.b.g gVar = new com.ucpro.feature.setting.b.d.b.g(context, (com.ucpro.feature.setting.b.b.b) dVar);
                            break;
                        case 2:
                            c.b(dVar instanceof com.ucpro.feature.setting.b.b.c);
                            j jVar = new j(context, (com.ucpro.feature.setting.b.b.c) dVar);
                            break;
                        default:
                            obj = null;
                            break;
                    }
                    if (obj != null) {
                        aVar.b.add(obj);
                    }
                }
                this.e.setAdapter(this.f);
            }
            this.f.a();
        }
    }

    public final FrameLayout getContentLayer() {
        if (this.h == null) {
            this.h = new FrameLayout(getContext());
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
            getBaseLayer().addView(this.h, layoutParams);
        }
        return this.h;
    }

    public final void l() {
        super.l();
        b();
        if (this.f != null) {
            com.ucpro.feature.setting.b.d.c.a aVar = this.f;
            if (aVar.b != null) {
                Iterator it = aVar.b.iterator();
                while (it.hasNext()) {
                    ((h) it.next()).d();
                }
            }
        }
        if (this.g != null) {
            this.g.b();
        }
    }

    public final int getTitleBarHeight() {
        return com.ucpro.ui.c.a.c((int) R.dimen.setting_window_title_bar_height);
    }

    public final void a(f fVar, View view, ad adVar) {
        getUICallbacks().a(true);
    }

    public final void a(f fVar, View view, w wVar) {
    }

    public final void a(com.ucpro.feature.setting.view.item.h hVar, int i, Object obj) {
        getSettingWindowCallback();
    }

    public final c getSettingWindowCallback() {
        return this.k;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSettingWindowCallback();
    }
}
