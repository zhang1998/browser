package com.bumptech.glide.b.c;

import android.content.ContentResolver;
import android.net.Uri;
import com.bumptech.glide.b.a.c;
import com.bumptech.glide.b.a.s;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class bn implements ar<Uri, InputStream>, bm<InputStream> {
    private final ContentResolver a;

    public bn(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    public final c<InputStream> a(Uri uri) {
        return new s(this.a, uri);
    }

    public final aq<Uri, InputStream> a(ba baVar) {
        return new bo(this);
    }
}
