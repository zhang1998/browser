package com.bumptech.glide.b.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.g;
import java.io.IOException;

/* compiled from: ProGuard */
public abstract class a<T> implements c<T> {
    private final String a;
    private final AssetManager b;
    private T c;

    protected abstract T a(AssetManager assetManager, String str) throws IOException;

    protected abstract void a(T t) throws IOException;

    public a(AssetManager assetManager, String str) {
        this.b = assetManager;
        this.a = str;
    }

    public final void a(g gVar, b<? super T> bVar) {
        try {
            this.c = a(this.b, this.a);
            bVar.a(this.c);
        } catch (Exception e) {
            Log.isLoggable("AssetPathFetcher", 3);
            bVar.a(e);
        }
    }

    public final void a() {
        if (this.c != null) {
            try {
                a(this.c);
            } catch (IOException e) {
            }
        }
    }

    public final void b() {
    }

    public final com.bumptech.glide.b.a c() {
        return com.bumptech.glide.b.a.LOCAL;
    }
}
