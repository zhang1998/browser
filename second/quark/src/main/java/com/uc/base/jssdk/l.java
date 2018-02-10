package com.uc.base.jssdk;

import android.text.TextUtils;
import com.uc.base.jssdk.a.a;
import com.uc.base.jssdk.a.b;
import com.uc.base.jssdk.a.c;
import com.uc.base.jssdk.a.d;
import com.uc.base.jssdk.a.e;
import com.uc.base.jssdk.a.f;
import com.uc.base.jssdk.a.g;
import com.uc.base.jssdk.a.h;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
final class l {
    private ConcurrentHashMap<String, h> a;
    private ConcurrentHashMap<String, b> b;
    private ConcurrentHashMap<String, d> c;
    private ConcurrentHashMap<String, e> d;
    private ConcurrentHashMap<Integer, Object> e;

    l() {
    }

    private synchronized ConcurrentHashMap<Integer, Object> b() {
        if (this.e == null) {
            this.e = new ConcurrentHashMap();
        }
        return this.e;
    }

    final synchronized ConcurrentHashMap<String, h> a() {
        if (this.a == null) {
            this.a = new ConcurrentHashMap();
        }
        return this.a;
    }

    private synchronized ConcurrentHashMap<String, b> c() {
        if (this.b == null) {
            this.b = new ConcurrentHashMap();
        }
        return this.b;
    }

    private synchronized ConcurrentHashMap<String, d> d() {
        if (this.c == null) {
            this.c = new ConcurrentHashMap();
        }
        return this.c;
    }

    private synchronized ConcurrentHashMap<String, e> e() {
        if (this.d == null) {
            this.d = new ConcurrentHashMap();
        }
        return this.d;
    }

    final c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        h hVar = (h) a().get(str);
        if (hVar == null) {
            return null;
        }
        c cVar;
        c cVar2 = b().get(Integer.valueOf(hVar.hashCode()));
        if (cVar2 == null) {
            synchronized (this.e) {
                cVar2 = hVar.a();
                b().putIfAbsent(Integer.valueOf(hVar.hashCode()), cVar2);
            }
            cVar = cVar2;
        } else {
            cVar = cVar2;
        }
        return cVar;
    }

    final f b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = (b) c().get(str);
        if (bVar == null) {
            return null;
        }
        f fVar;
        f fVar2 = b().get(Integer.valueOf(bVar.hashCode()));
        if (fVar2 == null) {
            synchronized (this.e) {
                fVar2 = bVar.a();
                b().putIfAbsent(Integer.valueOf(bVar.hashCode()), fVar2);
            }
            fVar = fVar2;
        } else {
            fVar = fVar2;
        }
        return fVar;
    }

    final g c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = (d) d().get(str);
        if (dVar == null) {
            return null;
        }
        g gVar;
        g gVar2 = b().get(Integer.valueOf(dVar.hashCode()));
        if (gVar2 == null) {
            synchronized (this.e) {
                gVar2 = dVar.a();
                b().putIfAbsent(Integer.valueOf(dVar.hashCode()), gVar2);
            }
            gVar = gVar2;
        } else {
            gVar = gVar2;
        }
        return gVar;
    }

    final a d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e eVar = (e) e().get(str);
        if (eVar == null) {
            return null;
        }
        a aVar;
        a aVar2 = b().get(Integer.valueOf(eVar.hashCode()));
        if (aVar2 == null) {
            synchronized (this.e) {
                aVar2 = eVar.a();
                b().putIfAbsent(Integer.valueOf(eVar.hashCode()), aVar2);
            }
            aVar = aVar2;
        } else {
            aVar = aVar2;
        }
        return aVar;
    }
}
