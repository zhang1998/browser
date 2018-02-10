package com.tencent.a.b;

import android.content.Context;

/* compiled from: ProGuard */
public final class n {
    public static Context a;

    public static final Context a() {
        return a == null ? null : a;
    }

    public static final String b() {
        return a() == null ? "" : a().getPackageName();
    }
}
