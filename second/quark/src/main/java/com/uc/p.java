package com.uc;

import android.content.Context;

/* compiled from: ProGuard */
public final class p {
    public static boolean a(String str, Context context) {
        m.a = context;
        for (b bVar : b.values()) {
            if (bVar.e.b(str)) {
                return bVar.a();
            }
        }
        return false;
    }
}
