package com.a.a.a;

import android.content.Context;

/* compiled from: ProGuard */
public final class bf extends as {
    private Context d;

    public bf(Context context) {
        super("idfa");
        this.d = context;
    }

    public final String b() {
        String a = fb.a(this.d);
        return a == null ? "" : a;
    }
}
