package com.ucpro.feature.setting.d;

import android.text.TextUtils;
import com.ucpro.base.a.f;
import com.ucpro.base.a.j;
import com.ucpro.business.stat.m;
import com.ucpro.feature.setting.e.b;
import com.ucpro.ui.g.c;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
final class e implements c {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void a(int i) {
        List a = com.ucpro.a.a.c.a();
        if (i >= 0 && i < a.size()) {
            b.a;
            CharSequence valueOf = String.valueOf(com.ucpro.a.a.c.a((String) a.get(i)));
            if (!TextUtils.isEmpty(valueOf)) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", valueOf);
                m.a("setting", "select_ua", hashMap);
            }
            f.a().a(j.m, com.ucpro.a.a.c.a((String) a.get(i)));
            this.a.a.a();
        }
    }
}
