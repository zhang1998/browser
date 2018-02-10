package com.e.b;

/* compiled from: ProGuard */
public final class e {
    private static e d = new e();
    String a = null;
    String b = null;
    String c = null;
    private String e = null;
    private h f = null;

    e() {
    }

    public final synchronized void a(h hVar) {
        this.f = hVar;
    }

    public final synchronized h a() {
        return this.f;
    }

    public static e b() {
        return d;
    }
}
