package com.c.a.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.c.a.ac;

/* compiled from: ProGuard */
public final class i extends l {
    private static final float b = Resources.getSystem().getDisplayMetrics().density;

    public i(a aVar) {
        super(aVar);
    }

    public final void a(Context context) {
    }

    public final void b(Context context) {
    }

    public final boolean a(int i, int i2) {
        for (ac acVar : a()) {
            acVar.a(acVar.h - ((((float) i) / b) * 0.2f));
            acVar.b(acVar.i - ((((float) i2) / b) * 0.2f));
        }
        return false;
    }

    public final void a(Activity activity) {
        for (ac b : a()) {
            b.b();
        }
    }

    public final void b(Activity activity) {
    }

    public final boolean c(Activity activity) {
        return true;
    }
}
