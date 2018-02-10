package com.ucpro.feature.setting.b.f;

import com.ucpro.c.b;
import com.ucpro.feature.setting.b.b.a.g;
import com.ucpro.feature.u.c;
import com.ucpro.feature.u.d;

/* compiled from: ProGuard */
public final class ch implements g {
    public final /* synthetic */ void a(Object obj) {
        Boolean bool = (Boolean) obj;
        if (b.b()) {
            if (bool.booleanValue()) {
                c.b();
            } else {
                c.c();
            }
            d a = com.ucpro.feature.u.b.a;
            boolean booleanValue = bool.booleanValue();
            a.a.edit().putBoolean("926B4774B1E4C37C", booleanValue).apply();
        }
    }

    public final /* synthetic */ Object a() {
        if (b.b()) {
            return Boolean.valueOf(c.a());
        }
        return Boolean.valueOf(false);
    }
}
