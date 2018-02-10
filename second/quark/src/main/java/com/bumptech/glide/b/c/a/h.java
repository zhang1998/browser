package com.bumptech.glide.b.c.a;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.bumptech.glide.b.a.a.b;
import com.bumptech.glide.b.a.a.d;
import com.bumptech.glide.b.a.a.e;
import com.bumptech.glide.b.c.ap;
import com.bumptech.glide.b.c.aq;
import com.bumptech.glide.b.d.a.al;
import com.bumptech.glide.b.i;
import com.bumptech.glide.b.m;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class h implements aq<Uri, InputStream> {
    private final Context a;

    @Nullable
    public final /* synthetic */ ap a(Object obj, int i, int i2, m mVar) {
        Uri uri = (Uri) obj;
        if (b.a(i, i2)) {
            Object obj2;
            Long l = (Long) mVar.a(al.a);
            if (l == null || l.longValue() != -1) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                i bVar = new com.bumptech.glide.g.b(uri);
                Context context = this.a;
                return new ap(bVar, e.a(context, uri, new d(context.getContentResolver())));
            }
        }
        return null;
    }

    public final /* synthetic */ boolean a(Object obj) {
        Uri uri = (Uri) obj;
        return b.a(uri) && b.b(uri);
    }

    h(Context context) {
        this.a = context.getApplicationContext();
    }
}
