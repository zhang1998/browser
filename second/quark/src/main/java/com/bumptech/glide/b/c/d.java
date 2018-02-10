package com.bumptech.glide.b.c;

import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.b.m;
import com.bumptech.glide.g.b;

/* compiled from: ProGuard */
public final class d<Data> implements aq<Uri, Data> {
    private static final int a = 22;
    private final AssetManager b;
    private final a<Data> c;

    public final /* synthetic */ ap a(Object obj, int i, int i2, m mVar) {
        Uri uri = (Uri) obj;
        return new ap(new b(uri), this.c.a(this.b, uri.toString().substring(a)));
    }

    public final /* synthetic */ boolean a(Object obj) {
        Uri uri = (Uri) obj;
        if ("file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0))) {
            return true;
        }
        return false;
    }

    public d(AssetManager assetManager, a<Data> aVar) {
        this.b = assetManager;
        this.c = aVar;
    }
}
