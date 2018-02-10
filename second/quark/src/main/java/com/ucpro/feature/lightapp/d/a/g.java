package com.ucpro.feature.lightapp.d.a;

import android.util.LruCache;

/* compiled from: ProGuard */
public final class g extends LruCache<String, d> {
    b a;

    protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        String str = (String) obj;
        d dVar = (d) obj3;
        if (this.a != null) {
            this.a.a(z, str, dVar);
        }
    }

    public g(int i) {
        super(i);
    }
}
