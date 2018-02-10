package com.loc;

import android.content.Context;
import java.util.List;

/* compiled from: ProGuard */
public final class u {
    n a;

    public u(Context context) {
        try {
            this.a = new n(context, n.a(t.class));
        } catch (Throwable th) {
        }
    }

    public final List<? extends v> a(int i, Class<? extends v> cls) {
        List<? extends v> list = null;
        try {
            list = this.a.a(v.c(i), (Class) cls, false);
        } catch (Throwable th) {
            es.a(th, "LogDB", "ByState");
        }
        return list;
    }

    final void a(String str, Class<? extends v> cls) {
        this.a.a(v.b(str), (Class) cls);
    }
}
