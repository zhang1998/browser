package com.ucpro.feature.setting.b.d.b;

import com.ucpro.feature.setting.b.b.a.g;
import com.ucpro.feature.setting.b.d.a.e;

/* compiled from: ProGuard */
final class c implements e {
    final /* synthetic */ g a;
    final /* synthetic */ j b;

    c(j jVar, g gVar) {
        this.b = jVar;
        this.a = gVar;
    }

    public final boolean a(boolean z) {
        this.a.a(Boolean.valueOf(z));
        com.ucpro.ui.b.e.a().a("Value set to :" + z, 0);
        this.b.a(String.valueOf(z));
        return false;
    }
}
