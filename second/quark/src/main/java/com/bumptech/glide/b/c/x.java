package com.bumptech.glide.b.c;

import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.a.b;
import com.bumptech.glide.b.a.c;
import com.bumptech.glide.g;
import java.io.File;
import java.io.IOException;

/* compiled from: ProGuard */
final class x<Data> implements c<Data> {
    private final File a;
    private final y<Data> b;
    private Data c;

    public x(File file, y<Data> yVar) {
        this.a = file;
        this.b = yVar;
    }

    public final void a(g gVar, b<? super Data> bVar) {
        try {
            this.c = this.b.a(this.a);
            bVar.a(this.c);
        } catch (Exception e) {
            Log.isLoggable("FileLoader", 3);
            bVar.a(e);
        }
    }

    public final void a() {
        if (this.c != null) {
            try {
                this.b.a(this.c);
            } catch (IOException e) {
            }
        }
    }

    public final void b() {
    }

    public final Class<Data> d() {
        return this.b.a();
    }

    public final a c() {
        return a.LOCAL;
    }
}
