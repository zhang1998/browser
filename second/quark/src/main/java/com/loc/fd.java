package com.loc;

import android.content.Context;
import android.os.Looper;
import java.util.List;

/* compiled from: ProGuard */
public final class fd extends l {
    private static boolean c = true;

    protected fd(int i) {
        super(i);
    }

    protected final String a(List<ep> list) {
        return null;
    }

    protected final boolean c(Context context) {
        if (ei.m(context) != 1 || !c) {
            return false;
        }
        c = false;
        synchronized (Looper.getMainLooper()) {
            x xVar = new x(context);
            y a = xVar.a();
            if (a == null) {
                return true;
            }
            if (a.b == 1) {
                a.b(false);
                xVar.a(a);
                return true;
            }
            return false;
        }
    }
}
