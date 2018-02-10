package com.ucpro.feature.setting.d;

import com.uc.apollo.impl.SettingsConst;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.setting.e.c;
import com.ucpro.feature.setting.view.b.b;
import com.ucpro.model.a.a;

/* compiled from: ProGuard */
final class h implements b {
    final /* synthetic */ k a;

    h(k kVar) {
        this.a = kVar;
    }

    public final void a() {
        a.a.b("setting_toolbar_style", 0);
        g.a().b(e.r);
        com.ucpro.feature.setting.e.b.a;
        c.a(SettingsConst.FALSE);
        if (this.a.j != null) {
            this.a.j.a();
        }
    }

    public final void b() {
        a.a.b("setting_toolbar_style", 1);
        g.a().b(e.r);
        com.ucpro.feature.setting.e.b.a;
        c.a(SettingsConst.TRUE);
        if (this.a.j != null) {
            this.a.j.a();
        }
    }
}
