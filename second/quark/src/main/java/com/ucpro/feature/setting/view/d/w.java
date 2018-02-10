package com.ucpro.feature.setting.view.d;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import com.quark.browser.R;
import com.ucpro.feature.setting.a.b;
import com.ucpro.feature.setting.a.e;
import com.ucpro.feature.setting.a.g;
import com.ucpro.feature.setting.d.a;
import com.ucpro.feature.setting.d.u;
import com.ucpro.feature.setting.view.c.c;
import com.ucpro.feature.setting.view.c.f;
import com.ucpro.feature.setting.view.item.h;

/* compiled from: ProGuard */
public final class w extends ac implements a {
    private c f;
    private g g;
    private b h;
    private u i = null;

    public w(Context context, i iVar) {
        super(context, iVar);
        this.g = iVar;
        n();
        this.f = new f(getContext());
        this.f.setSettingViewCallback(this);
        a();
        getContentLayer().addView(this.f.getSettingView(), new LayoutParams(-1, -1));
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        com.ucweb.common.util.c.b(bVar instanceof u);
        this.i = (u) bVar;
    }

    public final void a() {
        if (this.f != null) {
            if (this.h == null) {
                this.h = new b(getContext(), this.g);
                b bVar = this.h;
                e a = com.ucpro.feature.setting.a.f.a;
                getContext();
                bVar.a(a.a((byte) 5));
                this.f.setAdapter(this.h);
            }
            this.h.a();
            this.h.b();
            this.h.d();
        }
    }

    public final String getTitleText() {
        return com.ucpro.ui.c.a.d((int) R.string.main_setting_item_browse);
    }

    public final void a(h hVar, int i, Object obj) {
        i settingWindowCallback = getSettingWindowCallback();
        if (settingWindowCallback != null) {
            settingWindowCallback.a(i, obj);
        }
    }

    public final void l() {
        super.l();
        m();
        if (this.h != null) {
            this.h.c();
        }
    }
}
