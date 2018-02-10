package com.loc;

import android.content.Context;
import java.util.List;

/* compiled from: ProGuard */
public final class w {
    n a;
    Context b;

    public w(Context context, boolean z) {
        this.b = context;
        this.a = a(this.b, z);
    }

    static n a(Context context, boolean z) {
        try {
            return new n(context, n.a(t.class));
        } catch (Throwable th) {
            if (!z) {
                es.a(th, "SDKDB", "getDB");
            }
            return null;
        }
    }

    public final List<ep> a() {
        List<ep> list = null;
        try {
            list = this.a.a(ep.e(), ep.class, true);
        } catch (Throwable th) {
        }
        return list;
    }
}
