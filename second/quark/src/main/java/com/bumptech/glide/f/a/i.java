package com.bumptech.glide.f.a;

import android.util.Log;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class i implements OnPreDrawListener {
    private final WeakReference<j> a;

    i(j jVar) {
        this.a = new WeakReference(jVar);
    }

    public final boolean onPreDraw() {
        if (Log.isLoggable("ViewTarget", 2)) {
            new StringBuilder("OnGlobalLayoutListener called listener=").append(this);
        }
        j jVar = (j) this.a.get();
        if (!(jVar == null || jVar.b.isEmpty())) {
            int c = jVar.c();
            int b = jVar.b();
            if (jVar.b(c, b)) {
                jVar.a(c, b);
                jVar.a();
            }
        }
        return true;
    }
}
