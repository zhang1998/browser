package com.ucpro.feature.downloadpage.e.c.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class g implements h {
    ConcurrentHashMap<String, Drawable> a;

    private g() {
        this.a = new ConcurrentHashMap();
    }

    public final Drawable a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (Drawable) this.a.get(str);
    }
}
