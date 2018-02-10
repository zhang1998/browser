package com.loc;

import android.content.Context;
import android.os.Looper;
import java.util.Date;
import java.util.List;

/* compiled from: ProGuard */
public final class fc extends l {
    private static boolean c = true;

    protected fc(int i) {
        super(i);
    }

    protected final String a(String str) {
        return eq.e(ek.c(str + eq.a(new Date().getTime())));
    }

    protected final String a(List<ep> list) {
        return null;
    }

    protected final boolean c(Context context) {
        if (!c) {
            return false;
        }
        c = false;
        synchronized (Looper.getMainLooper()) {
            x xVar = new x(context);
            y a = xVar.a();
            if (a == null) {
                return true;
            }
            if (a.a == 1) {
                a.a(false);
                xVar.a(a);
                return true;
            }
            return false;
        }
    }
}
