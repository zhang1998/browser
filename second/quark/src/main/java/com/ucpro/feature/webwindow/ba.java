package com.ucpro.feature.webwindow;

import android.content.Context;
import com.ucpro.feature.webwindow.c.h;

/* compiled from: ProGuard */
public final class ba {
    public Context a;
    private ax b;
    private h c;

    public final h a() {
        if (this.c == null) {
            this.c = new h(this.a);
        }
        return this.c;
    }

    public ba(Context context, ax axVar) {
        this.a = context;
        this.b = axVar;
    }
}
