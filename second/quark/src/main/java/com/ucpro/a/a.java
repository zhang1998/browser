package com.ucpro.a;

import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ProGuard */
public final class a {
    private static Object b = new Object();
    CopyOnWriteArrayList<c> a;

    public static a a() {
        return l.a;
    }

    public final boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean addIfAbsent;
        synchronized (b) {
            addIfAbsent = b().addIfAbsent(cVar);
        }
        return addIfAbsent;
    }

    final CopyOnWriteArrayList<c> b() {
        if (this.a == null) {
            this.a = new CopyOnWriteArrayList();
        }
        return this.a;
    }
}
