package com.bumptech.glide.b.c;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.b.m;
import com.bumptech.glide.g.b;
import java.io.File;

/* compiled from: ProGuard */
public final class al implements aq<Uri, File> {
    private final Context a;

    public final /* synthetic */ ap a(Object obj, int i, int i2, m mVar) {
        Uri uri = (Uri) obj;
        return new ap(new b(uri), new ak(this.a, uri));
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return com.bumptech.glide.b.a.a.b.a((Uri) obj);
    }

    al(Context context) {
        this.a = context;
    }
}
