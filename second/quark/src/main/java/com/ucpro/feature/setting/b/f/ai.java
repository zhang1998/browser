package com.ucpro.feature.setting.b.f;

import com.uc.quark.filedownloader.contentprovider.a;
import com.ucpro.base.system.b;
import com.ucpro.feature.setting.b.b.a.h;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
public final class ai implements h {
    public final /* synthetic */ void a(Object obj) {
        String str = (String) obj;
        if (b.a.e(str)) {
            a.i(Integer.valueOf(str).intValue());
        } else {
            e.a().a("Requirements for numbers", 1);
        }
    }

    public final /* synthetic */ Object a() {
        return String.valueOf(a.c());
    }
}
