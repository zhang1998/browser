package com.uc.a.d;

import com.uc.a.a.a;

/* compiled from: ProGuard */
public final class w {
    static a a;

    public static void a(Object obj) {
        if (a != null) {
            new StringBuilder("writeLog: ").append(obj);
            a.a(obj);
        }
    }

    public static void a() {
        if (a != null) {
            a aVar = a;
            if (aVar.a != null) {
                aVar.a.a();
            }
        }
    }
}
