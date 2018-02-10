package com.bumptech.glide.a;

import java.io.File;
import java.io.IOException;

/* compiled from: ProGuard */
public final class c {
    final d a;
    final boolean[] b;
    public boolean c;
    public final /* synthetic */ f d;

    private c(f fVar, d dVar) {
        this.d = fVar;
        this.a = dVar;
        this.b = dVar.e ? null : new boolean[fVar.h];
    }

    public final File a() throws IOException {
        File file;
        synchronized (this.d) {
            if (this.a.f != this) {
                throw new IllegalStateException();
            }
            if (!this.a.e) {
                this.b[0] = true;
            }
            file = this.a.d[0];
            if (!this.d.b.exists()) {
                this.d.b.mkdirs();
            }
        }
        return file;
    }

    public final void b() throws IOException {
        this.d.a(this, false);
    }

    public final void c() {
        if (!this.c) {
            try {
                b();
            } catch (IOException e) {
            }
        }
    }
}
