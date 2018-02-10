package com.bumptech.glide.b.c.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.b.a.a.b;
import com.bumptech.glide.b.a.a.c;
import com.bumptech.glide.b.a.a.e;
import com.bumptech.glide.b.c.ap;
import com.bumptech.glide.b.c.aq;
import com.bumptech.glide.b.i;
import com.bumptech.glide.b.m;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class f implements aq<Uri, InputStream> {
    public final Context a;

    public final /* synthetic */ ap a(Object obj, int i, int i2, m mVar) {
        Uri uri = (Uri) obj;
        if (!b.a(i, i2)) {
            return null;
        }
        i bVar = new com.bumptech.glide.g.b(uri);
        Context context = this.a;
        return new ap(bVar, e.a(context, uri, new c(context.getContentResolver())));
    }

    public final /* synthetic */ boolean a(Object obj) {
        Uri uri = (Uri) obj;
        return b.a(uri) && !b.b(uri);
    }

    public f(Context context) {
        this.a = context.getApplicationContext();
    }
}
