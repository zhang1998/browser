package com.bumptech.glide.b.b.b;

import android.util.Log;
import com.bumptech.glide.a.c;
import com.bumptech.glide.a.e;
import com.bumptech.glide.a.f;
import com.bumptech.glide.b.i;
import java.io.File;
import java.io.IOException;

/* compiled from: ProGuard */
public final class j implements c {
    private static j a = null;
    private final v b;
    private final File c;
    private final int d;
    private final g e = new g();
    private f f;

    public static synchronized c a(File file, int i) {
        c cVar;
        synchronized (j.class) {
            if (a == null) {
                a = new j(file, i);
            }
            cVar = a;
        }
        return cVar;
    }

    private j(File file, int i) {
        this.c = file;
        this.d = i;
        this.b = new v();
    }

    private synchronized f b() throws IOException {
        if (this.f == null) {
            this.f = f.a(this.c, (long) this.d);
        }
        return this.f;
    }

    public final File a(i iVar) {
        String a = this.b.a(iVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            new StringBuilder("Get: Obtained: ").append(a).append(" for for Key: ").append(iVar);
        }
        try {
            e a2 = b().a(a);
            if (a2 != null) {
                return a2.a[0];
            }
            return null;
        } catch (Throwable e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }

    public final void a(i iVar, b bVar) {
        e eVar;
        g gVar = this.e;
        synchronized (gVar) {
            eVar = (e) gVar.a.get(iVar);
            if (eVar == null) {
                eVar = gVar.b.a();
                gVar.a.put(iVar, eVar);
            }
            eVar.b++;
        }
        eVar.a.lock();
        c b;
        try {
            String a = this.b.a(iVar);
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                new StringBuilder("Put: Obtained: ").append(a).append(" for for Key: ").append(iVar);
            }
            f b2 = b();
            if (b2.a(a) != null) {
                this.e.a(iVar);
                return;
            }
            b = b2.b(a);
            if (b == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + a);
            }
            if (bVar.a(b.a())) {
                b.d.a(b, true);
                b.c = true;
            }
            b.c();
            this.e.a(iVar);
        } catch (Throwable e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
            }
        } catch (Throwable th) {
            this.e.a(iVar);
        }
    }

    public final synchronized void a() {
        try {
            b().a();
            c();
        } catch (Throwable e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to clear disk cache", e);
            }
        }
    }

    private synchronized void c() {
        this.f = null;
    }
}
