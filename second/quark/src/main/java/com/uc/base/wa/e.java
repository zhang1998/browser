package com.uc.base.wa;

import com.uc.base.wa.b.b;
import com.uc.base.wa.b.c;
import com.uc.base.wa.b.q;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class e {
    public c a = new c();

    public final e a(String str, String str2) {
        this.a.a().put(str, str2);
        return this;
    }

    public final e a(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            this.a.a().putAll(hashMap);
        }
        return this;
    }

    public final e a(String str, long j, int i, boolean z) {
        if (str != null) {
            this.a.e = true;
            q b = this.a.b();
            Long valueOf = Long.valueOf(j);
            if (!(b == null || str == null || valueOf == null)) {
                q.a(b, str, new b(valueOf.longValue(), i, z));
            }
        }
        return this;
    }

    public final boolean a() {
        c cVar = this.a;
        if (cVar.a == null || cVar.a.isEmpty()) {
            if (cVar.b == null) {
                return true;
            }
            boolean z;
            q qVar = cVar.b;
            if ((qVar.a == null || qVar.a.isEmpty()) && ((qVar.b == null || qVar.b.isEmpty()) && ((qVar.c == null || qVar.c.isEmpty()) && ((qVar.d == null || qVar.d.isEmpty()) && (qVar.e == null || qVar.e.isEmpty()))))) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }
}
