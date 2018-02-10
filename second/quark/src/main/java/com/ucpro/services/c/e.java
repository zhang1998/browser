package com.ucpro.services.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.uc.util.b;
import com.ucpro.feature.webwindow.i.c;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.i.f;
import com.ucweb.common.util.n.a;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class e implements c {
    ConcurrentHashMap<String, Bitmap> a = new ConcurrentHashMap();

    public final void a(Context context, String str, d dVar, Object obj) {
        Bitmap a = a(str);
        if (a != null) {
            dVar.a(str, a, obj);
            return;
        }
        Object b = c.a.b(str);
        if (TextUtils.isEmpty(b)) {
            dVar.a(str, null, obj);
        } else {
            m.b(3, new g(this, context, b, str), new b(this, dVar, str, obj));
        }
    }

    public final Bitmap a(Context context, String str) {
        Bitmap a = a(str);
        if (a != null) {
            return a;
        }
        Object b = c.a.b(str);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        return b.a(context.getResources(), b);
    }

    final Bitmap a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String b = b(str);
            if (!a.a(b)) {
                return (Bitmap) this.a.get(b);
            }
        }
        return null;
    }

    static String b(String str) {
        if (!a.a(str)) {
            String c = f.c(str);
            if (!a.a(c)) {
                return c.toLowerCase();
            }
        }
        return null;
    }
}
