package com.a.a.a;

import android.content.Context;
import com.a.a.b;

/* compiled from: ProGuard */
public final class eb implements ed {
    private static eb l = null;
    fi a;
    ec b;
    long c = 1296000000;
    int d = 10000;
    long e = 0;
    long f = 0;
    Context g;
    private final long h = 1296000000;
    private final long i = 129600000;
    private final int j = 1800000;
    private final int k = 10000;

    public static synchronized eb a(Context context, ec ecVar) {
        eb ebVar;
        synchronized (eb.class) {
            if (l == null) {
                ebVar = new eb(context, ecVar);
                l = ebVar;
                ebVar.a(bb.a(context).c);
            }
            ebVar = l;
        }
        return ebVar;
    }

    private eb(Context context, ec ecVar) {
        this.g = context;
        this.a = fi.a(context);
        this.b = ecVar;
    }

    public final void a(ar arVar) {
        int i;
        long j = 1296000000;
        if (arVar.f != -1 && arVar.f >= 48) {
            j = 3600000 * ((long) arVar.f);
        }
        this.c = j;
        if (arVar.a == -1) {
            i = 0;
        } else if (arVar.a < 0 || arVar.a > 1800) {
            i = 0;
        } else {
            i = arVar.a * 1000;
        }
        if (i != 0) {
            this.d = i;
        } else if (b.i <= 0 || b.i > 1800000) {
            this.d = 10000;
        } else {
            this.d = b.i;
        }
    }
}
