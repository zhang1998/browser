package com.bumptech.glide.b.a.a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.a.b;
import com.bumptech.glide.b.a.c;
import com.bumptech.glide.b.a.i;
import com.bumptech.glide.g;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class e implements c<InputStream> {
    private final Uri a;
    private final g b;
    private InputStream c;

    public static e a(Context context, Uri uri, f fVar) {
        return new e(uri, new g(com.bumptech.glide.c.a(context).d.a(), fVar, com.bumptech.glide.c.a(context).e, context.getContentResolver()));
    }

    private e(Uri uri, g gVar) {
        this.a = uri;
        this.b = gVar;
    }

    public final void a(g gVar, b<? super InputStream> bVar) {
        try {
            int a;
            InputStream iVar;
            InputStream b = this.b.b(this.a);
            if (b != null) {
                a = this.b.a(this.a);
            } else {
                a = -1;
            }
            if (a != -1) {
                iVar = new i(b, a);
            } else {
                iVar = b;
            }
            this.c = iVar;
            bVar.a(this.c);
        } catch (Exception e) {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            bVar.a(e);
        }
    }

    public final void a() {
        if (this.c != null) {
            try {
                this.c.close();
            } catch (IOException e) {
            }
        }
    }

    public final void b() {
    }

    public final Class<InputStream> d() {
        return InputStream.class;
    }

    public final a c() {
        return a.LOCAL;
    }
}
