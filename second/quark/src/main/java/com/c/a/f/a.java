package com.c.a.f;

import android.content.Context;
import com.c.a.a.c;
import com.c.a.ac;
import com.uc.apollo.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: ProGuard */
public abstract class a {
    private boolean a;
    private c b = c.a;

    public abstract void a();

    public abstract void a(int i, int i2);

    public abstract void a(int i, int i2, int i3, ac acVar);

    public abstract void a(Context context);

    public final void b(Context context) {
        if (!this.a) {
            a(context);
            this.a = true;
        }
    }
}
