package com.ucpro.services.a;

import android.text.TextUtils;
import com.ucpro.b.d.b;

/* compiled from: ProGuard */
public final class c implements d {
    private c() {
    }

    public final void a(String str) {
        String[] a = b.a(str);
        if (a.length > 0) {
            for (String a2 : a) {
                b.a(a2);
            }
        }
    }

    public final boolean b(String str) {
        return b.b(str);
    }

    public final void c(String str) {
        com.ucweb.common.util.c.a((CharSequence) str);
        com.ucpro.b.d.a.c a = com.ucpro.b.d.a.c.a();
        if (!TextUtils.isEmpty(str)) {
            synchronized (a.a) {
                a.a.edit().remove(str).apply();
            }
        }
    }
}
