package com.c.a.f;

import android.content.Context;

/* compiled from: ProGuard */
public abstract class b {
    private boolean a;

    public abstract void a(int i, int i2, int i3);

    protected abstract void a(Context context);

    public abstract void b(int i, int i2, int i3);

    public final void b(Context context) {
        if (!this.a) {
            a(context);
            this.a = true;
        }
    }
}
