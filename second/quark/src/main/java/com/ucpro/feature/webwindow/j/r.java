package com.ucpro.feature.webwindow.j;

import android.content.Context;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ProGuard */
public final class r implements s {
    public v a;
    public final Context b;
    CopyOnWriteArrayList<n> c;
    private a d;

    public r(g gVar, Context context) {
        this.a = gVar;
        this.b = context;
    }

    final a a() {
        if (this.d == null) {
            this.d = new a(this.b, this);
            this.d.d = true;
        }
        return this.d;
    }
}
