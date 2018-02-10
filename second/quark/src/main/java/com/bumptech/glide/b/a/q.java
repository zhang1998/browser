package com.bumptech.glide.b.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.g;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: ProGuard */
public abstract class q<T> implements c<T> {
    private final Uri a;
    private final ContentResolver b;
    private T c;

    protected abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    protected abstract void a(T t) throws IOException;

    public q(ContentResolver contentResolver, Uri uri) {
        this.b = contentResolver;
        this.a = uri;
    }

    public final void a(g gVar, b<? super T> bVar) {
        try {
            this.c = a(this.a, this.b);
            bVar.a(this.c);
        } catch (Exception e) {
            Log.isLoggable("LocalUriFetcher", 3);
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

    public final a c() {
        return a.LOCAL;
    }
}
