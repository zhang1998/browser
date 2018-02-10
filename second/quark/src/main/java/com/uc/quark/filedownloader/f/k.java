package com.uc.quark.filedownloader.f;

/* compiled from: ProGuard */
final class k {
    static n a;
    static long b;

    private k() {
    }

    static n a() {
        n nVar;
        synchronized (k.class) {
            if (a != null) {
                nVar = a;
                a = nVar.f;
                nVar.f = null;
                b -= 2097152;
            } else {
                nVar = new n();
            }
        }
        return nVar;
    }

    static void a(n nVar) {
        synchronized (k.class) {
            if (nVar.f == null && nVar.g == null) {
                if (!nVar.d) {
                    b += 2097152;
                    nVar.f = a;
                    nVar.c = 0;
                    nVar.b = 0;
                    a = nVar;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
