package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.content.Context;
import android.webkit.ValueCallback;
import com.ucpro.feature.g.d.b.a;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.i.f;

/* compiled from: ProGuard */
public final class q {
    public static void a(x xVar, x xVar2) {
        if (xVar != null && xVar2 != null) {
            byte[] c = xVar2.c();
            if (c != null) {
                a aVar = new a();
                if (aVar.a(c)) {
                    if (aVar.d == 1) {
                        xVar.r = xVar2.r;
                    }
                    if (aVar.a == 1) {
                        xVar.n = xVar2.n;
                    }
                    if (aVar.e == 1) {
                        xVar.q = xVar2.q;
                    }
                }
            }
        }
    }

    public static boolean b(x xVar, x xVar2) {
        String b = xVar.b();
        if (b == null || !b.equalsIgnoreCase(xVar2.b())) {
            return true;
        }
        b = xVar.n;
        if (b != null && b.equals(xVar2.n) && xVar.r == xVar2.r && xVar.u == xVar2.u) {
            return false;
        }
        return true;
    }

    public static void a(Context context, String str, ValueCallback<String> valueCallback) {
        if (f.a((CharSequence) str)) {
            m.a(2, new p(context, valueCallback, str));
        } else {
            valueCallback.onReceiveValue("");
        }
    }
}
