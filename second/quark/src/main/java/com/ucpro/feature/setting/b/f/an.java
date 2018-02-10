package com.ucpro.feature.setting.b.f;

import com.uc.quark.filedownloader.contentprovider.a;
import com.ucpro.base.system.b;
import com.ucpro.feature.setting.b.b.a.h;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
public final class an implements h {
    public final /* synthetic */ void a(Object obj) {
        int i = 64;
        String str = (String) obj;
        if (b.a.e(str)) {
            int intValue = Integer.valueOf(str).intValue();
            if (intValue <= 64) {
                i = intValue;
            }
            a.g(i);
            return;
        }
        e.a().a("Requirements for numbers", 1);
    }

    public final /* synthetic */ Object a() {
        return String.valueOf(a.a());
    }
}
