package com.ucpro.feature.setting.view.d;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import com.quark.browser.R;
import com.ucpro.business.stat.a.d;
import com.ucpro.feature.setting.a.e;
import com.ucpro.feature.setting.a.f;
import com.ucpro.feature.setting.a.g;
import com.ucpro.feature.setting.d.p;
import com.ucpro.feature.setting.d.t;
import com.ucpro.feature.setting.view.c.b.b;
import com.ucpro.feature.setting.view.item.h;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.r;
import com.ucweb.common.util.c;
import java.util.List;

/* compiled from: ProGuard */
public final class k extends ac implements d, t {
    private b f;
    private g g;
    private com.ucpro.feature.setting.a.b h;
    private p i = null;

    public k(Context context, i iVar) {
        super(context, iVar);
        this.g = iVar;
        n();
        this.f = new b(getContext(), this.g);
        this.f.setSettingViewCallback(this);
        a();
        getContentLayer().addView(this.f.getSettingView(), new LayoutParams(-1, -1));
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        c.b(bVar instanceof p);
        this.i = (p) bVar;
    }

    public final void a() {
        if (this.f != null) {
            b bVar = this.f;
            e a = f.a;
            getContext();
            bVar.setData(a.a((byte) 3));
            bVar = this.f;
            bVar.a.j();
            bVar.a.k();
        }
    }

    public final String getTitleText() {
        return a.d((int) R.string.main_setting_item_clear_common);
    }

    public final void a(h hVar, int i, Object obj) {
        i settingWindowCallback = getSettingWindowCallback();
        if (settingWindowCallback != null) {
            if (com.ucpro.feature.setting.a.h.z == i) {
                this.e = hVar;
            }
            settingWindowCallback.a(i, obj);
        }
    }

    public final void a(List<String> list, int i, com.ucpro.ui.g.c cVar) {
        r rVar = new r(getContext(), !com.ucpro.c.d.b());
        rVar.a(a.d((int) R.string.common_setting_search_engine_dialog_title));
        rVar.a(list, i);
        rVar.a = cVar;
        rVar.show();
    }

    public final void b(List<String> list, int i, com.ucpro.ui.g.c cVar) {
        r rVar = new r(getContext(), false);
        rVar.a(a.d((int) R.string.common_crash_recovery));
        rVar.a(list, i);
        rVar.a = cVar;
        rVar.show();
    }

    public final void c(List<String> list, int i, com.ucpro.ui.g.c cVar) {
        r rVar = new r(getContext(), !com.ucpro.c.d.b());
        rVar.a(a.d((int) R.string.common_setting_ua_dialog_title));
        rVar.a(list, i);
        rVar.a = cVar;
        rVar.show();
    }

    public final void l() {
        super.l();
        m();
        if (this.h != null) {
            this.h.c();
        }
    }

    public final String getSpm() {
        return com.ucpro.business.stat.a.a.a("9102018");
    }

    public final String getPageName() {
        return "Page_set_common";
    }
}
