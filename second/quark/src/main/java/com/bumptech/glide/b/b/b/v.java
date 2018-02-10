package com.bumptech.glide.b.b.b;

import android.support.v4.d.q;
import com.bumptech.glide.b.i;
import com.bumptech.glide.util.a.h;
import com.bumptech.glide.util.g;
import com.bumptech.glide.util.l;

/* compiled from: ProGuard */
public final class v {
    private final g<i, String> a = new g(1000);
    private final q<u> b = h.a(10, new t(this));

    public final String a(i iVar) {
        String str;
        synchronized (this.a) {
            str = (String) this.a.b((Object) iVar);
        }
        if (str == null) {
            str = b(iVar);
        }
        synchronized (this.a) {
            this.a.b(iVar, str);
        }
        return str;
    }

    private String b(i iVar) {
        u uVar = (u) this.b.a();
        try {
            iVar.a(uVar.a);
            String a = l.a(uVar.a.digest());
            return a;
        } finally {
            this.b.a(uVar);
        }
    }
}
